package water.pool.core;

/**
 * Copyright 2022
 */

import java.util.Arrays;

/**
 * The class computes water pool square volume of landscape based on arguments
 * 
 * @author SKov
 *
 */
public class WaterPoolCalculator {

	private static final int MAX_POSITION = 32000;

	/**
	 * 
	 * @param landscape
	 * @return true - valid; false - unvalid.
	 */
	public static boolean isLandscapeValid(int[] landscape) {
		if ((landscape == null) || //
				(landscape.length == 0) || //
				(landscape.length > MAX_POSITION) || //
				Arrays.stream(landscape).anyMatch(p -> (p < 0)) || //
				Arrays.stream(landscape).anyMatch(p -> (p > MAX_POSITION))) {
			return false;
		}
		return true;
	}

	public static long calculationFromRightAndLeft(int[] landscape) {

		long volume = 0;
		int rightIndex = landscape.length - 1;
		int letftindex = 0;

		int rtPivot = landscape[rightIndex];
		int lftPivot = landscape[letftindex];

		while (letftindex < rightIndex) {
			int lValue = landscape[letftindex];
			int rValue = landscape[rightIndex];
			if (rValue < lValue) {
				// go from right to left
				if (rtPivot < rValue) {
					rtPivot = rValue;
				}
				volume += rtPivot - rValue;
				rightIndex--;
			} else {
				// go from left to right
				if (lftPivot < lValue) {
					lftPivot = lValue;
				}
				volume += lftPivot - lValue;
				letftindex++;
			}
		}
		return volume;
	}

}
