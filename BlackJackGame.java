package LetPlayBlackJack;

import java.util.Scanner;

/**
 * Manages the flow and logic of a Blackjack game.
 */
public class BlackJackGame {

    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new BlackjackGame with a player, dealer and scanner.
     */
    public BlackJackGame() {
        player = new Player();
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the game and displays the welcome message.
     */
    public void start() {
        System.out.println("Welcome to Blackjack!");
        startGame();
    }

    /**
     * Initializes a new round by creating a deck, dealing cards,
     * and checking for an immediate Blackjack.
     */
    private void startGame() {

        deck = new Deck();

        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());

        player.addHand(playerHand);
        dealer.setHand(dealerHand);

        if(playerHand.isBlackJack()){
            dealer.revealCard();
            System.out.println("BLACKJACK! You win!");
            System.out.println("Player: " + playerHand);
            System.out.println("Dealer: " + dealer.getHand());
            player.addScore(2);
            dealer.addScore(-2);
            displayScore();
            playAgain();
        }else {

            playerTurn();
        }
    }

    /**
     * Manages the player's turn by handling each hand in order.
     */
    private void playerTurn() {

        int i = 0;
        while (i<player.getHands().size()){

            System.out.println("--- Hand " + (i + 1) + " ---");
            handleHand(player.getHands().get(i));
            i++;
        }
        System.out.println("\n=== Your final hands ===");
        for (int j = 0; j < player.getHands().size(); j++) {
            System.out.println("Hand " + (j + 1) + ": " + player.getHands().get(j));
        }
        dealerTurn();

    }

    /**
     * Handles a single hand during the player's turn.
     * Allows the player to hit, stand, double, or split.
     * @param hand the hand to handle
     */
    private void handleHand(Hand hand) {

        while (true) {

            System.out.println("Dealer: " + dealer);
            System.out.println("Your hand: " + hand);

            System.out.println("It's your turn! What do you want to do? ");
                if (hand.canDouble() && hand.canSplit()) {
                    System.out.println("HIT - STAND - SPLIT - DOUBLE");
                } else if (hand.canDouble()) {
                    System.out.println("HIT - STAND - DOUBLE");
                } else if (hand.canSplit()) {
                    System.out.println("HIT - STAND - SPLIT");
                } else System.out.println("HIT - STAND");

                String action = scanner.nextLine();

                if (action.equalsIgnoreCase("HIT")) {

                    hand.addCard(deck.deal());
                    if (hand.isBust()) {
                        System.out.println("BUST!");
                        break;
                    }
                } else if (action.equalsIgnoreCase("STAND")) {
                    break;
                } else if (action.equalsIgnoreCase("DOUBLE")) {
                    hand.addCard(deck.deal());
                    hand.setDouble();
                    System.out.println("Your hand after double: " + hand);

                    if (hand.isBust()) {
                        System.out.println("BUST!");
                    }
                    break;
                } else if (action.equalsIgnoreCase("SPLIT")) {

                    Card secondHand = hand.getCards().get(1);
                    hand.getCards().remove(1);

                    Hand newHand = new Hand();
                    newHand.addCard(secondHand);

                    hand.addCard(deck.deal());
                    newHand.addCard(deck.deal());

                    player.addHand(newHand);

                    if (newHand.isBlackJack()) {
                        System.out.println("BLACKJACK on split hand!");
                    }
                } else System.out.println("Please make the right action!");


        }
    }

    /**
     * Manages the dealer's turn after the player has finished.
     * Dealer hits until score exceeds 16 or busts.
     * Each action of the dealer will be delay 1.5 sec to let the
     * player see the action of dealer
     */
    private void dealerTurn() {
        dealer.revealCard();
        System.out.println("Dealer reveals: " + dealer);

        try {
            Thread.sleep(1500); // delay 1.5 giây
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (dealer.shouldHit()) {
            dealer.getHand().addCard(deck.deal());
            System.out.println("Dealer hits: " + dealer);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (dealer.getHand().isBust()) {
                break;
            }
        }
        calculateResult();
    }

    /**
     * Calculates and prints the result for each player hand
     * against the dealer's final hand.
     */
    private void calculateResult() {

        for (Hand hand : player.getHands()) {

            if (hand.isBust()) {

                int point = hand.isDouble() ? -2 : -1 ;
                updateScore(point, -point);
                printResult("You Lose");
            } else if (hand.isBlackJack()) {

                updateScore(2, -2);
                printResult("BLACKJACK! You WIN");
            } else if (dealer.getHand().isBust()) {

                int point = hand.isDouble() ? 2 : 1;
                updateScore(point, - point);
                printResult("Dealer BUST! You WIN");
            }else if (hand.getScore() < dealer.getHand().getScore()) {

                int point = hand.isDouble() ? -2 : -1 ;
                updateScore(point, -point);
                printResult("You LOSE!");
            }else if (hand.getScore() == dealer.getHand().getScore()) {

                printResult("It's a DRAW!");
            }else{

                int point = hand.isDouble() ? 2 : 1;
                updateScore(point, -point);
                printResult("You WIN!");
            }

        }  playAgain();

    }

    /**
     * Updates player and dealer scores.
     * @param playerPoint points to add to player
     * @param dealerPoint points to add to dealer
     */
    private void updateScore(int playerPoint, int dealerPoint) {
        player.addScore(playerPoint);
        dealer.addScore(dealerPoint);
    }

    /**
     * Prints the result message and current scores.
     * @param message the result message to display
     */
    private void printResult(String message) {
        System.out.println(message);
        System.out.println("Player score: " + player.getScore());
        System.out.println("Dealer score: " + dealer.getScore());
    }

    /**
     * Displays the current accumulated scores of both player and dealer.
     */
    private void displayScore() {

        System.out.println (" You now have: " + player.getScore());
        System.out.println (" The dealer now have: " + dealer.getScore());
    }

    /**
     * Asks the player if they want to play another round.
     * Resets hands and starts a new game if yes, otherwise exits.
     */
    private void playAgain() {
        System.out.println("Do you want to play new game? YES or NO");
        String playOption = scanner.nextLine();

        if (playOption.equalsIgnoreCase("YES")) {

            player.getHands().clear();
            dealer.setHand(new Hand());
            dealer.resetHideCard();
            startGame();
        } else if (playOption.equalsIgnoreCase("NO")) {
            displayScore();
            System.out.println("Thanks for playing!");
        } else if (playOption.equalsIgnoreCase("RESET")) {

            player.resetScore();
            dealer.resetScore();
            System.out.println("Secret code activate, all point reset to 0");
            player.getHands().clear();
            dealer.setHand(new Hand());
            dealer.resetHideCard();
            startGame();
        } else {
            System.out.println("Please enter only YES or NO");
            playAgain();
        }
    }
}
