import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

		setSize(700, 500);
		JButton startButton = new JButton("Start the game!!!");

		JPanel startPanel = new JPanel();

		startPanel.add(startButton);

		add(startPanel);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFrame frame = new F2Frame();
				frame.setTitle("Don't think...Gamble!!");
				frame.setLocation(400, 100);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});
	}
}
