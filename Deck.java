package LetPlayBlackJack;

import LetPlayBlackJack.Enum.Rank;
import LetPlayBlackJack.Enum.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a standard deck of 52 playing cards.
 */
public class Deck {

    private List<Card> cards;

    /**
     * Constructs a new Deck, initializes 52 cards and shuffles them.
     */
    public Deck() {

        cards = initCards();

        shuffle();
    }

    /**
     * Initializes a full deck of 52 cards with all suits and ranks.
     * @return a list of 52 cards
     */
    private static List<Card> initCards() {

        List<Card> cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {

            for (Rank rank : Rank.values()) {

                cards.add(new Card(suit, rank));
            }
        }

        return cards;
    }

    /**
     * Shuffles the deck randomly.
     */
    private void shuffle() {

        Collections.shuffle(cards);
    }

    /**
     * Deals the top card from the deck and removes it.
     * @return the top card from the deck
     */
    public Card deal() {

        Card card = cards.get(0);

        cards.remove(0);

        return card;
    }

}
