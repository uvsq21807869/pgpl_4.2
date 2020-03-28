package uvsq.fr.pgpl_4_2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class MoteurRPNTest {
	private MoteurRPN M;
	@Before
	public void initialize() {
		M = new MoteurRPN();
	}
	@Test
	public void testEnregistrerOperande() {
		double val1=1, val2=2,val3=3;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.enregistrerOperande(val3);
		assertEquals(M.listeOperandes().size(), 3);
	}
	// On test si le Moteur verifie bien qu'on a pas assez d'operandes
			@Test(expected = ArithmeticException.class)
			public void testEnregistrerOperandeException() {

				double val1 = 3;
				M.enregistrerOperande(val1);

				M.appliquerOperation(Operations.MULT);

			}
			@Test
	public void testAppliquerOperation() throws NumberFormatException{
				double val1=1, val2=2;
				M.enregistrerOperande(val1);
				M.enregistrerOperande(val2);
				M.appliquerOperation(Operations.PLUS);
				assertTrue(M.listeOperandes().get(0)==3);
			}
			@Test(expected = ArithmeticException.class)
			public void testappliquerOperationException() {
				M.appliquerOperation(Operations.MOINS);
			}
			

}
