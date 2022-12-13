import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Road_STUDENT_Test {
	Road r1;
	Road r2;
	Town sanaa;
	Town aden;
	Town taiz;
	Town ibb;
	
	@Before
	public void setUp() throws Exception {
		sanaa = new Town("Town_1");
		aden = new Town("Town_2");
		taiz = new Town("Town_3");
		ibb = new Town("Town_4");
		r1 = new Road(sanaa, aden, 400, "International Line");
		r2 = new Road(taiz, ibb, "Highway");
	}

	@After
	public void tearDown() throws Exception {
		sanaa = null;
		aden = null;
		taiz = null;
		ibb = null;
		r1 = null;
		r2 = null;
	}	
	
	@Test
	public void testContains() {
		assertEquals(true, r1.contains(sanaa));
		assertEquals(false, r2.contains(sanaa));
	}
	
	@Test
	public void testGetName() {
		assertEquals("International Line", r1.getName());
	}
	
	@Test
	public void testGetDestination() {
		assertEquals(aden, r1.getDestination());
	}
	
	@Test
	public void testGetSource() {
		assertEquals(sanaa, r1.getSource());
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(400, r1.getWeight());
		assertEquals(1, r2.getWeight());
	}
	
	@Test
	public void testToString() {
		assertEquals("Town_3 to Town_4 via Highway", r2.toString());
	}

}
