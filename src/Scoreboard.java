import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Scoreboard extends JFrame{
	JLabel[] score = new JLabel[10];
	JButton back = new JButton("Back");
	JPanel scorepanel = new JPanel();

	Scoreboard(){
		this.setTitle("Score Board");
		this.setSize(540,890);
		this.setLayout(null);
		Container c = this.getContentPane();
		c.setBackground(Color.BLACK);
		
		///title///
		JLabel title = new JLabel("SCORE");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Bauhaus 93", Font.BOLD, 80));
		title.setSize(520,200);
		title.setLocation(10,10);
		c.add(title);
		//////////////
		
		////back button////
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorder(new LineBorder(Color.WHITE,1));
		back.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		back.setSize(250,50);
		back.setLocation(10,780);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JButton b = (JButton)e.getSource();
				
				new StartFrame();
				((Window) SwingUtilities.getRoot(b)).dispose();	
			}
		});
		c.add(back);
		//////////////////
		
		///score panel////
		scorepanel.setSize(500,550);
		scorepanel.setLocation(10,220);
		scorepanel.setBackground(Color.BLACK);
		scorepanel.setBorder(new LineBorder(Color.WHITE,0));
		scorepanel.setLayout(null);
		c.add(scorepanel);
		///////////////////
		
		///scores////
		try {
			this.updateScore();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		////////////
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	void updateScore() throws IOException {
		int score[] = new int[10];
		try {
			FileReader file = new FileReader("Score.txt");
			BufferedReader bufReader = new BufferedReader(file);
			String line = "";
			int cnt = 0;
			line = bufReader.readLine();
			StringTokenizer st = new StringTokenizer(line,"/");
			while(st.hasMoreElements()) {
				if(cnt < 10) {
					score[cnt] = Integer.parseInt(st.nextToken());
					cnt++;
				}
			}
			file.close();
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 9; i++) {
			this.score[i] = new JLabel();
			this.score[i].setText((i+1) + " : " + score[i]);
			this.score[i].setForeground(Color.WHITE);
			this.score[i].setHorizontalAlignment(JLabel.LEFT);
			this.score[i].setFont(new Font("Bauhaus 93",Font.BOLD,50));
			this.score[i].setSize(520,55);
			this.score[i].setLocation(40,55*i);
			scorepanel.add(this.score[i]);
		}
		this.score[9] = new JLabel();
		this.score[9].setText((10) + " : " + score[9]);
		this.score[9].setForeground(Color.WHITE);
		this.score[9].setHorizontalAlignment(JLabel.LEFT);
		this.score[9].setFont(new Font("Bauhaus 93",Font.BOLD,50));
		this.score[9].setSize(520,55);
		this.score[9].setLocation(10,55*9);
		scorepanel.add(this.score[9]);
		
		this.score[0].setForeground(Color.RED);
		this.score[1].setForeground(Color.YELLOW);
		this.score[2].setForeground(Color.BLUE);
	}
}
