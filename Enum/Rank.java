package LetPlayBlackJack.Enum;

/**
 * 13 Rank in a deck of 52 cards.
 */
public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    EIGHT(8), NINE(9), TEN(10), JACK(10),
    QUEEN(10), KING(10), ACE(11);

    private final int value;

    /**
     * Constructs a Rank with the given point value.
     * @param value the point value of the rank
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * Returns the point value of this rank.
     * @return the point value
     */
    public int getValue() {
        return value;
    }

}
