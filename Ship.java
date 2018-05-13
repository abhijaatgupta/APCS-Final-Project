
/**
 * Abstract class to set a template to make a ship Two boolean variables to
 * check if the ship is hit or sunk
 *
 */
import java.util.ArrayList;
import java.util.Random;

public abstract class Ship {
	protected boolean isDamaged = false;
	protected boolean isAlive = true;

	/**
	 * Constructor for Ship
	 */
	public Ship() {

	}

	/**
	 * Checks if ship is damaged
	 * 
	 * @return true if damaged, false if not
	 */
	public abstract boolean isDamaged();

	/**
	 * Checks if ship is alive
	 * 
	 * @return true if alive, false if not
	 */
	public abstract boolean isAlive();

	/**
	 * Getter method for ship size
	 * 
	 * @return ship size
	 */
	public abstract int getSize();

	/**
	 * Sets ship damage if damaged
	 * 
	 * @param status
	 *            - updated ship status
	 */
	public abstract void setDamage(boolean status);

	/**
	 * Sets ship status
	 * 
	 * @param status
	 *            - updated ship status
	 */
	public abstract void setStatus(boolean status);

}
