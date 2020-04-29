import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Gamemanager {
    private static final int WIDTH = 12;
    private static final int HEIGHT = 23;
	int blockpane[][] = new int[HEIGHT][WIDTH];
	int blockcnt = 0;
	int speed;
	int linecnt = 0;
	int point = 0;
	Block next;
	Block save;
	Gamemanager() {
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT-1) {
					if(j == 0 || j == 11) {
						blockpane[i][j] = 1;
					}
					else {
						blockpane[i][j] = 0;
					}
				}
				else {
					blockpane[i][j] = 1;
				}
			}
		}

	}
	
	boolean isLeftBlocked() {				//left wall 1 right wall 2 no 3
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							if(blockpane[i][j-1] == 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	boolean isRightBlocked() {
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							if(blockpane[i][j+1] == 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	boolean isBottomBlocked() {
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							if(blockpane[i+1][j] == 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	boolean isTopBlocked() {
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							if(i == 0) {
								return true;
							}
							else if(blockpane[i-1][j] == 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	void moveLeft() {
		int[][] point = new int[4][2];
		int cnt = 0;
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							blockpane[i][j] = 0;
							point[cnt][0] = i;
							point[cnt][1] = j;
							cnt++;
						}
					}
				}
			}
		}
		for(int i = 0 ; i < 4; i++) {
			blockpane[point[i][0]][point[i][1]-1] = 2;
		}
	}
	void moveRight() {
		int[][] point = new int[4][2];
		int cnt = 0;
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							blockpane[i][j] = 0;
							point[cnt][0] = i;
							point[cnt][1] = j;
							cnt++;
						}
					}
				}
			}
		}
		for(int i = 0 ; i < 4; i++) {
			blockpane[point[i][0]][point[i][1]+1] = 2;
		}
	}
	void moveDown() {
		int[][] point = new int[4][2];
		int cnt = 0;
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							blockpane[i][j] = 0;
							point[cnt][0] = i;
							point[cnt][1] = j;
							cnt++;
						}
					}
				}
			}
		}
		for(int i = 0 ; i < 4; i++) {
			blockpane[point[i][0]+1][point[i][1]] = 2;
		}
	}
	void moveUp() {
		int[][] point = new int[4][2];
		int cnt = 0;
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							blockpane[i][j] = 0;
							point[cnt][0] = i;
							point[cnt][1] = j;
							cnt++;
						}
					}
				}
			}
		}
		for(int i = 0 ; i < 4; i++) {
			blockpane[point[i][0]-1][point[i][1]] = 2;
		}
	}
	
	void rotateClockwise() {
		int[][] point = new int[4][2];
		point = this.getMovningBlock();
		
		if(point[0][0] == point[1][0] && point[0][0] == point[2][0] - 1 && point[0][0] == point[3][0] - 1 && point[0][1] == point[2][1]) {// oblock
			for(int i = 0; i < 4; i++) {
				blockpane[point[i][0]][point[i][1]] = 0;
			}
			for(int i = 0; i < 4; i++) {
				blockpane[point[i][0]][point[i][1]] = 2;
			}
		}
		else {
			if(isCRotatePossible(point)) {		//회전 가능
				for(int i = 0; i < 4; i++) {
					blockpane[point[i][0]][point[i][1]] = 0;
				}
				int n = this.findCenter(point);
				for(int i = 0; i < 4; i++) {
					blockpane[(int) (((int)Math.cos(-Math.PI/2) * (point[i][0] - point[n][0])  - (int)Math.sin(-Math.PI/2) * (point[i][1] - point[n][1]) + point[n][0]))][(int) (((int)Math.sin(-Math.PI/2) * (point[i][0] - point[n][0]) + (int)Math.cos(-Math.PI/2) * (point[i][1] - point[n][1]) + point[n][1]))] = 2;
				}
			}

			
			else {				//회전 불가능
				int trial = 0;
				int cnt = 0;
				while(!isCRotatePossible(point)) {
					if(trial % 4 == 0) {
						for(int i = 0; i < trial/4 + 1; i++) {
							if(!this.isLeftBlocked()) {
								this.moveLeft();
								cnt++;
							}
						}
						point = this.getMovningBlock();
						if(!isCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveRight();
								cnt = 0;
							}
						}
						trial++;
					}
					else if(trial % 4 == 1) {
						for(int i = 0; i < trial/4 + 1; i++) {
							if(!this.isRightBlocked()) {
								this.moveRight();
								cnt++;
							}			
						}
						point = this.getMovningBlock();
						if(!isCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveLeft();
								cnt = 0;
							}
						}
						trial++;
					}

					else if(trial % 4 == 2) {
						for(int i = 0; i < trial/4 + 1; i++) {
							if(!this.isTopBlocked()) {
								this.moveUp();
								cnt++;
							}
						}
						point = this.getMovningBlock();
						if(!isCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveDown();
								cnt = 0;
							}
						}
						trial++;
					}

					else if(trial % 4 == 3) {
						for(int i = 0; i < trial/4 + 1; i++) {	
							if(!this.isBottomBlocked()) {
								this.moveDown();
								cnt++;
							}
						}
						point = this.getMovningBlock();
						if(!isCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveUp();
								cnt = 0;
							}
						}
						trial++;
					}
					if(trial == 7) {
						break;
					}
				}
				if(isCRotatePossible(point)) {
					for(int i = 0; i < 4; i++) {
						blockpane[point[i][0]][point[i][1]] = 0;
					}
					for(int i = 0; i < 4; i++) {
						blockpane[(int) (Math.cos(-Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0])  - Math.sin(-Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][0])][(int) (Math.sin(-Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0]) + Math.cos(-Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][1])] = 2;
					}
				}
			}
			
		}
		

	}
	void rotateCounterClockwise() {
		int[][] point = new int[4][2];
		point = this.getMovningBlock();
		
		if(point[0][0] == point[1][0] && point[0][0] == point[2][0] - 1 && point[0][0] == point[3][0] - 1 && point[0][1] == point[2][1]) {// oblock
			for(int i = 0; i < 4; i++) {
				blockpane[point[i][0]][point[i][1]] = 0;
			}
			for(int i = 0; i < 4; i++) {
				blockpane[point[i][0]][point[i][1]] = 2;
			}
		}
		else {
			if(isCCRotatePossible(point)) {		//회전 가능
				for(int i = 0; i < 4; i++) {
					blockpane[point[i][0]][point[i][1]] = 0;
				}
				int n = this.findCenter(point);
				for(int i = 0; i < 4; i++) {
					blockpane[(int) (((int)Math.cos(Math.PI/2) * (point[i][0] - point[n][0])  - (int)Math.sin(Math.PI/2) * (point[i][1] - point[n][1]) + point[n][0]))][(int) (((int)Math.sin(Math.PI/2) * (point[i][0] - point[n][0]) + (int)Math.cos(Math.PI/2) * (point[i][1] - point[n][1]) + point[n][1]))] = 2;
				}
			}

			
			else {				//회전 불가능
				int trial = 0;
				int cnt = 0;
				while(!isCCRotatePossible(point)) {
					if(trial % 4 == 0) {
						for(int i = 0; i < trial/4 + 1; i++) {
							if(!this.isLeftBlocked()) {
								this.moveLeft();
								cnt++;
							}
						}
						point = this.getMovningBlock();
						if(!isCCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveRight();
								cnt = 0;
							}
						}
						trial++;
					}
					else if(trial % 4 == 1) {
						for(int i = 0; i < trial/4 + 1; i++) {
							if(!this.isRightBlocked()) {
								this.moveRight();
								cnt++;
							}			
						}
						point = this.getMovningBlock();
						if(!isCCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveLeft();
								cnt = 0;
							}
						}
						trial++;
					}

					else if(trial % 4 == 2) {
						for(int i = 0; i < trial/4 + 1; i++) {
							if(!this.isTopBlocked()) {
								this.moveUp();
								cnt++;
							}
						}
						point = this.getMovningBlock();
						if(!isCCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveDown();
								cnt = 0;
							}
						}
						trial++;
					}

					else if(trial % 4 == 3) {
						for(int i = 0; i < trial/4 + 1; i++) {	
							if(!this.isBottomBlocked()) {
								this.moveDown();
								cnt++;
							}
						}
						point = this.getMovningBlock();
						if(!isCCRotatePossible(point)) {
							for(int i = 0; i < cnt; i++) {
								this.moveUp();
								cnt = 0;
							}
						}
						trial++;
					}
					if(trial == 7) {
						break;
					}
				}
				if(isCCRotatePossible(point)) {
					for(int i = 0; i < 4; i++) {
						blockpane[point[i][0]][point[i][1]] = 0;
					}
					for(int i = 0; i < 4; i++) {
						blockpane[(int) (Math.cos(Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0])  - Math.sin(Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][0])][(int) (Math.sin(Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0]) + Math.cos(Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][1])] = 2;
					}
				}
			}
			
		}
		

	}
	boolean isCRotatePossible(int[][] point) {
		for(int i = 3; i >= 0; i--) {
			if(blockpane[(int) (Math.cos(-Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0])  - Math.sin(-Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][0])][(int) (Math.sin(-Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0]) + Math.cos(-Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][1])] == 1) {
				return false;
				
			}
		}
		return true;
	}
	boolean isCCRotatePossible(int [][]point) {
		for(int i = 3; i >= 0; i--) {
			if(blockpane[(int) (Math.cos(Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0])  - Math.sin(Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][0])][(int) (Math.sin(Math.PI/2) * (point[i][0] - point[this.findCenter(point)][0]) + Math.cos(Math.PI/2) * (point[i][1] - point[this.findCenter(point)][1]) + point[this.findCenter(point)][1])] == 1) {
				return false;
			}
		}
		return true;
	}
	void addBlock(Block b) {
		boolean flag = false;
		int n = 3;
		for(int i = 0; i < 4; i++) {
			if(this.blockpane[b.shape[i][0]][b.shape[i][1]] == 1) {
				flag = true;
				if(n > b.shape[i][0]) {
					n = b.shape[i][0];
				}
			}
		}
		if(flag == true) {
			if(n == 2) {
				for(int i = 0; i < 4; i++) {
					this.blockpane[b.shape[i][0]-2][b.shape[i][1]] = 2;
				}
			}
			else {
				for(int i = 0; i < 4; i++) {
					this.blockpane[b.shape[i][0]-1][b.shape[i][1]] = 2;
				}
			}
		}
		else {
			for(int i = 0; i < 4; i++) {
				this.blockpane[b.shape[i][0]][b.shape[i][1]] = 2;
			}
		}
		this.blockcnt++;
	}
	void enterBlock(){
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT-1) {
					if(j != 0 && j != 11) {
						if(this.blockpane[i][j] == 2) {
							this.blockpane[i][j] = 1;
						}
					}
				}
			}
		}
	}
	int getBlockcnt() {
		return blockcnt;
	}
	int getLinecnt() {
		return this.linecnt;
	}
	int getPoint() {
		return point;
	}
	void eraseLine() {
		int temp = this.linecnt;
		for(int i = 2; i < HEIGHT - 1; i++) {
			int cnt = 0;
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 1) {
							cnt++;
						}
					}
				}
			}
			if(cnt == 10) {
				for(int k = 1; k < WIDTH-1; k++) {
					blockpane[i][k] = 0;
				}
				for(int l = i - 1; l >= 0; l--) {
					for(int m = 1; m < WIDTH-1; m++) {
						blockpane[l+1][m] = blockpane[l][m];
			  		}
				}
				this.linecnt++;
			}
		}
		if(this.linecnt - temp == 1) {
			this.point += 100;
		}
		else if(this.linecnt - temp == 2) {
			this.point += 300;
		}
		else if(this.linecnt - temp == 3) {
			this.point += 1000;
		}
		else if(this.linecnt - temp == 4) {
			this.point += 2000;
		}
	}
	boolean isMovingblock(){
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if (i != HEIGHT - 1 && j != 0 && j != WIDTH - 1) {
					if(blockpane[i][j] == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	int findCenter(int[][] point) {
		///Jblock
		if(point[0][1] == point[1][1] && point[1][0] == point[2][0] && point[1][0] == point[3][0]) {//ㄴblock
			return 2;
		}
		else if(point[0][1] == point[2][1] && point[0][1] == point[3][1] && point[0][0] == point[1][0]) {//
			return 2;
		}
		else if(point[0][0] == point[1][0] && point[0][0] == point[2][0] && point[2][1] == point[3][1]) {//ㄱblock
			return 1;
		}
		else if(point[0][1] == point[1][1] && point[0][1] == point[3][1] && point[2][0] == point[3][0]) {//ㅢblock
			return 1;
		}
		///Lblock
		
		else if(point[0][1] == point[3][1] && point[1][0] == point[2][0] && point[1][0] == point[3][0]) {//Lblock
			return 2;
		}
		else if(point[0][1] == point[1][1] && point[0][1] == point[2][1] && point[2][0] == point[3][0]) {//ㄴblock
			return 1;
		}
		else if(point[0][0] == point[1][0] && point[0][0] == point[2][0] && point[0][1] == point[3][1]) {
			return 1;
		}
		else if(point[0][0] == point[1][0] && point[1][1] == point[2][1] && point[1][1] == point[3][1]) {
			return 2;
		}
		//sblock
		else if(point[0][1] == point[1][1] && point[2][1] == point[3][1] && point[1][0] == point[2][0]) {
			return 1;
		}
		else if(point[0][0] == point[1][0] && point[2][0] == point[3][0] && point[0][1] == point[3][1]) {
			return 3;
		}
		//zblock
		else if(point[0][1] == point[2][1] && point[1][1] == point[3][1] && point[1][0] == point[2][0]) {
			return 1;
		}
		else if(point[0][0] == point[1][0] && point[2][0] == point[3][0] && point[1][1] == point[2][1]) {
			return 2;
		}
		//Iblock
		else if(point[0][0] == point[1][0] && point[0][0] == point[2][0] && point[0][0] == point[3][0]) {
			return 2;
		}
		else if(point[0][1] == point[1][1] && point[0][1] == point[2][1] && point[0][1] == point[3][1]) {
			return 2;
		}
		//Tblock
		else if(point[0][1] == point[2][1] && point[1][0] == point[2][0] && point[1][0] == point[3][0]) {
			return 2;
		}
		else if(point[0][1] == point[1][1] && point[0][1] == point[3][1] && point[1][0] == point[2][0]) {
			return 1;
		}
		else if(point[0][0] == point[1][0] && point[0][0] == point[2][0] && point[1][1] == point[3][1]) {
			return 1;
		}
		else if(point[0][1] == point[1][1] && point[0][1] == point[2][1] && point[1][0] == point[2][0]) {
			return 2;
		}
		else {
			return 2;
		}
	}
	void show() {
		System.out.println();
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				System.out.print(blockpane[i][j]);
			}
			System.out.println();
		}
		
	}
	boolean isGameOver() {
		for(int i = 1; i < WIDTH - 1; i++) {
			if(blockpane[0][i] == 1 || blockpane[1][i] == 1) {
				
				return true;
			}
		}
		return false;
	}
	Block makeRandomBlock() {
		Block b = new Block();
		int random = (int)(Math.random()*7);
		switch(random) {
			case 0:
				b = new IBlock();
				break;
			case 1:
				b = new ZBlock();
				break;
			case 2:
				b = new SBlock();
				break;
			case 3:
				b = new TBlock();
				break;
			case 4:
				b = new JBlock();
				break;
			case 5:
				b = new LBlock();
				break;
			case 6:
				b = new OBlock();
				break;
		}

		return b;
	}
	void makeNextBlock() {
		next = makeRandomBlock();
	}
	Block getNextBlock() {
		return this.next;
	}
	void saveBlock(Block b) {
		this.save = b;
	}
	Block getSaveBlock() {
		return this.save;
	}
	void deleteMovingBlock() {
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT-1) {
					if(j != 0 && j != 11) {
						if(this.blockpane[i][j] == 2) {
							this.blockpane[i][j] = 0;
						}
					}
				}
			}
		}
	}
	int[][] getMovningBlock(){
		int cnt = 0;
		int[][] point = new int[4][2];
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(i != HEIGHT - 1) {
					if(j != 0 && j != WIDTH - 1) {
						if(blockpane[i][j] == 2) {
							point[cnt][0] = i;
							point[cnt][1] = j;
							cnt++;
						}
					}
				}
			}
		}
		return point;
	}
}
