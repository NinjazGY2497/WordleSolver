package com.ninjaz.wordlesolver.CLI;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private final int WORD_LENGTH = 5;
    private final int ROWS = 6;

    private final WordDictionary wordDict;
    private final ArrayList<Letter[]> words = new ArrayList<>(); // An ArrayList of arrays of Letters

    public Board(WordDictionary wordDict) {
        this.wordDict = wordDict;
    }

    public void addWord(String word, String colors) {
        word = word.strip();
        colors = colors.strip();

        if (word.length() != WORD_LENGTH || colors.length() != WORD_LENGTH) { // Make sure new word (and its colors) is correct length
            throw new IllegalArgumentException("The passed in 'word' and 'colors' arguments must be of length " + WORD_LENGTH);
        }

        if (words.size() >= ROWS) { // Make sure there's still room for another word
            throw new IllegalStateException("Board is full; no new words may be added");
        }

        // Loop through each character of the word and its corresponding color, adding them both to the letterArray
        Letter[] letterArray = new Letter[WORD_LENGTH];
        for (int i = 0; i < word.length(); i++) {
            letterArray[i] = new Letter(word.charAt(i), colors.charAt(i), i);
        }

        words.add(letterArray);
    }

    // public String[] getSolutions() {
    //
    // }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();

        for (Letter[] word : words) {
            board.append(Arrays.toString(word)).append("\n");
        }

        return board.toString();
    }
}
