package water.pool.core;

import java.util.ArrayList;

/**
 * Copyright 2022
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	public static boolean validateLandscape(int[] landscape) {

		if (landscape == null) {
			return false;
		}
		if (landscape.length == 0) {
			return false;
		}
		if (landscape.length > MAX_POSITION) {
			return false;
		}
		if (Arrays.stream(landscape).anyMatch(p -> (p < 0))) {
			return false;
		}
		if (Arrays.stream(landscape).anyMatch(p -> (p > MAX_POSITION))) {
			return false;
		}
		return true;
	}

	public static long calcFromRightAndLeft(int[] landscape) {
		long volume = 0;
		int rightIndex = landscape.length - 1;
		int letftindex = 0;

		int rtPivot = landscape[rightIndex];
		int lftPivot = landscape[letftindex];

		while (letftindex < rightIndex) {
			int l = landscape[letftindex];
			int r = landscape[rightIndex];
			if (r < l) {
				// go from right to left
				if (rtPivot < r) {
					rtPivot = r;
				}
				volume += rtPivot - r;
				rightIndex--;
			} else {
				// go from left to right
				if (lftPivot < l) {
					lftPivot = l;
				}
				volume += lftPivot - l;
				letftindex++;
			}
		}
		return volume;
	}

	public static long calculateWaterAmountHorizontallyandVertically(int[] landscape) {
		long volume = 0;
		List<Integer> elements = new ArrayList<>();

		// compute pits square
		// find shapes of heights landscape
		int deltaHeight = 0;
		int pivotIndex = 0;

		while (pivotIndex < landscape.length - 1) {
			int pivot = landscape[pivotIndex];
			// vertical
			for (int i = pivotIndex + 1; i < landscape.length; i++) {
				int current = landscape[i];

				if (pivot - deltaHeight > current) {
					elements.add(current);
				} else {
					volume += computeSquare(elements, pivot - deltaHeight);
					pivotIndex = i;
					elements.clear();
					deltaHeight = 0;
					break;
				}
			}
			// horizontal
			// when pivot is MAX of heels and elements for handling exits
			if (!elements.isEmpty()) {
				deltaHeight++;
				elements.clear();
			}
		}

		return volume;
	}

	private static long computeSquare(List<Integer> elements, int pivot) {
		if (elements.isEmpty()) {
			return 0;
		}
		return elements.stream() //
				.collect(Collectors.summingLong(t -> pivot - t)) //
				.longValue();
	}
}
