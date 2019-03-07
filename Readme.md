# Compiler 2019

## Prepare

> This is where I get [C.g4] and [java.g4][1] 
<!-- [Download Site][^2] [Usual Way][^3]
    [^2]: https://minhaskamal.github.io/DownGit/#/home
    [^3]: Click Raw to get https://raw.githubusercontent.com/antlr/codebuff/master/corpus/antlr4/training/C.g4 -->

> optimization:
无用代码消除
内联转换
内存优化
合并IR
循环转化
IR向量化

汇编代码优化



> change antlr4-vscode-extension
--> use antlr4 newset version: mv antlr-4.7.2-complete.jar to .vscode/extensions/mike*/antlr `and` rename it as antlr4-4.7.2-SNAPSHOT-complete.jar
--> use direct dir :
``` json
    // settings.json
    "antlr4.generation":{
        "mode": "external",
        "outputDir": "/home/xun/Documents/mxc/src/main/java/mxcompiler/parser",
        "importDir": "/home/xun/Documents/mxc/src/main/java/mxcompiler/parser/grammar",
        "package": "mxcompiler.parser",
        "language": "Java",
        "listeners": true,
        "visitors": true
    },

    // launch.json
    {
        "name": "Debug ANTLR4 grammar",
        "type": "antlr-debug",
        "request": "launch",
        "input": "src/test/cases/test.in", // test file
        "grammar": "src/main/java/mxcompiler/parser/grammar/Mx.g4", // copy-relative path
        "startRule": "start", // start rule
        "printParseTree": true,
        "visualParseTree": true
    }
```

- start
    - class
    - globleVarible
    - function

grun 之前一定记得javac *

antlr4
import, fragment, lexer, parser, grammar, returns,
locals, throws, catch, finally, mode, options, tokens

要将操作限制为生成的解析器或词法分析器，请使用@parser::name或@lexer::name。


[C.g4]: https://github.com/antlr/codebuff/blob/master/corpus/antlr4/training/C.g4
[1]: https://github.com/antlr/codebuff/blob/master/corpus/antlr4/training/java.g4
