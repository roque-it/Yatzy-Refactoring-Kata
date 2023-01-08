package com.github.emilybache.impl.roll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiceRollBuilderTest {

    @Test
    void build() {
        assertThrows(AssertionError.class, () -> new DiceRollBuilder().dice().build());
        assertThrows(AssertionError.class, () -> new DiceRollBuilder().dice(null).build());
        assertThrows(AssertionError.class, () -> new DiceRollBuilder().dice(1, 2).build());
        assertThrows(AssertionError.class, () -> new DiceRollBuilder().dice(1, 2, 3, 4, 5, 6).build());
        assertThrows(AssertionError.class, () -> new DiceRollBuilder().dice(0, 1, 2, 3, 4).build());
        assertThrows(AssertionError.class, () -> new DiceRollBuilder().dice(3, 4, 5, 6, 7).build());

        assertDoesNotThrow(() -> new DiceRollBuilder().dice(1, 2, 3, 4, 5).build());
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(1, 1, 1, 1, 1).build());
    }

    @Test
    void dice() {
        assertDoesNotThrow(() -> new DiceRollBuilder().dice());
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(null));
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(1, 2));
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(0, 1, 2, 3, 4));
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(3, 4, 5, 6, 7));

        assertDoesNotThrow(() -> new DiceRollBuilder().dice(1, 2, 3, 4, 5));
        assertDoesNotThrow(() -> new DiceRollBuilder().dice(1, 1, 1, 1, 1));
    }

}
