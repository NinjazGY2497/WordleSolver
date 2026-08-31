package com.ninjaz.wordlesolver.CLI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolutionsList {
    private final ArrayList<Letter[]> boardWords;
    private final WordDictionary wordDict;
    private final ArrayList<String> solutions = new ArrayList<>();

    /** Note: if the Board is updated, a new SolutionsList must be instantiated to stay up-to-date */
    public SolutionsList(ArrayList<Letter[]> boardWords, WordDictionary wordDict) {
        this.boardWords = boardWords;
        this.wordDict = wordDict;

        // Iterate through each of the English words in the word list, and check each one of them to see if they're a possible solution
        // based on the clues we have been given from the board
        for (String word : wordDict.getWords()) {
            word = word.toUpperCase();
            if (isSolution(word)) {
                solutions.add(word);
            }
        }
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

    /** Removes duplicates from a Letter array by converting the array to a HashSet and then back to an array
     * - Note: returns a copy */
    private static Letter[] removeDuplicateLetters(Letter[] letterArray) {
        HashSet<Letter> set = new HashSet<>(List.of(letterArray)); // Convert to a HashSet to remove duplicates
        return set.toArray(Letter[]::new); // Convert back to an array
    }

    // TODO: Add an algorithm explanation here
    private boolean isSolution(String suspectWord) {
        for (Letter[] boardWord : boardWords) { // Loop through each row (word) in the Wordle grid
            Letter[] uniqueLetters = removeDuplicateLetters(boardWord);

            for (Letter uniqueLetter : uniqueLetters) {
                Letter[] letterList = filterForLetter(uniqueLetter.letter, boardWord); // Gets all the letters matching the current unique letter in the word

                // Check #1 - Black - Determines required counts of the unique letter in the answer, indicated by the black unique letters
                int totalCount = letterList.length;
                int blackLetterCount = filterForColor('B', letterList).length;

                int letterCountInSuspect = filterForLetter(uniqueLetter.letter, Letter.toColorlessLetterArray(suspectWord)).length; // Simply the count of the uniqueLetter in the suspect word
                if (blackLetterCount == 0) {
                    // No black letters present means suspect word must have a count of AT LEAST "totalCount - blackLetterCount"
                    if (letterCountInSuspect < (totalCount - blackLetterCount)) return false;
                } else {
                    // 1+ black letters present means suspect word must have a count of EXACTLY "totalCount - blackLetterCount"
                    if (letterCountInSuspect != (totalCount - blackLetterCount)) return false;
                }

                // Check #2 - Green - For each green letter, make sure the letter of the suspect word at that corresponding position matches
                for (Letter greenLetter : filterForColor('G', letterList)) {
                    if (suspectWord.charAt(greenLetter.position) != greenLetter.letter) return false; // greenLetter 'position' attribute holds which column it was originally in the boardWord, before it got thrown into a HashSet and unordered
                }

                // Check #3 - Yellow - For each yellow letter, make sure the letter of the suspect word at that corresponding position DOES NOT match
                for (Letter yellowLetter : filterForColor('Y', letterList)) {
                    if (suspectWord.charAt(yellowLetter.position) == yellowLetter.letter) return false;
                }
            }
        }

        return true;
    }

    // ---- Other ----
    public String[] getSolutions() {
        return solutions.toArray(String[]::new);
    }
}
