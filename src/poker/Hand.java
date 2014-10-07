package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	private ArrayList<Card> CardsInHand = null;

	private int HandStrength;
	private int HiHand;
	private int LoHand;
	private int Kicker;
	private boolean bScored = false;

	private boolean Flush;
	private boolean Straight;
	private boolean Ace;

	private int numOfJokers = 0; //encap
	public boolean Joker = false;

	public Hand(Deck d) {
		ArrayList<Card> Import = new ArrayList<Card>();
		for (int x = 0; x < 5; x++) {
			Import.add(d.drawFromDeck());
		}
		CardsInHand = Import;
	}

	// overloaded constructor for other EvalHand
	public Hand(ArrayList<Card> hand) {
		CardsInHand = hand;
	}

	
	public ArrayList<Card> getCards() {
		return CardsInHand;
	}

	public int getHandStrength() {
		return HandStrength;
	}

	public int getKicker() {
		return Kicker;
	}

	public int getHighPairStrength() {
		return HiHand;
	}

	public int getLowPairStrength() {
		return LoHand;
	}

	public boolean getAce() {
		return Ace;
	}

	public static Hand EvalHand(ArrayList<Card> SeededHand) {

		Hand h = new Hand(SeededHand);
		
		h.isJoker();
		if (h.Joker){
			h.EvalHand();
		}
		else
			h.EvalHand(false);

		return h;
	}

	public void EvalHand(boolean Joker) {
		// Evaluates if the hand is a flush and/or straight then figures out
		// the hand's strength attributes

		// Sort the cards!
		Collections.sort(CardsInHand, Card.CardRank);

		// Ace Evaluation
		if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == eRank.ACE) {
			Ace = true;
		}

		// Flush Evaluation
		if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getSuit()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getSuit()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getSuit()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getSuit() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getSuit()) {
			Flush = true;
		} else {
			Flush = false;
		}

		// Straight Evaluation
		if (Ace) {
			// Looks for Ace, King, Queen, Jack, 10
			if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == eRank.KING
					&& CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.QUEEN
					&& CardsInHand.get(eCardNo.FourthCard.getCardNo())
							.getRank() == eRank.JACK
					&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TEN) {
				Straight = true;
				// Looks for Ace, 2, 3, 4, 5
			} else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TWO
					&& CardsInHand.get(eCardNo.FourthCard.getCardNo())
							.getRank() == eRank.THREE
					&& CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == eRank.FOUR
					&& CardsInHand.get(eCardNo.SecondCard.getCardNo())
							.getRank() == eRank.FIVE) {
				Straight = true;
			} else {
				Straight = false;
			}
			// Looks for straight without Ace
		} else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
				.getRank() == CardsInHand.get(eCardNo.SecondCard.getCardNo())
				.getRank().getRank() + 1
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
						.getRank() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getRank().getRank() + 2
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
						.getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()
						.getRank() + 3
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
						.getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank().getRank() + 4) {
			Straight = true;
		} else {
			Straight = false;
		}

		// Evaluates the hand type

		// Natural Royal Flush
		if (Straight == true
				&& Flush == true
				&& Joker == false
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TEN
				&& Ace) {
			ScoreHand(eHandStrength.NaturalRoyalFlush, 0, 0, 0);
		}

		// Royal Flush
		else if (Straight == true
				&& Flush == true
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == eRank.TEN
				&& Ace) {
			ScoreHand(eHandStrength.RoyalFlush, 0, 0, 0);
		}

		// Straight Flush
		else if (Straight == true && Flush == true) {
			ScoreHand(eHandStrength.StraightFlush,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0, 0);
		}
		// Five of a Kind
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.FiveOfAKind,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0, 0);

		}
		// Four of a Kind

		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.FourOfAKind,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank()
							.getRank());
		}

		else if (CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.FourOfAKind,
					CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank());
		}

		// Full House
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.FullHouse,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank()
							.getRank(), 0);
		}

		else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FifthCard.getCardNo()).getRank()
				&& CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.SecondCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.FullHouse,
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0);
		}

		// Flush
		else if (Flush) {
			ScoreHand(eHandStrength.Flush,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0, 0);
		}

		// Straight
		else if (Straight) {
			ScoreHand(eHandStrength.Straight,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0, 0);
		}

		// Three of a Kind
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.ThreeOfAKind,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank()
							.getRank());
		}

		else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.ThreeOfAKind,
					CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank()
							.getRank());
		} else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FifthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.ThreeOfAKind,
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank());
		}

		// Two Pair
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FourthCard.getCardNo()).getRank())) {
			ScoreHand(eHandStrength.TwoPair,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.FifthCard.getCardNo()).getRank()
							.getRank());
		} else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()
				&& (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank())) {
			ScoreHand(eHandStrength.TwoPair,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank()
							.getRank());
		} else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()
				&& (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
						.get(eCardNo.FifthCard.getCardNo()).getRank())) {
			ScoreHand(eHandStrength.TwoPair,
					CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank()
							.getRank(),
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank());
		}

		// Pair
		else if (CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.SecondCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.Pair,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank()
							.getRank());
		} else if (CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.ThirdCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.Pair,
					CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank());
		} else if (CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FourthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.Pair,
					CardsInHand.get(eCardNo.ThirdCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank());
		} else if (CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank() == CardsInHand
				.get(eCardNo.FifthCard.getCardNo()).getRank()) {
			ScoreHand(eHandStrength.Pair,
					CardsInHand.get(eCardNo.FourthCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank());
		}

		else {
			ScoreHand(eHandStrength.HighCard,
					CardsInHand.get(eCardNo.FirstCard.getCardNo()).getRank()
							.getRank(), 0,
					CardsInHand.get(eCardNo.SecondCard.getCardNo()).getRank()
							.getRank());
		}
	}

	private void ScoreHand(eHandStrength hST, int HiHand, int LoHand, int Kicker) {
		this.HandStrength = hST.getHandStrength();
		this.HiHand = HiHand;
		this.LoHand = LoHand;
		this.Kicker = Kicker;
		this.bScored = true;

	}
	
	//overloaded ScoreHand for all int
	private void ScoreHand(int hST, int HiHand, int LoHand, int Kicker) {
		this.HandStrength = hST;
		this.HiHand = HiHand;
		this.LoHand = LoHand;
		this.Kicker = Kicker;
		this.bScored = true;

	}

	// Checks if there are Jokers in the hand and counts them
	public boolean isJoker() {
		for (int CardNum = 0; CardNum < CardsInHand.size(); CardNum++) {
			if (CardsInHand.get(CardNum).getRank() == eRank.JOKER)
				numOfJokers += 1;

			if (numOfJokers != 0)
				Joker = true;

		}
		return Joker;
	}

	public void EvalHand() {
		
		ArrayList<Card> discardHand = new ArrayList<Card>(CardsInHand);
		Collections.sort(discardHand, Card.CardRank);//dafwsefqe
		// Removes Jokers from hand, from the end
		for (int count = 1; count <= numOfJokers; count++) {
			discardHand.remove(discardHand.size() - 1);
		}

		if (numOfJokers == 5) {
			ScoreHand(eHandStrength.RoyalFlush, 0, 0, 0);
		}

		else if (numOfJokers == 4) {
			if (discardHand.get(0).getRank().getRank() >= 10) {
				ScoreHand(eHandStrength.RoyalFlush, 0, 0, 0);
			} else {
				ScoreHand(eHandStrength.StraightFlush, discardHand.get(0)
						.getRank().getRank() + 4, 0, 0);
			}
		}

		else if (numOfJokers == 3) {
			// 5 of a kind
			if (discardHand.get(0).getRank() == discardHand.get(1).getRank()) {
				ScoreHand(eHandStrength.FiveOfAKind, discardHand.get(0)
						.getRank().getRank(), 0, 0);
			}
			// Royal Flush
			else if (discardHand.get(0).getSuit() == discardHand.get(1)
					.getSuit()) {
				if (Math.abs(discardHand.get(0).getRank().getRank()
						- discardHand.get(1).getRank().getRank()) <= 4) {
					if (discardHand.get(0).getRank().getRank() >= 10
							&& discardHand.get(1).getRank().getRank() >= 10) {
						ScoreHand(eHandStrength.RoyalFlush, 0, 0, 0);
					}// Straight Flush
					else {
						if (discardHand.get(0).getRank().getRank() < discardHand
								.get(1).getRank().getRank()) {
							ScoreHand(eHandStrength.StraightFlush, discardHand
									.get(0).getRank().getRank() + 4, 0, 0);
						} else {
							ScoreHand(eHandStrength.StraightFlush, discardHand
									.get(1).getRank().getRank() + 4, 0, 0);
						}
					}
				} else {
					if (discardHand.get(0).getRank().getRank() > discardHand
							.get(1).getRank().getRank()) {
						ScoreHand(eHandStrength.FourOfAKind, discardHand.get(0)
								.getRank().getRank(), discardHand.get(1)
								.getRank().getRank(), 0);
					} else {
						ScoreHand(eHandStrength.FourOfAKind, discardHand.get(1)
								.getRank().getRank(), discardHand.get(0)
								.getRank().getRank(), 0);
					}
				}

			} else {
				if (discardHand.get(0).getRank().getRank() > discardHand.get(1)
						.getRank().getRank()) {
					ScoreHand(eHandStrength.FourOfAKind, discardHand.get(0)
							.getRank().getRank(), discardHand.get(1).getRank()
							.getRank(), 0);
				} else {
					ScoreHand(eHandStrength.FourOfAKind, discardHand.get(1)
							.getRank().getRank(), discardHand.get(0).getRank()
							.getRank(), 0);
				}
			}
		}

		// 2 jokers
		else if (numOfJokers == 2) {
			ArrayList<Integer> bestEval = new ArrayList<Integer>(Arrays.asList(
					0, 0, 0, 0));

			// makes an arraylist of all the cards
			ArrayList<Card> MakingDeck = new ArrayList<Card>();
			for (short i = 0; i <= 3; i++) {
				eSuit SuitValue = eSuit.values()[i];
				for (short j = 0; j <= 12; j++) {
					eRank RankValue = eRank.values()[j];
					Card NewCard = new Card(SuitValue, RankValue);
					MakingDeck.add(NewCard);
				}
			} // runs through 2 jokers

			for (Card i : MakingDeck) {
				for (Card j : MakingDeck) { // uses this card list variable to
											// evaluate and computer to the best
											// eval
					ArrayList<Card> changingHand = new ArrayList<Card>(discardHand);
					changingHand.add(i);
					changingHand.add(j);
					Hand newHand = new Hand(changingHand);
					Collections.sort(newHand.CardsInHand, Card.CardRank);
					newHand.EvalHand(true);

					if (newHand.HandStrength > bestEval.get(0)) {
						bestEval.set(0, newHand.HandStrength);
						bestEval.set(1, newHand.HiHand);
						bestEval.set(2, newHand.LoHand);
						bestEval.set(3, newHand.Kicker);

					}

					else if (newHand.HandStrength == bestEval.get(0)
							&& newHand.HiHand > bestEval.get(1)) {
						bestEval.set(1, newHand.HiHand);
						bestEval.set(2, newHand.LoHand);
						bestEval.set(3, newHand.Kicker);

					} else if (newHand.HandStrength == bestEval.get(0)
							&& newHand.HiHand == bestEval.get(1)
							&& newHand.LoHand > bestEval.get(2)) {
						bestEval.set(2, newHand.LoHand);
						bestEval.set(3, newHand.Kicker);
					}

					else if (newHand.HandStrength == bestEval.get(0)
							&& newHand.HiHand == bestEval.get(1)
							&& newHand.LoHand == bestEval.get(2)
							&& newHand.Kicker > bestEval.get(3)) {
						bestEval.set(3, newHand.Kicker);
					}
				}

			}
			
			ScoreHand(bestEval.get(0), bestEval.get(1),bestEval.get(2), bestEval.get(3));
		}
		
		//1 joker 
		else if (numOfJokers == 1){
			//same as above
			ArrayList<Integer> bestEval = new ArrayList<Integer>(Arrays.asList(
					0, 0, 0, 0));

			// makes an arraylist of all the cards
			ArrayList<Card> MakingDeck = new ArrayList<Card>();
			for (short i = 0; i <= 3; i++) {
				eSuit SuitValue = eSuit.values()[i];
				for (short j = 0; j <= 12; j++) {
					eRank RankValue = eRank.values()[j];
					Card NewCard = new Card(SuitValue, RankValue);
					MakingDeck.add(NewCard);
				}
			}
			for (Card i : MakingDeck) {
				ArrayList<Card> changingHand = new ArrayList<Card>(discardHand);
				changingHand.add(i);
				Hand newHand = new Hand(changingHand);
				Collections.sort(newHand.CardsInHand, Card.CardRank);
				newHand.EvalHand(true);

				if (newHand.HandStrength > bestEval.get(0)) {
					bestEval.set(0, newHand.HandStrength);
					bestEval.set(1, newHand.HiHand);
					bestEval.set(2, newHand.LoHand);
					bestEval.set(3, newHand.Kicker);

				}

				else if (newHand.HandStrength == bestEval.get(0)
						&& newHand.HiHand > bestEval.get(1)) {
					bestEval.set(1, newHand.HiHand);
					bestEval.set(2, newHand.LoHand);
					bestEval.set(3, newHand.Kicker);

				} else if (newHand.HandStrength == bestEval.get(0)
						&& newHand.HiHand == bestEval.get(1)
						&& newHand.LoHand > bestEval.get(2)) {
					bestEval.set(2, newHand.LoHand);
					bestEval.set(3, newHand.Kicker);
				}

				else if (newHand.HandStrength == bestEval.get(0)
						&& newHand.HiHand == bestEval.get(1)
						&& newHand.LoHand == bestEval.get(2)
						&& newHand.Kicker > bestEval.get(3)) {
					bestEval.set(3, newHand.Kicker);
				}
			}
			ScoreHand(bestEval.get(0), bestEval.get(1),bestEval.get(2), bestEval.get(3));
		}
		
	}
	
	//public static Hand PickBestHand(ArrayList<Hand> Hands) throws exHand        need to make the exception and do this method
	

	/**
	 * Custom sort to figure the best hand in an array of hands
	 */
	public static Comparator<Hand> HandRank = new Comparator<Hand>() {

		public int compare(Hand h1, Hand h2) {

			int result = 0;

			result = h2.HandStrength - h1.HandStrength;

			if (result != 0) {
				return result;
			}

			result = h2.HiHand - h1.HiHand;
			if (result != 0) {
				return result;
			}

			result = h2.LoHand = h1.LoHand;
			if (result != 0) {
				return result;
			}

			result = h2.Kicker = h1.Kicker;
			if (result != 0) {
				return result;
			}

			return 0;
		}
	};
}
