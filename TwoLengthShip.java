/**
 * Subclass to superclass Ship, creates a ship with length of two
 */
public class TwoLengthShip extends Ship {
	Coordinate c1;
	Coordinate c2;

	/**
	 * Creates a two length ship with two coordinates
	 * 
	 * @param c1
	 *            - first coordinate
	 * @param c2
	 *            - second coordinate
	 */
	public TwoLengthShip(Coordinate c1, Coordinate c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	/**
	 * Boolean method to check if ship is damaged
	 * 
	 * @return boolean - true if a coordinate has been guessed (ship is damaged), false if
	 *         not
	 */
	public boolean isDamaged() {
		if ((c1.isDamaged() || c2.isDamaged())) {
			return true;
		} else if (c1.isDamaged() && c2.isDamaged()) {
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
		if (c1.isDamaged() || c2.isDamaged()) {
			return true;
		} else if (!c1.isDamaged() && !c2.isDamaged()) {
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
		return 2;
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
