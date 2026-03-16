package LetPlayBlackJack;

import LetPlayBlackJack.Enum.Rank;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's hand in a Blackjack game.
 */
public class Hand {

    private List<Card> cards = new ArrayList<>();

    private boolean isDoubled = false;

    /**
     * Adds a card to the hand.
     * @param card the card to add
     */
    public void addCard(Card card) {

        cards.add(card);
    }

    /**
     *
     * @return
     */
    public List<Card> getCards() {

        return cards;
    }

    /**
     * Calculates the total score of the hand.
     * Aces are counted as 11 unless the total exceeds 21,
     * in which case they are counted as 1.
     * @return the total score of the hand
     */
    public int getScore() {

        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {

            total -= 10;
            aceCount--;
        }

        return total;
    }

    /**
     * Checks if the hand is a Blackjack (Ace + 10-value card from first 2 cards).
     * @return true if the hand is a Blackjack, false otherwise.
     */
    public boolean isBlackJack() {

        if (cards.size() != 2) return false;
        boolean isAce = false;
        boolean hasTen = false;

        for (Card card : cards) {

            if (card.getRank() == Rank.ACE) isAce = true;
            if (card.getValue() == 10) hasTen = true;
        }
        return isAce && hasTen;
    }

    /**
     * Checks if the hand is bust (total score exceeds 21).
     * @return true if the hand is bust, false otherwise
     */
    public boolean isBust() {

        return getScore() > 21;
    }

    /**
     * Checks if the hand can be split (2 cards with equal value).
     * @return true if the hand can be split, false otherwise
     */
    public boolean canSplit() {

        return (cards.size() == 2) && (cards.get(0).getValue() == cards.get(1).getValue());
    }

    /**
     * Checks if the hand can be doubled (only allowed with 2 cards).
     * @return true if the hand can be doubled, false otherwise
     */
    public boolean canDouble() {
        return cards.size() == 2;
    }


    /**
     * Marks the hand as doubled.
     */
    public void setDouble() {
        isDoubled = true;
    }

    /**
     * Checks if the hand has been doubled.
     * @return true if the hand is doubled, false otherwise
     */
    public boolean isDouble() {

        return isDoubled;
    }

    /**
     * Returns a string representation of the hand with all cards and total score.
     * @return the hand as a readable string e.g. "[KING of HEARTS, ACE of SPADES] = 21"
     */
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < cards.size(); i++) {

            sb.append(cards.get(i).toString());

            if (i < cards.size() - 1) sb.append(", ");

        }
        sb.append((" ] = ") + getScore());

        return sb.toString();
    }

}
