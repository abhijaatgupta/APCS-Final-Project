/**
 * Subclass to superclass Ship, creates a ship with length of three
 */
public class ThreeLengthShip extends Ship {
	Coordinate c1;
	Coordinate c2;
	Coordinate c3;

	/**
	 * Creates a three length ship with three coordinates
	 * 
	 * @param c1
	 *            - first coordinate
	 * @param c2
	 *            - second coordinate
	 * @param c3
	 *            - third coordinate
	 */
	public ThreeLengthShip(Coordinate c1, Coordinate c2, Coordinate c3) {
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}

	@Override
	/**
	 * Boolean method to check if ship is damaged
	 * 
	 * @return boolean - true if a coordinate has been guessed (ship is damaged), false if
	 *         not
	 */
	public boolean isDamaged() {
		if ((c1.isDamaged() || c2.isDamaged() || c3.isDamaged())) {
			return true;
		} else if (c1.isDamaged() && c2.isDamaged() && c3.isDamaged()) {
			setStatus(false);
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * Boolean method to check if ship is alive
	 * 
	 * @return boolean - true if all coordinates have not been guessed, false if not
	 */
	public boolean isAlive() {
		if (c1.isDamaged() || c2.isDamaged() || c3.isDamaged()) {
			return true;
		} else if (!c1.isDamaged() && !c2.isDamaged() && !c3.isDamaged()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Getter method for ship size
	 * 
	 * @return ship size
	 */
	public int getSize() {
		return 3;
	}

	/**
	 * Getter method for first coordinate
	 * 
	 * @return c1 - first coordinate
	 */
	public Coordinate getC1() {
		return c1;
	}

	/**
	 * Getter method for second coordinate
	 * 
	 * @return c2 - second coordinate
	 */
	public Coordinate getC2() {
		return c2;
	}

	/**
	 * Getter method for third coordinate
	 * 
	 * @return c3 - third coordinate
	 */
	public Coordinate getC3() {
		return c3;
	}

	@Override
	/**
	 * Sets status for ship if alive or not
	 */
	public void setStatus(boolean status) {
		isAlive = status;

	}

	@Override
	/**
	 * Sets damage for ship status
	 */
	public void setDamage(boolean status) {
		isDamaged = status;

	}
}
