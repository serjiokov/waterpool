/**
 * Copyright 2022
 */
package water.pool.core;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class computes waterpool volume on landscape arguments
 * 
 * @author SKov
 *
 */
public class WaterPoolCalculator {

	/**
	 * 
	 * @param landscape
	 * @return
	 */
	public static long calculateWaterAmount(int[] landscape) {
		long totalSquare = 0;
		if (landscape == null) {
			return totalSquare;
		}
		if (landscape.length == 0) {
			return totalSquare;
		}

		List<Integer> elements = new LinkedList<>();

		// compute pits square
		// find shapes of heights landscape
		int dLevel = 0;
		int pivotIndex = 0;

		while (pivotIndex < landscape.length - 1) {

			int pivot = landscape[pivotIndex];
			// vertical
			for (int i = pivotIndex + 1; i < landscape.length; i++) {
				int current = landscape[i];
				int delta = pivot - current - dLevel;
				if (delta > 0) {
					elements.add(current);

				} else {
					totalSquare += computeSquare(elements, pivot - dLevel);
					pivotIndex = i;
					elements.clear();
					dLevel = 0;
					break;
				}
			}
			// horizontal
			// when pivot is MAX of heels and elements for handling exits
			if (!elements.isEmpty() && pivot > 0) {
				dLevel++;
				elements.clear();
			}
		}

		return totalSquare;
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
