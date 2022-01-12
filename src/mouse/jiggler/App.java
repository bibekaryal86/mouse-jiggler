package mouse.jiggler;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class App {
	
	private static int x = 0;
	private static int y = 0;

	public static void main(String[] args) {
		while (System.currentTimeMillis() > 0L) {
			spot(); move1(); spot(); move2();
		}
	}
	
	private static void spot() {
		Point currentPoint = MouseInfo.getPointerInfo().getLocation();
		x = (int) currentPoint.getX();
		y = (int) currentPoint.getY();
	}
	
	private static void move1() {
		try {
			Robot robot = new Robot();
			robot.mouseMove(x+1, y+1);
			Thread.sleep(1000);
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	private static void move2() {
		try {
			Robot robot = new Robot();
			robot.mouseMove(x-1, y-1);
			Thread.sleep(1000);
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
