import java.util.*;

public class BattleshipDriver extends ShipSetup {

	public BattleshipDriver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	Scanner scan = new Scanner(System.in);
	
	public String game() {
		System.out.println("Welcome to Battleship!");
		System.out.println("The game will be played on an 8 by 8" + " field. 0-7 on the x-axis and 0-7 on the y-axis.");
		System.out.println("Select how big your battleship is: 2,3,4?");
		int size = scan.nextInt();
		while(size != 2 || size != 3 || size != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size = scan.nextInt();
		}
		System.out.println("Now pick coordinates to place your ship.");
		if(size == 2) {
			humanSetupFor2Ship();
			computer();
		}
		else if(size == 3) {
			humanSetupFor3Ship();
			computer();
		}
		else if(size == 4) {
			humanSetupFor4Ship();
			computer();
		}
		while()
	}

	protected static int shipChoice;
	
        //NEW METHOD
	public String updateStatus(ArrayList<Ship> arr, int low, int high) {
		int damageCount = 0;
		int aliveCount = 0;
		int deadCount = 0;
		low = 0;
		high = arr.size() - 1;
		String s = "";
		if(low > high) {
			s += "Alive: " + aliveCount + "\n" + "Dead: " + deadCount + "\n" + "Damaged: " + damageCount + "\n";
			return s;
		}
		else {
			if(arr.get(low).isAlive()) {
				aliveCount++;
			}
			if(arr.get(low).isDamaged()) {
				damageCount++;
			}
			if(!arr.get(low).isDamaged()) {
				deadCount++;
			}
			if(arr.get(high).isAlive()) {
				aliveCount++;
			}
			if(arr.get(high).isDamaged()) {
				damageCount++;
			}
			if(!arr.get(high).isDamaged()) {
				deadCount++;
			}
			
			return updateStatus(arr, ++low, --high);
		}
		
		
	}

	public static void main(String[] args) {
	}

}
