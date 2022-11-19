package com.wordreplacer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Config {
    private static final String fileName = "app.config";
    private static String symbol;
    private static List<String> words;

    public Config() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
            symbol = prop.getProperty("symbol");
            words = Arrays.asList(prop.getProperty("words").split(","));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getSymbol() {
        return symbol;
    }

    public static List<String> getWords() {
        return words;
    }
}
