package com.github.emilybache.impl.roll;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DiceRollBuilder {
    private static final int NB_DICE = 5;

    private List<Integer> dice;

    public DiceRoll build() {
        assertions();

        return new DiceRoll(this.dice);
    }

    public DiceRollBuilder dice(int... dice) {
        if (dice!=null) {
            this.dice = Arrays.stream(dice)
                .boxed()
                .collect(toList());
        }
        return this;
    }

    private void assertions() {
        assert dice!=null:"Dice in parameter must not be null";
        assert dice.size()==NB_DICE:NB_DICE + " dice are required";
        for (int die : dice) {
            assert die >= 1 && die <= 6:"Die must have a value between 1 and 6 (included)";
        }
    }
}
