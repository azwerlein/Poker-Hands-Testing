package pokergame.test;

import org.junit.Before;
import org.junit.Test;
import pokergame.Card;
import pokergame.Game;
import pokergame.Suit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class GameTest {
    Card[] none;
    Card[] fullHouse;
    Card[] twoOfAKind;
    Card[] threeOfAKind;
    Card[] fourOfAKind;
    Card[] flush;

    @Before
    public void populateHands() {
        none = new Card[]{new Card(Suit.CLUBS, 3), new Card(Suit.SPADES, 5), new Card(Suit.HEARTS, 7), new Card(Suit.DIAMONDS, 4), new Card(Suit.CLUBS, 1)};
        fullHouse = new Card[]{new Card(Suit.CLUBS, 3), new Card(Suit.SPADES, 3), new Card(Suit.HEARTS, 3), new Card(Suit.HEARTS, 2), new Card(Suit.DIAMONDS, 2)};
        twoOfAKind = new Card[]{new Card(Suit.CLUBS, 3), new Card(Suit.SPADES, 3), new Card(Suit.HEARTS, 7), new Card(Suit.DIAMONDS, 4), new Card(Suit.CLUBS, 1)};
        threeOfAKind = new Card[]{new Card(Suit.CLUBS, 3), new Card(Suit.SPADES, 3), new Card(Suit.HEARTS, 3), new Card(Suit.DIAMONDS, 4), new Card(Suit.CLUBS, 1)};
        fourOfAKind = new Card[]{new Card(Suit.CLUBS, 3), new Card(Suit.SPADES, 3), new Card(Suit.HEARTS, 3), new Card(Suit.DIAMONDS, 3), new Card(Suit.CLUBS, 1)};
        flush = new Card[]{new Card(Suit.CLUBS, 3), new Card(Suit.CLUBS, 5), new Card(Suit.CLUBS, 7), new Card(Suit.CLUBS, 4), new Card(Suit.CLUBS, 1)};
    }

    @Test
    void checkFullHouse() {
        assertFalse(Game.checkFullHouse(none));
        assertTrue(Game.checkFullHouse(fullHouse));
        assertTrue(Game.checkFullHouse(twoOfAKind));
        assertTrue(Game.checkFullHouse(threeOfAKind));
        assertFalse(Game.checkFullHouse(fourOfAKind));
        assertFalse(Game.checkFullHouse(flush));
    }

    @Test
    void checkTwoOfAKind() {
        assertFalse(Game.checkCardsOfAKind(none, 2));
        assertTrue(Game.checkCardsOfAKind(fullHouse, 2));
        assertTrue(Game.checkCardsOfAKind(twoOfAKind, 2));
        assertTrue(Game.checkCardsOfAKind(threeOfAKind, 2));
        assertTrue(Game.checkCardsOfAKind(fourOfAKind, 2));
        assertFalse(Game.checkCardsOfAKind(flush, 2));
    }

    @Test
    void checkThreeOfAKind() {
        assertFalse(Game.checkCardsOfAKind(none, 3));
        assertTrue(Game.checkCardsOfAKind(fullHouse, 3));
        assertFalse(Game.checkCardsOfAKind(twoOfAKind, 3));
        assertTrue(Game.checkCardsOfAKind(threeOfAKind, 3));
        assertTrue(Game.checkCardsOfAKind(fourOfAKind, 3));
        assertFalse(Game.checkCardsOfAKind(flush, 3));
    }

    @Test
    void checkFourOfAKind() {
        assertFalse(Game.checkCardsOfAKind(none, 4));
        assertFalse(Game.checkCardsOfAKind(fullHouse, 4));
        assertFalse(Game.checkCardsOfAKind(twoOfAKind, 4));
        assertFalse(Game.checkCardsOfAKind(threeOfAKind, 4));
        assertTrue(Game.checkCardsOfAKind(fourOfAKind, 4));
        assertFalse(Game.checkCardsOfAKind(flush, 4));
    }

    @Test
    void checkFlush() {
        assertFalse(Game.checkFlush(none));
        assertFalse(Game.checkFlush(fullHouse));
        assertFalse(Game.checkFlush(twoOfAKind));
        assertFalse(Game.checkFlush(threeOfAKind));
        assertFalse(Game.checkFlush(fourOfAKind));
        assertTrue(Game.checkFlush(flush));
    }
}