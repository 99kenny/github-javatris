
public class Block {
	int classificaiton;
	int[][]shape = new int[4][2];//�ʱ���ǥ
	Block() {
	}


}

class OBlock extends Block{
	OBlock(){
		this.classificaiton = 0;
		this.shape[0][0] = 2;
		this.shape[0][1] = 5;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 2;
		this.shape[1][1] = 6;
		this.shape[2][0] = 3;
		this.shape[2][1] = 5;
		this.shape[3][0] = 3;
		this.shape[3][1] = 6;
	}
}

class IBlock extends Block{
	IBlock(){
		this.classificaiton = 1;
		this.shape[0][0] = 2;
		this.shape[0][1] = 3;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 2;
		this.shape[1][1] = 4;
		this.shape[2][0] = 2;
		this.shape[2][1] = 5;
		this.shape[3][0] = 2;
		this.shape[3][1] = 6;
	}
}

class ZBlock extends Block{
	ZBlock(){
		this.classificaiton = 2;
		this.shape[0][0] = 2;
		this.shape[0][1] = 3;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 2;
		this.shape[1][1] = 4;
		this.shape[2][0] = 3;
		this.shape[2][1] = 4;
		this.shape[3][0] = 3;
		this.shape[3][1] = 5;
	}
}

class SBlock extends Block{
	SBlock(){
		this.classificaiton = 3;
		this.shape[0][0] = 3;
		this.shape[0][1] = 4;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 3;
		this.shape[1][1] = 5;
		this.shape[2][0] = 2;
		this.shape[2][1] = 5;
		this.shape[3][0] = 2;
		this.shape[3][1] = 6;
	}
}

class TBlock extends Block{
	TBlock(){
		this.classificaiton = 4;
		this.shape[0][0] = 2;
		this.shape[0][1] = 3;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 2;
		this.shape[1][1] = 4;
		this.shape[2][0] = 3;
		this.shape[2][1] = 4;
		this.shape[3][0] = 2;
		this.shape[3][1] = 5;
	}
}

class JBlock extends Block{
	JBlock(){
		this.classificaiton = 5;
		this.shape[0][0] = 2;
		this.shape[0][1] = 3;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 3;
		this.shape[1][1] = 3;
		this.shape[2][0] = 3;
		this.shape[2][1] = 4;
		this.shape[3][0] = 3;
		this.shape[3][1] = 5;
	}
}

class LBlock extends Block{
	LBlock(){
		this.classificaiton = 6;
		this.shape[0][0] = 3;
		this.shape[0][1] = 3;     //{{0,5},{0,6},{1,5},{1,6}};
		this.shape[1][0] = 3;
		this.shape[1][1] = 4;
		this.shape[2][0] = 3;
		this.shape[2][1] = 5;
		this.shape[3][0] = 2;
		this.shape[3][1] = 5;
	}
}
