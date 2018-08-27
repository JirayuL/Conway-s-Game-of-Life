
public class Square {
	private boolean alive;
	private int neighbor;
	
	public Square() {
		this.alive = false;
		this.neighbor = 0;
	}

	public int getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(int neighbor) {
		this.neighbor = neighbor;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
