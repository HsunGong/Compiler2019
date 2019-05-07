package mxcompiler.main;

import java.util.Map;
import java.util.HashMap;


enum CompilerMode {
	Default("-C"), Debug("--debug"), Test("--test");

	static private Map<String, CompilerMode> modes;
	static {
		modes = new HashMap<String, CompilerMode>();
		modes.put("--test", Test); // not realized
		modes.put("-C", Default);
		modes.put("--debug", Debug);
	}

	private final String option;

	CompilerMode(String option) {
		this.option = option;
	}

	static public CompilerMode fromOption(String opt) {
		CompilerMode m = modes.get(opt);
		if (m == null) {
			throw new Error("must not happen: unknown mode option: " + opt);
		}
		return m;
	}

	public String getOption() {
		return option;
	}

	static public boolean isModeOption(String opt) {
		return modes.containsKey(opt);
	}

	enum DumpMode {
		ASTDump("--dump-ast"), ScopeDump("--dump-scope"), IRDump("--dump-ir"), AllDump(
				"--dump-all");

		static private Map<String, DumpMode> modes;
		static {
			modes = new HashMap<String, DumpMode>();
			modes.put("--dump-all", AllDump); // not realized
			modes.put("--dump-ast", ASTDump);
			modes.put("--dump-ir", IRDump);
			modes.put("--dump-scope", ScopeDump);
		}

		private final String option;

		DumpMode(String option) {
			this.option = option;
		}

		static public DumpMode fromOption(String opt) {
			DumpMode m = modes.get(opt);
			if (m == null) {
				throw new Error("must not happen: unknown mode option: " + opt);
			}
			return m;
		}

		public String getOption() {
			return option;
		}

		static public boolean isModeOption(String opt) {
			return modes.containsKey(opt);
		}
	}
}