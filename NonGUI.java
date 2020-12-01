public class NonGUI {
	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			double density = 0.05 + (i * 0.05);

			// System.out.println(density);
			System.out.println(getAveragePercentBurned(100, 100, density, 1000));
		}

	}

	// Returns the average percent burned for a specific density
	public static double getAveragePercentBurned(int width, int height, double density, int trials) {
		double numTrees;
		double percentCounter = 0;
		Simulator[] sims = new Simulator[trials];
		for (int i = 0; i < sims.length; i++) {
			sims[i] = new Simulator(height, width, density);
			numTrees = Forest.numState(Tree.ALIVE, sims[i].getArr());
			do {
				sims[i].Increment();
			} while (Forest.numState(Tree.FIRE, sims[i].getArr()) > 0);
			percentCounter += (Forest.numState(Tree.DEAD, sims[i].getArr()) / numTrees) * 100;
		}
		return (percentCounter / trials);
	}

}
