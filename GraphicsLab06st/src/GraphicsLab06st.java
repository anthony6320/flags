// GraphicsLab06st.java
// This is the Student Version of the Lab11GRFX06 assignment.

import java.awt.*;
import java.applet.*;
import java.util.*;

public class GraphicsLab06st extends Applet {
	public void paint(Graphics g) {
		int circleCount = 40;
		Circles circles = new Circles(g, circleCount);
	}
}

class Circles {
	private int circleCount;
	private Random rnd;
	private Color randomColor;
	private int colorRow;

	private int redCount, greenCount, blueCount;

	public Circles(Graphics g, int c) {
		rnd = new Random(12345);
		circleCount = c;
		redCount = 1;
		greenCount = 1;
		blueCount = 1;
		drawSquares(g);
		for (int k = 1; k <= circleCount; k++)
			drawRandomCircle(g);
	}

	public void drawSquares(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(10, 100, 30, 30);
		g.setColor(Color.green);
		g.fillRect(10, 250, 30, 30);
		g.setColor(Color.blue);
		g.fillRect(10, 400, 30, 30);
	}

	public void drawRandomCircle(Graphics g) {

		getRandomColor();
		

		// set the color to randomColor
		g.setColor(randomColor);
		
		// draw circle in appropiate row
		// at appropiate position
		if(colorRow==1){
			g.fillOval(10+50*redCount, 100, 30, 30);
			redCount++;
		}
		if(colorRow==2){
			g.fillOval(10+50*greenCount,250,30,30);
			greenCount++;
		}
		if(colorRow==3){
			g.fillOval(10+50*blueCount,400,30,30);
			blueCount++;
		}
		
	}

	public void getRandomColor() {

		// generate a random number for red up to 255
		int red = rnd.nextInt(256);

		// generate a random number for green up to 255
		int green = rnd.nextInt(256);
		// generate a random number for blue up to 255
		int blue = rnd.nextInt(256);
		// create a color out of the values of red green and blue and set random
		// Color
		randomColor = new Color(red, green, blue);
		System.out.println(red + " " + green + " " + blue);
		// determine what row it should be in and set colorRow
		if (blue > red && blue > green)
			colorRow = 3;
		if (green > blue && green > red)
			colorRow = 2;
		if (red > blue && red > green)
			colorRow = 1;
	}

}
