package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Application.Carta;
import Application.CartaTrampa;

public class CartaTrampaTest {

	@Test
	public void colocarCartaTrampaBocaAbajo() {
		
		Carta cartaTrampa = new CartaTrampa();
		
		cartaTrampa.invocar();
	}
}
