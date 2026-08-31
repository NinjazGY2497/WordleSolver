package com.ninjaz.wordlesolver.CLI;

import java.util.Arrays;

/** Each letter definitely contains three pieces of data:
 * - The letter (always uppercased)
 * - The color, represented as a character (TODO: MAKE THIS AN ENUM)
 *      'B' = Black, 'Y' = Yellow, 'G' = Green, '?' = Unknown
 * - The position of the letter in the word (0-indexed)
 *      Ex: 1st letter of the word is at Position 0
 *
 *  Two 'Letter' objects with the same 'letter' attribute are considered equal
 * */
public class Letter { // TODO: TO CONVERT TO A RECORD
    public final char letter;
    public final char color;
    public final int position;

    public Letter(char letter, char color, int position) {
        this.letter = Character.toUpperCase(letter);
        this.color = Character.toUpperCase(color);
        this.position = position;

        if (this.color != 'B' && this.color != 'Y' && this.color != 'G' && this.color != '?') { // TODO: let's use an enum here instead, for color
            throw new IllegalArgumentException("Invalid color: " + this.color);
        }

        if (position < 0) {
            throw new IllegalArgumentException("Cannot have a negative position: " + this.position);
        }
    }

    /** Converts a String to a Letter array. However, all the Letter objects have an unknown color: '?' */
    public static Letter[] toColorlessLetterArray(String str) {
        Letter[] letterArray = new Letter[str.length()];
        for (int i = 0; i < letterArray.length; i++) {
            letterArray[i] = new Letter(str.charAt(i), '?', i);
        }

        return letterArray;
    }

    /** Converts a String to a Letter array. Takes in two parameters:
     * A string of letters
     * A string of characters representing the colors corresponding to each letter
     * */
    public static Letter[] toLetterArray(String lettersStr, String colorsStr) {
        if (lettersStr.length() != colorsStr.length()) { // Make sure both passed in Strings are of same length
            throw new IllegalArgumentException("The passed in 'lettersStr' and 'colorsStr' arguments must be of equal length");
        }

        // Loop through each character of the lettersStr and its corresponding color, adding them both to the letterArray
        Letter[] letterArray = new Letter[lettersStr.length()];
        for (int i = 0; i < letterArray.length; i++) {
            letterArray[i] = new Letter(lettersStr.charAt(i), colorsStr.charAt(i), i);
        }

        return letterArray;
    }

    @Override
    public String toString() {
        return "'%c'(color=%c)(pos=%d)".formatted(letter, color, position);
    }

    /** Basic equality checks PLUS extended functionality:
    * If two Letter objects are compared and they have the same 'letter' attribute, they will be declared equal
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Letter otherLetter = (Letter) o;

        return this.letter == otherLetter.letter;
    }

    /** Two different Letter objects with the same 'letter' attribute will have the same hash */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(letter);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(toLetterArray("hello", "BBYGb")));
    }
}
