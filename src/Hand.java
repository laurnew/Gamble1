import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JLabel;

/**
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber The Hand class sets the
 *         hand in Yahtzee, displays it, and takes user input to determine which
 *         die are to be re-rolled.
 */
public class Hand {
	/**
	 * initializes objects in Hand class
	 */
	
	Scorecard score = new Scorecard();
	
	public Hand() {
		numOfTurnsLeft = 0; // default
		numOfDie = 0;
		int numOfRolls = 4;
		keepDie = "";
		gameComplete = false;
		handComplete = false;
		endGame = "n";
	}

	/**
	 * sets numOfDie based on file output
	 * 
	 * @param num
	 */
	public void setNumOfDie(int num) {
		numOfDie = num;
		newDice.setNumOfSides(num);
		for (int i = 0; i < numOfDie; i++) {
			hand.add(newDice);
			newDice = new Dice();
			newDice.setNumOfSides(num);
		}
		int x = 0;
		while (x < numOfDie) {
			keepDie += "n";
			x++;
		}
	}

	/**
	 * sets numOfTurnsLeft based on file output
	 * 
	 * @param num
	 */
	public void setNumOfTurnLeft(int num) {
		numOfTurnsLeft = num;
	}

	/**
	 * @param num
	 *            rolls six dice upon first turn and rerolls based on user input
	 */
	public void setCurrentHand(int num) {
		if (numOfTurnsLeft == 0) {
			System.out.println("You have no turns left. ");
			printHand();
			handComplete = true;
			return;
		}

		char keepThis = keepDie.charAt(0);
		
		Boolean allYes = true;
		for (int i = 0; i < numOfDie; i++) {
			keepThis = keepDie.charAt(i);
			if (keepThis == 'n') {
				allYes = false;
				newDice = new Dice();
				newDice.setNumOfSides(num); // makes sure num of sides set
				hand.set(i, newDice);
			}
		}
		
		if (allYes) {
			handComplete = true; // if they keep all die
			numOfTurnsLeft = 1; // increments to 0 at end of loop
			System.out.println("You kept your hand.");
			printHand();
			return;
		}
		printHand();
		if (numOfTurnsLeft != 1) { // won't ask user input if last roll
			// keepHand();
		}
		numOfTurnsLeft -= 1;

	}

	/**
	 * sorts and prints the user's hand
	 */
	public void printHand() {
		sortHand();
		if (numOfTurnsLeft > 0) {
			System.out.println("Your hand is: ");
		} else {
			System.out.println("Your final hand was: ");
		}
		for (int i = 0; i < numOfDie; i++) {
			System.out.print(hand.get(i).getRoll() + " ");
		}
		System.out.println(" ");
	}

	/**
	 * takes user input on which die are to be re-rolled
	 */
	public void keepHand(String h) {
		/*
		 * Boolean flag = false; while (flag == false){
		 * System.out.print("Enter dice to keep (y or n):"); in = new
		 * Scanner(System.in); keepDie = in.next(); if (isNumeric(keepDie)){
		 * System.out.println("Please enter a valid response"); } else flag =
		 * true; }
		 */
		keepDie = h;
	}

	/**
	 * takes user input on which die are to be re-rolled
	 */
	public void sortHand() {
		System.out.println("Here is your sorted hand:");
		Collections.sort(hand, new Comparator<Dice>() {
			public int compare(Dice dieOne, Dice dieTwo) {
				return Integer.compare(dieOne.getRoll(), dieTwo.getRoll());
			}
		});
	}

	/**
	 * @return number of turns left
	 */
	public int getNumOfTurnsLeft() {
		return numOfTurnsLeft;
	}

	/**
	 * @return user's hand
	 */
	public ArrayList<Dice> returnHand() {
		return hand;
	}

	/**
	 * @return gameComplete
	 */
	public Boolean getGameComplete() {
		return gameComplete;
	}

	/**
	 * @return handComplete
	 */
	public Boolean getHandComplete() {
		return handComplete;
	}

	/**
	 * asks user if they want to play another hand
	 */
	public void gameComplete() {

		System.out.print("Would you like to play another hand (y or n): ");
		in = new Scanner(System.in);
		endGame = in.next();
		char end = endGame.charAt(0);
		if (end == 'n') {
			gameComplete = true;
		}
	}

	/**
	 * finds if a string is numeric
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// ******************************************************
	// ******************************************************
	// VARIABLES:
	private ArrayList<Dice> hand = new ArrayList<Dice>();
	private String endGame;
	Dice newDice = new Dice();
	private String keepDie;
	private int numOfDie;
	private int numOfTurnsLeft;
	boolean gameComplete;
	boolean handComplete;
	private Scanner in;
}