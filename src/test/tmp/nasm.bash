#!/bin/bash
# @Echo off


name=$1

if [ x$2 != x ]; then
	outName=$2
else
	outName="a.out"
fi

echo "input:" $name
echo "output:" $outName

rm -f $name.o $outName

nasm -felf64 $name.log

# ld $name.o 
gcc $name.o -no-pie -o $outName

./$outName

#rm -f $name.o

# nasm -felf64 hello.asm && ld hello.o && ./a.out
# nasm -felf64 hello.asm && ld hello.o -no-pie && ./a.out

exit 0
