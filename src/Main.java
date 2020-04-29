import java.awt.Container;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		StartFrame sf = new StartFrame();
		Click cl = new Click();
		sf.startgame.addMouseListener(cl);

	}

}
