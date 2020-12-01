
public class Simulator {

	private Forest forest;

	/***
	 * Create a new simulator. The simulator creates a new Forest of size (r,
	 * c).
	 * 
	 * @param r
	 * @param c
	 */
	public Simulator(int r, int c, double density) {
		forest = new Forest(r, c, density);
	}

	public void Increment() {
		Forest.oneStep();
	}

	public Forest getForest() {
		return this.forest;
	}

	public Tree[][] getArr() {
		return this.forest.currentArr;
	}

}