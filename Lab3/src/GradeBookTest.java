import junit.framework.TestCase;

public class GradeBookTest extends TestCase {
	GradeBook book1, book2;

	protected void setUp() throws Exception {
		super.setUp();
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		book1.addScore(5);
		book1.addScore(20);

		book2.addScore(30);
		book2.addScore(40);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		book1 = null;
		book2 = null;
	}

	public void testAddScore() {
		assertTrue(book1.toString().equals("5.0 20.0 "));
		assertEquals(2, book1.getScoreSize());
		assertTrue(book2.toString().equals("30.0 40.0 "));
		assertEquals(2, book2.getScoreSize());
	}

	public void testSum() {
		assertEquals(25, book1.sum(), .0001);
		assertEquals(70, book2.sum(), .0001);
	}

	public void testMinimum() {
		assertEquals(5, book1.minimum(), .001);
		assertEquals(30, book2.minimum(), .001);
	}

	public void testFinalScore() {
		assertEquals(20, book1.finalScore(), .001);
		assertEquals(40, book2.finalScore(), .001);
	}

	public void testGetScoreSize() {
		fail("Not yet implemented");
	}

	public void testToString() {
		fail("Not yet implemented");
	}

}
