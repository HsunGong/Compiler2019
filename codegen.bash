# specify output as out.asm

set -e
cd "$(dirname "$0")"
export CCHK="java -classpath ./lib/antlr-4.7.2-complete.jar:./bin mxcompiler.main.Compiler --test -o out.asm"
$CCHK

cat out.asm