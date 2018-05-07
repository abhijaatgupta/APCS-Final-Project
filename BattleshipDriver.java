import java.util.*;

public class BattleshipDriver extends ShipSetup {

	public BattleshipDriver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();



	Scanner scan = new Scanner(System.in);

	public void game() {
		boolean isGame = false;
		computer();
		ArrayList<Integer> xPoints = new <Integer>ArrayList();
		ArrayList<Integer> yPoints = new <Integer>ArrayList();
		for (int i = 0; i > 8; i++) {
			xPoints.add(i);
			yPoints.add(i);
		}
		Ship cship = compArray.get(0);
		Ship cship2 = compArray.get(1);
		Ship cship3 = compArray.get(2);
		System.out.println("Welcome to Battleship!");
		System.out.println("The game will be played on an 8 by 8" + " field. 0-7 on the x-axis and 0-7 on the y-axis.");
		System.out.println("Select how big your battleship is: 2,3,4?");
		int size = scan.nextInt();
		while (size != 2 && size != 3 && size != 4) {
			
			System.out.println("Error! Ships can only be between sizes 2-4");
			size = scan.nextInt();
		}
		System.out.println("Now pick coordinates to place your ship.");
		if (size == 2) {
			humanSetupFor2Ship();
			while (isGame == false) {
				while (cship.isAlive() == true) {
					System.out.println("Guess a point!");
					System.out.println("x: ");
					int xGuess = scan.nextInt();
					System.out.println("y: ");
					int yGuess = scan.nextInt();
					System.out.println("broken");
					if ((xGuess == compX.get(0) && yGuess == compY.get(0))) {
						Coordinate c = new Coordinate(compX.get(0), compY.get(0));
						System.out.println("Hit!");
						c.setDamage(true);
					} else if (xGuess == compX.get(1) && yGuess == compY.get(2)) {
						Coordinate c = new Coordinate(compX.get(1), compY.get(1));
						System.out.println("Hit!");
						c.setDamage(true);
					} else {
						System.out.println("You missed");
					}
					int compGuessX = rand.nextInt(8);
					int compGuessY = rand.nextInt(8);
					if (compGuessX == humanX.get(0) && compGuessY == humanY.get(0)) {
						Coordinate c = new Coordinate(humanX.get(0), humanY.get(0));
						System.out.println("The computer has got a hit!");
						c.setDamage(true);
					} else if (compGuessX == humanX.get(1) && compGuessY == humanY.get(2)) {
						Coordinate c = new Coordinate(humanX.get(1), humanY.get(1));
						System.out.println("The computer has got a hit!");
						c.setDamage(true);
					}
				}
			}
		} else if (size == 3) {
			humanSetupFor3Ship();
		} else if (size == 4) {
			humanSetupFor4Ship();
		}

	}

	protected static int shipChoice;

	// NEW METHOD
	public String updateStatus(ArrayList<Ship> arr, int low, int high) {
		int damageCount = 0;
		int aliveCount = 0;
		int deadCount = 0;
		low = 0;
		high = arr.size() - 1;
		String s = "";
		if (low > high) {
			s += "Alive: " + aliveCount + "\n" + "Dead: " + deadCount + "\n" + "Damaged: " + damageCount + "\n";
			return s;
		} else {
			if (arr.get(low).isAlive()) {
				aliveCount++;
			}
			if (arr.get(low).isDamaged()) {
				damageCount++;
			}
			if (!arr.get(low).isDamaged()) {
				deadCount++;
			}
			if (arr.get(high).isAlive()) {
				aliveCount++;
			}
			if (arr.get(high).isDamaged()) {
				damageCount++;
			}
			if (!arr.get(high).isDamaged()) {
				deadCount++;
			}

			return updateStatus(arr, ++low, --high);
		}

	}

	public static void main(String[] args) {
		BattleshipDriver b = new BattleshipDriver(0, 0);
		b.game();
	}

}
