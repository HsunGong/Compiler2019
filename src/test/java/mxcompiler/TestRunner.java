package mxcompiler;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import mxcompiler.ir.src.LLIRInterpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


public class TestRunner {
    private static Option opts;
    private static InputStream fileIn;
    private static PrintStream fileOut;

    public static void main(String[] args) throws Exception {
        // parse options
        opts = new Option(args);

        fileIn = (opts.sourceFile() == null) ? System.in : new FileInputStream(opts.sourceFile());

        fileOut = new PrintStream(new FileOutputStream(opts.outputFile(), false));

        LLIRTest();
    }

    private static void LLIRTest() throws Exception, Error {
        LLIRInterpreter test = new LLIRInterpreter(fileIn, false);
        if (test.isReady()) {
            test.run();

            System.out.println(test.getExitcode());
            System.out.println(test.exitException());
        } else
            throw new Error("something wrong");

        fileOut.close();
    }

    private static void NaiveMercyTest() {
        Result result = JUnitCore.runClasses(SemanticTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

        result = JUnitCore.runClasses(SemanticTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
