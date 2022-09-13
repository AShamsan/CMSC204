import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	private GradeBook g1;
	private GradeBook g2;
	private GradeBook g3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g3 = new GradeBook(5);
		
		g1.addScore(85);
		g1.addScore(75);
		
		g2.addScore(90);
		g2.addScore(38);
		g2.addScore(70);
		
		g3.addScore(60);
		g3.addScore(80);
		g3.addScore(100);
		g3.addScore(59);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null; 
		g2 = null;
		g3 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("85.0 75.0 "));
		assertTrue(g2.toString().equals("90.0 38.0 70.0 "));
		assertTrue(g3.toString().equals("60.0 80.0 100.0 59.0 "));
		
		
		assertEquals(2, g1.getScoreSize());
		assertEquals(3, g2.getScoreSize());
		assertEquals(4, g3.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(160, g1.sum());
		assertEquals(198, g2.sum());
		assertEquals(299, g3.sum());
	}
	
	@Test
	void testMinimum() {
		
		assertEquals(75, g1.minimum());
		assertEquals(38, g2.minimum());
		assertEquals(59, g3.minimum());
	}

	@Test
	void testFinalScore() {
		
		assertEquals(85, g1.finalScore());
		assertEquals(160, g2.finalScore());
		assertEquals(240, g3.finalScore());
		
	}

}
