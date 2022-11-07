package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HandDisplayTest {
    @Test
    public void displayFaceUpCard() {
        Hand hand = new Hand(List.of(new Card(Suit.HEARTS, Rank.ACE)));

        String expected = "[31m┌─────────┐[1B[11D│A        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        A│[1B[11D└─────────┘";

        assertThat(ConsoleHand.displayFaceUpCard(hand))
                .isEqualTo(expected);
    }
}