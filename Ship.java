public abstract class Ship {
	protected boolean isDamaged = false;
	protected boolean isAlive = true;
	
	public Ship() {
		
	}
	
	public abstract boolean isDamaged();
	public abstract boolean isAlive();
	public abstract int getSize();
	public abstract void setDamage(boolean status);
	public abstract void setStatus(boolean status);
	
}
