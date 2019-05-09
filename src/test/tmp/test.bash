#!/bin/bash
# @Echo off

timeout()
{
        waitfor=15
        command=$*
        $command &
        commandpid=$!
        ( sleep $waitfor ; kill -9 $commandpid  > /dev/null 2>&1 ) &
        watchdog=$!
        sleeppid=$PPID
        wait $commandpid > /dev/null 2>&1
        kill $sleeppid > /dev/null 2>&1
}

output="test"
t_output="standard_test"

echo "output: " $output
echo "test_output: " $t_output

rm -f *.o

bash /home/xun/Documents/tmp/standard/codegen.bash

#bash /home/xun/Documents/tmp/standard/codegen.bash

nasm -felf64 $output.log
nasm -felf64 $t_output.log

# ld $name.o 

gcc $output.o -no-pie -o a.out
gcc $t_output.o -no-pie -o b.out




echo ">>> my default out"
timeout ./a.out


echo ">>> standard out"
timeout ./b.out

rm -f *.o *.out

# nasm -felf64 hello.asm && ld hello.o && ./a.out
# nasm -felf64 hello.asm && ld hello.o -no-pie && ./a.out

exit 0
