package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;


public enum Suit {
    CLUBS("♣", false),
    DIAMONDS("♦", true),
    HEARTS("♥", true),
    SPADES("♠", false);

    private String displayString;

    private boolean isRed;

    Suit(String displayString, boolean isRed) {
        this.displayString = displayString;
        this.isRed = isRed;
    }

    public String getDisplayString() {
        return displayString;
    }

    public boolean isRed() {
        return isRed;
    }


    @Override
    public String toString() {
        return this.displayString;
    }
}
