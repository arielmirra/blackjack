package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Card;
import com.jitterted.ebp.blackjack.domain.Rank;
import com.jitterted.ebp.blackjack.domain.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CardDisplayTest {
    private static final Suit DUMMY_SUIT = Suit.HEARTS;

    @Test
    public void displayTenAsString() {
        Card card = new Card(DUMMY_SUIT, Rank.TEN);

        String expectedDisplay = "[31m┌─────────┐[1B[11D│10       │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│       10│[1B[11D└─────────┘";

        Assertions.assertThat(ConsoleCard.display(card))
                  .isEqualTo(expectedDisplay);
    }

    @Test
    public void displayNonTenAsString() {
        Card card = new Card(DUMMY_SUIT, Rank.SEVEN);

        String expectedDisplay = "[31m┌─────────┐[1B[11D│7        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        7│[1B[11D└─────────┘";

        assertThat(ConsoleCard.display(card))
                .isEqualTo(expectedDisplay);
    }
}