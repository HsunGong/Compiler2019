package mxcompiler.utils;

/** a static class to store String */
public class Tool {
    public static final String STATIC_DATA = "__d_";
    public static final String BLOCK = "__b_";//block

    // region builtIn
    // class

    public static final String STRING = "string"; // string x;
    public static final String ARRAY = "_array";
    public static final String THIS = "__this";
    public static final String DOMAIN = ".";

    // function
    public static final String PRINT = "print";
    public static final String PRINTLN = "println";
    public static final String PRINTINT = "_printInt";
    public static final String PRINTLNINT = "_printlnInt";
    public static final String GETSTRING = "getString";
    public static final String GETINT = "getInt";
    public static final String TOSTRING = "toString";

    public static final String SUBSTRING = "substring";
    public static final String PARSEINT = "parseInt";
    public static final String ORD = "ord";
    public static final String SIZE = "size";
    public static final String LENGTH = "length";

    public static final String STRING_CONCAT = "concat";
    public static final String STRING_EQUAL = "equal";
    public static final String STRING_INEQUAL = "inequal";
    public static final String STRING_LESS = "less";
    public static final String STRING_LESS_EQUAL = "less_equal";

    public static final String PRINT_KEY = PRINT;
    public static final String PRINTLN_KEY = PRINTLN;
    public static final String PRINTINT_KEY = PRINTINT;
    public static final String PRINTLNINT_KEY = PRINTLNINT;
    public static final String GETSTRING_KEY = GETSTRING;
    public static final String GETINT_KEY = GETINT;
    public static final String TOSTRING_KEY = TOSTRING;

    public static final String SUBSTRING_KEY = STRING + DOMAIN + SUBSTRING;
    public static final String PARSEINT_KEY = STRING + DOMAIN + PARSEINT;
    public static final String ORD_KEY = STRING + DOMAIN + ORD;
    public static final String LENGTH_KEY = STRING + DOMAIN + LENGTH;

    public static final String SIZE_KEY = ARRAY + DOMAIN + SIZE;

    public static final String STRING_CONCAT_KEY = STRING + DOMAIN + STRING_CONCAT;
    public static final String STRING_EQUAL_KEY = STRING + DOMAIN + STRING_EQUAL;
    public static final String STRING_INEQUAL_KEY = STRING + DOMAIN + STRING_INEQUAL;
    public static final String STRING_LESS_KEY = STRING + DOMAIN + STRING_LESS;
    public static final String STRING_LESS_EQUAL_KEY = STRING + DOMAIN + STRING_LESS_EQUAL;

    // endregion
}