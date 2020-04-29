import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TimerTask;

import javax.swing.Timer;


public class Game {
	Gameplayframe g;
	Gamemanager gm;
	Container c;
    Block movingblock;
    int time = 0;
    int speed = 1000;
    control keyboard;
	Game(){
		
        g = new Gameplayframe();
        gm = new Gamemanager();
        c =  g.getContentPane();
        movingblock = gm.makeRandomBlock();
        gm.makeNextBlock();
        g.updateNext(gm.getNextBlock());
        gm.addBlock(movingblock);
        g.updateBlockcnt(gm.getBlockcnt());
        g.updateFallingblock(movingblock);
        g.updateFrame(gm.blockpane);
        
        c.addKeyListener(keyboard = new control(movingblock, gm, g.fallingblock, g));
        
        Timer t = new Timer(speed, null);
        Al actionlistener = new Al(t);
        t.addActionListener(actionlistener);
        t.start();
        
        
       Timer realtime = new Timer(1000, new timecounter());
       realtime.start();
       
	}
	class timecounter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
	        g.updateTimecnt(time);
		}
	
	}
	class Al implements ActionListener{
		Timer t;
		Al(Timer t){
			this.t = t;
		}
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 if(gm.isMovingblock()) {
				 if(gm.isBottomBlocked()){
					gm.enterBlock();
					gm.eraseLine();
					g.delete(gm.blockpane);
					g.updateLinecnt(gm.getLinecnt());
					g.updatePoint(gm.getPoint());
					g.delete(gm.blockpane);
					g.addStoppedblock(gm.blockpane,movingblock);
					
					if(gm.isGameOver()) {
						try {
							g.addRecord(gm.getPoint());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						g.gameOver();
						t.stop();
					}
					movingblock = gm.getNextBlock();
					gm.makeNextBlock();
					g.updateNext(gm.getNextBlock());
					gm.addBlock(movingblock);
					g.updateBlockcnt(gm.getBlockcnt());
					g.updateFallingblock(movingblock);
					g.updateFrame(gm.blockpane);
					
				}
				else{
					 gm.moveDown();
					 g.updateFrame(gm.blockpane);
					 
				}
			}
			else{
				if(gm.isGameOver()) {
					g.gameOver();
					t.stop();
					try {
						g.addRecord(gm.getPoint());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			if(time % 30 == 0) {
				if(speed >= 200) {
					speed -= 100;
					t.setDelay(speed);
				}
			}
			
		 }		 
		 
	}


}
