import processing.core.*;

public class GUI extends PApplet {
	int c;
	Simulator sim;
	Display display;

	public void setup() {
		size(1400, 1400); // set the size of the screen.

		// Create a simulator
		sim = new Simulator(150, 150, 0.65);

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, 1400, 1400);

		display.setNumCols(150); // NOTE: these must match your simulator!!
		display.setNumRows(150);

		// Set different grid values to different colors
		// TODO: uncomment these lines!

		display.setColor(Tree.FIRE, color(255, 0, 0));
		display.setColor(Tree.ASH, color(100, 100, 100));
		display.setColor(Tree.ALIVE, color(0, 255, 0));

		// You can use classes instead, for example:
		display.setColor(Tree.class, color(0, 255, 0));
		// display.setColor(Ash.class, color(0, 255, 0));

	}

	@Override
	public void draw() {
		background(200);

		// have your simulation run one step.
		sim.Increment();

		display.drawGrid(sim.getArr()); // display the game
	}
}