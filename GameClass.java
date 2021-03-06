import java.util.*;

public class GameClass extends ShipSetup {

	public static ArrayList<Integer> compGuessesX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> compGuessesY = new <Integer>ArrayList(); // NEW
	public static boolean guesses[][] = new boolean[8][8];
	public static boolean humanBoard[][] = new boolean[8][8];
	public static boolean compBoard[][] = new boolean[8][8];
	public static ArrayList<Boolean> living = new ArrayList<Boolean>(3);
	public static ArrayList<Boolean> hLiving = new ArrayList<Boolean>(3);

	public GameClass(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	Random rand = new Random();

	Scanner scan = new Scanner(System.in);

	public void game() {
		living.add(true);
		living.add(true);
		living.add(true);
		hLiving.add(true);
		hLiving.add(true);
		hLiving.add(true);
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
		while (isGame == false) {
			if (humArray.size() >= 1) {
				Ship humShip1 = humArray.get(0);
			}
			if (humArray.size() >= 2) {
				Ship humShip2 = humArray.get(1);
			}
			if (humArray.size() >= 3) {
				Ship humShip3 = humArray.get(2);
			}
			int round = 1;

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
								Coordinate c1 = new Coordinate(x1, y1);
								Coordinate c2 = new Coordinate(x2, y2);

								if ((humanBoard[x1][y1] && humanBoard[x2][y2])
										&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2))) {
									if (!living.get(m)) {
										for (int s = 0; s < living.size(); s++) {
											if (living.get(s)) {
												living.set(s, false);
												break;
											}
										}
									} else {
										living.set(m, false);
									}
									// compArray.get(m).setStatus(false);
									// living.set(m, false);
									// dead.set(m, true);
									// damaged.set(m, true);
									System.out.println("You sunk a ship of length two!");
									System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									compArray.remove(m);
									break;
								} else if ((humanBoard[x1][y1] || humanBoard[x2][y2])
										&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2))) {

									// compArray.get(m).setDamage(true);
									// living.set(m, true);
									// dead.set(m, false);
									// damaged.set(m, true);
									// currentShip.setDamage(true);
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
								Coordinate c1 = new Coordinate(x1, y1);
								Coordinate c2 = new Coordinate(x2, y2);
								Coordinate c3 = new Coordinate(x3, y3);

								if ((humanBoard[x1][y1] && humanBoard[x2][y2] && humanBoard[x3][y3])
										&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
												&& currentShip.getC3().equals(c3))) {
									if (!living.get(m)) {
										for (int s = 0; s < living.size(); s++) {
											if (living.get(s)) {
												living.set(s, false);
												break;
											}
										}
									} else {
										living.set(m, false);
									}
									// currentShip.setStatus(false);
									// living.set(m, false);
									// dead.set(m, true);
									// damaged.set(m, true);
									// currentShip.setStatus(false);
									System.out.println("You sunk a ship of length three!");
									System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									compArray.remove(m);
									break;
								} else if ((humanBoard[x1][y1] || humanBoard[x2][y2] || humanBoard[x3][y3])
										&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
												&& currentShip.getC3().equals(c3))) {

									// living.set(m, true);
									// dead.set(m, false);
									// damaged.set(m, true);
									// currentShip.setDamage(true);
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
								Coordinate c1 = new Coordinate(x1, y1);
								Coordinate c2 = new Coordinate(x2, y2);
								Coordinate c3 = new Coordinate(x3, y3);
								Coordinate c4 = new Coordinate(x4, y4);

								if ((humanBoard[x1][y1] && humanBoard[x2][y2] && humanBoard[x3][y3]
										&& humanBoard[x4][y4])
										&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
												&& currentShip.getC3().equals(c3) && currentShip.getC4().equals(c4))) {
									if (!living.get(m)) {
										for (int s = 0; s < living.size(); s++) {
											if (living.get(s)) {
												living.set(s, false);
												break;
											}
										}
									} else {
										living.set(m, false);
									}
									// living.set(m, false);
									// dead.set(m, true);
									// damaged.set(m, true);
									// currentShip.setStatus(false);
									System.out.println("You sunk a ship of length four!");
									System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									compArray.remove(m);
									break;
								} else if ((humanBoard[x1][y1] || humanBoard[x2][y2] || humanBoard[x3][y3]
										|| humanBoard[x4][y4])
										&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
												&& currentShip.getC3().equals(c3) && currentShip.getC4().equals(c4))) {

									// living.set(m, true);
									// dead.set(m, false);
									// damaged.set(m, true);
									// currentShip.setDamage(true);
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
			for (int i = 0; i < humanX.size(); i++) {
				if ((compGuessX == humanX.get(i) && compGuessY == humanY.get(i))) {
					System.out.println("The computer got a hit at (" + compGuessX + ", " + compGuessY + ")!");
					compBoard[compGuessX][compGuessY] = true;
					for (int m = 0; m < humArray.size(); m++) {
						if ((humArray.get(m).getSize() == 2)) {
							TwoLengthShip currentShip = (TwoLengthShip) humArray.get(m);
							int x1 = currentShip.getC1().getX();
							int y1 = currentShip.getC1().getY();
							int x2 = currentShip.getC2().getX();
							int y2 = currentShip.getC2().getY();

							if (compBoard[x1][y1] && compBoard[x2][y2]) {
								Coordinate c1 = new Coordinate(x1, y1);
								Coordinate c2 = new Coordinate(x2, y2);
								if (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)) {
									if (!hLiving.get(m)) {
										for (int s = 0; s < hLiving.size(); s++) {
											if (hLiving.get(s)) {
												hLiving.set(s, false);
												break;
											}
										}
									} else {
										hLiving.set(m, false);
									}
									// hLiving.set(m, false);
									// hDead.set(m, true);
									// hDamaged.set(m, true);
									// humArray.get(m).setStatus(false);

									// currentShip.setStatus(false);
									System.out.println("The computer sunk your ship of length two!");
									System.out.println();
									System.out.println("Your stats:");
									System.out.println(updateStatus(0));
									System.out.println("Computer's stats:");
									System.out.println(updateCompStatus(0));
									humArray.remove(m);
									break;
								}
							} else if (compBoard[x1][y1] || compBoard[x2][y2]) {
								Coordinate c1 = new Coordinate(x1, y1);
								Coordinate c2 = new Coordinate(x2, y2);
								if (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)) {
									// hLiving.set(m, true);
									// hDead.set(m, false);
									// hDamaged.set(m, true);
									// humArray.get(m).setDamage(true);

									// currentShip.setDamage(true);
									break;
								}
							}
						} else if ((humArray.get(m).getSize() == 3)) {
							ThreeLengthShip currentShip = (ThreeLengthShip) humArray.get(m);
							int x1 = currentShip.getC1().getX();
							int y1 = currentShip.getC1().getY();
							int x2 = currentShip.getC2().getX();
							int y2 = currentShip.getC2().getY();
							int x3 = currentShip.getC3().getX();
							int y3 = currentShip.getC3().getY();

							Coordinate c1 = new Coordinate(x1, y1);
							Coordinate c2 = new Coordinate(x2, y2);
							Coordinate c3 = new Coordinate(x3, y3);

							if ((compBoard[x1][y1] && compBoard[x2][y2] && compBoard[x3][y3])
									&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
											&& currentShip.getC3().equals(c3))) {
								if (!hLiving.get(m)) {
									for (int s = 0; s < hLiving.size(); s++) {
										if (hLiving.get(s)) {
											hLiving.set(s, false);
											break;
										}
									}
								} else {
									hLiving.set(m, false);
								}
								// hLiving.set(m, false);
								// hDead.set(m, true);
								// hDamaged.set(m, true);
								// currentShip.setStatus(false);
								// humArray.get(m).setStatus(false);
								System.out.println("The computer sunk your ship of length three!");
								System.out.println();
								System.out.println("Your stats:");
								System.out.println(updateStatus(0));
								System.out.println("Computer's stats:");
								System.out.println(updateCompStatus(0));
								humArray.remove(m);
								break;
							} else if (compBoard[x1][y1] || compBoard[x2][y2] || compBoard[x3][y3]) {
								// hLiving.set(m, true);
								// hDead.set(m, false);
								// hDamaged.set(m, true);
								// humArray.get(m).setDamage(true);
								// currentShip.setDamage(true);
								break;
							}
						} else if ((humArray.get(m).getSize() == 4)) {
							FourLengthShip currentShip = (FourLengthShip) humArray.get(m);
							int x1 = currentShip.getC1().getX();
							int y1 = currentShip.getC1().getY();
							int x2 = currentShip.getC2().getX();
							int y2 = currentShip.getC2().getY();
							int x3 = currentShip.getC3().getX();
							int y3 = currentShip.getC3().getY();
							int x4 = currentShip.getC4().getX();
							int y4 = currentShip.getC4().getY();

							Coordinate c1 = new Coordinate(x1, y1);
							Coordinate c2 = new Coordinate(x2, y2);
							Coordinate c3 = new Coordinate(x3, y3);
							Coordinate c4 = new Coordinate(x4, y4);

							if ((compBoard[x1][y1] && compBoard[x2][y2] && compBoard[x3][y3] && compBoard[x4][y4])
									&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
											&& currentShip.getC3().equals(c3) && currentShip.getC4().equals(c4))) {
								if (!hLiving.get(m)) {
									for (int s = 0; s < hLiving.size(); s++) {
										if (hLiving.get(s)) {
											hLiving.set(s, false);
											break;
										}
									}
								} else {
									hLiving.set(m, false);
								}

								// hLiving.set(m, false);
								// hDead.set(m, true);
								// hDamaged.set(m, true);
								// currentShip.setStatus(false);
								// humArray.get(m).setStatus(false);
								System.out.println("The computer sunk your ship of length four!");
								System.out.println();
								System.out.println("Your stats:");
								System.out.println(updateStatus(0));
								System.out.println("Computer's stats:");
								System.out.println(updateCompStatus(0));
								humArray.remove(m);
								break;
							} else if ((compBoard[x1][y1] || compBoard[x2][y2] || compBoard[x3][y3]
									|| compBoard[x4][y4])
									&& (currentShip.getC1().equals(c1) && currentShip.getC2().equals(c2)
											&& currentShip.getC3().equals(c3) && currentShip.getC4().equals(c4))) {
								// hLiving.set(m, true);
								// hDead.set(m, false);
								// hDamaged.set(m, true);
								// humArray.get(m).setDamage(true);
								// currentShip.setDamage(true);
								break;
							}
						}
					}

				}
			}
			if (compArray.size() == 0) {
				System.out.println("Congratulations, you sunk all the computer's ships and won!");
				isGame = true;
			} else if (humArray.size() == 0) {
				System.out.println("Sorry, the computer sunk all your ships. You lose!");
				isGame = true;
			}
		}
		/*
		 * for (int i = 0; i < round - 1; i++) { while (compGuessesX.get(i) ==
		 * compGuessX && compGuessesY.get(i) == compGuessY) {
		 * System.out.println("You already guessed this point, pick again"); } }
		 */
		/*
		 * for(int l = 0; l < humArray.size(); l++) { if (compGuessX == humanX.get(0) &&
		 * compGuessY == humanY.get(0)) { Coordinate c = new Coordinate(humanX.get(0),
		 * humanY.get(0)); System.out.println("The computer has got a hit!");
		 * c.setDamage(true); } else if (compGuessX == humanX.get(1) && compGuessY ==
		 * humanY.get(2)) { Coordinate c = new Coordinate(humanX.get(1), humanY.get(1));
		 * System.out.println("The computer has got a hit!"); c.setDamage(true); }
		 * round++; }
		 */
	}

	protected static int shipChoice;

	// NEW METHOD
	int aliveCount = 0;
	int deadCount = 0;
	String s = "";

	private String updateStatus(int low) {

		if (low == 3) {
			s += "Alive: " + aliveCount + "\n" + "Dead: " + deadCount + "\n";
			aliveCount = 0;
			deadCount = 0;
			return s;

		} else {
			s = "";
			if (hLiving.get(low)) {
				aliveCount++;
			}

			if (!hLiving.get(low)) {
				deadCount++;
			}

		}
		low = low + 1;
		return updateStatus(low);

	}

	int aliveCount2 = 0;
	int deadCount2 = 0;
	String s2 = "";

	private String updateCompStatus(int low) {

		if (low == 3) {
			s2 += "Alive: " + aliveCount2 + "\n" + "Dead: " + deadCount2 + "\n";
			aliveCount2 = 0;
			deadCount2 = 0;
			return s2;

		} else {
			s2 = "";
			if (living.get(low)) {
				aliveCount2++;
			}

			if (!living.get(low)) {
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
