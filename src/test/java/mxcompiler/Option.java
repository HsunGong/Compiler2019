package mxcompiler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import mxcompiler.error.OptionError;
import mxcompiler.CompilerMode.DumpMode;

public class Option {

	/** only support 1 source file */
	private File src = null;
	private File output = null;
	private CompilerMode mode = null;
	private List<DumpMode> dumpMode = new ArrayList<>();
	private int level = 0;
	private boolean debug = false;

	public Option(String[] args) throws OptionError {
		parseArgs(args);
	}

	void parseArgs(String[] Args) throws OptionError {
		ListIterator<String> args = Arrays.asList(Args).listIterator();
		while (args.hasNext()) {
			String arg = args.next();
			if (arg.startsWith("-")) {
				if (CompilerMode.isModeOption(arg)) {
					if (mode != null) {
						throw new OptionError(mode.getOption() + " option and " + arg + " option is exclusive");
					}
					mode = CompilerMode.fromOption(arg);
				} else if (DumpMode.isModeOption(arg)) {
					dumpMode.add(DumpMode.fromOption(arg));
				} else if (arg.startsWith("-o")) { 
					// attention: dump to dump.out can not change
					// is asm-out
					if (args.hasNext()) {
						output = new File(args.next());
					} else {
						output = new File("./a.out");
					}
				} else if (arg.startsWith("-O")) {
					String type = arg.substring(2);
					if (!type.matches("^([0123s]|)$")) {
						throw new OptionError("unknown optimization switch: " + arg);
					}
					level = (type.equals("s") ? 3 : Integer.parseInt(type));
				} else if (arg.equals("--version") || arg.equals("-v")) {
					System.exit(0);
				} else if (arg.equals("--help") || arg.equals("-h")) {
					printUsage();
					System.exit(0);
				} else {
					throw new OptionError("unknown option: " + arg);
				}
			} else if (src == null) {
				try {
					src = new File(arg);
				} catch (Exception e) {
					throw new OptionError(e.getMessage());
				}
			} else {
				throw new OptionError("too many srcs");
			}
		}

		if (mode == null) {
			mode = CompilerMode.Default;
		}
	}

	public File sourceFile() {
		return src;
	}

	// TODO: may support output to system.out
	public File outputFile() {
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