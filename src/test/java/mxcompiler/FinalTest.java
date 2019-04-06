// package com.mercy.compiler.BackEnd;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.junit.runners.Parameterized;

// import java.io.*;
// import java.util.*;
// import java.util.stream.Collectors;

// import static com.mercy.compiler.Main.compile;
// import static org.junit.Assert.assertTrue;

// /**
//  * Created by mercy on 17-5-6.
//  */
// @RunWith(Parameterized.class)
// public class FinalTest {
//     @Parameterized.Parameters
//     public static Collection<Object[]> data() {
//         final String dataRoot = "testcase/final/";
//         final String srcExt = ".mx";
//         final String inExt =  ".in";
//         final String ansExt = ".out";
//         SortedSet<String> files = new TreeSet<>(Arrays.stream(new File(dataRoot).listFiles())
//                 .filter(File::isFile).map(x -> dataRoot + x.getName()).collect(Collectors.toSet()));
//         Collection<Object[]> params = new ArrayList<>();
//         for (String file : files) {
//             if (!file.endsWith(srcExt)) continue;
//             String name = file.substring(0, file.length()-srcExt.length());
//             String in = files.contains(name + inExt) ? name + inExt : null;
//             String ans = files.contains(name + ansExt) ? name + ansExt : null;
//             params.add(new Object[] {file, in, ans});
//         }
//         return params;
//     }

//     private String srcFile;
//     private String inFile;
//     private String ansFile;

//     public FinalTest(String srcFile, String inFile, String ansFile) {
//         this.srcFile = srcFile;
//         this.inFile = inFile;
//         this.ansFile = ansFile;

//     }

//     @Test
//     public void testPass() throws Exception {
//         System.out.println("########## " + srcFile + " ##########" );
//         System.out.flush();
//         if (ansFile == null) throw new RuntimeException("no ans file");

//         InputStream is = new FileInputStream(srcFile);
//         PrintStream os = new PrintStream(new FileOutputStream("out.asm"));

//         compile(is, os);

//         // run test
//         Process run = new ProcessBuilder("./asm.bash","out")
//                 .redirectInput(ProcessBuilder.Redirect.PIPE)
//                 .redirectOutput(ProcessBuilder.Redirect.PIPE)
//                 .redirectError(ProcessBuilder.Redirect.PIPE)
//                 .start();

//         if (inFile != null) {
//             BufferedReader br = new BufferedReader(new FileReader(inFile));
//             PrintStream runOut = new PrintStream(run.getOutputStream());
//             String line;
//             while ((line = br.readLine()) != null)
//                 runOut.println(line);
//             runOut.close();
//         }
//         run.waitFor();

//         BufferedReader brAns = new BufferedReader(new FileReader(ansFile));
//         BufferedReader brOut = new BufferedReader(new InputStreamReader(run.getInputStream()));
//         boolean correct = true;
//         System.out.println("===== PROGRAM OUTPUT:");
//         while (true) {
//             String lineOut = brOut.readLine();
//             String lineAns = brAns.readLine();
//             if ((lineOut == null) != (lineAns == null)) correct = false;
//             if (lineOut == null) break;
//             System.out.println(lineOut);
//             if (correct && !lineAns.trim().equals(lineOut.trim())) {
//                 correct = false;
//                 System.out.println("===== ANS OUTPUT: " + lineAns);
//             }
//         }

//         BufferedReader brErr = new BufferedReader(new InputStreamReader(run.getErrorStream()));
//         System.out.println("===== STDERR:");
//         String line;
//         while ((line = brErr.readLine()) != null) {
//             System.out.println(line);
//         }

//         System.out.println("########## " + srcFile + " ##########" );
//         System.out.flush();
//         assertTrue(correct);
//     }
// }