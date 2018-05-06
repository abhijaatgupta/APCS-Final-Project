public class ThreeLengthShip extends Ship {
	Coordinate c1;
	Coordinate c2;
	Coordinate c3;
	
	public ThreeLengthShip(Coordinate c1, Coordinate c2, Coordinate c3){
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}
	@Override
	public boolean isDamaged() {
		if((c1.isDamaged() || c2.isDamaged() || c3.isDamaged()) && (!isAlive())) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isAlive() {
		if(c1.isDamaged() && c2.isDamaged() && c3.isDamaged()) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getSize() {
		return 3;
	}
	public Coordinate getC1() {
		return c1;
	}
	public Coordinate getC2() {
		return c2;
	}
	public Coordinate getC3() {
		return c3;
	}

}
