public class Coordinate {

	private int x; // x coordinate of ship
	private int y; // y coordinate of ship
	private int size; // battleship size
	private boolean damage = false; // has the ship taken a hit?

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	/**
	 * 
	 * @return x: the x coordinate of the ship
	 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @return y: the y coordinate of the ship
	 */
	public int getY() {
		return y;
	}
	/**
	 * 
	 * @return getSize: the size of the ship
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @return damage: boolean if the ship has been hit
	 */
	public boolean isDamaged() {
		return damage;
	}
	/**
	 * 
	 * the damage will be set to true has been hit
	 */
	public void setDamage(boolean status) {
		damage = status;
	}
}