/**
 * Copyright 2022
 */
package water.pool.core;

/**
 * Application launcher
 * 
 * @author SKov
 *
 */
public class WaterPoolApplication {

	public static void main(String[] args) {
		int landscape[] = { 5, 2, 3, 4, 5, 4, 0, 3, 1, 4 };
		long result = WaterPoolCalculator.calculateWaterAmount(landscape);
		System.out.println(String.format("Total square: %d ", result));
	}
}
