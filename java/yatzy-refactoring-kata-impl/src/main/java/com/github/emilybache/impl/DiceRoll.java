package com.github.emilybache.impl;

import com.github.emilybache.api.DiceRollDto;

public class DiceRoll {
    private static final int NB_DICE = 5;
    private int[] dice = new int[NB_DICE];

    public static DiceRoll from(DiceRollDto dto) {
        int[] dice = dto.getDice();
        return new DiceRoll().dice(dice);
    }

    public int getDie(int index) {
        //TODO check index compare to 1 and dice size
        return this.dice[index - 1];
    }

    public int[] getDice() {
        return this.dice;
    }

    private DiceRoll dice(int... dice) {
        //TODO check dice size

        this.dice = dice;
        return this;
    }
}
