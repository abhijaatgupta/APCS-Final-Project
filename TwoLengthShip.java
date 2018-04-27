public class TwoLengthShip extends Ship {
	Coordinate c1;
	Coordinate c2;
	
	
	public TwoLengthShip(Coordinate c1, Coordinate c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	@Override
	public boolean isDamaged() {
		if((c1.isDamaged() || c2.isDamaged()) && (!isAlive())) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isAlive() {
		if(c1.isDamaged() && c2.isDamaged()) {
			return true;
		}
		else {
			return false;
		}
	}

}