import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.paint.Color;
import java.awt.color.*;

/**
 * 
 * @author Lauren Weiser, Emma Delucchi, Katrina Baber
 * Gamble, 4/24/2017
 * class startFrame creates a window to start the game
 * when the user is ready
 *
 */

@SuppressWarnings("serial")
public class startFrame extends JFrame {
	public startFrame() {

		setSize(1000, 700);
		//setBackground(Color.CORNFLOWERBLUE);
		JButton startButton = new JButton("Start the game!!!");
		ImageIcon gamble = new ImageIcon(getClass().getResource("gamble.png"));
		JLabel label =  new JLabel("", gamble, JLabel.CENTER);
		JPanel startPanel = new JPanel();
		startPanel.add(label);
		startPanel.add(startButton);

		add(startPanel);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				
				JFrame frame = new F2Frame();
				frame.setTitle("Don't think...Gamble!!");
				frame.setLocation(400, 100);
				//frame.getContentPane().setBackground(Color.CORNFLOWERBLUE)
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});
	}
}
