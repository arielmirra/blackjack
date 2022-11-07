package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.adapter.in.console.ConsoleHand;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Hand() {
    }

    public int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    public Card dealerFaceUpCard() {
        return cards.get(0);
    }

    public boolean dealerMustDrawCard() {
        return value() <= 16;
    }

    public String display() {
        return ConsoleHand.cardsAsString(this);
    }

    public List<Card> cards() {
        return cards;
    }

    public void drawFrom(Deck deck) {
        cards.add(deck.draw());
    }

    public boolean isBusted() {
        return value() > 21;
    }

    public boolean pushes(Hand hand) {
        return hand.value() == value();
    }

    public boolean beats(Hand hand) {
        return hand.value() < value();
    }
}