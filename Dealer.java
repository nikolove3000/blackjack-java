package LetPlayBlackJack;

/**
 * Represents the dealer in a Blackjack game.
 */
public class Dealer {

    /**
     * Constructs a new Dealer with an empty hand and second card hidden.
     */
    public Dealer() {

        hand = new Hand();
    }

    private Hand hand;

    private boolean hideSecondCard = true;

    public int score;

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Returns the dealer's hand.
     * @return the dealer's hand
     */
    public Hand getHand() {

        return hand;
    }

    /**
     * Checks if the dealer should hit based on current score.
     * Dealer must hit if score is 16 or below.
     * @return true if dealer should hit, false otherwise
     */
    public boolean shouldHit() {

        return hand.getScore() <= 16;
    }

    /**
     * Reveals the dealer's second card.
     */
    public void revealCard() {

        hideSecondCard = false;
    }

    public void resetHideCard() {

        hideSecondCard = true;
    }

    /**
     *  Returns the dealer's accumulated score.
     * @return the current score
     */
    public int getScore() {

        return score;
    }

    /**
     * Adds points to the dealer's accumulated score.
     * @param point the points to add (can be negative for losses)
     */
    public void addScore(int point) {

        score += point;
    }

    /**
     * Resets the dealer's score to zero.
     */
    public void resetScore() {

        score = 0;
    }


    /**
     *  Returns a string representation of the dealer's hand.
     *  Second card is hidden until revealed.
     *  @return the dealer's hand as a readable string
     */
    public String toString() {
        if (hideSecondCard) {
            return "[" + hand.getCards().get(0).toString() + " ]" + ", ???";
        }
                return hand.toString();
    }

}
