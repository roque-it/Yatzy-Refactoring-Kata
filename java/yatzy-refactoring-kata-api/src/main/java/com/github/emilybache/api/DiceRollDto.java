package com.github.emilybache.api;

public class DiceRollDto {
    private int[] dice;

    public static DiceRollDto of(int... dice) {
        return new DiceRollDto().dice(dice);
    }

    public int[] getDice() {
        return this.dice;
    }

    private DiceRollDto dice(int... dice) {
        this.dice = dice;
        return this;
    }
}
