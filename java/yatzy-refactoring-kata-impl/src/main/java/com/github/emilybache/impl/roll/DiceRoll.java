package com.github.emilybache.impl.roll;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Model for a roll of dice.
 * DiceRoll must be created with the specific builder. @see {@link DiceRollBuilder}
 */
public class DiceRoll {
    private final List<Integer> dice;

    //Package scope constructor
    DiceRoll(List<Integer> dice) {
        this.dice = dice;
    }

    /**
     * Return a map where keys are the differents faces of the dice, and values are the equivalent count of each face.
     * The return is never null
     * Example: Dice roll 1,2,2,5,3 should return a map with <1:1, 2:2, 5:1, 3:1>
     *
     * @return a map with faces as key, and count of each face as value
     */
    public Map<Integer, Integer> countByFace() {
        return dice.stream()
            .collect(groupingBy(identity(), summingInt(i -> 1)));
    }

    /**
     * Return a set of dice faces present at least n times in the roll
     * The return is never null
     *
     * @param n: minimum number of faces
     * @return set of dice faces present at least n times
     */
    public Set<Integer> findNTuple(int n) {
        return this.countByFace().entrySet().stream()
            .filter(e -> e.getValue() >= n)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
    }

    /**
     * Return the sum of all faces.
     *
     * @return the sum
     */
    public int sum() {
        return dice.stream()
            .mapToInt(i -> i)
            .sum();
    }

    /**
     * Return the sum of faces with a specific value 'value'.
     *
     * @param value: the specific value
     * @return the sum
     */
    public int sumWithFace(int value) {
        return dice.stream()
            .filter(die -> die==value)
            .mapToInt(i -> i)
            .sum();
    }

    /**
     * Returns a list consisting of the faces of this roll, sorted according to natural order.
     * The return is never null
     *
     * @return the sorted list
     */
    public List<Integer> getSortedDice() {
        return dice.stream().sorted().collect(Collectors.toList());
    }
}
