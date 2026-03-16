package LetPlayBlackJack;

import LetPlayBlackJack.Enum.Rank;
import LetPlayBlackJack.Enum.Suit;

/**
 * Represents a playing card with a suit and rank.
 */
public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * Constructs a new Card with the given suit and rank.
     * @param suit the suit of the card
     * @param rank the rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns the suit of the card.
     * @return the card suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the card.
     * @param suit the new suit of the card
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Returns the rank of the card.
     * @return the card rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Sets the rank of the card.
     * @param rank the new rank of the card
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * Returns the point value of the card.
     * Numbered cards are worth their face value,
     * face cards (J, Q, K) are worth 10,
     * and Ace is worth 11 by default.
     * @return the point value of the card
     */
    public int getValue() {
        return rank.getValue();
    }

    /**
     * Returns a string representation of the card.
     * @return the card as a readable string e.g. "K HEARTS"
     */
    public String toString() {
        return rank.name() + " OF " + suit.name();
    }
}
