package junit.monprojet.test;
import junit.monprojet.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
public class SommeArgentTest {

	private SommeArgent m12CHF,m14CHF,m14USD;
	private static int i;
	
	
	@Before
	public void init() {
		
		m12CHF= new SommeArgent(12, "CHF");
		m14CHF= new SommeArgent(14, "CHF");
		m14USD= new SommeArgent(14, "USD");
		
		System.out.println(++i + " ieme passage avant execution d'une methode de test");
	}
	
	
	@Test
	public void testSomme() {
		SommeArgent expected = new SommeArgent(26, "CHF");
		SommeArgent result;
		try {
			result = m12CHF.add(m14CHF);
			Assert.assertTrue(expected.equals(result)); // (3)
		} catch (UniteDistincteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // (2)
	}
		
	@Test
	public void testEquals() {
		Assert.assertTrue(!m12CHF.equals(null));
		Assert.assertEquals(m12CHF, m12CHF);
		Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF")); // (1)
		Assert.assertTrue(!m12CHF.equals(m14CHF));
		Assert.assertTrue(!m14USD.equals(m14CHF));

	}
	
	@Test(expected=UniteDistincteException.class) 
	public void testException() throws UniteDistincteException {
		SommeArgent m10TND = new SommeArgent(10, "TND"); 
		SommeArgent m12USD = new SommeArgent(12, "USD");
		SommeArgent result = m10TND.add(m12USD);
	}
	
	@Test
	public void testPorte() {
		SommeArgent m5EUR = new SommeArgent(5, "EUR");
		SommeArgent m10EUR = new SommeArgent(10, "EUR"); 

		PorteMonnaie p5EUR = new PorteMonnaie();
		p5EUR.ajouteSomme(m5EUR);
		p5EUR.ajouteSomme(m5EUR);
		PorteMonnaie p10EUR = new PorteMonnaie();
		p10EUR.ajouteSomme(m10EUR);
		Assert.assertTrue(p10EUR.equals(p5EUR));

	}
	
	@After
	public void clean() {
		System.gc();
		System.out.println(i + " ieme passage APRES execution d'une methode de test");
		
	}

}
