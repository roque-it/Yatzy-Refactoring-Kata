package com.github.emilybache.api;

public interface YatzyScoreApi {

    /**
     * Chance: The player scores the sum of all dice, no matter what they read.
     * For example:
     * - 1,1,3,3,6 placed on “chance” scores 14 (1+1+3+3+6)</li>
     * - 4,5,5,6,1 placed on “chance” scores 21 (4+5+5+6+1)</li>
     *
     * @param rollDto: the roll of dice.
     * @return the sum of all dice.
     */
    int scoreForCategoryChance(DiceRollDto rollDto);

    /**
     * Fives: The player scores the sum of the dice that reads five.
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the dice that reads five. Zero otherwise.
     */
    int scoreForCategoryFives(DiceRollDto rollDto);

    /**
     * Four of a kind: If there are four dice with the same number, the player scores the sum of these dice.
     * For example, when placed on “four of a kind”:
     * - 2,2,2,2,5 scores 8 (2+2+2+2)
     * - 2,2,2,5,5 scores 0
     * - 2,2,2,2,2 scores 8 (2+2+2+2)
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the four dice with the same number, if exists. Zero otherwise.
     */
    int scoreForCategoryFourOfAKind(DiceRollDto rollDto);

    /**
     * Fours: The player scores the sum of the dice that reads four.
     * For example:
     * - 1,1,2,4,4 placed on “fours” scores 8 (4+4)
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the dice that reads four. Zero otherwise.
     */
    int scoreForCategoryFours(DiceRollDto rollDto);

    /**
     * Full house: If the dice are two of a kind and three of a kind, the player scores the sum of all the dice.
     * For example, when placed on “full house”:
     * - 1,1,2,2,2 scores 8 (1+1+2+2+2)
     * - 2,2,3,3,4 scores 0
     * - 4,4,4,4,4 scores 0
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the two of a kind and three of a kind, if exists. Zero otherwise.
     */
    int scoreForCategoryFullHouse(DiceRollDto rollDto);

    /**
     * Large straight: When placed on “large straight”, if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     *
     * @param rollDto: the roll of dice.
     * @return 20 if the dice read 2,3,4,5,6. Zero otherwise.
     */
    int scoreForCategoryLargeStraight(DiceRollDto rollDto);

    /**
     * Ones: The player scores the sum of the dice that reads one.
     * For example:
     * - 3,3,3,4,5 placed on “ones” scores 0
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the dice that reads one. Zero otherwise.
     */
    int scoreForCategoryOnes(DiceRollDto rollDto);

    /**
     * Pair: The player scores the sum of the two highest matching dice.
     * For example, when placed on “pair”:
     * - 1,2,3,4,5 scores 0
     * - 3,3,3,4,4 scores 8 (4+4)
     * - 1,1,6,2,6 scores 12 (6+6)
     * - 3,3,3,4,1 scores 6 (3+3)
     * - 3,3,3,3,1 scores 6 (3+3)
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the two highest matching dice. Zero otherwise.
     */
    int scoreForCategoryPair(DiceRollDto rollDto);

    /**
     * Sixes: The player scores the sum of the dice that reads six.
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the dice that reads six. Zero otherwise.
     */
    int scoreForCategorySixes(DiceRollDto rollDto);

    /**
     * Small straight: When placed on “small straight”, if the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice).
     *
     * @param rollDto: the roll of dice.
     * @return 15 if the dice read 1,2,3,4,5. Zero otherwise.
     */
    int scoreForCategorySmallStraight(DiceRollDto rollDto);

    /**
     * Three of a kind: If there are three dice with the same number, the player scores the sum of these dice.
     * For example, when placed on “three of a kind”:
     * - 3,3,3,4,5 scores 9 (3+3+3)
     * - 3,3,4,5,6 scores 0
     * - 3,3,3,3,1 scores 9 (3+3+3)
     *
     * @param rollDto: the roll of dice.
     * @return the sum of three dice with the same number. Zero otherwise.
     */
    int scoreForCategoryThreeOfAKind(DiceRollDto rollDto);

    /**
     * Threes: The player scores the sum of the dice that reads three.
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the dice that reads three. Zero otherwise.
     */
    int scoreForCategoryThrees(DiceRollDto rollDto);

    /**
     * Two pairs: If there are two pairs of dice with the same number, the player scores the sum of these dice.
     * For example, when placed on “two pairs”:
     * - 1,1,2,3,3 scores 8 (1+1+3+3)
     * - 1,1,2,3,4 scores 0
     * - 1,1,2,2,2 scores 6 (1+1+2+2)
     * - 3,3,3,3,1 scores 0
     *
     * @param rollDto: the roll of dice.
     * @return the sum of two pairs of dice with the same number. Zero otherwise.
     */
    int scoreForCategoryTwoPairs(DiceRollDto rollDto);

    /**
     * Twos: The player scores the sum of the dice that reads two.
     * For example:
     * - 2,3,2,5,1 placed on “twos” scores 4 (2+2)
     *
     * @param rollDto: the roll of dice.
     * @return the sum of the dice that reads two. Zero otherwise.
     */
    int scoreForCategoryTwos(DiceRollDto rollDto);

    /**
     * Yatzy: If all dice have the same number, the player scores 50 points.
     * For example:
     * - 1,1,1,1,1 placed on “yatzy” scores 50
     * - 1,1,1,2,1 placed on “yatzy” scores 0
     *
     * @param rollDto: the roll of dice.
     * @return 50 if all dice have the same number. Zero otherwise.
     */
    int scoreForCategoryYatzy(DiceRollDto rollDto);
}



