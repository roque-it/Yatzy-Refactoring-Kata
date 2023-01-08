import com.github.emilybache.api.YatzeCategory;
import com.github.emilybache.api.YatzyScoreApi;
import com.github.emilybache.impl.YatzyScoreApiImpl;

import static com.github.emilybache.api.YatzeCategory.*;

public class Yatzy {
    private static final YatzyScoreApi instance = new YatzyScoreApiImpl();

    protected int[] dice;

    public Yatzy(int die1, int die2, int die3, int die4, int die5) {
        dice = new int[]{die1, die2, die3, die4, die5};
    }

    /**
     * @see YatzeCategory#CHANCE
     */
    public static int chance(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(CHANCE, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#FOUR_OF_A_KIND
     */
    public static int four_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(FOUR_OF_A_KIND, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#FULL_HOUSE
     */
    public static int fullHouse(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(FULL_HOUSE, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#LARGE_STRAIGHT
     */
    public static int largeStraight(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(LARGE_STRAIGHT, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#ONES
     */
    public static int ones(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(ONES, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#PAIR
     */
    public static int score_pair(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(PAIR, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#SMALL_STRAIGHT
     */
    public static int smallStraight(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(SMALL_STRAIGHT, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#THREE_OF_A_KIND
     */
    public static int three_of_a_kind(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(THREE_OF_A_KIND, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#THREES
     */
    public static int threes(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(THREES, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#TWO_PAIRS
     */
    public static int two_pair(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(TWO_PAIRS, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#TWOS
     */
    public static int twos(int die1, int die2, int die3, int die4, int die5) {
        return instance.processScore(TWOS, die1, die2, die3, die4, die5);
    }

    /**
     * @see YatzeCategory#YATZY
     */
    public static int yatzy(int... dice) {
        return instance.processScore(YATZY, dice);
    }

    /**
     * @see YatzeCategory#FIVES
     */
    public int fives() {
        return instance.processScore(FIVES, this.dice);
    }

    /**
     * @see YatzeCategory#FOURS
     */
    public int fours() {
        return instance.processScore(FOURS, this.dice);
    }

    /**
     * @see YatzeCategory#SIXES
     */
    public int sixes() {
        return instance.processScore(SIXES, this.dice);
    }
}



