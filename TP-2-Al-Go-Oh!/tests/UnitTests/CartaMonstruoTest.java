package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import Application.CartaMonstruo;

public class CartaMonstruoTest {
	
	@Test
	public void colocarMonstruoEnPosicionDeAtaque() {
		
		int puntosATK, puntosDEF, nivel;
		
		puntosATK = 1000;
		puntosDEF = 500;
		nivel = 3;
		
		CartaMonstruo monstruo = new CartaMonstruo(puntosATK, puntosDEF, nivel);
		
		monstruo.colocarEnPosicionDeAtaque();
	}
	
	@Test
	public void colocarMonstruoEnPosicionDeDefensa() {
		
		int puntosATK, puntosDEF, nivel;
		
		puntosATK = 1000;
		puntosDEF = 500;
		nivel = 3;
		
		CartaMonstruo monstruo = new CartaMonstruo(puntosATK, puntosDEF, nivel);
		
		monstruo.colocarEnPosicionDeDefensa();
	}
}
