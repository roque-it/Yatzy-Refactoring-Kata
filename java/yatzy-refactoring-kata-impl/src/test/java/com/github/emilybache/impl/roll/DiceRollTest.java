package com.github.emilybache.impl.roll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

class DiceRollTest {
    @Test
    void countByFace() {
        Map<Integer, Integer> expected = Map.of(1, 1, 2, 2, 5, 1, 3, 1);
        Assertions.assertEquals(expected, newDiceRoll(1, 2, 2, 5, 3).countByFace());
    }

    @Test
    void findNTuple() {
        Assertions.assertEquals(Set.of(), newDiceRoll(1, 2, 2, 5, 3).findNTuple(3));
        Assertions.assertEquals(Set.of(1), newDiceRoll(1, 2, 1, 5, 3).findNTuple(2));
        Assertions.assertEquals(Set.of(1, 3), newDiceRoll(1, 3, 1, 5, 3).findNTuple(2));
        Assertions.assertEquals(Set.of(), newDiceRoll(1, 3, 1, 5, 3).findNTuple(4));
    }

    @Test
    void getSortedDice() {
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5), newDiceRoll(5, 4, 3, 2, 1).getSortedDice());
        Assertions.assertEquals(List.of(1, 1, 2, 3, 5), newDiceRoll(1, 2, 1, 5, 3).getSortedDice());
    }

    @Test
    void sum() {
        Assertions.assertEquals(15, newDiceRoll(5, 4, 3, 2, 1).sum());
        Assertions.assertEquals(12, newDiceRoll(1, 2, 1, 5, 3).sum());
    }

    @Test
    void sumWithFace() {
        Assertions.assertEquals(2, newDiceRoll(1, 2, 1, 5, 3).sumWithFace(1));
        Assertions.assertEquals(18, newDiceRoll(1, 6, 1, 6, 6).sumWithFace(6));
    }

    private static DiceRoll newDiceRoll(int... dice) {
        return new DiceRollBuilder().dice(dice).build();
    }
}
