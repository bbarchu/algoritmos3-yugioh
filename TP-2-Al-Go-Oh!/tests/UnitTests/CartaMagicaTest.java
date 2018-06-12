package UnitTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Application.Carta;
import Application.CartaMagica;

public class CartaMagicaTest {

	@Test 
	public void colocarCartaMagicaBocaAbajoNoActivaNingunEfecto() {
		
		Carta cartaMagica = new CartaMagica();
		
		cartaMagica.invocarBocaAbajo();
	}
	
}
