package mxcompiler.main;

import java.util.ArrayList;
import java.util.List;

public class Option {


    private List<String> srcs;
    private String Output;

    public Option (String[] args) {
        // will compile to direct file path
        try {
            srcs = new ArrayList<String>();
            srcs.add(args[0]);
        } catch(Exception e) {
            System.out.println("here wrong");
            System.out.println(args[0]);
            System.out.println(srcs.get(0));
        }

        Output = "a.out";
    }
    
    public List<String> sourceFiles() {
        System.out.println(srcs.get(0) instanceof String);
        return srcs;
    }

}