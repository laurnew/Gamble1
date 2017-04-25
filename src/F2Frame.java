
import java.awt.Component;

/**
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber
 * 4/24/2017, Gamble
 * F2Frame sets up the frame and buttons
 */
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class F2Frame extends JFrame {

	/** the variables are initialized **/

	private String keepThis = "nnnnn";
	private String keepBefore = "";
	private String keepAfter = "";
	private JPanel dieOne;

	ArrayList<Integer> scorecard = new ArrayList<Integer>(13);

	int flag = 0;
	int bet = 0;
	int line = 0;

	Scorecard score = new Scorecard();
	Dice dice = new Dice();

	public F2Frame() {

		for (int j = 0; j < 13; j++) {
			scorecard.add(0);
		}

		/** the size of the frame is set **/
		setSize(1000, 700);

		/** the icon images of the dice are created **/
		ImageIcon OG;
		ImageIcon icon = new ImageIcon(getClass().getResource("1.png"));
		ImageIcon icon2 = new ImageIcon(getClass().getResource("2.png"));
		ImageIcon icon3 = new ImageIcon(getClass().getResource("3.png"));
		ImageIcon icon4 = new ImageIcon(getClass().getResource("4.png"));
		ImageIcon icon5 = new ImageIcon(getClass().getResource("5.png"));
		ImageIcon icon6 = new ImageIcon(getClass().getResource("6.png"));
		int numOfRolls = 4;
		int numOfDie = 5;

		/** the dice are rolled and displayed **/
		Hand myHand = new Hand();
		myHand.setNumOfDie(numOfDie);
		myHand.setNumOfTurnLeft(numOfRolls);
		ArrayList<Dice> hand = myHand.returnHand();
		myHand.printHand();
		Dice t1 = hand.get(0);
		int num1 = t1.getRoll();
		if (num1 == 1) {
			OG = icon;
		} else if (num1 == 2) {
			OG = icon2;
		} else if (num1 == 3) {
			OG = icon3;
		} else if (num1 == 4) {
			OG = icon4;
		} else if (num1 == 5) {
			OG = icon5;
		} else {
			OG = icon6;
		}
		JButton one = new JButton(OG);
		Dice t2 = hand.get(1);
		int num2 = t2.getRoll();
		if (num2 == 1) {
			OG = icon;
		} else if (num2 == 2) {
			OG = icon2;
		} else if (num2 == 3) {
			OG = icon3;
		} else if (num2 == 4) {
			OG = icon4;
		} else if (num2 == 5) {
			OG = icon5;
		} else {
			OG = icon6;
		}
		JButton two = new JButton(OG);
		Dice t3 = hand.get(2);
		int num3 = t3.getRoll();
		if (num3 == 1) {
			OG = icon;
		} else if (num3 == 2) {
			OG = icon2;
		} else if (num3 == 3) {
			OG = icon3;
		} else if (num3 == 4) {
			OG = icon4;
		} else if (num3 == 5) {
			OG = icon5;
		} else {
			OG = icon6;
		}
		JButton three = new JButton(OG);
		Dice t4 = hand.get(3);
		int num4 = t4.getRoll();
		if (num4 == 1) {
			OG = icon;
		} else if (num4 == 2) {
			OG = icon2;
		} else if (num4 == 3) {
			OG = icon3;
		} else if (num4 == 4) {
			OG = icon4;
		} else if (num4 == 5) {
			OG = icon5;
		} else {
			OG = icon6;
		}
		JButton four = new JButton(OG);
		Dice t5 = hand.get(4);
		int num5 = t5.getRoll();
		if (num5 == 1) {
			OG = icon;
		} else if (num5 == 2) {
			OG = icon2;
		} else if (num5 == 3) {
			OG = icon3;
		} else if (num5 == 4) {
			OG = icon4;
		} else if (num5 == 5) {
			OG = icon5;
		} else {
			OG = icon6;
		}
		JButton five = new JButton(OG);

		/** buttons to re-roll or start a new hand are created **/
		JButton roll = new JButton("re-roll!!");

		JButton newHand = new JButton("Start a New Hand");
		JButton endGame = new JButton("End Game");

		String betAmount = JOptionPane.showInputDialog(null, "How much would you like to bet?");
		String lineBet = JOptionPane.showInputDialog(null, "Which line (1-13) would you like to bet on?");

		bet = Integer.parseInt(betAmount); // gets int value of player's bet
		line = Integer.parseInt(lineBet);
		
		while (line >13 || line < 1) {
			lineBet = JOptionPane.showInputDialog(null, "Please enter a number between 1 and 13:");
			line = Integer.parseInt(lineBet);
		}

		int totalmoney = score.money;

		while (bet > totalmoney && bet < 0) {
			betAmount = JOptionPane.showInputDialog(null, "How much would you like to bet?");
			bet = Integer.parseInt(betAmount);
		}

		/** buttons are added to panel, panel to frame **/

		dieOne = new JPanel();
		dieOne.add(one);
		dieOne.add(two);
		dieOne.add(three);
		dieOne.add(four);
		dieOne.add(five);
		dieOne.add(roll);
		dieOne.add(newHand);
		dieOne.add(endGame);
		add(dieOne);
		ColorAction One = new ColorAction(1);
		ColorAction Two = new ColorAction(2);
		ColorAction Three = new ColorAction(3);
		ColorAction Four = new ColorAction(4);
		ColorAction Five = new ColorAction(5);
		one.addActionListener(One);
		two.addActionListener(Two);
		three.addActionListener(Three);
		four.addActionListener(Four);
		five.addActionListener(Five);

		/**
		 * action listener is created for the new hand button and the corrected
		 * icon is shown depending the dice
		 **/
		newHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				myHand.keepHand(keepThis);
				keepThis = "nnnnn";
				myHand.setCurrentHand(6);
				ArrayList<Dice> hand = myHand.returnHand();
				ImageIcon OG;
				Dice t1 = hand.get(0);
				int num1 = t1.getRoll();
				if (num1 == 1) {
					OG = icon;
				} else if (num1 == 2) {
					OG = icon2;
				} else if (num1 == 3) {
					OG = icon3;
				} else if (num1 == 4) {
					OG = icon4;
				} else if (num1 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				one.setIcon(OG);
				Dice t2 = hand.get(1);
				int num2 = t2.getRoll();
				if (num2 == 1) {
					OG = icon;
				} else if (num2 == 2) {
					OG = icon2;
				} else if (num2 == 3) {
					OG = icon3;
				} else if (num2 == 4) {
					OG = icon4;
				} else if (num2 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				two.setIcon(OG);
				Dice t3 = hand.get(2);
				int num3 = t3.getRoll();
				if (num3 == 1) {
					OG = icon;
				} else if (num3 == 2) {
					OG = icon2;
				} else if (num3 == 3) {
					OG = icon3;
				} else if (num3 == 4) {
					OG = icon4;
				} else if (num3 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				three.setIcon(OG);
				Dice t4 = hand.get(3);
				int num4 = t4.getRoll();
				if (num4 == 1) {
					OG = icon;
				} else if (num4 == 2) {
					OG = icon2;
				} else if (num4 == 3) {
					OG = icon3;
				} else if (num4 == 4) {
					OG = icon4;
				} else if (num4 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				four.setIcon(OG);
				Dice t5 = hand.get(4);
				int num5 = t5.getRoll();
				if (num5 == 1) {
					OG = icon;
				} else if (num5 == 2) {
					OG = icon2;
				} else if (num5 == 3) {
					OG = icon3;
				} else if (num5 == 4) {
					OG = icon4;
				} else if (num5 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				five.setIcon(OG);
			}
		});
		
		/** the action listener for the end game button
		 * is created
		 */
		endGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});

		/**
		 * the action listener for the re-roll is created
		 * 
		 */
		roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				flag += 1;

				if (flag <= 2) {
					flag++;
				}

				JLabel scoremoney = new JLabel("Current Money");
				JPanel showscore = new JPanel();

				/**
				 * a hand has three rolls after those three rolls the score is
				 * added to an array and the user sees how much money they have
				 */
				if (flag > 2) {
					for (int l = 0; l < 13; l++) {
						if (line == l) {
							Scorecard.upperSection(hand, numOfDie, 6, bet, l);
							Scorecard.lowerSection(hand, 6, numOfDie, bet, l);
							scorecard.add(l, Scorecard.scoreRecord.get(l));
						}
					}
					JOptionPane.showMessageDialog(null, "The hand has ended. You have $" + score.money);

					String lineBet = JOptionPane.showInputDialog(null, "Which line (1-13) would you like to bet on?");
					line = Integer.parseInt(lineBet);
					while (line >13 || line < 1) {
						lineBet = JOptionPane.showInputDialog(null, "Please enter a number between 1 and 13:");
						line = Integer.parseInt(lineBet);
					}
					flag = 0;
				}
			
				
				

				myHand.keepHand(keepThis);
				keepThis = "nnnnn";
				myHand.setCurrentHand(6);
				ArrayList<Dice> hand = myHand.returnHand();
				ImageIcon OG;
				Dice t1 = hand.get(0);
				int num1 = t1.getRoll();
				if (num1 == 1) {
					OG = icon;
				} else if (num1 == 2) {
					OG = icon2;
				} else if (num1 == 3) {
					OG = icon3;
				} else if (num1 == 4) {
					OG = icon4;
				} else if (num1 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				one.setIcon(OG);
				Dice t2 = hand.get(1);
				int num2 = t2.getRoll();
				if (num2 == 1) {
					OG = icon;
				} else if (num2 == 2) {
					OG = icon2;
				} else if (num2 == 3) {
					OG = icon3;
				} else if (num2 == 4) {
					OG = icon4;
				} else if (num2 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				two.setIcon(OG);
				Dice t3 = hand.get(2);
				int num3 = t3.getRoll();
				if (num3 == 1) {
					OG = icon;
				} else if (num3 == 2) {
					OG = icon2;
				} else if (num3 == 3) {
					OG = icon3;
				} else if (num3 == 4) {
					OG = icon4;
				} else if (num3 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				three.setIcon(OG);
				Dice t4 = hand.get(3);
				int num4 = t4.getRoll();
				if (num4 == 1) {
					OG = icon;
				} else if (num4 == 2) {
					OG = icon2;
				} else if (num4 == 3) {
					OG = icon3;
				} else if (num4 == 4) {
					OG = icon4;
				} else if (num4 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				four.setIcon(OG);
				Dice t5 = hand.get(4);
				int num5 = t5.getRoll();
				if (num5 == 1) {
					OG = icon;
				} else if (num5 == 2) {
					OG = icon2;
				} else if (num5 == 3) {
					OG = icon3;
				} else if (num5 == 4) {
					OG = icon4;
				} else if (num5 == 5) {
					OG = icon5;
				} else {
					OG = icon6;
				}
				five.setIcon(OG);

			}

		});

	}

	/**
	 * ColorAction records which dice the user will keep or re-roll
	 * 
	 *
	 */
	private class ColorAction implements ActionListener {
		private int num;

		public ColorAction(int n) {
			num = n;
		}

		public void actionPerformed(ActionEvent event) {
			if (num == 1) {
				keepBefore = keepThis.substring(1);
				if (keepThis.charAt(0) == 'n') {
					keepThis = "y" + keepBefore;
				} else {
					keepThis = "n" + keepBefore;
				}
			} else if (num == 2) {
				keepBefore = keepThis.substring(0, 1);
				keepAfter = keepThis.substring(2);
				if (keepThis.charAt(1) == 'n') {
					keepThis = keepBefore + "y" + keepAfter;
				} else {
					keepThis = keepBefore + "n" + keepAfter;
				}
			} else if (num == 3) {
				keepBefore = keepThis.substring(0, 2);
				keepAfter = keepThis.substring(3);
				if (keepThis.charAt(2) == 'n') {
					keepThis = keepBefore + "y" + keepAfter;
				} else {
					keepThis = keepBefore + "n" + keepAfter;
				}
			} else if (num == 4) {
				keepBefore = keepThis.substring(0, 3);
				keepAfter = keepThis.substring(4);
				if (keepThis.charAt(3) == 'n') {
					keepThis = keepBefore + "y" + keepAfter;
				} else {
					keepThis = keepBefore + "n" + keepAfter;
				}
			} else if (num == 5) {
				keepBefore = keepThis.substring(0, 4);
				keepAfter = keepThis.substring(5);
				if (keepThis.charAt(4) == 'n') {
					keepThis = keepBefore + "y" + keepAfter;
				} else {
					keepThis = keepBefore + "n" + keepAfter;
				}
			} else {
				keepBefore = keepThis.substring(0, 5);
				if (keepThis.charAt(5) == 'n') {
					keepThis = keepBefore + "y";
				} else {
					keepThis = keepBefore + "n";
				}
			}
			System.out.println(keepThis);
		}
	}

}
