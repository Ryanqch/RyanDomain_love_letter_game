package com.lovelettergame;

import java.util.List;
import java.util.Scanner;


/**
 * The Baron class represents a Baron card in the Love Letter game.
 * This card allows a player to compare their card with another player's card,
 * and the player with the lower-value card is eliminated from the round.
 */

public class Baron extends Card {
    // Constructor for Baron card
    public Baron() {
        super("Baron", 3);

    }
    /**
     * Compare your hand with another player's hand. The player with the lower-value card is out of the round.
     *
     * @param currentPlayer The current player who plays the Baron card.
     * @param allPlayers   A list of all players in the game.
     * @param scanner      A Scanner object for user input.
     */
    @Override
    public void effect(Player currentPlayer, List<Player> allPlayers, Scanner scanner) {
        System.out.println("Which player would you like to compare hands with? (Enter a number 1-" + allPlayers.size() + ")");
        int playerNum = scanner.nextInt();
        while (playerNum < 1 || playerNum > allPlayers.size() || allPlayers.get(playerNum-1).equals(currentPlayer)) {
            System.out.println("Invalid player number. Please enter a number 1-" + allPlayers.size() + ".");
            playerNum = scanner.nextInt();
        }
        Player targetPlayer = allPlayers.get(playerNum-1);
        Card hand = currentPlayer.getHand();
        if (hand != null ) {
            int currentPlayerCardValue = hand.getHierarchy();
            int targetPlayerCardValue = targetPlayer.getHand().getHierarchy();
            if (currentPlayerCardValue > targetPlayerCardValue) {
                System.out.println("You win! " + targetPlayer.getName() + " is out of the round.");
                targetPlayer.setOut(true);
            } else if (currentPlayerCardValue < targetPlayerCardValue) {
                System.out.println("You lose! You are out of the round.");
                currentPlayer.setOut(true);
            } else {
                System.out.println("It's a tie! Nothing happens.");
            }
        }
        scanner.nextLine();
    }


}

