package com.wordreplacer;

public class Replacer {

    public static String replace(String str) {
        for (String w : Config.getWords()) {
            str = str.replaceAll(w, w + Config.getSymbol());
        }
        return str;
    }
}
