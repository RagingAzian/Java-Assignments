import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class HolidayBonusTestStudent {

	private double[][] dataSet1 = { { 5, 2, 7 }, { 3 }, { 2, 1, 8 } };

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(11000.0, result[0], .001);
			assertEquals(2000.0, result[1], .001);
			assertEquals(7000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		try {
			double total = HolidayBonus.calculateTotalHolidayBonus(dataSet1);
			assertEquals(20000.0, total, .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}
}
