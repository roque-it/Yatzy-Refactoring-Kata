package com.github.emilybache.api;

public final class DiceRollDto {
    private int[] dice;

    private DiceRollDto() {
        //private constructor
    }

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
