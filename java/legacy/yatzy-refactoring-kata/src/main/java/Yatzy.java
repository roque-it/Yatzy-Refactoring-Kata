import com.github.emilybache.api.YatzyApi;
import com.github.emilybache.impl.YatzyImpl;

public class Yatzy {
    private final static YatzyApi instance = YatzyImpl.getInstance();

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return instance.chance(d1, d2, d3, d4, d5);
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
        return instance.four_of_a_kind(_1, _2, d3, d4, d5);
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        return instance.fullHouse(d1, d2, d3, d4, d5);
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        return instance.largeStraight(d1, d2, d3, d4, d5);
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return instance.ones(d1, d2, d3, d4, d5);
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        return instance.score_pair(d1, d2, d3, d4, d5);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        return instance.smallStraight(d1, d2, d3, d4, d5);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return instance.three_of_a_kind(d1, d2, d3, d4, d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return instance.threes(d1, d2, d3, d4, d5);
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        return instance.two_pair(d1, d2, d3, d4, d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return instance.twos(d1, d2, d3, d4, d5);
    }

    public static int yatzy(int... dice) {
        return instance.yatzy(dice);
    }

    public int fives() {
        return instance.fives(this.dice);
    }

    public int fours() {
        return instance.fours(this.dice);
    }

    public int sixes() {
        return instance.sixes(this.dice);
    }
}



