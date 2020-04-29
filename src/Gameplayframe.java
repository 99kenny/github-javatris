import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Gameplayframe extends JFrame{
	private static final int WIDTH = 12;
    private static final int HEIGHT = 23;
	JLabel[][] blocks = new JLabel[20][10];
	ImageIcon[] Colorblock = new ImageIcon[7];
	ImageIcon Oblock = new ImageIcon("images\\Oblock.png");
	ImageIcon Lblock = new ImageIcon("images\\Lblock.png");
	ImageIcon Jblock = new ImageIcon("images\\Jblock.png");
	ImageIcon Sblock = new ImageIcon("imgaes\\Sblock.png");
	ImageIcon Zblock = new ImageIcon("imgaes\\Zblock.png");
	ImageIcon Tblock = new ImageIcon("imgaes\\Tblock.png");
	ImageIcon Iblock = new ImageIcon("imgaes\\Iblock.png");
	JPanel blockcontainer = new JPanel();
	JLabel[] fallingblock = new JLabel[4];
	JLabel points = new JLabel("Point : " + 0);
	JLabel erasedlinecnt = new JLabel("Line : " + 0);
	JLabel blockscnt = new JLabel("Block : " + 0);
	JLabel timecnt = new JLabel("Time : " + 0);
	JLabel pic = new JLabel();
	JLabel savepic = new JLabel();
	JPanel nextpanel = new JPanel();
	JPanel savepanel = new JPanel();
	JLabel level = new JLabel();
	Gameplayframe g;
	Gameplayframe(){
		g = this;
		////////Frame//////////
		this.setTitle("Javatris");
		this.setSize(540,840);
		this.setLayout(null);

		Container c = this.getContentPane();
		c.setBackground(Color.BLACK);
		
		c.setFocusable(true);
		c.requestFocus();
		////////////////////////

		////////block container////////
		blockcontainer.setSize(302,602);
		blockcontainer.setLocation(10,10);
		blockcontainer.setBackground(Color.BLACK);
		blockcontainer.setLayout(null);
		blockcontainer.setBorder(new LineBorder(Color.white,1));
		c.add(blockcontainer);
		
		///////////////////////////////

		////////Block Image Icons////////
		Colorblock[0] = new ImageIcon("imgaes\\Blue.png");
		Colorblock[1] = new ImageIcon("imgaes\\Green.png");
		Colorblock[2] = new ImageIcon("imgaes\\Orange.png");
		Colorblock[3] = new ImageIcon("imgaes\\Purple.png");
		Colorblock[4] = new ImageIcon("imgaes\\Red.png");
		Colorblock[5] = new ImageIcon("imgaes\\Yellow.png");
		Colorblock[6] = new ImageIcon("imgaes\\Sky.png");
		//////////////////////////////////
		
		//////flalling block settings/////
		fallingblock[0] = new JLabel();
		fallingblock[1] = new JLabel();
		fallingblock[2] = new JLabel();
		fallingblock[3] = new JLabel();
		fallingblock[0].setSize(30, 30);
		fallingblock[1].setSize(30, 30);
		fallingblock[2].setSize(30, 30);
		fallingblock[3].setSize(30, 30);
		//////////////////////////////////
		
		//////Points////////////
		
		points.setForeground(Color.RED);
		points.setSize(300,40);
		points.setLocation(10, 620);
		points.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		c.add(points);
		
		/////erased Line count/////
		
		erasedlinecnt.setForeground(Color.YELLOW);
		erasedlinecnt.setSize(300,40);
		erasedlinecnt.setLocation(10, 660);
		erasedlinecnt.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		c.add(erasedlinecnt);
		
		////Blocks count/////
		
		blockscnt.setForeground(Color.GREEN);
		blockscnt.setSize(300,40);
		blockscnt.setLocation(10, 700);
		blockscnt.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		c.add(blockscnt);
		
		///Time count///
		
		timecnt.setForeground(Color.BLUE);
		timecnt.setSize(300,40);
		timecnt.setLocation(10, 740);
		timecnt.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		c.add(timecnt);
       
		///////////////
		
		///Next BLock////
		
		nextpanel.setSize(190,200);
		nextpanel.setLocation(322,10);
		nextpanel.setBorder(new LineBorder(Color.WHITE,1));
		nextpanel.setBackground(Color.BLACK);
		nextpanel.setLayout(null);
		c.add(nextpanel);
		
		JLabel next = new JLabel("NEXT");
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		next.setSize(170,80);
		next.setLocation(10,10);
		next.setHorizontalAlignment(JLabel.CENTER);
		next.setVerticalAlignment(JLabel.TOP);
		pic.setSize(170,100);
		pic.setLocation(10,100);
		
		nextpanel.add(next);
		nextpanel.add(pic);
		//////////////////
		
		///Save Block///
		savepanel.setSize(190,200);
		savepanel.setLocation(322,220);
		savepanel.setBorder(new LineBorder(Color.WHITE,1));
		savepanel.setBackground(Color.BLACK);
		savepanel.setLayout(null);
		c.add(savepanel);
		
		JLabel save = new JLabel("SAVE");
		save.setForeground(Color.WHITE);
		save.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		save.setSize(170,80);
		save.setLocation(10,10);
		save.setHorizontalAlignment(JLabel.CENTER);
		save.setVerticalAlignment(JLabel.TOP);
		
		savepic.setSize(170,100);
		savepic.setLocation(10,100);
		
		savepanel.add(save);
		savepanel.add(savepic);
		/////////////////
		//level///
		level.setText("Level " + 1);
		level.setSize(190,150);
		level.setLocation(360,620);
		level.setFont(new Font("Bauhaus 93",Font.BOLD,40));
		level.setForeground(Color.WHITE);
		this.getContentPane().add(level);
		/////////
		
		//java logo///
		JLabel javalogo = new JLabel(new ImageIcon("imgaes\\javalogo.png"));
		javalogo.setSize(190,200);
		javalogo.setLocation(330,430);
		c.add(javalogo);
		//////////////
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	void updateTimecnt(int n) {
		this.timecnt.setText("Time : " + n);
		level.setText("Level " + ((n / 30) + 1));
	}
	void updateBlockcnt(int n) {
		this.blockscnt.setText("Block : " + n);
	}
	void updateLinecnt(int n) {
		this.erasedlinecnt.setText("Line : " + n);
	}	
	void updatePoint(int n) {
		this.points.setText("Point : " + n);
	}
	void updateNext(Block b) {
		if(b.classificaiton == 0) {
			nextpanel.remove(pic);
			pic = new JLabel(Oblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();
		}
		else if(b.classificaiton == 1) {
			nextpanel.remove(pic);
			pic = new JLabel(Iblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();
		}
		else if(b.classificaiton == 2) {
			nextpanel.remove(pic);
			pic = new JLabel(Zblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();	
		}
		else if(b.classificaiton == 3) {
			nextpanel.remove(pic);
			pic = new JLabel(Sblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();
		}
		else if(b.classificaiton == 4) {
			nextpanel.remove(pic);
			pic = new JLabel(Tblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();
		}
		else if(b.classificaiton == 5) {
			nextpanel.remove(pic);
			pic = new JLabel(Jblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();
		}
		else if(b.classificaiton == 6) {
			nextpanel.remove(pic);
			pic = new JLabel(Lblock);
			pic.setSize(80,80);
			pic.setLocation(55,100);
			nextpanel.add(pic);
			nextpanel.repaint();
		}
		
	}
	void updateSave(Block b) {
		if(b.classificaiton == 0) {
			savepanel.remove(savepic);
			savepic = new JLabel(Oblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();
		}
		else if(b.classificaiton == 1) {
			savepanel.remove(savepic);
			savepic = new JLabel(Iblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();
		}
		else if(b.classificaiton == 2) {
			savepanel.remove(savepic);
			savepic = new JLabel(Zblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();	
		}
		else if(b.classificaiton == 3) {
			savepanel.remove(savepic);
			savepic = new JLabel(Sblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();
		}
		else if(b.classificaiton == 4) {
			savepanel.remove(savepic);
			savepic = new JLabel(Tblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();
		}
		else if(b.classificaiton == 5) {
			savepanel.remove(savepic);
			savepic = new JLabel(Jblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();
		}
		else if(b.classificaiton == 6) {
			savepanel.remove(savepic);
			savepic = new JLabel(Lblock);
			savepic.setSize(80,80);
			savepic.setLocation(55,100);
			savepanel.add(savepic);
			savepanel.repaint();
		}
	}
	void updateFrame(int blockpane[][]) {
		fallingblock[0].setVisible(false);
		fallingblock[1].setVisible(false);
		fallingblock[2].setVisible(false);
		fallingblock[3].setVisible(false);
		int cnt = 0;
		for(int i = 2; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT-1) {
					if(j != 0 && j != 11) {
						if(blockpane[i][j] == 2) {
							fallingblock[cnt].setLocation(30*(j-1) + 1,30*(i - 2)+1);
							fallingblock[cnt].setVisible(true);
							blockcontainer.add(fallingblock[cnt]);
							cnt++;
						}
					}
				}
			}
		}

	}
	void updateFallingblock(Block b) {
		if(b.classificaiton == 0) {
			fallingblock[0].setIcon(Colorblock[5]);
			fallingblock[1].setIcon(Colorblock[5]);
			fallingblock[2].setIcon(Colorblock[5]);
			fallingblock[3].setIcon(Colorblock[5]);
		}
		else if(b.classificaiton == 1) {
			fallingblock[0].setIcon(Colorblock[6]);
			fallingblock[1].setIcon(Colorblock[6]);
			fallingblock[2].setIcon(Colorblock[6]);
			fallingblock[3].setIcon(Colorblock[6]);
		}
		else if(b.classificaiton == 2) {
			fallingblock[0].setIcon(Colorblock[4]);
			fallingblock[1].setIcon(Colorblock[4]);
			fallingblock[2].setIcon(Colorblock[4]);
			fallingblock[3].setIcon(Colorblock[4]);
		}
		else if(b.classificaiton == 3) {
			fallingblock[0].setIcon(Colorblock[1]);
			fallingblock[1].setIcon(Colorblock[1]);
			fallingblock[2].setIcon(Colorblock[1]);
			fallingblock[3].setIcon(Colorblock[1]);
		}
		else if(b.classificaiton == 4) {
			fallingblock[0].setIcon(Colorblock[3]);
			fallingblock[1].setIcon(Colorblock[3]);
			fallingblock[2].setIcon(Colorblock[3]);
			fallingblock[3].setIcon(Colorblock[3]);
		}
		else if(b.classificaiton == 5) {
			fallingblock[0].setIcon(Colorblock[0]);
			fallingblock[1].setIcon(Colorblock[0]);
			fallingblock[2].setIcon(Colorblock[0]);
			fallingblock[3].setIcon(Colorblock[0]);
		}
		else if(b.classificaiton == 6) {
			fallingblock[0].setIcon(Colorblock[2]);
			fallingblock[1].setIcon(Colorblock[2]);
			fallingblock[2].setIcon(Colorblock[2]);
			fallingblock[3].setIcon(Colorblock[2]);
		}
	}
	void addStoppedblock(int blockpane[][],Block b) {
		for(int i = 2; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT-1) {
					if(j != 0 && j != 11) {
						if(blockpane[i][j] == 1) {
							if(b.classificaiton == 0) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Yellow.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							else if(b.classificaiton == 1) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Sky.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							else if(b.classificaiton == 2) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Red.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							else if(b.classificaiton == 3) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Green.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							else if(b.classificaiton == 4) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Purple.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							else if(b.classificaiton == 5) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Blue.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							else if(b.classificaiton == 6) {
								JLabel stoppedblock = new JLabel(new ImageIcon("imgaes\\Orange.png"));
								stoppedblock.setSize(30,30);
								stoppedblock.setLocation(30*(j-1)+1,30*(i-2)+1);
								blockcontainer.add(stoppedblock);
							}
							
						}
					}
				}
			}
		}
		fallingblock[0].setVisible(false);
		fallingblock[1].setVisible(false);
		fallingblock[2].setVisible(false);
		fallingblock[3].setVisible(false);
	}
	void delete(int blockpane[][]) {
		for(int i = 2; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT-1) {
					if(j != 0 && j != 11) {
						if(blockpane[i][j] == 1) {
							blockcontainer.remove(blockcontainer.getComponentAt(30*(j-1)+1, 30*(i-2)+1));	
							blockcontainer.repaint();
						}
					}
				}
			}
		}
		
	}
	void gameOver() {
		JFrame Gameover = new JFrame("Game Over");
		Gameover.setSize(500,500);
		JLabel Point = new JLabel(this.points.getText());
		Point.setForeground(Color.WHITE);
		Point.setFont(new Font("Bauhaus 93",Font.PLAIN ,30));
		Point.setHorizontalAlignment(JLabel.CENTER);
		JLabel Line = new JLabel(this.erasedlinecnt.getText());
		Line.setForeground(Color.WHITE);
		Line.setFont(new Font("Bauhaus 93",Font.PLAIN ,30));
		Line.setHorizontalAlignment(JLabel.CENTER);
		JLabel Block = new JLabel(this.blockscnt.getText());
		Block.setForeground(Color.WHITE);
		Block.setFont(new Font("Bauhaus 93",Font.PLAIN ,30));
		Block.setHorizontalAlignment(JLabel.CENTER);
		JLabel Time = new JLabel(this.timecnt.getText());
		Time.setForeground(Color.WHITE);
		Time.setFont(new Font("Bauhaus 93",Font.PLAIN ,30));
		Time.setHorizontalAlignment(JLabel.CENTER);
		JLabel gameset = new JLabel("Game Over");
		gameset.setForeground(Color.WHITE);
		gameset.setFont(new Font("Bauhaus 93",Font.PLAIN,50));
		gameset.setHorizontalAlignment(JLabel.CENTER);
		Container con = Gameover.getContentPane();
		con.setBackground(Color.BLACK);
		con.setLayout(new GridLayout(6,1));
		con.add(gameset);
		con.add(Point);
		con.add(Line);
		con.add(Block);
		con.add(Time);
		JLabel end = new JLabel("Press Enter to go back to the Menu...");
		end.setForeground(Color.WHITE);
		end.setHorizontalAlignment(JLabel.CENTER);
		con.add(end);
		con.setFocusable(true);
		
		
		con.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					g.dispose();
					Gameover.dispose();
					new StartFrame();
				}
			}
		});
		Gameover.setVisible(true);
	}
	void addRecord(int n) throws IOException {
		int [] score= {0,0,0,0,0,0,0,0,0,0};
		File record = new File("imgaes.Score.txt");
		FileReader file;
		try {
			file = new FileReader(record);
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
			for(int i = 0; i < 10; i++) {
				if(score[i] < n) {
					for(int j = 9; j > i; j--) {
						score[j] = score[j-1];
					}
					score[i] = n;
					break;
				}
			}
			file.close();
			bufReader.close();
			FileWriter fw = new FileWriter(record,false);
			for(int i = 0; i < 10; i++) {
				fw.write(Integer.toString(score[i]) + "/");
			}
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
