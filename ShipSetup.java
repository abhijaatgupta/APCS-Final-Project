import java.util.*;

public class ShipSetup extends Coordinate {
	public static ArrayList<Ship> compArray = new <Ship>ArrayList(); // NEW
	public static ArrayList<Ship> humArray = new <Ship>ArrayList(); // NEW
	public static ArrayList<Integer> compX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> compY = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> humanX = new <Integer>ArrayList(); // NEW
	public static ArrayList<Integer> humanY = new <Integer>ArrayList(); // NEW

	public ShipSetup(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	boolean[][] board = new boolean[8][8];

	public static void computer() {
		Ship compShip = null;
		Random rand = new Random();
		int i = 0;
		boolean repeat = false;
		while (i < 3) {
			int size = rand.nextInt(3) + 2;
			int coin = rand.nextInt(2);
			int xcoord;
			int ycoord;
			if (coin == 1) {
				xcoord = rand.nextInt(8);
				ycoord = rand.nextInt(8 - size);
			} else {
				xcoord = rand.nextInt(8 - size);
				ycoord = rand.nextInt(8);
			}
			Coordinate c1;
			Coordinate c2;
			Coordinate c3;
			Coordinate c4;
			if (coin == 1) {
				c1 = new Coordinate(xcoord, ycoord);
				c2 = new Coordinate(xcoord, ycoord + 1);
				c3 = new Coordinate(xcoord, ycoord + 2);
				c4 = new Coordinate(xcoord, ycoord + 3);
			} else {
				c1 = new Coordinate(xcoord, ycoord);
				c2 = new Coordinate(xcoord + 1, ycoord);
				c3 = new Coordinate(xcoord + 2, ycoord);
				c4 = new Coordinate(xcoord + 3, ycoord);
			}
			if (size == 2) {
				compShip = new TwoLengthShip(c1, c2);
				for (int j = 0; j < compArray.size(); j++) {
					if (size == compArray.get(j).getSize()) {
						Coordinate compShipC1 = (((TwoLengthShip) compShip).getC1());
						Coordinate arrayShipC1 = (((TwoLengthShip) compArray.get(j)).getC1());
						Coordinate compShipC2 = (((TwoLengthShip) compShip).getC2());
						Coordinate arrayShipC2 = (((TwoLengthShip) compArray.get(j)).getC2());
						if (compShipC1.equals(arrayShipC1) || compShipC2.equals(arrayShipC2)) {
							repeat = true;
							break;
						} else {
							continue;
						}
					}
				}

				if (!repeat) {
					compX.add((((TwoLengthShip) compShip).getC1().getX()));
					compY.add((((TwoLengthShip) compShip).getC1().getY()));
					compX.add((((TwoLengthShip) compShip).getC2().getX()));
					compY.add((((TwoLengthShip) compShip).getC2().getY()));
					compArray.add(compShip);
				}

			} else if (size == 3) {
				compShip = new ThreeLengthShip(c1, c2, c3);
				for (int j = 0; j < compArray.size(); j++) {
					if (size == compArray.get(j).getSize()) {
						Coordinate compShipC1 = (((ThreeLengthShip) compShip).getC1());
						Coordinate arrayShipC1 = (((ThreeLengthShip) compArray.get(j)).getC1());
						Coordinate compShipC2 = (((ThreeLengthShip) compShip).getC2());
						Coordinate arrayShipC2 = (((ThreeLengthShip) compArray.get(j)).getC2());
						Coordinate compShipC3 = (((ThreeLengthShip) compShip).getC3());
						Coordinate arrayShipC3 = (((ThreeLengthShip) compArray.get(j)).getC3());
						if (compShipC1.equals(arrayShipC1) || compShipC2.equals(arrayShipC2)
								|| compShipC3.equals(arrayShipC3)) {
							repeat = true;
							break;
						} else {
							continue;
						}
					}
				}

				if (!repeat) {
					compX.add((((ThreeLengthShip) compShip).getC1().getX()));
					compY.add((((ThreeLengthShip) compShip).getC1().getY()));
					compX.add((((ThreeLengthShip) compShip).getC2().getX()));
					compY.add((((ThreeLengthShip) compShip).getC2().getY()));
					compX.add((((ThreeLengthShip) compShip).getC3().getX()));
					compY.add((((ThreeLengthShip) compShip).getC3().getY()));
					compArray.add(compShip);
				}
			} else if (size == 4) {
				compShip = new FourLengthShip(c1, c2, c3, c4);
				for (int j = 0; j < compArray.size(); j++) {
					if (size == compArray.get(j).getSize()) {
						Coordinate compShipC1 = (((FourLengthShip) compShip).getC1());
						Coordinate arrayShipC1 = (((FourLengthShip) compArray.get(j)).getC1());
						Coordinate compShipC2 = (((FourLengthShip) compShip).getC2());
						Coordinate arrayShipC2 = (((FourLengthShip) compArray.get(j)).getC2());
						Coordinate compShipC3 = (((FourLengthShip) compShip).getC3());
						Coordinate arrayShipC3 = (((FourLengthShip) compArray.get(j)).getC3());
						Coordinate compShipC4 = (((FourLengthShip) compShip).getC4());
						Coordinate arrayShipC4 = (((FourLengthShip) compArray.get(j)).getC4());
						if (compShipC1.equals(arrayShipC1) || compShipC2.equals(arrayShipC2)
								|| compShipC3.equals(arrayShipC3) || compShipC4.equals(arrayShipC4)) {
							repeat = true;
							break;
						} else {
							continue;
						}
					}
				}

				if (!repeat) {
					compX.add((((FourLengthShip) compShip).getC1().getX()));
					compY.add((((FourLengthShip) compShip).getC1().getY()));
					compX.add((((FourLengthShip) compShip).getC2().getX()));
					compY.add((((FourLengthShip) compShip).getC2().getY()));
					compX.add((((FourLengthShip) compShip).getC3().getX()));
					compY.add((((FourLengthShip) compShip).getC3().getY()));
					compX.add((((FourLengthShip) compShip).getC4().getX()));
					compY.add((((FourLengthShip) compShip).getC4().getY()));
					compArray.add(compShip);
				}
			}
			if (!repeat) {
				i++;
			} else {
				i = i + 0;
			}
		}
	}

	public static void humanSetupFor2Ship() {
		int round = 1;//Change
		TwoLengthShip ship;
		Scanner scan = new Scanner(System.in);
		boolean repeat = false;//CHANGE
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		//while(repeat) {
		for (int i = 1; i < 3; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			System.out.println("y: ");
			yPoint = scan.nextInt();
			ship = new TwoLengthShip(c1, c2);
			int size = ship.getSize();
			for (int j = 0; j < humArray.size(); j++) {//change
				if (size == humArray.get(j).getSize()) {
					//Coordinate humShipC1 = (((TwoLengthShip) ship).getC1());
					Coordinate arrayShipC1 = (((TwoLengthShip) humArray.get(j)).getC1());
					//Coordinate humShipC2 = (((TwoLengthShip) ship).getC2());
					Coordinate arrayShipC2 = (((TwoLengthShip) humArray.get(j)).getC2());
					if ((xPoint == arrayShipC1.getX() && yPoint == arrayShipC1.getY()) || (xPoint == arrayShipC2.getX() && yPoint == arrayShipC2.getY())) {//Change
						repeat = true;
						System.out.println("You have chosen coordinates that overlap with another ship! Please try again.");
                         --i;
                         break;
						
					} else {
						repeat = false;
						
					}
				}
			}
			while ((xPoint > 7 || xPoint < 0) || (yPoint > 7 || yPoint < 0)) {
				System.out.println("Out of bounds");
				System.out.println("Pick another point!");
				System.out.println("x: ");
				xPoint = scan.nextInt();
				System.out.println("y: ");
				yPoint = scan.nextInt();
			}
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) != 1 && Math.abs(c2.getY() - c1.getY()) != 1) {
					System.out.println("Please enter a second point next" + " to the first one. (1 within point 1)");
					System.out.println("Re-enter the previous coordinate");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
					
					c2 = new Coordinate(xPoint, yPoint);
					round++;//Change
				}
			}
			
			if (!repeat) {
				
				humanX.add((((TwoLengthShip) ship).getC1().getX()));
				humanY.add((((TwoLengthShip) ship).getC1().getY()));
				humanX.add((((TwoLengthShip) ship).getC2().getX()));
				humanY.add((((TwoLengthShip) ship).getC2().getY()));
				humArray.add(ship);
			}
		}
		
		 

		
		//else {
		//}
	}/* else {
			while (repeat) {
				System.out.println("You have chosen coordinates that overlap with another ship! Please try again.");
				humanSetupFor2Ship();
			}
		}*/
	//}

	// }

	public static void humanSetupFor3Ship() {
		boolean repeat = false;
		Scanner scan = new Scanner(System.in);
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		Coordinate c3 = new Coordinate(0, 0);
		for (int i = 1; i < 4; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			System.out.println("y: ");
			yPoint = scan.nextInt();
			while ((xPoint > 7 || xPoint < 0) || (yPoint > 7 || yPoint < 0)) {
				System.out.println("Out of bounds");
				System.out.println("Guess a point!");
				System.out.println("x: ");
				xPoint = scan.nextInt();
				System.out.println("y: ");
				yPoint = scan.nextInt();
			}
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) != 1 && Math.abs(c2.getY() - c1.getY()) != 1) {
					System.out.println("Please enter a second point next" + " to the first one. (1 within point 1)");
					System.out.println("Re-enter the previous coordinate");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
					c2 = new Coordinate(xPoint, yPoint);
				}
			} else if (i == 3) {
				c3 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c3.getX() - c1.getX()) != 1 || Math.abs(c3.getY() - c2.getY()) != 1) {
					while (Math.abs(c3.getX() - c2.getX()) != 1 || Math.abs(c3.getY() - c2.getY()) != 1) {
						System.out.println("Please enter a third point next"
								+ "to the first one or second one. (1 within point of either)");
						System.out.println("Re-enter the previous coordinate");
						System.out.println("x: ");
						xPoint = scan.nextInt();
						System.out.println("y: ");
						yPoint = scan.nextInt();
						c3 = new Coordinate(xPoint, yPoint);
					}
				}
			}
		}

		ThreeLengthShip ship = new ThreeLengthShip(c1, c2, c3);
		int size = ship.getSize();
		for (int j = 0; j < humArray.size(); j++) {
			if (size == compArray.get(j).getSize()) {
				Coordinate humShipC1 = (((ThreeLengthShip) ship).getC1());
				Coordinate arrayShipC1 = (((ThreeLengthShip) humArray.get(j)).getC1());
				Coordinate humShipC2 = (((ThreeLengthShip) ship).getC2());
				Coordinate arrayShipC2 = (((ThreeLengthShip) humArray.get(j)).getC2());
				Coordinate humShipC3 = (((ThreeLengthShip) ship).getC3());
				Coordinate arrayShipC3 = (((ThreeLengthShip) humArray.get(j)).getC3());
				if (humShipC1.equals(arrayShipC1) || humShipC2.equals(arrayShipC2) || humShipC3.equals(arrayShipC3)) {
					repeat = true;
					break;
				} else {
					repeat = false;
					continue;
				}
			}
		}

		if (!repeat) {
			humanX.add((((ThreeLengthShip) ship).getC1().getX()));
			humanY.add((((ThreeLengthShip) ship).getC1().getY()));
			humanX.add((((ThreeLengthShip) ship).getC2().getX()));
			humanY.add((((ThreeLengthShip) ship).getC2().getY()));
			humanX.add((((ThreeLengthShip) ship).getC3().getX()));
			humanY.add((((ThreeLengthShip) ship).getC3().getY()));
			humArray.add(ship);
		} else {
			while (repeat) {
				System.out.println("You have chosen coordinates that overlap with another ship! Please try again.");
				humanSetupFor3Ship();
			}
		}
	}

	public static void humanSetupFor4Ship() {
		Scanner scan = new Scanner(System.in);
		boolean repeat = false;
		int xPoint;
		int yPoint;
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		Coordinate c3 = new Coordinate(0, 0);
		Coordinate c4 = new Coordinate(0, 0);
		for (int i = 1; i < 5; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			System.out.println("y: ");
			yPoint = scan.nextInt();
			while ((xPoint > 7 || xPoint < 0) || (yPoint > 7 || yPoint < 0)) {
				System.out.println("Out of bounds");
				System.out.println("Guess a point!");
				System.out.println("x: ");
				xPoint = scan.nextInt();
				System.out.println("y: ");
				yPoint = scan.nextInt();
			}
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) != 1 && Math.abs(c2.getY() - c1.getY()) != 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("Re-enter the previous coordinate");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
					c2 = new Coordinate(xPoint, yPoint);
				}
			} else if (i == 3) {
				c3 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c3.getX() - c1.getX()) > 1 || Math.abs(c3.getY() - c2.getY()) > 1) {
					while (Math.abs(c3.getX() - c2.getX()) > 1 || Math.abs(c3.getY() - c2.getY()) > 1) {
						System.out.println("Please enter a third point next"
								+ "to the first one or second one. (1 within point of either)");
						System.out.println("x: ");
						xPoint = scan.nextInt();
						System.out.println("y: ");
						yPoint = scan.nextInt();
						c3 = new Coordinate(xPoint, yPoint);
					}
				}
			} else if (i == 4) {
				c4 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c4.getX() - c3.getX()) != 1 || Math.abs(c4.getY() - c3.getY()) != 1) {
					while (Math.abs(c4.getX() - c2.getX()) != 1 || Math.abs(c4.getY() - c2.getY()) != 1) {
						while (Math.abs(c4.getX() - c1.getX()) != 1 || Math.abs(c4.getY() - c1.getY()) != 1) {
							System.out.println("Please enter a fourth point next"
									+ " to the first second or third one. (1 within point of any)");
							System.out.println("Re-enter the previous coordinate");
							System.out.println("x: ");
							xPoint = scan.nextInt();
							System.out.println("y: ");
							yPoint = scan.nextInt();
							c4 = new Coordinate(xPoint, yPoint);
						}
					}
				}
			}

		}

		FourLengthShip ship = new FourLengthShip(c1, c2, c3, c4);
		int size = ship.getSize();
		for (int j = 0; j < humArray.size(); j++) {
			if (size == compArray.get(j).getSize()) {
				Coordinate humShipC1 = (((FourLengthShip) ship).getC1());
				Coordinate arrayShipC1 = (((FourLengthShip) humArray.get(j)).getC1());
				Coordinate humShipC2 = (((FourLengthShip) ship).getC2());
				Coordinate arrayShipC2 = (((FourLengthShip) humArray.get(j)).getC2());
				Coordinate humShipC3 = (((FourLengthShip) ship).getC3());
				Coordinate arrayShipC3 = (((FourLengthShip) humArray.get(j)).getC3());
				Coordinate humShipC4 = (((FourLengthShip) ship).getC4());
				Coordinate arrayShipC4 = (((FourLengthShip) humArray.get(j)).getC4());
				if (humShipC1.equals(arrayShipC1) || humShipC2.equals(arrayShipC2) || humShipC3.equals(arrayShipC3)
						|| humShipC4.equals(arrayShipC4)) {
					repeat = true;
					break;
				} else {
					repeat = false;
					continue;
				}
			}
		}

		if (!repeat) {
			humanX.add((((FourLengthShip) ship).getC1().getX()));
			humanY.add((((FourLengthShip) ship).getC1().getY()));
			humanX.add((((FourLengthShip) ship).getC2().getX()));
			humanY.add((((FourLengthShip) ship).getC2().getY()));
			humanX.add((((FourLengthShip) ship).getC3().getX()));
			humanY.add((((FourLengthShip) ship).getC3().getY()));
			humanX.add((((FourLengthShip) ship).getC4().getX()));
			humanY.add((((FourLengthShip) ship).getC4().getY()));
			humArray.add(ship);
		} else {
			while (repeat) {
				System.out.println("You have chosen coordinates that overlap with another ship! Please try again.");
				humanSetupFor3Ship();
			}
		}

	}
}
