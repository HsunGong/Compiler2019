package mxcompiler.main;

import java.util.Map;
import java.util.HashMap;

enum CompilerMode{
    Default ("-C"),
    Check 	("--check"),
    Dump    ("--dump");
    static private Map<String, CompilerMode> modes;
    static {
        modes = new HashMap<String, CompilerMode>();
        modes.put("--check", Check); // not realized
        modes.put("-C", Default);
        modes.put("--dump", Dump);
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
}