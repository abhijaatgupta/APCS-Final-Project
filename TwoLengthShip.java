public class TwoLengthShip extends Ship {
	Coordinate c1;
	Coordinate c2;
	
	
	public TwoLengthShip(Coordinate c1, Coordinate c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	@Override
	public boolean isDamaged() {
		if((c1.isDamaged() || c2.isDamaged())) {
			return true;
		}
		else if(c1.isDamaged() && c2.isDamaged()) {
			setStatus(false);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isAlive() {
		if(c1.isDamaged() || c2.isDamaged()) {
			return true;
		}
		else if(!c1.isDamaged() && !c2.isDamaged()) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getSize() {
		return 2;
	}
	public Coordinate getC1() {
		return c1;
	}
	public Coordinate getC2() {
		return c2;
	}
	@Override
	public void setStatus(boolean status) {
		isAlive = status;
		
	}
	@Override
	public void setDamage(boolean status) {
		isDamaged = status;
		
	}
}
