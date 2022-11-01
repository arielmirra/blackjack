package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Game game = new Game();
        List<Card> cards = List.of(new Card(Suit.HEARTS, Rank.A),
                                   new Card(Suit.HEARTS, Rank.FIVE));

        assertThat(game.handValueOf(cards))
                .isEqualTo(11 + 5);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Game game = new Game();
        List<Card> cards = List.of(new Card(Suit.HEARTS, Rank.A),
                                   new Card(Suit.HEARTS, Rank.EIGHT),
                                   new Card(Suit.HEARTS, Rank.THREE));

        assertThat(game.handValueOf(cards))
                .isEqualTo(1 + 8 + 3);
    }

}
