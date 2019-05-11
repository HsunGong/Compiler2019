#!/bin/bash
# @Echo off

if [ x$1 != x ]; then
	if [[ $1 == *.* ]]; then
		echo "No .asm needed"
		exit 1
	fi
	name=$1
else
	echo "No input Name"
	exit 1
fi

if [ ! -f "$1.log" ]; then
	echo "No such .asm file"
	exit 1
fi

if [ x$2 != x ]; then
	outName=$2
else
	outName="a.out"
fi

echo "input:" $name.asm
echo "output:" $outName

rm -f $name.o $outName

nasm -felf64 $name.log

# ld $name.o 
gcc $name.o -no-pie

./$outName

#rm -f $name.o

# nasm -felf64 hello.asm && ld hello.o && ./a.out
# nasm -felf64 hello.asm && ld hello.o -no-pie && ./a.out

exit 0
