package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;

public class TestHands {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void TestNaturalRoyalFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be nrf:",
				eHandStrength.NaturalRoyalFlush.getHandStrength(),
				h.getHandStrength());

	}

	@Test
	public final void TestNaturalRoyalFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be nrf:",
				eHandStrength.NaturalRoyalFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestNaturalRoyalFlush3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES, eRank.KING));
		rfHand.add(new Card(eSuit.SPADES, eRank.ACE));
		rfHand.add(new Card(eSuit.SPADES, eRank.TEN));
		rfHand.add(new Card(eSuit.SPADES, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be nrf:",
				eHandStrength.NaturalRoyalFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush4() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush5() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush6() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.KING));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestJokerRoyalFlush7() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.TEN));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.KING));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.NINE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FIVE));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.SIX));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFiveOfAKind1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES, eRank.FOUR));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 5k:",
				eHandStrength.FiveOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFiveOfAKind2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 5k:",
				eHandStrength.FiveOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFiveOfAKind3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.HEARTS, eRank.FOUR));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 5k:",
				eHandStrength.FiveOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestJokerFourOfAKind1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestJokerFourOfAKind2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestJokerFourOfAKind3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestJokerFourOfAKind4() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFullHouse1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be fh:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFullHouse2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFullHouse3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.EIGHT));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.FOUR));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFullHouse4() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.TWO));
		rfHand.add(new Card(eSuit.JOKER, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4k:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.KING));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be fl:", eHandStrength.Flush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.KING));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be fl:", eHandStrength.Flush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFlush3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.HEARTS, eRank.KING));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be fl:", eHandStrength.Flush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraight1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.SIX));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.HEARTS, eRank.FOUR));
		rfHand.add(new Card(eSuit.SPADES, eRank.FIVE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be st:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraight2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.ACE));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TEN));
		rfHand.add(new Card(eSuit.SPADES, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be st:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraight3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.ACE));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be st:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraight4() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.ACE));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.SPADES, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be st:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeOfAKind1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.HEARTS, eRank.TWO));
		rfHand.add(new Card(eSuit.SPADES, eRank.TWO));
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 3k:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeOfAKind2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 3k:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeOfAKind3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.TWO));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 3k:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestTwoPair1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 2p:",
				eHandStrength.TwoPair.getHandStrength(),
				h.getHandStrength());
	}
	@Test
	public final void TestTwoPair2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 2p:",
				eHandStrength.TwoPair.getHandStrength(),
				h.getHandStrength());
	}
	@Test
	public final void TestPair1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 1p:",
				eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}
	@Test
	public final void TestPair2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 1p:",
				eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}
	@Test
	public final void TestPair3() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.JOKER, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 1p:",
				eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}
	@Test
	public final void TestHighCard1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be hc:",
				eHandStrength.HighCard.getHandStrength(),
				h.getHandStrength());
	}
	@Test
	public final void TestHighCard2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.DIAMONDS, eRank.JACK));
		rfHand.add(new Card(eSuit.SPADES, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		rfHand.add(new Card(eSuit.HEARTS, eRank.NINE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be hc:",
				eHandStrength.HighCard.getHandStrength(),
				h.getHandStrength());
	}
}
