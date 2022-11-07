package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Card;
import com.jitterted.ebp.blackjack.domain.Hand;
import com.jitterted.ebp.blackjack.domain.Rank;
import com.jitterted.ebp.blackjack.domain.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HandDisplayTest {
    @Test
    public void displayFaceUpCard() {
        Hand hand = new Hand(List.of(new Card(Suit.HEARTS, Rank.ACE)));

        String expected = "[31m┌─────────┐[1B[11D│A        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        A│[1B[11D└─────────┘";

        Assertions.assertThat(ConsoleHand.displayFaceUpCard(hand))
                  .isEqualTo(expected);
    }
}