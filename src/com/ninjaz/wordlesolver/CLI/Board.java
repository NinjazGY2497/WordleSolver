package com.ninjaz.wordlesolver.CLI;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private final int WORD_LENGTH = 5;
    private final int ROWS = 6;

    private final ArrayList<Letter[]> words = new ArrayList<>(); // An ArrayList of arrays of Letters

    public void addWord(String word, String colors) {
        word = word.strip();
        colors = colors.strip();

        if (word.length() != WORD_LENGTH || colors.length() != WORD_LENGTH) { // Make sure new word (and its colors) is correct length
            throw new IllegalArgumentException("The passed in 'word' and 'colors' arguments must be of length " + WORD_LENGTH);
        }

        if (words.size() >= ROWS) { // Make sure there's still room for another word
            throw new IllegalStateException("Board is full; no new words may be added");
        }

        words.add(Letter.toLetterArray(word, colors));
    }

    public ArrayList<Letter[]> getWords() {
        return words;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();

        for (Letter[] word : words) {
            board.append(Arrays.toString(word)).append("\n");
        }

        return board.toString();
    }
}
