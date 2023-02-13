package water.pool.test;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import water.pool.core.WaterPoolCalculator;

public class WaterPoolNoSourceTest {
	@Test
	public void waterpoolShouldFailforNullsTest() {
		assertFalse(WaterPoolCalculator.isLandscapeValid(null));
		assertFalse(WaterPoolCalculator.isLandscapeValid(new int[] {}));
	}
}
