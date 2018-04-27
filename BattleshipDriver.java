import java.util.*;

public class BattleshipDriver extends ShipSetup {
	
	public BattleshipDriver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	protected static int shipChoice;

	public static void main(String[] args) {
		System.out.println("Welcome to Battleship!");
		System.out.println("The game will be played on an 8 by 8" + " field. 0-7 on the x-axis and 0-7 on the y-axis.");
		System.out.println("Select how big your battleship is: 2,3,4?");
		
		Scanner scan = new Scanner(System.in);
		shipChoice = scan.nextInt();
		
		if(shipChoice == 2) {
			humanSetupFor2Ship();
		}
		else if(shipChoice == 3) {
			humanSetupFor3Ship();
		}
		else if(shipChoice == 4) {
			humanSetupFor4Ship();
		}
		
	}

}