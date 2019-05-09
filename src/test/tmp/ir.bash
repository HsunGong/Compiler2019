#!/bin/bash
# @Echo off


name=$1

echo "input:" $name
curPath="../../../../tmp"
exefile="../java/mxcompiler/ir/src/LLIRInterpreter.java"
exePath="../java/mxcompiler/ir/src"

if [[ -f $name.dump && -f $exefile ]]; then
	cd $exePath/
	java *.java  < $curPath/$name.dump
	# java -cp $exePath/ mxcompiler/ir/src/LLIRInterpreter < $name.dump

	# rm -f $exePath/*.class

fi


#rm -f $name.o

# nasm -felf64 hello.asm && ld hello.o && ./a.out
# nasm -felf64 hello.asm && ld hello.o -no-pie && ./a.out

exit 0
