package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Card;
import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleCard {
    public static String display(Card card) {
        String[] lines = new String[7];
        lines[0] = "┌─────────┐";
        lines[1] = String.format("│%s%s       │", card.rank(), card.rank().getValue() == 10 ? "" : " ");
        lines[2] = "│         │";
        lines[3] = String.format("│    %s    │", card.suit());
        lines[4] = "│         │";
        lines[5] = String.format("│       %s%s│", card.rank().getValue() == 10 ? "" : " ", card.rank());
        lines[6] = "└─────────┘";

        Ansi.Color color = card.suit().isRed() ? Ansi.Color.RED : Ansi.Color.BLACK;

        return ansi()
                .fg(color).toString()
                + String.join(ansi().cursorDown(1)
                                    .cursorLeft(11)
                                    .toString(), lines);
    }
}
