package com.github.emilybache.impl;

import com.github.emilybache.api.DiceRollDto;
import com.github.emilybache.api.YatzyScoreApi;

public class YatzyScoreApiImpl implements YatzyScoreApi {
    /* Thread safe singleton. @see https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception)#Java*/
    private final static YatzyScoreApiImpl instance = new YatzyScoreApiImpl();

    private YatzyScoreApiImpl() {
    }

    public final static YatzyScoreApiImpl getInstance() {
        return instance;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryChance(DiceRollDto)
     */
    public int scoreForCategoryChance(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int total = 0;
        total += roll.getDie(1);
        total += roll.getDie(2);
        total += roll.getDie(3);
        total += roll.getDie(4);
        total += roll.getDie(5);
        return total;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFives(DiceRollDto)
     */
    public int scoreForCategoryFives(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int s = 0;
        int i;
        int[] dice = roll.getDice();
        for (i = 0; i < dice.length; i++)
            if (dice[i]==5)
                s = s + 5;
        return s;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFourOfAKind(DiceRollDto)
     */
    public int scoreForCategoryFourOfAKind(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] tallies;
        tallies = new int[6];
        tallies[roll.getDie(1) - 1]++;
        tallies[roll.getDie(2) - 1]++;
        tallies[roll.getDie(3) - 1]++;
        tallies[roll.getDie(4) - 1]++;
        tallies[roll.getDie(5) - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFours(DiceRollDto)
     */
    public int scoreForCategoryFours(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int sum;
        sum = 0;
        int[] dice = roll.getDice();
        for (int at = 0; at!=5; at++) {
            if (dice[at]==4) {
                sum += 4;
            }
        }
        return sum;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryFullHouse(DiceRollDto)
     */
    public int scoreForCategoryFullHouse(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[roll.getDie(1) - 1] += 1;
        tallies[roll.getDie(2) - 1] += 1;
        tallies[roll.getDie(3) - 1] += 1;
        tallies[roll.getDie(4) - 1] += 1;
        tallies[roll.getDie(5) - 1] += 1;

        for (i = 0; i!=6; i += 1)
            if (tallies[i]==2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i!=6; i += 1)
            if (tallies[i]==3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryLargeStraight(DiceRollDto)
     */
    public int scoreForCategoryLargeStraight(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] tallies;
        tallies = new int[6];
        tallies[roll.getDie(1) - 1] += 1;
        tallies[roll.getDie(2) - 1] += 1;
        tallies[roll.getDie(3) - 1] += 1;
        tallies[roll.getDie(4) - 1] += 1;
        tallies[roll.getDie(5) - 1] += 1;
        if (tallies[1]==1 &&
                tallies[2]==1 &&
                tallies[3]==1 &&
                tallies[4]==1
                && tallies[5]==1)
            return 20;
        return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryOnes(DiceRollDto)
     */
    public int scoreForCategoryOnes(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int sum = 0;
        if (roll.getDie(1)==1) sum++;
        if (roll.getDie(2)==1) sum++;
        if (roll.getDie(3)==1) sum++;
        if (roll.getDie(4)==1) sum++;
        if (roll.getDie(5)==1)
            sum++;

        return sum;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryPair(DiceRollDto)
     */
    public int scoreForCategoryPair(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] counts = new int[6];
        counts[roll.getDie(1) - 1]++;
        counts[roll.getDie(2) - 1]++;
        counts[roll.getDie(3) - 1]++;
        counts[roll.getDie(4) - 1]++;
        counts[roll.getDie(5) - 1]++;
        int at;
        for (at = 0; at!=6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategorySixes(DiceRollDto)
     */
    public int scoreForCategorySixes(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int sum = 0;
        int[] dice = roll.getDice();
        for (int at = 0; at < dice.length; at++)
            if (dice[at]==6)
                sum = sum + 6;
        return sum;
    }

    /**
     * @see YatzyScoreApi#scoreForCategorySmallStraight(DiceRollDto)
     */
    public int scoreForCategorySmallStraight(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] tallies;
        tallies = new int[6];
        tallies[roll.getDie(1) - 1] += 1;
        tallies[roll.getDie(2) - 1] += 1;
        tallies[roll.getDie(3) - 1] += 1;
        tallies[roll.getDie(4) - 1] += 1;
        tallies[roll.getDie(5) - 1] += 1;
        if (tallies[0]==1 &&
                tallies[1]==1 &&
                tallies[2]==1 &&
                tallies[3]==1 &&
                tallies[4]==1)
            return 15;
        return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryThreeOfAKind(DiceRollDto)
     */
    public int scoreForCategoryThreeOfAKind(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] t;
        t = new int[6];
        t[roll.getDie(1) - 1]++;
        t[roll.getDie(2) - 1]++;
        t[roll.getDie(3) - 1]++;
        t[roll.getDie(4) - 1]++;
        t[roll.getDie(5) - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryThrees(DiceRollDto)
     */
    public int scoreForCategoryThrees(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int s;
        s = 0;
        if (roll.getDie(1)==3) s += 3;
        if (roll.getDie(2)==3) s += 3;
        if (roll.getDie(3)==3) s += 3;
        if (roll.getDie(4)==3) s += 3;
        if (roll.getDie(5)==3) s += 3;
        return s;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryTwoPairs(DiceRollDto)
     */
    public int scoreForCategoryTwoPairs(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] counts = new int[6];
        counts[roll.getDie(1) - 1]++;
        counts[roll.getDie(2) - 1]++;
        counts[roll.getDie(3) - 1]++;
        counts[roll.getDie(4) - 1]++;
        counts[roll.getDie(5) - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n==2)
            return score * 2;
        else
            return 0;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryTwos(DiceRollDto)
     */
    public int scoreForCategoryTwos(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int sum = 0;
        if (roll.getDie(1)==2) sum += 2;
        if (roll.getDie(2)==2) sum += 2;
        if (roll.getDie(3)==2) sum += 2;
        if (roll.getDie(4)==2) sum += 2;
        if (roll.getDie(5)==2) sum += 2;
        return sum;
    }

    /**
     * @see YatzyScoreApi#scoreForCategoryYatzy(DiceRollDto)
     */
    public int scoreForCategoryYatzy(DiceRollDto rollDto) {
        DiceRoll roll = DiceRoll.from(rollDto);

        int[] counts = new int[6];
        int[] dice = roll.getDice();
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i!=6; i++)
            if (counts[i]==5)
                return 50;
        return 0;
    }
}



