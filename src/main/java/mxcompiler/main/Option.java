package mxcompiler.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import mxcompiler.exception.OptionException;

public class Option {


    private List<String> srcs;
    private String output = "a.out";
    private CompilerMode mode;
    private int level = 0;
    private boolean debug = false;

    public Option (String[] args) throws OptionException{
        parseArgs(args);
    }
    
    void parseArgs(String[] Args) throws OptionException{
        srcs = new ArrayList<String>();
        // srcs.add(args[0]);
        ListIterator<String> args = Arrays.asList(Args).listIterator();
        while (args.hasNext()) {
            String arg = args.next();
            if (arg.startsWith("-")) {
                if (CompilerMode.isModeOption(arg)) {
                    if (mode != null) {
                        throw new OptionException(mode.getOption() + " option and " 
                            + arg + " option is exclusive");
                    }
                    mode = CompilerMode.fromOption(arg);
                }
                else if (arg.equals("--debug")) {
                    debug = true;
                }
                else if (arg.startsWith("-o")) {
                    if (args.hasNext()){
                        output = args.next();
                    } else {
                        output = "a.out";
                    }
                }
                else if (arg.startsWith("-O")) {
                    String type = arg.substring(2);
                    if (! type.matches("^([0123s]|)$")) {
                        throw new OptionException("unknown optimization switch: " + arg);
                    }
                    level = (type.equals("0") ? 0 : 1);
                }
                else if (arg.equals("--version")) {
                    System.out.printf("%s version %s\n",
                        Compiler.ProgName, Compiler.Version);
                    System.exit(0);
                }
                else if (arg.equals("--help")) {
                    printUsage();
                    System.exit(0);
                }
                else {
                    throw new OptionException("unknown option: " + arg);
                }
            }
            else {
                srcs.add(arg);
            }
        }

        if (mode == null) {
            mode = CompilerMode.Compile;
        }
    }


    public List<String> sourceFiles() {
        System.out.println(srcs.get(0) instanceof String);
        return srcs;
    }

    public String outputFile() {
        return output;
    }

    public Integer OptimizationLevel() {
        return level;
    }

    public CompilerMode mode() {
        return mode;
    }

    public boolean isDebug() {
        return debug;
    }

    

    public void printUsage() {
        System.out.println("EMPTY");
    }
}