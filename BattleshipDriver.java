import java.util.*;

/**
 * Driver class to test and run Battleship
 * 
 * @author Project Battleship
 */
public class BattleshipDriver {
	/**
	 * Creates a GameClass object to test and run the Battleship simulation
	 * 
	 * @param args
	 *            - args
	 */
	public static void main(String[] args) {
		GameClass g = new GameClass(0, 0);
		g.game();
	}

}
