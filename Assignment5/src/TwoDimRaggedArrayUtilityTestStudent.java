import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };

	@Test
	public void testReadFile() {
		File file = new File("TwoDimRaggedArrayTestStudent.txt");
		for (int x = 0; x < dataSet1.length; x++) {
			for (int y = 0; y < dataSet1[x].length; y++) {
				assertEquals(dataSet1[x][y], TwoDimRaggedArrayUtility.readFile(file)[x][y], .001);
			}
		}
	}

	@Test
	public void TestWriteToFile() {
		File file = new File("TwoDimRaggedArrayTestStudent.txt");
		for (int x = 0; x < dataSet1.length; x++) {
			for (int y = 0; y < dataSet1[x].length; y++) {
				assertEquals(dataSet1[x][y], TwoDimRaggedArrayUtility.readFile(file)[x][y], .001);
			}
		}
	}

	@Test
	public void testGetColTotal() {
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), .001);
	}

	@Test
	public void testGetRowTotal() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
		assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), .001);
	}

	@Test
	public void testGetTotal() {
		assertEquals(45, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
	}

	@Test
	public void testGetAverage() {
		assertEquals(5, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
	}

	@Test
	public void testGetHighest() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
	}

	@Test
	public void testGetLowest() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
	}

	@Test
	public void testGetLowestInRow() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), .001);
	}

	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2), .001);
	}

	@Test
	public void testGetLowestInCol() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), .001);
	}

	@Test
	public void testGetLowestInColIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2), .001);
	}

	@Test
	public void testGetHighestInRow() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), .001);
	}

	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2), .001);
	}

	@Test
	public void testGetHighestInCol() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), .001);
	}

	@Test
	public void testGetHighestInColIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0), .001);
	}
}
