import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSquarelotron() {
		Squarelotron se = new Squarelotron(2);
		assertEquals(2, se.size);
		assertEquals(1, se.squarelotron[0][0]);
		assertEquals(2, se.squarelotron[0][1]);
		assertEquals(3, se.squarelotron[1][0]);
		assertEquals(4, se.squarelotron[1][1]);
	}

	@Test
	public void testUpsideDownFlip1() {
		Squarelotron se = new Squarelotron(4);
		se = se.upsideDownFlip(1);
		assertEquals(13, se.squarelotron[0][0]);
		assertEquals(15, se.squarelotron[0][2]);
		assertEquals(9, se.squarelotron[1][0]);
		assertEquals(6, se.squarelotron[1][1]);
		assertEquals(8, se.squarelotron[2][3]);
		assertEquals(4, se.squarelotron[3][3]);
	}
	
	@Test
	public void testUpsideDownFlip2() {
		Squarelotron se = new Squarelotron(4);
		se = se.upsideDownFlip(2);
		assertEquals(13, se.squarelotron[3][0]);
		assertEquals(15, se.squarelotron[3][2]);
		assertEquals(6, se.squarelotron[2][1]);
		assertEquals(7, se.squarelotron[2][2]);
		assertEquals(11, se.squarelotron[1][2]);
	}
	
	@Test
	public void testMainDiagonalFlip1() {
		Squarelotron se = new Squarelotron(2);
		se = se.mainDiagonalFlip(1);
		assertEquals(1, se.squarelotron[0][0]);
		assertEquals(3, se.squarelotron[0][1]);
		assertEquals(2, se.squarelotron[1][0]);
		assertEquals(4, se.squarelotron[1][1]);
	}
	
	@Test
	public void testMainDiagonalFlip2() {
		Squarelotron se = new Squarelotron(3);
		se = se.mainDiagonalFlip(1);
		assertEquals(4, se.squarelotron[0][1]);
		assertEquals(2, se.squarelotron[1][0]);
		assertEquals(8, se.squarelotron[1][2]);
		assertEquals(6, se.squarelotron[2][1]);
	}

	@Test
	public void testRotateRight1() {
		Squarelotron se = new Squarelotron(2);
		se.rotateRight(1);
		assertEquals(3, se.squarelotron[0][0]);
		assertEquals(1, se.squarelotron[0][1]);
		assertEquals(4, se.squarelotron[1][0]);
		assertEquals(2, se.squarelotron[1][1]);
	}
	
	@Test 
	public void testRotateRight2() {
		Squarelotron se = new Squarelotron(2);
		se.rotateRight(-1);
		assertEquals(2, se.squarelotron[0][0]);
		assertEquals(4, se.squarelotron[0][1]);
		assertEquals(1, se.squarelotron[1][0]);
		assertEquals(3, se.squarelotron[1][1]);
	}


}
