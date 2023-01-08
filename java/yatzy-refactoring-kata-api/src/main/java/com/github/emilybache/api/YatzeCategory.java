package com.github.emilybache.api;

public enum YatzeCategory {
    /**
     * Chance: The player scores the sum of all dice, no matter what they read.
     * For example:
     * - 1,1,3,3,6 placed on “chance” scores 14 (1+1+3+3+6)</li>
     * - 4,5,5,6,1 placed on “chance” scores 21 (4+5+5+6+1)</li>
     */
    CHANCE,

    /**
     * Fives: The player scores the sum of the dice that reads five.
     */
    FIVES,

    /**
     * Fours: The player scores the sum of the dice that reads four.
     * For example:
     * - 1,1,2,4,4 placed on “fours” scores 8 (4+4)
     */
    FOURS,

    /**
     * Four of a kind: If there are four dice with the same number, the player scores the sum of these dice.
     * For example, when placed on “four of a kind”:
     * - 2,2,2,2,5 scores 8 (2+2+2+2)
     * - 2,2,2,5,5 scores 0
     * - 2,2,2,2,2 scores 8 (2+2+2+2)
     */
    FOUR_OF_A_KIND,

    /**
     * Full house: If the dice are two of a kind and three of a kind, the player scores the sum of all the dice.
     * For example, when placed on “full house”:
     * - 1,1,2,2,2 scores 8 (1+1+2+2+2)
     * - 2,2,3,3,4 scores 0
     * - 4,4,4,4,4 scores 0
     */
    FULL_HOUSE,

    /**
     * Large straight: When placed on “large straight”, if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     */
    LARGE_STRAIGHT,
    /**
     * Ones: The player scores the sum of the dice that reads one.
     * For example:
     * - 3,3,3,4,5 placed on “ones” scores 0
     */
    ONES,

    /**
     * Pair: The player scores the sum of the two highest matching dice.
     * For example, when placed on “pair”:
     * - 1,2,3,4,5 scores 0
     * - 3,3,3,4,4 scores 8 (4+4)
     * - 1,1,6,2,6 scores 12 (6+6)
     * - 3,3,3,4,1 scores 6 (3+3)
     * - 3,3,3,3,1 scores 6 (3+3)
     */
    PAIR,

    /**
     * Sixes: The player scores the sum of the dice that reads six.
     */
    SIXES,

    /**
     * Small straight: When placed on “small straight”, if the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice).
     */
    SMALL_STRAIGHT,

    /**
     * Threes: The player scores the sum of the dice that reads three.
     */
    THREES,

    /**
     * Three of a kind: If there are three dice with the same number, the player scores the sum of these dice.
     * For example, when placed on “three of a kind”:
     * - 3,3,3,4,5 scores 9 (3+3+3)
     * - 3,3,4,5,6 scores 0
     * - 3,3,3,3,1 scores 9 (3+3+3)
     */
    THREE_OF_A_KIND,

    /**
     * Twos: The player scores the sum of the dice that reads two.
     * For example:
     * - 2,3,2,5,1 placed on “twos” scores 4 (2+2)
     */
    TWOS,

    /**
     * Two pairs: If there are two pairs of dice with the same number, the player scores the sum of these dice.
     * For example, when placed on “two pairs”:
     * - 1,1,2,3,3 scores 8 (1+1+3+3)
     * - 1,1,2,3,4 scores 0
     * - 1,1,2,2,2 scores 6 (1+1+2+2)
     * - 3,3,3,3,1 scores 0
     */
    TWO_PAIRS,

    /**
     * Yatzy: If all dice have the same number, the player scores 50 points.
     * For example:
     * - 1,1,1,1,1 placed on “yatzy” scores 50
     * - 1,1,1,2,1 placed on “yatzy” scores 0
     */
    YATZY
}
