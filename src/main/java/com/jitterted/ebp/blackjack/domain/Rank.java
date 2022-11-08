package com.jitterted.ebp.blackjack.domain;

public enum Rank {

    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    J("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String display;

    private final int value;

    Rank(String display, int value) {
        this.display = display;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.display;
    }

    public String display() {
        return display;
    }

    public int getValue() {
        return this.value;
    }




}
