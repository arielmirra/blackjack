package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Game;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleGame {
    public static void displayGameState(Game game) {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(ConsoleHand.displayFaceUpCard(game.dealerHand()));

        // second card is the hole card, which is hidden, or "face down"
        displayBackOfCard();

        System.out.println();
        System.out.println("Player has: ");
        System.out.println(game.playerHand().display());
        System.out.println(" (" + game.playerHand().value() + ")");
    }

    public static void displayBackOfCard() {
        System.out.print(
                ansi()
                        .cursorUp(7)
                        .cursorRight(12)
                        .a("┌─────────┐").cursorDown(1).cursorLeft(11)
                        .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                        .a("│░ E S   ░│").cursorDown(1).cursorLeft(11)
                        .a("│░ P O R ░│").cursorDown(1).cursorLeft(11)
                        .a("│░ A H I ░│").cursorDown(1).cursorLeft(11)
                        .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                        .a("└─────────┘"));
    }

    public static void waitForEnterFromUser() {
        System.out.println(ansi()
                                   .cursor(3, 1)
                                   .fgBrightBlack().a("Hit [ENTER] to start..."));

        System.console().readLine();
    }

    public static void displayWelcomeScreen() {
        AnsiConsole.systemInstall();
        System.out.println(ansi()
                                   .bgBright(Ansi.Color.WHITE)
                                   .eraseScreen()
                                   .cursor(1, 1)
                                   .fgGreen().a("Welcome to")
                                   .fgRed().a(" EsPorAhí's")
                                   .fgBlack().a(" BlackJack game"));
    }

    public static String determineOutcome(Game game) {
        if (game.playerHand().isBusted()) {
            return "You Busted, so you lose.  💸";
        } else if (game.dealerHand().isBusted()) {
            return "Dealer went BUST, Player wins! Yay for you!! 💵";
        } else if (game.playerHand().beats(game.dealerHand())) {
            return "You beat the Dealer! 💵";
        } else if (game.playerHand().pushes(game.dealerHand())) {
            return "Push: Nobody wins, we'll call it even.";
        } else {
            return "You lost to the Dealer. 💸";
        }
    }

    public static void displayOutcome(Game game) {
        System.out.println(determineOutcome(game));
    }

    public static void displayFinalGameState(Game game) {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(game.dealerHand().display());
        System.out.println(" (" + game.dealerHand().value() + ")");

        System.out.println();
        System.out.println("Player has: ");
        System.out.println(game.playerHand().display());
        System.out.println(" (" + game.playerHand().value() + ")");
    }

    public static String inputFromPlayer() {
        System.out.println("[H]it or [S]tand?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void resetScreen() {
        System.out.println(ansi().reset());
    }

    public static void playerTurn(Game game) {
        // get Player's decision: hit until they stand, then they're done (or they go bust)
        while (!game.playerHand().isBusted()) {
            displayGameState(game);
            String playerChoice = inputFromPlayer().toLowerCase();
            if (playerChoice.startsWith("s")) {
                break;
            }
            if (playerChoice.startsWith("h")) {
                game.playerHand().drawFrom(game.deck());
                if (game.playerHand().isBusted()) {
                    return;
                }
            } else {
                System.out.println("You need to [H]it or [S]tand");
            }
        }
    }
}
