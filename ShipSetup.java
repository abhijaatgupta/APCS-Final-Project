import java.util.*;

public class ShipSetup extends Coordinate {

	public ShipSetup(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	boolean[][] board = new boolean[8][8];
	Coordinate [][] twoShipArray = new Coordinate[2][2];
	Coordinate [][] threeShipArray = new Coordinate[3][3];
	Coordinate [][] fourShipArray = new Coordinate[4][4];


	public static Ship computer() {
		Ship compShip = null;
		Random rand = new Random();
		int size = rand.nextInt(3) + 2;
		Coordinate c1 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
		Coordinate c2 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
		Coordinate c3 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
		Coordinate c4 = new Coordinate(rand.nextInt(8), rand.nextInt(8));
		if (size == 2) {
			compShip = new TwoLengthShip(c1, c2);
		} else if (size == 3) {
			compShip = new ThreeLengthShip(c1, c2, c3);
		} else if (size == 4) {
			compShip = new FourLengthShip(c1, c2, c3, c4);
		}
		return compShip;

	}
	private static int xPoint;
	private static int yPoint;
	public static Ship humanSetupFor2Ship() {
		Scanner scan = new Scanner(System.in);
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		for (int i = 1; i < 3; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			System.out.println("y: ");
			yPoint = scan.nextInt();
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
					System.out.println("x: ");
					xPoint = scan.nextInt();
					System.out.println("y: ");
					yPoint = scan.nextInt();
					c2 = new Coordinate(xPoint, yPoint);
				}
			}
		}
		TwoLengthShip ship = new TwoLengthShip(c1, c2);
		return ship;
	}

	public static Ship humanSetupFor3Ship() {
		Scanner scan = new Scanner(System.in);
		Coordinate c1 = new Coordinate(0, 0);
		Coordinate c2 = new Coordinate(0, 0);
		Coordinate c3 = new Coordinate(0, 0);
		for (int i = 1; i < 4; i++) {
			System.out.println("Coordinate " + i);
			System.out.println("x: ");
			xPoint = scan.nextInt();
			System.out.println("y: ");
			yPoint = scan.nextInt();
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
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
			}
		}

		ThreeLengthShip ship = new ThreeLengthShip(c1, c2, c3);
		return ship;
	}

	public static Ship humanSetupFor4Ship() {
		Scanner scan = new Scanner(System.in);
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
			if (i == 1) {
				c1 = new Coordinate(xPoint, yPoint);
			} else if (i == 2) {
				c2 = new Coordinate(xPoint, yPoint);
				while (Math.abs(c2.getX() - c1.getX()) > 1 && Math.abs(c2.getY() - c1.getY()) > 1) {
					System.out.println("Please enter a second point next" + "to the first one. (1 within point 1)");
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
				while (Math.abs(c4.getX() - c1.getX()) > 1 || Math.abs(c4.getY() - c2.getY()) > 1) {
					while (Math.abs(c4.getX() - c2.getX()) > 1 || Math.abs(c4.getY() - c2.getY()) > 1) {
						while (Math.abs(c4.getX() - c1.getX()) > 1 || Math.abs(c4.getY() - c1.getY()) > 1) {
							System.out.println("Please enter a fourth point next"
									+ "to the first second or third one. (1 within point of any)");
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
		return ship;
	}
}
