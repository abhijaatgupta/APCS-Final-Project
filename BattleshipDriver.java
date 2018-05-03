import java.util.*;

public class BattleshipDriver extends ShipSetup {

	public BattleshipDriver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	Scanner scan = new Scanner(System.in);

	public void game() {
		System.out.println("Welcome to Battleship!");
		System.out.println("The game will be played on an 8 by 8" + " field. 0-7 on the x-axis and 0-7 on the y-axis.");
		System.out.println("Select how big your battleship is: 2,3,4?");
		int size = scan.nextInt();
		while (size != 2 || size != 3 || size != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size = scan.nextInt();
		}
		System.out.println("Now pick coordinates to place your ship.");
		if (size == 2) {
			computer();
			Ship ship = humanSetupFor2Ship();
			boolean destroyed = false;
			while (destroyed == false) {
				System.out.println("Take a guess");
				int guess = scan.nextInt();
				if () {
				}
			}
		} else if (size == 3) {
			humanSetupFor3Ship();
			computer();
		} else if (size == 4) {
			humanSetupFor4Ship();
			computer();
		}

	}

	protected static int shipChoice;

	public static void main(String[] args) {
	}

}
