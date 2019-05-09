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

if [ test -f "$name.dump" ] && [ test -f "../llir/src/LLIRInterpreter.java"  ] ; then
	exefile="../llir/src/LLIRInterpreter.java"
	javac exefile 

	./$outName

fi


#rm -f $name.o

# nasm -felf64 hello.asm && ld hello.o && ./a.out
# nasm -felf64 hello.asm && ld hello.o -no-pie && ./a.out

exit 0
