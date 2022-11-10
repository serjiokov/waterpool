package water.pool.test;

/**
 * Copyright 2022
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import water.pool.core.WaterPoolCalculator;

/*
 * Parameterized tests suite for water pool square computation  
 */

@RunWith(Parameterized.class)
public class WaterPoolCalculatorTest {

	private final int[] source;

	private final int result;

	@Parameters(name = "{index}: checked with result: {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ new int[] { 0, 0, 0 }, 0 }, //
				{ new int[] { 1, 0, 0 }, 0 }, //
				{ new int[] { 1, 1, 0 }, 0 }, //
				{ new int[] { 0, 1, 1 }, 0 }, //
				{ new int[] { 1, 0, 1 }, 1 }, //

				{ new int[] { 1, 0, 1, 0, 1 }, 2 }, //
				{ new int[] { 2, 0, 2, 0, 1 }, 3 }, //
				{ new int[] { 5, 2, 3, 4, 5, 4, 0, 3, 1 }, 9 }, //
				{ new int[] { 5, 2, 3, 4, 5, 4, 0, 3, 1, 4 }, 14 } //
		});
	}

	public WaterPoolCalculatorTest(int[] source, int result) {
		this.source = source;
		this.result = result;
	}

	@Test
	public void waterPoolCalculatorTest() {
		long calculateWaterAmount = WaterPoolCalculator.calculateWaterAmountHorizontallyandVertically(source);
		assertEquals(result, calculateWaterAmount);

		calculateWaterAmount = WaterPoolCalculator.calcFromRightAndLeft(source);
		assertEquals(result, calculateWaterAmount);
	}

}
