import argparse
import json
import os
import sys
import subprocess
import pickle

from . import testcase
from . import codegen_test
from . import semantic_test


def replace_newlines(dst, src):
    with open(dst, "w") as dst_f:
        with open(src) as src_f:
            content = src_f.read()
        dst_f.write(content.replace("\r\n", "\n"))


def main():
    # args
    parser = argparse.ArgumentParser()
    parser.add_argument("-c", "--config",
                        help="the path to the config file " +
                             "(default=\"./config.json\")",
                        type=str, default="./config.json")
    parser.add_argument("-t", "--testcases_dir",
                        help="the path to testcases(default in config file)",
                        type=str, default="")
    parser.add_argument("-b", "--bash_dir",
                        help="the path to bash file(default in config file)",
                        type=str, default="")
    parser.add_argument("-p", "--phases",
                        help="the test phase(default in config file)",
                        type=str, default="")
    args = parser.parse_args()

    # config.json
    with open(args.config) as f:
        config = json.load(f)
    if args.testcases_dir != "":
        config["testcases_dir"] = args.testcases_dir
    if args.bash_dir != "":
        config["bash_dir"] = args.bash_dir
    if args.phases != "":
        config["phases"] = [phase.strip() for phase in args.phases.split(",")]

    # bash
    for name in ["build.bash", "semantic.bash", "codegen.bash", "optim.bash"]:
        src = os.path.join(config["bash_dir"], name)
        if not os.path.isfile(src):
            print("Not found " + src)
            continue
        dst = os.path.join(config["bash_dir"], "" + name)
        # replace_newlines(dst, src)

    # build
    print("building...", end=' ')
    sys.stdout.flush()
    res = subprocess.run(
        ["bash", os.path.join(config["bash_dir"], "build.bash")],
        stdout=subprocess.DEVNULL, stderr=subprocess.PIPE)
    
    if res.returncode != 0:
        print("Failed.")
        print(str(res.stderr))
        clear_cache(config)
        print("\033[91m build Failed.")
        sys.stdout.flush()
        return
    print("Passed.")

    # read cases
    cases = [t for t in testcase.read_testcases(config['testcases_dir'])
             if t.phase in config['phases']]
    cases.sort(key=lambda x: x.filename)
    cases_failed = []
    pass_num = 0
    test_num = 0

    # run cases
    for test in cases:
        print("running " + test.filename + "...", end=" ")
        sys.stdout.flush()
        phase = test.phase.partition(" ")[0]
        if phase == "codegen":
            res = codegen_test.test(
                test, os.path.join(config["bash_dir"], "codegen.bash"))
                # test, os.path.join(config["bash_dir"], "__codegen.bash"), config["ir_interpreter"])
        elif phase == "semantic":
            res = semantic_test.test(
                test, os.path.join(config["bash_dir"], "semantic.bash"))
        elif phase == "optim":
            res = codegen_test.test(
                test, os.path.join(config["bash_dir"], "optim.bash"))
        else:
            print(phase + " is unsupported currently")
            continue
        test_num += 1
        if res[0]:
            pass_num += 1
            print("\033[32mPassed. " + res[1] + "\033[0m")
        else:
            cases_failed.append(test.filename)
            print("\033[31mFailed: " + res[1] + "\033[0m")

    # conclusion
    if len(cases_failed) == 0:
        print("All testcases have been passed")
    else:
        print("testcases failed:")
        for name in cases_failed:
            print(name)
        print("Pass rate: {}/{}".format(pass_num, test_num))

    clear_cache(config)
    return    

    # todo
    print("\nComparing with the last run: ")
    log_filename = "oj-result.data"
    last_failed = []
    try:
        with open(log_filename, "rb") as f:
            last_failed = pickle.load(f)
    except:
        print("The data of the last run can not be read")
    with open(log_filename, "wb") as f:
        pickle.dump(cases_failed, f)
    
    print("\033[32m", end='')
    for name in set(last_failed) - set(cases_failed):
        print("+ " + name)
    print("\033[0m" + "\033[31m")
    for name in set(cases_failed) - set(last_failed):
        print("- " + name)
    print("\033[0m", end='')


def clear_cache(config):
    # clear cache
    subprocess.run("rm -f __a.asm __a.o __a.out",
                   shell=True, stdout=subprocess.DEVNULL,
                   stderr=subprocess.DEVNULL)
    rm = "rm -f " + config['bash_dir'] + "/__*.bash"
    subprocess.run(rm, shell=True)
    subprocess.run("rm -f ./__ir.ll", shell=True)
