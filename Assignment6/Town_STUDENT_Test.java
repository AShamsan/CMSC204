
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Town_STUDENT_Test {
	Town sanaa,dhamar;

	@Before
	public void setUp() throws Exception {
		sanaa=new Town("oldSanaa");
		dhamar=new Town("maaber");
	}

	@After
	public void tearDown() throws Exception {
		sanaa=dhamar=null;
	}


	@Test
	public void testCompareTo() {
		assertTrue(0==sanaa.compareTo(sanaa));
		assertTrue(0<sanaa.compareTo(dhamar));
	}

	@Test
	public void testEqualsTown() {
		assertTrue(sanaa.equals(new Town("oldSanaa")));
		assertTrue(!sanaa.equals(dhamar));
	}

	@Test
	public void testGetName() {
		assertEquals("oldSanaa",sanaa.getName());
		assertEquals("maaber",dhamar.getName());
	}

	@Test
	public void testToString() {
		assertEquals("oldSanaa",sanaa.toString());
		assertEquals("maaber",dhamar.toString());
	}

}