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
    /** Remove's any Letter objects that don't have the target 'letter' attribute value
     * Note: returns a copy */
    private static Letter[] filterForLetter(char targetLetter, Letter[] letterArray) {
        ArrayList<Letter> matchingLetters = new ArrayList<>();

        for (Letter letter: letterArray) {
            if (Character.toUpperCase(letter.letter) == Character.toUpperCase(targetLetter)) {
                matchingLetters.add(letter);
            }
        }

        return matchingLetters.toArray(Letter[]::new);
    }

    /** Remove's any Letter objects that don't have the target 'color' attribute value
     * Note: returns a copy */
    private static Letter[] filterForColor(char targetColor, Letter[] letterArray) {
        ArrayList<Letter> matchingLetters = new ArrayList<>();

        for (Letter letter: letterArray) {
            if (Character.toUpperCase(letter.color) == Character.toUpperCase(targetColor)) {
                matchingLetters.add(letter);
            }
        }

        return matchingLetters.toArray(Letter[]::new);
    }

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

    public static void main(String[] args) {
        Letter[] myWord = {new Letter('A', 'B', 2), new Letter('B', 'G', 4), new Letter('C', 'B', 1), new Letter('D', 'G', 3), new Letter('D', 'Y', 2)};
        System.out.println(Arrays.toString(filterForColor('B', myWord)));
    }
}
