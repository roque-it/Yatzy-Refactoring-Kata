package com.github.emilybache.impl;

import com.github.emilybache.api.YatzeCategory;
import com.github.emilybache.api.YatzyScoreApi;
import com.github.emilybache.impl.roll.DiceRoll;
import com.github.emilybache.impl.roll.DiceRollBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static com.github.emilybache.api.YatzeCategory.*;

public class YatzyScoreApiImpl implements YatzyScoreApi {
    private static final Map<YatzeCategory, Function<DiceRoll, Integer>> registry = new HashMap<>();

    static {
        registry.put(CHANCE, DiceRoll::sum); //@see YatzeCategory#CHANCE

        //Sum of dice with a specific value
        registry.put(ONES, roll -> roll.sumWithFace(1)); //@see YatzeCategory#ONES
        registry.put(TWOS, roll -> roll.sumWithFace(2)); //@see YatzeCategory#TWOS
        registry.put(THREES, roll -> roll.sumWithFace(3)); //@see YatzeCategory#THREES
        registry.put(FOURS, roll -> roll.sumWithFace(4)); //@see YatzeCategory#FOURS
        registry.put(FIVES, roll -> roll.sumWithFace(5)); //@see YatzeCategory#FIVES
        registry.put(SIXES, roll -> roll.sumWithFace(6)); //@see YatzeCategory#SIXES

        //Compare dice to a specific set
        registry.put(SMALL_STRAIGHT, roll -> List.of(1, 2, 3, 4, 5).equals(roll.getSortedDice()) ? 15:0); //@see YatzeCategory#SMALL_STRAIGHT
        registry.put(LARGE_STRAIGHT, roll -> List.of(2, 3, 4, 5, 6).equals(roll.getSortedDice()) ? 20:0); //@see YatzeCategory#LARGE_STRAIGHT

        //Check if dices read only one face
        registry.put(YATZY, roll -> roll.countByFace().size()==1 ? 50:0); //@see YatzeCategory#YATZY

        //Find n-tuple and sum
        registry.put(PAIR, roll -> scoreForCategoryNumberOfAKind(roll, 2)); //@see YatzeCategory#PAIR
        registry.put(THREE_OF_A_KIND, roll -> scoreForCategoryNumberOfAKind(roll, 3)); //@see YatzeCategory#THREE_OF_A_KIND
        registry.put(FOUR_OF_A_KIND, roll -> scoreForCategoryNumberOfAKind(roll, 4)); //@see YatzeCategory#FOUR_OF_A_KIND

        //More complex categories
        registry.put(TWO_PAIRS, YatzyScoreApiImpl::scoreForCategoryTwoPairs); //@see YatzeCategory#TWO_PAIRS
        registry.put(FULL_HOUSE, YatzyScoreApiImpl::scoreForCategoryFullHouse); //@see YatzeCategory#FULL_HOUSE
    }

    @Override
    public int processScore(YatzeCategory category, int... dice) {
        assert category!=null:"Category should not be null";

        Function<DiceRoll, Integer> function = registry.get(category);
        assert function!=null:"Category " + category + " is not implemented";

        //Check and create dice roll:
        DiceRoll roll = new DiceRollBuilder().dice(dice).build();

        //Execute category function:
        return function.apply(roll);
    }


    /**
     * @see YatzeCategory#FULL_HOUSE
     */
    private static int scoreForCategoryFullHouse(DiceRoll roll) {
        Map<Integer, Integer> countByFaceMap = roll.countByFace();

        //TODO Maybe find a better way
        if (countByFaceMap.size()==2) //As there are only 5 dice, this reduces to 2 possible combinaisons: full house or fourOfAKind
            return countByFaceMap.entrySet().stream()
                .filter(e -> e.getValue()==2 || e.getValue()==3) // Filter to full house combinaison
                .mapToInt(e -> e.getKey() * e.getValue()) // Sum
                .sum();

        return 0;
    }

    private static int scoreForCategoryNumberOfAKind(DiceRoll roll, int number) {
        Set<Integer> tuples = roll.findNTuple(number);

        return tuples.stream()
            .max(Integer::compare)// In case of severable pairs, keep greatest
            .map(i -> i * number)//  Sum
            .orElse(0);
    }

    /**
     * @see YatzeCategory#TWO_PAIRS
     */
    private static int scoreForCategoryTwoPairs(DiceRoll roll) {
        Set<Integer> pairs = roll.findNTuple(2); //Find pairs

        if (pairs.size()==2) {
            return pairs.stream()
                .mapToInt(pair -> pair * 2) //Sum
                .sum();
        }
        return 0;
    }
}
