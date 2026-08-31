package com.ninjaz.wordlesolver.CLI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordDictionary {
    private String[] words;

    public WordDictionary(String path) {
        readDictionaryFile(path);
    }

    private void readDictionaryFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            words = reader.lines().toArray(String[]::new);
        } catch (FileNotFoundException e) {
            System.out.println("File containing all the words not found at location: " + path);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error occurred when performing IO operation: " + e);
        }
    }

    public String[] getWords() {
        return words;
    }
}
