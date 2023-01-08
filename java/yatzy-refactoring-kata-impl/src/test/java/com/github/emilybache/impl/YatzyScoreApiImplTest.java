package com.github.emilybache.impl;

import com.github.emilybache.api.YatzyScoreApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.emilybache.api.DiceRollDto.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyScoreApiImplTest {

    private static YatzyScoreApi api;

    @BeforeAll
    public static void beforeAll() {
        api = YatzyScoreApiImpl.getInstance();
    }

    @Test
    void scoreForCategoryChance() {
        //From javadoc examples
        assertEquals(14, api.scoreForCategoryChance(of(1, 1, 3, 3, 6)));
        assertEquals(21, api.scoreForCategoryChance(of(4, 5, 5, 6, 1)));

        //From legacy tests
        assertEquals(15, api.scoreForCategoryChance(of(2, 3, 4, 5, 1)));
        assertEquals(16, api.scoreForCategoryChance(of(3, 3, 4, 5, 1)));
    }

    @Test
    void scoreForCategoryFives() {
        //From legacy tests
        assertEquals(10, api.scoreForCategoryFives(of(4, 4, 4, 5, 5)));
        assertEquals(15, api.scoreForCategoryFives(of(4, 4, 5, 5, 5)));
        assertEquals(20, api.scoreForCategoryFives(of(4, 5, 5, 5, 5)));
    }

    @Test
    void scoreForCategoryFourOfAKind() {
        //From javadoc examples
        assertEquals(8, api.scoreForCategoryFourOfAKind(of(2, 2, 2, 2, 5)));
        assertEquals(0, api.scoreForCategoryFourOfAKind(of(2, 2, 2, 5, 5)));
        assertEquals(8, api.scoreForCategoryFourOfAKind(of(2, 2, 2, 2, 2)));

        //From legacy tests
        assertEquals(12, api.scoreForCategoryFourOfAKind(of(3, 3, 3, 3, 5)));
        assertEquals(20, api.scoreForCategoryFourOfAKind(of(5, 5, 5, 4, 5)));
        assertEquals(12, api.scoreForCategoryFourOfAKind(of(3, 3, 3, 3, 3)));
    }

    @Test
    void scoreForCategoryFours() {
        //From javadoc examples
        assertEquals(8, api.scoreForCategoryFours(of(1, 1, 2, 4, 4)));

        //From legacy tests
        assertEquals(12, api.scoreForCategoryFours(of(4, 4, 4, 5, 5)));
        assertEquals(8, api.scoreForCategoryFours(of(4, 4, 5, 5, 5)));
        assertEquals(4, api.scoreForCategoryFours(of(4, 5, 5, 5, 5)));
    }

    @Test
    void scoreForCategoryFullHouse() {
        //From javadoc examples
        assertEquals(8, api.scoreForCategoryFullHouse(of(1, 1, 2, 2, 2)));
        assertEquals(0, api.scoreForCategoryFullHouse(of(2, 2, 3, 3, 4)));
        assertEquals(0, api.scoreForCategoryFullHouse(of(4, 4, 4, 4, 4)));

        //From legacy tests
        assertEquals(18, api.scoreForCategoryFullHouse(of(6, 2, 2, 2, 6)));
        assertEquals(0, api.scoreForCategoryFullHouse(of(2, 3, 4, 5, 6)));
    }

    @Test
    void scoreForCategoryLargeStraight() {
        //From legacy tests
        assertEquals(20, api.scoreForCategoryLargeStraight(of(6, 2, 3, 4, 5)));
        assertEquals(20, api.scoreForCategoryLargeStraight(of(2, 3, 4, 5, 6)));
        assertEquals(0, api.scoreForCategoryLargeStraight(of(1, 2, 2, 4, 5)));
    }

    @Test
    void scoreForCategoryOnes() {
        //From javadoc examples
        assertEquals(0, api.scoreForCategoryOnes(of(3, 3, 3, 4, 5)));

        //From legacy tests
        assertEquals(1, api.scoreForCategoryOnes(of(1, 2, 3, 4, 5)));
        assertEquals(2, api.scoreForCategoryOnes(of(1, 2, 1, 4, 5)));
        assertEquals(0, api.scoreForCategoryOnes(of(6, 2, 2, 4, 5)));
        assertEquals(4, api.scoreForCategoryOnes(of(1, 2, 1, 1, 1)));
    }

    @Test
    void scoreForCategoryPair() {
        //From javadoc examples
        assertEquals(0, api.scoreForCategoryPair(of(1, 2, 3, 4, 5)));
        assertEquals(8, api.scoreForCategoryPair(of(3, 3, 3, 4, 4)));
        assertEquals(12, api.scoreForCategoryPair(of(1, 1, 6, 2, 6)));
        assertEquals(6, api.scoreForCategoryPair(of(3, 3, 3, 4, 1)));
        assertEquals(6, api.scoreForCategoryPair(of(3, 3, 3, 3, 1)));

        //From legacy tests
        assertEquals(6, api.scoreForCategoryPair(of(3, 4, 3, 5, 6)));
        assertEquals(10, api.scoreForCategoryPair(of(5, 3, 3, 3, 5)));
        assertEquals(12, api.scoreForCategoryPair(of(5, 3, 6, 6, 5)));
    }

    @Test
    void scoreForCategorySixes() {
        //From legacy tests
        assertEquals(0, api.scoreForCategorySixes(of(4, 4, 4, 5, 5)));
        assertEquals(6, api.scoreForCategorySixes(of(4, 4, 6, 5, 5)));
        assertEquals(18, api.scoreForCategorySixes(of(6, 5, 6, 6, 5)));
    }

    @Test
    void scoreForCategorySmallStraight() {
        //From legacy tests
        assertEquals(15, api.scoreForCategorySmallStraight(of(1, 2, 3, 4, 5)));
        assertEquals(15, api.scoreForCategorySmallStraight(of(2, 3, 4, 5, 1)));
        assertEquals(0, api.scoreForCategorySmallStraight(of(1, 2, 2, 4, 5)));
    }

    @Test
    void scoreForCategoryThreeOfAKind() {
        //From javadoc examples
        assertEquals(9, api.scoreForCategoryThreeOfAKind(of(3, 3, 3, 4, 5)));
        assertEquals(0, api.scoreForCategoryThreeOfAKind(of(3, 3, 4, 5, 6)));
        assertEquals(9, api.scoreForCategoryThreeOfAKind(of(3, 3, 3, 3, 1)));

        //From legacy tests
        assertEquals(9, api.scoreForCategoryThreeOfAKind(of(3, 3, 3, 3, 3)));
        assertEquals(9, api.scoreForCategoryThreeOfAKind(of(3, 3, 3, 4, 5)));
        assertEquals(15, api.scoreForCategoryThreeOfAKind(of(5, 3, 5, 4, 5)));
        assertEquals(9, api.scoreForCategoryThreeOfAKind(of(3, 3, 3, 3, 5)));
    }

    @Test
    void scoreForCategoryThrees() {
        //From legacy tests
        assertEquals(6, api.scoreForCategoryThrees(of(1, 2, 3, 2, 3)));
        assertEquals(12, api.scoreForCategoryThrees(of(2, 3, 3, 3, 3)));
    }

    @Test
    void scoreForCategoryTwoPairs() {
        //From javadoc examples
        assertEquals(8, api.scoreForCategoryTwoPairs(of(1, 1, 2, 3, 3)));
        assertEquals(0, api.scoreForCategoryTwoPairs(of(1, 1, 2, 3, 4)));
        assertEquals(6, api.scoreForCategoryTwoPairs(of(1, 1, 2, 2, 2)));
        assertEquals(0, api.scoreForCategoryTwoPairs(of(3, 3, 3, 3, 1)));

        //From legacy tests
        assertEquals(16, api.scoreForCategoryTwoPairs(of(3, 3, 5, 4, 5)));
        assertEquals(16, api.scoreForCategoryTwoPairs(of(3, 3, 5, 5, 5)));
    }

    @Test
    void scoreForCategoryTwos() {
        //From javadoc examples
        assertEquals(4, api.scoreForCategoryTwos(of(2, 3, 2, 5, 1)));

        //From legacy tests
        assertEquals(4, api.scoreForCategoryTwos(of(1, 2, 3, 2, 6)));
        assertEquals(10, api.scoreForCategoryTwos(of(2, 2, 2, 2, 2)));
    }

    @Test
    void scoreForCategoryYatzy() {
        //From javadoc examples
        assertEquals(50, api.scoreForCategoryYatzy(of(1, 1, 1, 1, 1)));
        assertEquals(0, api.scoreForCategoryYatzy(of(1, 1, 1, 2, 1)));

        //From legacy tests
        assertEquals(50, api.scoreForCategoryYatzy(of(4, 4, 4, 4, 4)));
        assertEquals(50, api.scoreForCategoryYatzy(of(6, 6, 6, 6, 6)));
        assertEquals(0, api.scoreForCategoryYatzy(of(6, 6, 6, 6, 3)));
    }
}
