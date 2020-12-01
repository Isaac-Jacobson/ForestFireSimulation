
public class Forest {

	private int width;
	private int height;
	public static Tree[][] currentArr;
	private static Tree[][] nextArr;
	private static double treeDensity;
	private static int[][] life;

	// Constructs a forest
	public Forest(int r, int c, double density) {

		currentArr = new Tree[r][c];
		nextArr = new Tree[r][c];
		life = new int[r][c];

		treeDensity = density;
		width = c;
		height = r;

		setTrees();

	}

	public int getWidth() {
		return width;
	}

	public Tree getObjectAt(int r, int c) {
		return currentArr[r][c];
	}

	public int getHeight() {
		return height;
	}

	// Checks if a location is valid and in a current state
	public static boolean obtainable(int r, int c, int state) {
		if (r >= 0 && r < currentArr.length) {
			if (c >= 0 && c < currentArr[0].length) {
				if (currentArr[r][c] != null) {
					return currentArr[r][c].getState() == state;
				}
			}
		}
		return false;
	}

	// Initialize trees and set first fire
	public void setTrees() {
		int row;
		int col;
		int numTrees = 0;
		int targetNum = (int) (width * height * treeDensity);
		do {
			row = (int) (Math.random() * height);
			col = (int) (Math.random() * width);

			if (currentArr[row][col] == null) {
				currentArr[row][col] = new Tree(row, col);
				nextArr[row][col] = new Tree(row, col);
				life[row][col] = (int) (Math.random() * 5) + 5;

				numTrees++;
			}
		} while (numTrees < targetNum);

		currentArr[row][col].setState(Tree.FIRE);
		// Set last random tree on fire
	}

	// Propagate the fire by one step
	public static void oneStep() {

		for (int i = 0; i < currentArr.length; i++) {
			for (int j = 0; j < currentArr[0].length; j++) {
				spreadFire(i, j);
			}
		}
		Tree[][] temp = nextArr;
		nextArr = currentArr;
		currentArr = temp;

	}

	public static void spreadFire(int row, int col) {
		if (currentArr[row][col] != null && nextArr[row][col] != null) {
			if (obtainable(row, col, Tree.FIRE)) {
				life[row][col]--;
				if (obtainable(row - 1, col, Tree.ALIVE)) {
					nextArr[row - 1][col].setState(Tree.FIRE);
				}
				if (obtainable(row + 1, col, Tree.ALIVE)) {
					nextArr[row + 1][col].setState(Tree.FIRE);
				}
				if (obtainable(row, col - 1, Tree.ALIVE)) {
					nextArr[row][col - 1].setState(Tree.FIRE);
				}
				if (obtainable(row, col + 1, Tree.ALIVE)) {
					nextArr[row][col + 1].setState(Tree.FIRE);
				}

			}
			if (life[row][col] <= 0) {
				nextArr[row][col].setState(Tree.DEAD);
			}
		}
	}

	// Returns how many trees are in a current state
	public static int numState(int state, Tree[][] Arr) {
		int counter = 0;
		for (int i = 0; i < Arr.length; i++) {
			for (int j = 0; j < Arr[0].length; j++) {
				if (Arr[i][j] != null) {
					if (Arr[i][j].getState() == state) {
						counter++;
					}
				}
			}
		}
		return counter;
	}

}
