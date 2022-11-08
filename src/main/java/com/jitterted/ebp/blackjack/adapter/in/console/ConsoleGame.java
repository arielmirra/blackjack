package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Game;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleGame {
    private final Game game;

    public ConsoleGame(Game game) {
        this.game = game;
    }

    public void start() {
        displayWelcomeScreen();
        waitForEnterFromUser();

        game.initialDeal();

        playerPlays();

        game.dealerTurn();

        displayFinalGameState();

        System.out.println(game.determineOutcome());

        resetScreen();
    }

    private void playerPlays() {
        while (!game.isPlayerDone()) {
            displayGameState();
            String command = inputFromPlayer();
            handle(command);
        }
    }

    private void handle(String command) {
        if (command.toLowerCase().startsWith("h")) {
            game.playerHits();
        } else if (command.toLowerCase().startsWith("s")) {
            game.playerStands();
        }
    }


    public void displayWelcomeScreen() {
        AnsiConsole.systemInstall();
        System.out.println(ansi()
                                   .bgBright(Ansi.Color.WHITE)
                                   .eraseScreen()
                                   .cursor(1, 1)
                                   .fgGreen().a("Welcome to")
                                   .fgRed().a(" EsPorAhí's")
                                   .fgBlack().a(" BlackJack game"));
    }

    public void displayFinalGameState() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(game.dealerHand().display());
        System.out.println(" (" + game.dealerHand().value() + ")");

        System.out.println();
        System.out.println("Player has: ");
        System.out.println(game.playerHand().display());
        System.out.println(" (" + game.playerHand().value() + ")");
    }

    public void resetScreen() {
        System.out.println(ansi().reset());
    }

    public void waitForEnterFromUser() {
        System.out.println(ansi()
                                   .cursor(3, 1)
                                   .fgBrightBlack().a("Hit [ENTER] to start..."));

        System.console().readLine();
    }

    private void displayBackOfCard() {
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

    private void displayGameState() {
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

    private String inputFromPlayer() {
        System.out.println("[H]it or [S]tand?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
