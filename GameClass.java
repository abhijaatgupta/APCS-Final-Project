
import java.util.*;

public class GameClass extends ShipSetup {

	public static ArrayList<Integer> compGuessesX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> compGuessesY = new <Integer>ArrayList(); // NEW
	public static boolean guesses[][] = new boolean[8][8];
	public static boolean humanBoard[][] = new boolean[8][8];
	public static boolean compBoard[][] = new boolean[8][8];
	public static ArrayList<Boolean> living = new ArrayList<Boolean>(3);
	public static ArrayList<Boolean> dead = new ArrayList<Boolean>(3);
	public static ArrayList<Boolean> damaged = new ArrayList<Boolean>(3);
	public static ArrayList<Boolean> hLiving = new ArrayList<Boolean>(3);
	public static ArrayList<Boolean> hDead = new ArrayList<Boolean>(3);
	public static ArrayList<Boolean> hDamaged = new ArrayList<Boolean>(3);
	public static ArrayList<Coordinate> compGuess = new <Coordinate>ArrayList();
	public static ArrayList<Integer> flips = new <Integer>ArrayList();
	public static ArrayList<Integer> flips2 = new <Integer>ArrayList(); // NEW

	public GameClass(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();

	Scanner scan = new Scanner(System.in);

	public void game() {
		/*
		 * for (int k = 0; k < 3; k++) { living.set(k, true); }
		 */
		boolean isGame = false;
		computer();
		ArrayList<Integer> xPoints = new <Integer>ArrayList();
		ArrayList<Integer> yPoints = new <Integer>ArrayList();
		for (int i = 0; i > 8; i++) {
			xPoints.add(i);
			yPoints.add(i);
		}
		Ship cship1 = compArray.get(0);
		Ship cship2 = compArray.get(1);
		Ship cship3 = compArray.get(2);
		System.out.println("Welcome to Battleship!");
		System.out.println("The game will be played on an 8 by 8" + " field. 0-7 on the x-axis and 0-7 on the y-axis.");
		System.out.println("Select how big your battleship is: 2,3,4?");
		int size1 = scan.nextInt();
		while (size1 != 2 && size1 != 3 && size1 != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size1 = scan.nextInt();
		}
		System.out.println("Select how big your second battleship is: 2,3,4?");
		int size2 = scan.nextInt();
		while (size2 != 2 && size2 != 3 && size2 != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size2 = scan.nextInt();
		}
		System.out.println("Select how big your third battleship is: 2,3,4?");
		int size3 = scan.nextInt();
		while (size3 != 2 && size3 != 3 && size3 != 4) {
			System.out.println("Error! Ships can only be between sizes 2-4");
			size3 = scan.nextInt();
		}
		System.out.println("Now pick coordinates to place your ship.");
		if (size1 == 2) {
			humanSetupFor2Ship();
		}
		if (size2 == 2) {
			humanSetupFor2Ship();
		}
		if (size3 == 2) {
			humanSetupFor2Ship();
		}
		if (size1 == 3) {
			humanSetupFor3Ship();
		}
		if (size2 == 3) {
			humanSetupFor3Ship();
		}
		if (size3 == 3) {
			humanSetupFor3Ship();
		}
		if (size1 == 4) {
			humanSetupFor4Ship();
		}
		if (size2 == 4) {
			humanSetupFor4Ship();
		}
		if (size3 == 4) {
			humanSetupFor4Ship();
		}
		for (int i = 0; i < compX.size(); i++) {// FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL PRESENTATION
			System.out.println(compX.get(i) + "," + compY.get(i));// FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL
																	// PRESENTATION
		} // FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL PRESENTATION
		System.out.println();// FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL PRESENTATION
		for (int i = 0; i < humanX.size(); i++) {// FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL PRESENTATION
			System.out.println(humanX.get(i) + "," + humanY.get(i));// FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL
																	// PRESENTATION
		} // FOR TESTING PURPOSES ONLY, REMOVE FOR ACTUAL PRESENTATION
		int compRound = 0;
		while (isGame == false) {
			int round = 1;
			Ship humShip1 = humArray.get(0);
			Ship humShip2 = humArray.get(1);
			Ship humShip3 = humArray.get(2);
			/**
			 * Human guessing portion
			 */
			try {
				System.out.println("Guess a point!");
				System.out.println("x: ");
				int xGuess = scan.nextInt();
				System.out.println("y: ");
				int yGuess = scan.nextInt();
				// goes through the x's and y's to check if the coordinates were guessed
				// beforehand
				while (guesses[xGuess][yGuess] == true) {
					System.out.println("You already guessed that point, guess again.");
					System.out.println("x: ");
					xGuess = scan.nextInt();
					System.out.println("y: ");
					yGuess = scan.nextInt();
				}
				guesses[xGuess][yGuess] = true;
				// checks the humans guess
				boolean hit = false;
				for (int i = 0; i < compX.size(); i++) {
					if ((xGuess == compX.get(i) && yGuess == compY.get(i))) {
						Coordinate c = new Coordinate(compX.get(i), compY.get(i));
						System.out.println("Hit!");
						humanBoard[xGuess][yGuess] = true;
						c.setDamage(true);
						hit = true;
						for (int m = 0; m < compArray.size(); m++) {
							if ((compArray.get(m).getSize() == 2)) {
								TwoLengthShip currentShip = (TwoLengthShip) compArray.get(m);
								int x1 = currentShip.getC1().getX();
								int y1 = currentShip.getC1().getY();
								int x2 = currentShip.getC2().getX();
								int y2 = currentShip.getC2().getY();

								if (humanBoard[x1][y1] && humanBoard[x2][y2]) {
									compArray.get(m).setStatus(false);
									// living.set(m, false);
									// dead.set(m, true);
									// damaged.set(m, true);
									System.out.println("You sunk a ship of length two!");
									// System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									compArray.remove(m);
									break;
								} else if (humanBoard[x1][y1] || humanBoard[x2][y2]) {
									compArray.get(m).setDamage(true);
									// living.set(m, true);
									// dead.set(m, false);
									// damaged.set(m, true);
									currentShip.setDamage(true);
									break;
								}
							} else if ((compArray.get(m).getSize() == 3)) {
								ThreeLengthShip currentShip = (ThreeLengthShip) compArray.get(m);
								int x1 = currentShip.getC1().getX();
								int y1 = currentShip.getC1().getY();
								int x2 = currentShip.getC2().getX();
								int y2 = currentShip.getC2().getY();
								int x3 = currentShip.getC3().getX();
								int y3 = currentShip.getC3().getY();

								if (humanBoard[x1][y1] && humanBoard[x2][y2] && humanBoard[x3][y3]) {
									currentShip.setStatus(false);
									// living.set(m, false);
									// dead.set(m, true);
									// damaged.set(m, true);
									currentShip.setStatus(false);
									System.out.println("You sunk a ship of length three!");
									// System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									compArray.remove(m);
									break;
								} else if (humanBoard[x1][y1] || humanBoard[x2][y2] || humanBoard[x3][y3]) {
									// living.set(m, true);
									// dead.set(m, false);
									// damaged.set(m, true);
									currentShip.setDamage(true);
									break;
								}
							} else if ((compArray.get(m).getSize() == 4)) {
								FourLengthShip currentShip = (FourLengthShip) compArray.get(m);
								int x1 = currentShip.getC1().getX();
								int y1 = currentShip.getC1().getY();
								int x2 = currentShip.getC2().getX();
								int y2 = currentShip.getC2().getY();
								int x3 = currentShip.getC3().getX();
								int y3 = currentShip.getC3().getY();
								int x4 = currentShip.getC4().getX();
								int y4 = currentShip.getC4().getY();

								if (humanBoard[x1][y1] && humanBoard[x2][y2] && humanBoard[x3][y3]
										&& humanBoard[x4][y4]) {
									// living.set(m, false);
									// dead.set(m, true);
									// damaged.set(m, true);
									currentShip.setStatus(false);
									System.out.println("You sunk a ship of length four!");
									// System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									compArray.remove(m);
									break;
								} else if (humanBoard[x1][y1] || humanBoard[x2][y2] || humanBoard[x3][y3]
										|| humanBoard[x4][y4]) {
									// living.set(m, true);
									// dead.set(m, false);
									// damaged.set(m, true);
									currentShip.setDamage(true);
									break;
								}
							}
						}
						break;
					} else {
						hit = false;
					}
				}
				if (hit == false) {
					System.out.println("You missed!");
				}
			} catch (ArrayIndexOutOfBoundsException a) {
				System.out.println("Your guess was outside of the field. Please make another guess.");
			}
			/**
			 * Computer guessing portion
			 */
			int compGuessX = rand.nextInt(8);
			int compGuessY = rand.nextInt(8);
			while (compBoard[compGuessX][compGuessY] == true) {
				System.out.println("Duplicate");
				compGuessX = rand.nextInt(8);
				compGuessY = rand.nextInt(8);

			}
			compBoard[compGuessX][compGuessY] = true;
			int count = 0;
			if (compGuess.size() > 0) {
				Coordinate nextGuess = compGuess.get(compRound);
				Random coin = new Random();
				int flip = coin.nextInt(2);
				flips.add(flip);
				if (compRound > 0) {
					if (flips.get(0) == 1) {
						flip = 0;
					} else if (flips.get(0) == 0) {
						flip = 1;
					}
				}
				if (flip == 0) {
					int flip2 = coin.nextInt(2);
					flips2.add(flip2);
					System.out.println(compRound);
					if (compRound > 0) {
						if (flips2.get(0) == 1) {
							flip2 = 0;
						} else if (flips2.get(1) == 0) {
							flip2 = 1;
						}
					}
					if (flip2 == 0) {
						int x = nextGuess.getX() + 1;
						System.out.println(x);
						if (x > 7) {
							x = nextGuess.getX() - 1;
						}
						nextGuess = new Coordinate(x, nextGuess.getY());
						compGuess.add(nextGuess);
						compGuessX = x;
						compGuessY = nextGuess.getY();
						compRound++;
					} else {
						int x = nextGuess.getX() - 1;
						System.out.println(x);
						if (x < 0) {
							x = nextGuess.getX() + 1;
						}
						nextGuess = new Coordinate(x, nextGuess.getY());
						compGuess.add(nextGuess);
						compGuessX = x;
						compGuessY = nextGuess.getY();
						compRound++;
					}
				} else {
					int flip2 = coin.nextInt(2);
					flips2.add(flip2);
					System.out.println(compRound);
					if (compRound > 0) {
						if (flips2.get(0) == 1) {
							flip2 = 0;
						} else if (flips2.get(1) == 0) {
							flip2 = 1;
						}
					}
					if (flip == 0) {
						int y = nextGuess.getY() + 1;
						if (y > 7) {
							y = nextGuess.getY() - 1;
						}
						nextGuess = new Coordinate(nextGuess.getX(), y);
						compGuess.add(nextGuess);
						compGuessX = nextGuess.getX();
						compGuessY = nextGuess.getY();
						compRound++;
					} else {
						int y = nextGuess.getY() - 1;
						if (y < 0) {
							y = nextGuess.getY() + 1;
						}
						nextGuess = new Coordinate(nextGuess.getX(), y);
						compGuess.add(nextGuess);
						compGuessX = nextGuess.getX();
						compGuessY = y;
						compRound++;
					}
				}
				// }
				// flips.add(flip);
				// }
			}

			if (compGuessX == humanX.get(0) && compGuessY == humanY.get(0)) {
				System.out.println("The computer guessed point: " + compGuessX + ", " + compGuessY);
				Coordinate c = new Coordinate(humanX.get(0), humanY.get(0));
				System.out.println("The computer has got a hit!");
				c.setDamage(true);
				compGuess.add(c);
			} else if (compGuessX == humanX.get(1) && compGuessY == humanY.get(1)) {
				System.out.println("The computer guessed point: " + compGuessX + ", " + compGuessY);
				Coordinate c = new Coordinate(humanX.get(1), humanY.get(1));
				System.out.println("The computer has got a hit!");
				c.setDamage(true);
				compGuess.add(c);
			} else if (compGuessX == humanX.get(2) && compGuessY == humanY.get(2)) {
				System.out.println("The computer guessed point: " + compGuessX + ", " + compGuessY);
				Coordinate c = new Coordinate(humanX.get(1), humanY.get(1));
				System.out.println("The computer has got a hit!");
				c.setDamage(true);
				compGuess.add(c);
			} else {
				System.out.println("The computer guessed point: " + compGuessX + ", " + compGuessY + " and missed");
			}
		}

	}

	protected static int shipChoice;

	// NEW METHOD
	int damageCount = 0;
	int aliveCount = 0;
	int deadCount = 0;
	String s = "";

	private String updateStatus(int low) {

		if (low == 3) {
			s += "Alive: " + aliveCount + "\n" + "Dead: " + deadCount + "\n" + "Damaged: " + damageCount + "\n";
			damageCount = 0;
			aliveCount = 0;
			deadCount = 0;
			return s;

		} else {
			s = "";
			if (humArray.get(low).isAlive()) {
				aliveCount++;
			}
			if (humArray.get(low).isDamaged()) {
				damageCount++;
			}
			if (!humArray.get(low).isAlive()) {
				deadCount++;
			}

		}
		low = low + 1;
		return updateStatus(low);

	}

	int damageCount2 = 0;
	int aliveCount2 = 0;
	int deadCount2 = 0;
	String s2 = "";

	private String updateCompStatus(int low) {

		if (low == 3) {
			s += "Alive: " + aliveCount2 + "\n" + "Dead: " + deadCount2 + "\n" + "Damaged: " + damageCount2 + "\n";
			damageCount2 = 0;
			aliveCount2 = 0;
			deadCount2 = 0;
			return s2;

		} else {
			s = "";
			if (compArray.get(low).isAlive()) {
				aliveCount2++;
			}
			if (compArray.get(low).isDamaged()) {
				damageCount2++;
			}
			if (!compArray.get(low).isAlive()) {
				deadCount2++;
			}

		}
		low = low + 1;
		return updateCompStatus(low);

	}

	public static void main(String[] args) {
		GameClass b = new GameClass(0, 0);
		b.game();
	}

}
