import com.github.emilybache.api.DiceRollDto;
import com.github.emilybache.api.YatzyScoreApi;
import com.github.emilybache.impl.YatzyScoreApiImpl;

import static com.github.emilybache.api.DiceRollDto.of;

public class Yatzy {
    private static final YatzyScoreApi instance = YatzyScoreApiImpl.getInstance();

    protected DiceRollDto roll;

    public Yatzy(int die1, int die2, int die3, int die4, int die5) {
        roll = DiceRollDto.of(die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryChance(DiceRollDto)
     */
    public static <T extends DiceRollDto> int chance(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategoryChance(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFourOfAKind(DiceRollDto)
     */
    public static int four_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategoryFourOfAKind(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFullHouse(DiceRollDto)
     */
    public static int fullHouse(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategoryFullHouse(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryLargeStraight(DiceRollDto)
     */
    public static int largeStraight(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategoryLargeStraight(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryOnes(DiceRollDto)
     */
    public static int ones(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategoryOnes(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryPair(DiceRollDto)
     */
    public static int score_pair(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategoryPair(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategorySmallStraight(DiceRollDto)
     */
    public static int smallStraight(int die1, int die2, int die3, int die4, int die5) {
        return instance.scoreForCategorySmallStraight(of(die1, die2, die3, die4, die5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryThreeOfAKind(DiceRollDto)
     */
    public static int three_of_a_kind(int dice1, int dice2, int dice3, int dice4, int dice5) {
        return instance.scoreForCategoryThreeOfAKind(of(dice1, dice2, dice3, dice4, dice5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryThrees(DiceRollDto)
     */
    public static int threes(int dice1, int dice2, int dice3, int dice4, int dice5) {
        return instance.scoreForCategoryThrees(of(dice1, dice2, dice3, dice4, dice5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryTwoPairs(DiceRollDto)
     */
    public static int two_pair(int dice1, int dice2, int dice3, int dice4, int dice5) {
        return instance.scoreForCategoryTwoPairs(of(dice1, dice2, dice3, dice4, dice5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryTwos(DiceRollDto)
     */
    public static int twos(int dice1, int dice2, int dice3, int dice4, int dice5) {
        return instance.scoreForCategoryTwos(of(dice1, dice2, dice3, dice4, dice5));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryYatzy(DiceRollDto)
     */
    public static int yatzy(int... dice) {
        return instance.scoreForCategoryYatzy(of(dice));
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFives(DiceRollDto)
     */
    public int fives() {
        return instance.scoreForCategoryFives(this.roll);
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFours(DiceRollDto)
     */
    public int fours() {
        return instance.scoreForCategoryFours(this.roll);
    }

    /**
     * @see YatzyScoreApi#scoreForCategorySixes(DiceRollDto)
     */
    public int sixes() {
        return instance.scoreForCategorySixes(this.roll);
    }
}



