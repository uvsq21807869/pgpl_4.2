package uvsq.fr.pgpl_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class OperationsTest {
	private MoteurRPN M;

	@Before
	public void initialize() {
		M = new MoteurRPN();

	}

	@Test
	public void testOperationplus() {
		double val1 = 10, val2 = 90;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operations.PLUS);
		assertTrue(M.listeOperandes().get(0) == 100);

	}

	@Test
	public void testOperationmoins() {
		double val1 = 10, val2 = 90;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operations.MOINS);
		assertTrue(M.listeOperandes().get(0) == 80);

	}

	@Test
	public void testOperationmult() {
		double val1 = 10, val2 = 90;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operations.MULT);
		assertTrue(M.listeOperandes().get(0) == 900);

	}

	@Test
	public void testOperationdiv() {
		double val1 = 10, val2 = 90;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operations.DIV);
		assertTrue(M.listeOperandes().get(0) == 9);

	}
	@Test (expected = ArithmeticException.class)
	public void TestDivisionSurZero(){
		
		double val1=77,val2=0;
		M.enregistrerOperande(val2);
		M.enregistrerOperande(val1);
		M.appliquerOperation(Operations.DIV);
	}
	@Test
	public void testGetSymbol() {
		Operations o = Operations.MOINS;
		assertEquals(o.getSymbol(), '-');

	}

}
