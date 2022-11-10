package water.pool.core.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import water.pool.core.WaterPoolCalculator;

public class WaterPoolCalculatorTest {

	@Test
	public void calculatorNegativeArgumentsTest() {

		long calculateWaterAmount = WaterPoolCalculator.calculateWaterAmount(null);
		assertEquals(0, calculateWaterAmount);

		calculateWaterAmount = WaterPoolCalculator.calculateWaterAmount(new int[] {});
		assertEquals(0, calculateWaterAmount);

	}
}
