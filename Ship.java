public abstract class Ship {
	private boolean isDamaged;
	private boolean isAlive;
	
	public Ship() {
		
	}
	
	public abstract boolean isDamaged();
	public abstract boolean isAlive();
	public abstract int getSize();
	
	
}
