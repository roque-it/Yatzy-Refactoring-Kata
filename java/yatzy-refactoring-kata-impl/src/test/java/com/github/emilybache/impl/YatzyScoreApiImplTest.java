package com.github.emilybache.impl;

import com.github.emilybache.api.YatzyScoreApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.emilybache.api.YatzeCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyScoreApiImplTest {

    private static YatzyScoreApi api;

    @BeforeAll
    public static void beforeAll() {
        api = new YatzyScoreApiImpl();
    }

    @Test
    void scoreForCategoryChance() {
        //From javadoc examples
        assertEquals(14, api.processScore(CHANCE, 1, 1, 3, 3, 6));
        assertEquals(21, api.processScore(CHANCE, 4, 5, 5, 6, 1));

        //From legacy tests
        assertEquals(15, api.processScore(CHANCE, 2, 3, 4, 5, 1));
        assertEquals(16, api.processScore(CHANCE, 3, 3, 4, 5, 1));
    }

    @Test
    void scoreForCategoryFives() {
        //From legacy tests
        assertEquals(10, api.processScore(FIVES, 4, 4, 4, 5, 5));
        assertEquals(15, api.processScore(FIVES, 4, 4, 5, 5, 5));
        assertEquals(20, api.processScore(FIVES, 4, 5, 5, 5, 5));
    }

    @Test
    void scoreForCategoryFourOfAKind() {
        //From javadoc examples
        assertEquals(8, api.processScore(FOUR_OF_A_KIND, 2, 2, 2, 2, 5));
        assertEquals(0, api.processScore(FOUR_OF_A_KIND, 2, 2, 2, 5, 5));
        assertEquals(8, api.processScore(FOUR_OF_A_KIND, 2, 2, 2, 2, 2));

        //From legacy tests
        assertEquals(12, api.processScore(FOUR_OF_A_KIND, 3, 3, 3, 3, 5));
        assertEquals(20, api.processScore(FOUR_OF_A_KIND, 5, 5, 5, 4, 5));
        assertEquals(12, api.processScore(FOUR_OF_A_KIND, 3, 3, 3, 3, 3));
    }

    @Test
    void scoreForCategoryFours() {
        //From javadoc examples
        assertEquals(8, api.processScore(FOURS, 1, 1, 2, 4, 4));

        //From legacy tests
        assertEquals(12, api.processScore(FOURS, 4, 4, 4, 5, 5));
        assertEquals(8, api.processScore(FOURS, 4, 4, 5, 5, 5));
        assertEquals(4, api.processScore(FOURS, 4, 5, 5, 5, 5));
    }

    @Test
    void scoreForCategoryFullHouse() {
        //From javadoc examples
        assertEquals(8, api.processScore(FULL_HOUSE, 1, 1, 2, 2, 2));
        assertEquals(0, api.processScore(FULL_HOUSE, 2, 2, 3, 3, 4));
        assertEquals(0, api.processScore(FULL_HOUSE, 4, 4, 4, 4, 4));

        //From legacy tests
        assertEquals(18, api.processScore(FULL_HOUSE, 6, 2, 2, 2, 6));
        assertEquals(0, api.processScore(FULL_HOUSE, 2, 3, 4, 5, 6));
    }

    @Test
    void scoreForCategoryLargeStraight() {
        //From legacy tests
        assertEquals(20, api.processScore(LARGE_STRAIGHT, 6, 2, 3, 4, 5));
        assertEquals(20, api.processScore(LARGE_STRAIGHT, 2, 3, 4, 5, 6));
        assertEquals(0, api.processScore(LARGE_STRAIGHT, 1, 2, 2, 4, 5));
    }

    @Test
    void scoreForCategoryOnes() {
        //From javadoc examples
        assertEquals(0, api.processScore(ONES, 3, 3, 3, 4, 5));

        //From legacy tests
        assertEquals(1, api.processScore(ONES, 1, 2, 3, 4, 5));
        assertEquals(2, api.processScore(ONES, 1, 2, 1, 4, 5));
        assertEquals(0, api.processScore(ONES, 6, 2, 2, 4, 5));
        assertEquals(4, api.processScore(ONES, 1, 2, 1, 1, 1));
    }

    @Test
    void scoreForCategoryPair() {
        //From javadoc examples
        assertEquals(0, api.processScore(PAIR, 1, 2, 3, 4, 5));
        assertEquals(8, api.processScore(PAIR, 3, 3, 3, 4, 4));
        assertEquals(12, api.processScore(PAIR, 1, 1, 6, 2, 6));
        assertEquals(6, api.processScore(PAIR, 3, 3, 3, 4, 1));
        assertEquals(6, api.processScore(PAIR, 3, 3, 3, 3, 1));

        //From legacy tests
        assertEquals(6, api.processScore(PAIR, 3, 4, 3, 5, 6));
        assertEquals(10, api.processScore(PAIR, 5, 3, 3, 3, 5));
        assertEquals(12, api.processScore(PAIR, 5, 3, 6, 6, 5));
    }

    @Test
    void scoreForCategorySixes() {
        //From legacy tests
        assertEquals(0, api.processScore(SIXES, 4, 4, 4, 5, 5));
        assertEquals(6, api.processScore(SIXES, 4, 4, 6, 5, 5));
        assertEquals(18, api.processScore(SIXES, 6, 5, 6, 6, 5));
    }

    @Test
    void scoreForCategorySmallStraight() {
        //From legacy tests
        assertEquals(15, api.processScore(SMALL_STRAIGHT, 1, 2, 3, 4, 5));
        assertEquals(15, api.processScore(SMALL_STRAIGHT, 2, 3, 4, 5, 1));
        assertEquals(0, api.processScore(SMALL_STRAIGHT, 1, 2, 2, 4, 5));
    }

    @Test
    void scoreForCategoryThreeOfAKind() {
        //From javadoc examples
        assertEquals(9, api.processScore(THREE_OF_A_KIND, 3, 3, 3, 4, 5));
        assertEquals(0, api.processScore(THREE_OF_A_KIND, 3, 3, 4, 5, 6));
        assertEquals(9, api.processScore(THREE_OF_A_KIND, 3, 3, 3, 3, 1));

        //From legacy tests
        assertEquals(9, api.processScore(THREE_OF_A_KIND, 3, 3, 3, 3, 3));
        assertEquals(9, api.processScore(THREE_OF_A_KIND, 3, 3, 3, 4, 5));
        assertEquals(15, api.processScore(THREE_OF_A_KIND, 5, 3, 5, 4, 5));
        assertEquals(9, api.processScore(THREE_OF_A_KIND, 3, 3, 3, 3, 5));
    }

    @Test
    void scoreForCategoryThrees() {
        //From legacy tests
        assertEquals(6, api.processScore(THREES, 1, 2, 3, 2, 3));
        assertEquals(12, api.processScore(THREES, 2, 3, 3, 3, 3));
    }

    @Test
    void scoreForCategoryTwoPairs() {
        //From javadoc examples
        assertEquals(8, api.processScore(TWO_PAIRS, 1, 1, 2, 3, 3));
        assertEquals(0, api.processScore(TWO_PAIRS, 1, 1, 2, 3, 4));
        assertEquals(6, api.processScore(TWO_PAIRS, 1, 1, 2, 2, 2));
        assertEquals(0, api.processScore(TWO_PAIRS, 3, 3, 3, 3, 1));

        //From legacy tests
        assertEquals(16, api.processScore(TWO_PAIRS, 3, 3, 5, 4, 5));
        assertEquals(16, api.processScore(TWO_PAIRS, 3, 3, 5, 5, 5));
    }

    @Test
    void scoreForCategoryTwos() {
        //From javadoc examples
        assertEquals(4, api.processScore(TWOS, 2, 3, 2, 5, 1));

        //From legacy tests
        assertEquals(4, api.processScore(TWOS, 1, 2, 3, 2, 6));
        assertEquals(10, api.processScore(TWOS, 2, 2, 2, 2, 2));
    }

    @Test
    void scoreForCategoryYatzy() {
        //From javadoc examples
        assertEquals(50, api.processScore(YATZY, 1, 1, 1, 1, 1));
        assertEquals(0, api.processScore(YATZY, 1, 1, 1, 2, 1));

        //From legacy tests
        assertEquals(50, api.processScore(YATZY, 4, 4, 4, 4, 4));
        assertEquals(50, api.processScore(YATZY, 6, 6, 6, 6, 6));
        assertEquals(0, api.processScore(YATZY, 6, 6, 6, 6, 3));
    }
}
