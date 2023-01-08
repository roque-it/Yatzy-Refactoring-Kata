package com.github.emilybache.impl;

import com.github.emilybache.api.DiceRollDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceRollTest {

    @Test
    void from() {
        assertThrows(AssertionError.class, () -> DiceRoll.from(null));
        assertThrows(AssertionError.class, () -> DiceRoll.from(DiceRollDto.of()));
        assertThrows(AssertionError.class, () -> DiceRoll.from(DiceRollDto.of(null)));
        assertThrows(AssertionError.class, () -> DiceRoll.from(DiceRollDto.of(1, 2)));
        assertThrows(AssertionError.class, () -> DiceRoll.from(DiceRollDto.of(1, 2, 3, 4, 5, 6)));
        assertThrows(AssertionError.class, () -> DiceRoll.from(DiceRollDto.of(0, 1, 2, 3, 4)));
        assertThrows(AssertionError.class, () -> DiceRoll.from(DiceRollDto.of(3, 4, 5, 6, 7)));

        assertDoesNotThrow(() -> DiceRoll.from(DiceRollDto.of(1, 2, 3, 4, 5)));
        assertDoesNotThrow(() -> DiceRoll.from(DiceRollDto.of(1, 1, 1, 1, 1)));
    }

    @Test
    void getDice() {
        int[] dice = {3, 2, 1, 2, 1};
        DiceRoll roll = DiceRoll.from(DiceRollDto.of(dice));

        assertArrayEquals(dice, roll.getDice());
        assertNotSame(dice, roll.getDice());
    }

    @Test
    void getDie() {
        int[] dice = {5, 4, 3, 2, 1};
        DiceRoll roll = DiceRoll.from(DiceRollDto.of(dice));

        assertEquals(5, roll.getDie(1));
        assertEquals(4, roll.getDie(2));
        assertEquals(3, roll.getDie(3));
        assertEquals(2, roll.getDie(4));
        assertEquals(1, roll.getDie(5));

        assertThrows(AssertionError.class, () -> roll.getDie(0));
        assertThrows(AssertionError.class, () -> roll.getDie(-1));
        assertThrows(AssertionError.class, () -> roll.getDie(6));
    }
}
