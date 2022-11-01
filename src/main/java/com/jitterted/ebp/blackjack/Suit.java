package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;


public enum Suit {
    CLUBS("♣", Ansi.Color.BLACK),
    DIAMONDS("♦", Ansi.Color.RED),
    HEARTS("♥", Ansi.Color.RED),
    SPADES("♠", Ansi.Color.BLACK);

    private String displayString;

    private Ansi.Color color;

    Suit(String displayString, Ansi.Color color) {
        this.displayString = displayString;
        this.color = color;
    }

    public String getDisplayString() {
        return displayString;
    }

    public Ansi.Color getColor() {
        return color;
    }


    @Override
    public String toString() {
        return this.displayString;
    }
}
