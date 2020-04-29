import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class StartFrame extends JFrame {
	JButton startgame = new JButton();
	JButton tosocreboard = new JButton();
	StartFrame(){
		this.setTitle("Javatris");
		this.setSize(540,840);
		
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);

		/////////Title/////////
		ImageIcon logo = new ImageIcon("images\\logo.png");
		JLabel title = new JLabel(logo);
		title.setSize(440,210);
		title.setLocation(50, 0);
		c.add(title);
		//////////////////////


		/////////StartGame button//////////

		startgame.setSize(540,50);
		startgame.setText("Game Start");
		startgame.setFont(new Font("Bauhaus 93",Font.BOLD,40));
		startgame.setForeground(Color.WHITE);
		startgame.setBorderPainted(false);
		startgame.setLocation(0, 420);
		startgame.setBackground(Color.BLACK);
		startgame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JButton b = (JButton)e.getSource();
				new Game();
				((Window) SwingUtilities.getRoot(b)).dispose();	
			}
		});
		c.add(startgame);
		///////////////////////////////////


		/////////ScoreBoard button/////////

		tosocreboard.setSize(540,50);
		tosocreboard.setText("Score Board");
		tosocreboard.setFont(new Font("Bauhaus 93",Font.BOLD,40));
		tosocreboard.setForeground(Color.WHITE);
		tosocreboard.setBorderPainted(false);
		tosocreboard.setLocation(0, 520);
		tosocreboard.setBackground(Color.BLACK);
		tosocreboard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JButton b = (JButton)e.getSource();
				((Window) SwingUtilities.getRoot(b)).dispose();	
				if(b.getText().equals("Score Board")) {
					new Scoreboard();
				}
			}
		});
		c.add(tosocreboard);
		///////////////////////////////////

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
