/**
 * Copyright 2022
 */
package water.pool.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The water pool application launcher
 * 
 * @author SKov
 *
 */
public class WaterPoolApplication {
	static Logger logger = Logger.getLogger(WaterPoolApplication.class.getName());

	public static void main(String[] args) {
		int[] landscape = { 5, 2, 3, 4, 5, 4, 0, 3, 1 ,4};
		if (!WaterPoolCalculator.validateLandscape(landscape)) {
			logger.log(Level.INFO, "Source landscape data unvalid... ");

		} else {
			logger.log(Level.INFO, "Total square [approach -1] : {0} ", //
					WaterPoolCalculator.calculateWaterAmountHorizontallyandVertically(landscape));
			logger.log(Level.INFO, "Total square [approach -2] : {0} ", //
					WaterPoolCalculator.calcFromRightAndLeft(landscape));
		}
	}
}
