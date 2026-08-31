package com.ninjaz.wordlesolver.CLI;

public class Main {
    public static final String DICTIONARY_PATH = "src/com/ninjaz/wordlesolver/CLI/all-5-letter-words.txt";


    public static void main(String[] args) {
        WordDictionary wordDict = new WordDictionary(DICTIONARY_PATH);
        Board board = new Board(wordDict);

        board.addWord("HeLLO", "BBBBB");
        board.addWord("HELLO", "BBBBB");

        System.out.println(board);
    }
}
