package mxcompiler.error;

public class SyntaxError extends Error {

    public SyntaxError(String message) {
        super("[Syntax Error] at " + message);
    }
}