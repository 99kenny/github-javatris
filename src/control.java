import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

class control extends KeyAdapter{
	Block movingblock;
	Gamemanager gm;
	JLabel[] fallingblock;
	Gameplayframe g;
	boolean issavepossible = true;
	int cnt = 0;
	control(Block movingblock, Gamemanager gm, JLabel[] fallingblock, Gameplayframe g){
		this.movingblock = movingblock;
		this.gm = gm;
		this.fallingblock = fallingblock;
		this.g = g;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {		//left
			if(!gm.isLeftBlocked()) {
				gm.moveLeft();
				g.updateFrame(gm.blockpane);
			}
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(!gm.isRightBlocked()) {
				gm.moveRight();
				g.updateFrame(gm.blockpane);
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(!gm.isBottomBlocked()){	
				gm.moveDown();
				g.updateFrame(gm.blockpane);
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			while(!gm.isBottomBlocked()) {
				gm.moveDown();
			}
			gm.enterBlock();		
			g.delete(gm.blockpane);
			gm.eraseLine();
			g.updateLinecnt(gm.getLinecnt());
			g.updatePoint(gm.getPoint());
			g.delete(gm.blockpane);
			g.addStoppedblock(gm.blockpane,movingblock);
			if(gm.isGameOver()) {
				g.getContentPane().setFocusable(false);
			}
			else {
				movingblock = gm.getNextBlock();
				gm.makeNextBlock();
				g.updateNext(gm.getNextBlock());
				gm.addBlock(movingblock);
				g.updateBlockcnt(gm.getBlockcnt());
				g.updateFallingblock(movingblock);
				g.updateFrame(gm.blockpane);
			}
			this.issavepossible = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			gm.rotateClockwise();
			g.updateFrame(gm.blockpane);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z) {
			gm.rotateCounterClockwise();
			g.updateFrame(gm.blockpane);
		}
		else if(e.getKeyCode() == KeyEvent.VK_C) {
			if(cnt == 0) {
				if(this.issavepossible == true) {
					gm.deleteMovingBlock();
					gm.saveBlock(movingblock);
					g.updateSave(movingblock);
					this.issavepossible = false;
					
					movingblock = gm.getNextBlock();
					gm.makeNextBlock();
					g.updateNext(gm.getNextBlock());
					gm.addBlock(movingblock);
					g.updateBlockcnt(gm.getBlockcnt());
					g.updateFallingblock(movingblock);
					g.updateFrame(gm.blockpane);	
					cnt++;
				}
			}
			else {
				if(this.issavepossible == true) {
					Block temp = movingblock;
					movingblock = gm.getSaveBlock();
					gm.deleteMovingBlock();
					gm.saveBlock(temp);
					g.updateSave(temp);
					this.issavepossible = false;
					
					gm.addBlock(movingblock);
					g.updateBlockcnt(gm.getBlockcnt());
					g.updateFallingblock(movingblock);
					g.updateFrame(gm.blockpane);	
					cnt++;
				}
			}
			
		}
	}
	
	void setSavePossible() {
		this.issavepossible = true;
	}
}
