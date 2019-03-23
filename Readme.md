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

	concluion from ASTBuilder
		1, ctx.label | ctx.parserRule()
		2, visit(ctx.xx) Deprecated visitChildren

ctrl alt - -> back (after press f12)

1 workspace is used for 1 project
which as seen may the same level as maven, springboot...
but large workspace may include diff langurages.

1, if ctx.params == null -> can not get params.param; can not use for(:)
2, if varListNode == null or varListNode.varList == null it is diff


## Part 2-Type Check

变量引用消除				类型名字消除
						  类型定义检查
	    	表达式有效性检查
	    	  静态类型检查

变量引用：确定作用域 -> LocalResolver
类型名称：似乎不用，因为不会有只声明不定义的情况 -> TypeResolver
类型定义：语义方面，会不会有null类型数组，void类型的bulabula，自身作为自身结构体 -> TypeTable
表达式有效性：1++无法执行的表达式；内置的表达式 -> DereferenceChecker
静态类型：不允许类型转换 -> TypeChecker




[C.g4]: https://github.com/antlr/codebuff/blob/master/corpus/antlr4/training/C.g4
[1]: https://github.com/antlr/codebuff/blob/master/corpus/antlr4/training/java.g4
