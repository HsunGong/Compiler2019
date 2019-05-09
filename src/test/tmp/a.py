lines = []
with open ("test.log", "r") as f:
    # for i in f.readlines():
    #     print(i)
    lines = [i for i in f.readlines()]

with open ("tran.log", "w") as f:
    idx = 10
    for idx in range(0, 10):
        f.write(lines[idx])
    for idx in range(10, 85):
        f.write('a' + str(idx) + lines[idx])
    for idx in range(85, len(lines)):
        f.write(lines[idx])
