
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
	 * Default constructor for Ship
	 */
	public Ship() {
	}

	/**
	 * Boolean method to check if ship is damaged
	 * 
	 * @return boolean - true if damaged, false if not
	 */
	public abstract boolean isDamaged();

	/**
	 * Boolean method to check if ship is alive
	 * 
	 * @return boolean - true if alive, false if not
	 */
	public abstract boolean isAlive();

	/**
	 * Getter method to get ship size
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
