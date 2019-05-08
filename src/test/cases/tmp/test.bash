#!/bin/bash
# @Echo off

output="test"
t_output="standard_test"

echo "output:" $output
echo "test_output:" $t_output

rm -f *.o

bash /home/xun/Documents/tmp/standard/codegen.bash

nasm -felf64 $output.asm
nasm -felf64 $t_output.asm

# ld $name.o 

gcc $output.o -no-pie -o a.out
gcc $t_output.o -no-pie -o b.out

echo "my default out"
./a.out
echo "standard out"
./b.out

rm -f *.o *.out

# nasm -felf64 hello.asm && ld hello.o && ./a.out
# nasm -felf64 hello.asm && ld hello.o -no-pie && ./a.out

exit 0
