package mxcompiler.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import mxcompiler.exception.OptionException;
import mxcompiler.main.CompilerMode.DumpMode;

public class Option {

	/** only support 1 source file */
	private InputStream src;
	private String output = "a.out";
	private CompilerMode mode = null;
	private List<DumpMode> dumpMode = new ArrayList<>();
	private int level = 0;
	private boolean debug = false;

	public Option(String[] args) throws OptionException {
		parseArgs(args);
	}

	void parseArgs(String[] Args) throws OptionException {
		ListIterator<String> args = Arrays.asList(Args).listIterator();
		while (args.hasNext()) {
			String arg = args.next();
			if (arg.startsWith("-")) {
				if (CompilerMode.isModeOption(arg)) {
					if (mode != null) {
						throw new OptionException(mode.getOption() + " option and " + arg + " option is exclusive");
					}
					mode = CompilerMode.fromOption(arg);
				} else if (DumpMode.isModeOption(arg)) {
					dumpMode.add(DumpMode.fromOption(arg));
				} else if (arg.startsWith("-o")) { 
					// attention: dump to dump.out can not change
					// is asm-out
					if (args.hasNext()) {
						output = args.next();
					} else {
						output = "a.out";
					}
				} else if (arg.startsWith("-O")) {
					String type = arg.substring(2);
					if (!type.matches("^([0123s]|)$")) {
						throw new OptionException("unknown optimization switch: " + arg);
					}
					level = (type.equals("0") ? 0 : 1);
				} else if (arg.equals("--version") || arg.equals("-v")) {
					System.out.printf("%s version %s\n", Compiler.ProgName, Compiler.Version);
					System.exit(0);
				} else if (arg.equals("--help") || arg.equals("-h")) {
					printUsage();
					System.exit(0);
				} else {
					throw new OptionException("unknown option: " + arg);
				}
			} else if (src == null) {
				try {
					src = new FileInputStream(arg);
				} catch (FileNotFoundException e) {
					throw new OptionException(e.getMessage());
				}
			} else {
				throw new OptionException("too many srcs");
			}
		}

		if (src == null)
			src = System.in;

		if (mode == null) {
			mode = CompilerMode.Default;
		}
	}

	public InputStream sourceFile() {
		return src;
	}

	// TODO: may support output to system.out
	public String outputFile() {
		return output;
	}

	public Integer OptimizationLevel() {
		return level;
	}

	public CompilerMode mode() {
		return mode;
	}

	public List<DumpMode> dumpMode() {
		return (mode.equals(CompilerMode.Test)) ? new ArrayList<>() : dumpMode;
	}

	public boolean isDebug() {
		return debug;
	}

	public void printUsage() {
		System.out.println("EMPTY");
	}
}