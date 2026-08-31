package com.ninjaz.wordlesolver.CLI;

/** Each letter definitely contains three pieces of data:
 * - The letter (always uppercased)
 * - The color, represented as a character (TODO: MAKE THIS AN ENUM)
 *      'B' = Black, 'Y' = Yellow, 'G' = Green
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

        if (color != 'B' && color != 'Y' && color != 'G') { // TODO: let's use an enum here instead, for color
            throw new IllegalArgumentException("Invalid color: " + color);
        }

        if (position < 0) {
            throw new IllegalArgumentException("Cannot have a negative position: " + position);
        }
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
}
