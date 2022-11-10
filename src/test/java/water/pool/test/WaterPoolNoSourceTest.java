package water.pool.test;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import water.pool.core.WaterPoolCalculator;

public class WaterPoolNoSourceTest {
	@Test
	public void waterComputationNullSourceTest() {
		assertFalse(WaterPoolCalculator.validateLandscape(null));
		assertFalse(WaterPoolCalculator.validateLandscape(new int[] {}));
	}
}
