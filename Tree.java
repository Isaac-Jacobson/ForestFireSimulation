
public class Tree {

	public static int ALIVE = 0;
	public static int FIRE = 1;
	public static int ASH = 2;

	private int state;

	private int row, col;

	public Tree() {
	}

	public Tree(int r, int c) {
		state = 0;
		row = r;
		col = c;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;

	}
}
