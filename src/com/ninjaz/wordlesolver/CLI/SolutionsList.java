package com.ninjaz.wordlesolver.CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SolutionsList {
    private ArrayList<Letter[]> boardWords;
    WordDictionary wordDict;
    private ArrayList<String> solutions;

    public SolutionsList(ArrayList<Letter[]> boardWords, WordDictionary wordDict) {
        this.boardWords = boardWords;
        this.wordDict = wordDict;
    }

    // // ---- Algorithm ----
    // public boolean isSolution(String suspectWord) {
    //     for (Letter[] boardWord : boardWords) {
    //         // Remove duplicates (convert array to a HashSet and then back to an array)
    //         HashSet<Letter> letterSet = new HashSet<>(Arrays.asList(boardWord));
    //         Letter[] uniqueLetters = letterSet.toArray(Letter[]::new);
    //
    //
    //     }
    // }

    // ---- Other ----
    public ArrayList<String> getSolutions() {
        return solutions;
    }
}
