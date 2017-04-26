
import java.util.ArrayList;

/**
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber 4/24/2017, Gamble The
 *         Scorecard class uses the hand from the user's Yahtzee game to
 *         calculate the user's score on each line of the scorecard and display
 *         it
 */
public class Scorecard {

	static ArrayList<Integer> scoreRecord = new ArrayList<Integer>();

	int ifWon = 0;
	static int money = 0;
	static int moneyWon = 0;
	static int won;

	/**
	 * initializes the Scorecard class
	 */
	public Scorecard() {
		for (int j = 0; j < 13; j++) {
			scoreRecord.add(0);
		}
	}

	/**
	 * calculates total score of upper section and prints scores of each line
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 * @param lineBet
	 *            containing the player's hand, number of dice, number of sides
	 * @returns total upper section score
	 */
	public static int upperSection(ArrayList<Dice> hand, int numOfDie, int numOfSides, int BET, int lineBet) {
		won = 0;
		for (int dieValue = 1; dieValue <= numOfSides; dieValue++) {
			int currentCount = 0;
			for (int diePosition = 0; diePosition < numOfDie - 1; diePosition++) { 
				if (hand.get(diePosition).getRoll() == dieValue){
					currentCount++;}
			}
			if (dieValue == lineBet) {
				//currentCount+=1;
				won = dieValue * currentCount * BET;
				return won;
			} 
			else
				scoreRecord.add(0);
		}
		if (won == 0) {
			won = (BET * -1);
			
			return won;
		} 
		else {
			return won;
		}
		
	}

	/**
	 * calculates total score of lower section containing 
	 * the player's hand, number of sides, number of dice
	 * 
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 * @param betline
	 * @return total lower section score
	 */
	public static int lowerSection(ArrayList<Dice> hand, int numOfSides, int numOfDie, int BET, int betline) {
		won = 0;
		int start = numOfDie + 2;
		if (betline == 7) {
			//System.out.println(won);
			won = threeOfAKind(hand, numOfDie, numOfSides, BET);
			money += won;
			//return won;
		} //else if (betline != start) {
			//scoreRecord.add(0);} 
		else if (betline == start + 1) {
			won = fourOfAKind(hand, numOfDie, numOfSides, BET);
			scoreRecord.add(won);
			money += won;
			//return won;
		} //else if (betline != start + 1) {
			//scoreRecord.add(0);}
		 else if (betline == start + 2) {
			won = scoreFullHouse(hand, numOfSides, numOfDie, BET);
			scoreRecord.add(won);
			money += won;
			//return won;
		} //else if (betline != start + 2) {
			//scoreRecord.add(0);}
		 else if (betline == start + 3) {
			won = smallStraight(hand, numOfDie, BET);
			scoreRecord.add(won);
			//return won;
		 }
		 //else if (betline != start + 3) {
			//scoreRecord.add(0);}
		 else if (betline == start + 4) {
			won = largeStraight(hand, numOfDie, BET);
			scoreRecord.add(won);
			money += won;
			//return won;
		} //else if (betline != start + 4) {
			//scoreRecord.add(0);}
		 else {
				won = YAHTZEE(hand, numOfDie, BET);// Yahtzee!!
				scoreRecord.add(won);
				money += won;
				//return won;
			}
		
		 if (won == 0) {
			won = (BET * -1);
			//money += moneyWon;
			//System.out.println(won);
			return won;
		}
		 
		 else
			//System.out.println(money);
			//return money;
			return won;
	}

	/**
	 * calculates and displays score for three of a kind line
	 * containing the player's hand, number of dice, number of sides
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int threeOfAKind(ArrayList<Dice> hand, int numOfDie, int numOfSides, int BET) {
		int numSame = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numOfDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
				numSame += 1;
			} else {
				if (numSame < 2) { // if they already have 3 they don't need
									// more in order
					numSame = 0;
				}
			}
		}
		if (numSame >= 2) {
			int newbet = BET * 2;
			return BET * 2;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for four of a kind line
	 * containing the player's hand, number of dice, number of sides
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int fourOfAKind(ArrayList<Dice> hand, int numOfDie, int numOfSides, int BET) {
		int numSame = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numof
																				// die
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
				numSame += 1;
			} else {
				if (numSame < 3) { // if they already have 4 they dont need more
									// in order
					numSame = 0;
				}
			}
		}
		if (numSame >= 3) {
			BET = BET * 2;
			return BET;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for full house line
	 * containing the player's hand, number of sides, number of die
	 *@param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int scoreFullHouse(ArrayList<Dice> hand, int numOfSides, int numOfDie, int BET) {
		int currentCount = 0;
		boolean threeOfKindFound = false;
		boolean twoOfKindFound = false;
		boolean greaterKind = false;
		for (int dieValue = 1; dieValue <= numOfSides; dieValue++) { // num of
																		// sides
																		// = 6
			for (int diePosition = 0; diePosition < numOfDie; diePosition++) // num
																				// of
																				// die
																				// =
																				// 5
			{
				if (hand.get(diePosition).getRoll() == dieValue) {
					currentCount += 1;
				}
			}
			if (currentCount == 3) {
				threeOfKindFound = true;
			}
			if (currentCount == 2) {
				twoOfKindFound = true;
			}
			if (currentCount >= 5) {
				greaterKind = true;
			}
			currentCount = 0;
		}
		if ((threeOfKindFound && twoOfKindFound) || greaterKind) {
			BET = BET * 2;
			return BET;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for small straight line
	 * containing the player's hand, number of dice
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int smallStraight(ArrayList<Dice> hand, int numOfDie, int BET) {
		int numInOrder = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numofDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll() - 1)) {
				numInOrder += 1;
			} else if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
				numInOrder += 0; // nothing happens
			} else {
				if (numInOrder < 3) { // if they already have 4 they dont need
										// more in order
					numInOrder = 0;
				}
			}
		}
		if (numInOrder >= 3) {
			System.out.println(BET);
			BET = BET * 3;
			System.out.println(BET);
			return BET;
		} else {
			return 0;
		}
	} 
	

	/**
	 * calculates and displays score for large straight line
	 * containing the player's hand, number of die
	 * @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int largeStraight(ArrayList<Dice> hand, int numOfDie, int BET) {
		int numInOrder = 0;
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numOfDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() != (hand.get(placeHolder + 1).getRoll() - 1)) {
				if (hand.get(placeHolder).getRoll() == (hand.get(placeHolder + 1).getRoll())) {
					numInOrder += 0; // nothing happens
				} else {
					numInOrder = 0; // sets zero if any not in order
				}
			} else {
				numInOrder += 1;
			}
		}
		if (numInOrder >= 4) {
			BET = BET * 4;
			return BET;
		} else {
			return 0;
		}
	}

	/**
	 * calculates and displays score for yahtzee line
	 * containing the player's hand, number of die
	 *  @param hand
	 * @param numOfDie
	 * @param numOfSides
	 * @param BET
	 *            
	 * @return score for that line
	 */
	public static int YAHTZEE(ArrayList<Dice> hand, int numOfDie, int BET) {
		boolean YAHTZEE = true;
		// ASSUME LIST IS SORTED
		for (int placeHolder = 0; placeHolder < numOfDie - 1; placeHolder++) { // numOfDie
																				// -
																				// 1
																				// =
																				// 4
			if (hand.get(placeHolder).getRoll() != (hand.get(placeHolder + 1).getRoll())) {
				YAHTZEE = false; // sets zero if any not in order
			}
		}
		if (YAHTZEE) {
			BET = BET * 10;
			return BET;
		} else {
			return 0;
		}
	}

}
