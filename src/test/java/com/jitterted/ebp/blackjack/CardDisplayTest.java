package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CardDisplayTest {
    private static final Suit DUMMY_SUIT = Suit.HEARTS;

    @Test
    public void displayTenAsString() throws Exception {
        Card card = new Card(DUMMY_SUIT, Rank.TEN);

        String expectedDisplay = "[31m┌─────────┐[1B[11D│10       │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│       10│[1B[11D└─────────┘";

        assertThat(card.display())
                .isEqualTo(expectedDisplay);
    }

    @Test
    public void displayNonTenAsString() throws Exception {
        Card card = new Card(DUMMY_SUIT, Rank.SEVEN);

        String expectedDisplay = "[31m┌─────────┐[1B[11D│7        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        7│[1B[11D└─────────┘";

        assertThat(card.display())
                .isEqualTo(expectedDisplay);
    }
}