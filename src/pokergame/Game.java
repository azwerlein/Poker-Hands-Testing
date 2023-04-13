package pokergame;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class is used to determine what type of hand is being passed in.
 */
public class Game {

    /**
     * Returns true if the hand has three cards of one value and two of another.
     * @param hand The player's hand
     */
    public static boolean checkFullHouse(Card[] hand) {
        Arrays.sort(hand, Comparator.comparing(Card::getSuit));
        return false;
    }

    /**
     * Returns true if the hand has the specified number of cards with the same value.
     * @param hand The player's hand
     * @param count How many cards to match
     */
    public static boolean checkCardsOfAKind(Card[] hand, int count) {
        Arrays.sort(hand, Comparator.comparing(Card::getValue));
        for (int i = 0; i < hand.length - count; i++) {
            if (checkForMatches(hand, count, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForMatches(Card[] hand, int count, int index) {
        for (int i = 1; i < count; i++) {
            if (hand[index + i].getValue() != hand[index + i].getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if all cards in the hand have the same suit.
     * @param hand The player's hand
     */
    public static boolean checkFlush(Card[] hand) {
        Suit suit = hand[0].getSuit();
        for (Card card : hand) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }
}
