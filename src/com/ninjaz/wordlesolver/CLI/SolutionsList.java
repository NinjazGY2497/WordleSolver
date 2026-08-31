package com.ninjaz.wordlesolver.CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
            if (Character.toUpperCase(letter.letter) == Character.toUpperCase(targetLetter)) { // If the Letter object is of the target letter character, we declare it as a match
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
            if (Character.toUpperCase(letter.color) == Character.toUpperCase(targetColor)) { // If the Letter is of the target color, we declare it a match
                matchingLetters.add(letter);
            }
        }

        return matchingLetters.toArray(Letter[]::new);
    }

    // /** Sorts the Letters based on their color attribute
    //  * - The order is: Green, Yellow, Black */
    // private static Letter[] sortGYB(Letter[] letterArray) {
    //     ArrayList<Letter> colorSortedLetters = new ArrayList<>();
    //
    //     for (char color : new char[] {'G', 'Y', 'B'}) {
    //         colorSortedLetters.addAll(List.of(filterForColor(color, letterArray))); // Adds all the 'G' letters, then all the 'Y' letters, then all the 'B' letters to the ArrayList
    //     }
    //
    //     return colorSortedLetters.toArray(Letter[]::new);
    // }

    /** Removes duplicates from a Letter array by converting the array to a HashSet and then back to an array
     * - Note: returns a copy */
    private static Letter[] removeDuplicateLetters(Letter[] letterArray) {
        HashSet<Letter> set = new HashSet<>(List.of(letterArray)); // Convert to a HashSet to remove duplicates
        return set.toArray(Letter[]::new); // Convert back to an array
    }

    // public boolean isSolution(String suspectWord) {
    //     for (Letter[] boardWord : boardWords) { // Loop through each row (word) in the Wordle grid
    //         Letter[] uniqueLetters = removeDuplicatesFromArray(boardWord);
    //
    //         for (Letter uniqueLetter : uniqueLetters) {
    //             Letter[] letterList = filterForLetter(uniqueLetter.letter, boardWord); // Gets all the letters matching the current unique letter in the word
    //
    //             // Check #1 - Determines required counts of the unique letter in the answer, indicated by the black unique letters
    //             int totalCount = letterList.length;
    //             int blackLetterCount = filterForColor('B', letterList).length;
    //
    //             int letterCountInSuspect = filterForLetter(uniqueLetter.letter, suspectWord);
    //
    //             if (blackLetterCount == 0) {
    //                 int requiredCountInAnswer = totalCount - blackLetterCount;
    //
    //             }
    //         }
    //     }
    // }

    // ---- Other ----
    public ArrayList<String> getSolutions() {
        return solutions;
    }

    public static void main(String[] args) {
        Letter[] myWord = {new Letter('A', 'B', 2), new Letter('B', 'G', 4), new Letter('C', 'B', 1), new Letter('D', 'G', 3), new Letter('D', 'Y', 2)};
        System.out.println(Arrays.toString(removeDuplicateLetters(myWord)));
    }
}
