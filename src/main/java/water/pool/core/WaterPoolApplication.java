/**
 * Copyright 2022
 */
package water.pool.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The water pool application launcher
 * 
 * @author skov
 *
 */
public class WaterPoolApplication {
	static Logger logger = Logger.getLogger(WaterPoolApplication.class.getName());

	public static void main(String[] args) {
		int[] landscape = { 5, 2, 3, 4, 5, 4, 0, 3, 1, 4 };
		logger.log(Level.INFO, "Total square : {0} ", //
				WaterPoolCalculator.calculationFromRightAndLeft(landscape));

	}
}
