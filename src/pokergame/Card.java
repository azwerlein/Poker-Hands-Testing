package pokergame;

/**
 * This class represents a card in a player's hand. It contains a suit
 * and a numeric value.
 * @author Archie
 */
public class Card {
    private final Suit suit;
    private final int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
