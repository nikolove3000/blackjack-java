package LetPlayBlackJack;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in a Blackjack game.
 */
public class Player {

    private List<Hand> hands = new ArrayList<>();
    private int score;

    /**
     * Adds a new hand to the player's list of hands.
     * @param hand the hand to add
     */
    public void addHand(Hand hand) {

        hands.add(hand);
    }

    /**
     *  Returns all hands the player currently holds.
     *  @return the list of player's hands
     */
    public List<Hand> getHands() {

        return hands;
    }

    /**
     *  Returns the player's accumulated score.
     * @return the current score
     */
    public int getScore() {

        return score;
    }

    /**
     * Adds points to the player's accumulated score.
     * @param point the points to add (can be negative for losses)
     */
    public void addScore(int point) {

        score += point;
    }

    /**
     * Resets the player's score to zero.
     */
    public void resetScore() {

        score = 0;
    }

}
