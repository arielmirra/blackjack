package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.CLUBS;

    @Test
    public void handWithOneAceAndOtherCardValuedLessThan10ThenAceIsValuedAt11() {
        Hand hand = createHand(Rank.ACE, Rank.FIVE);

        assertThat(hand.value() == (11 + 5))
                .isTrue();
    }

    @Test
    public void handWithOneAceAndOtherCardsValuedAt10ThenAceIsValuedAt11() {
        Hand hand = createHand(Rank.ACE, Rank.TEN);

        assertThat(hand.value() == (11 + 10))
                .isTrue();
    }

    @Test
    public void handWithOneAceAndOtherCardsValuedAs11ThenAceIsValuedAt1() {
        Hand hand = createHand(Rank.ACE, Rank.EIGHT, Rank.THREE);

        assertThat(hand.value() == (1 + 8 + 3))
                .isTrue();
    }

    private Hand createHand(Rank... ranks) {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }
        return new Hand(cards);
    }

}