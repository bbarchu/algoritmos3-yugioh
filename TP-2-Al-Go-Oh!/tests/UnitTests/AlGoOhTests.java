package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Application.AlGoOh;

public class AlGoOhTests {
	
	@Test
	public void obtenerValor() {
		
		AlGoOh algooh = new AlGoOh();
		
		assertEquals(3, algooh.getValor() );
	}
	@Test
	public void obtenerOtroValor() {
		
		AlGoOh algooh = new AlGoOh();
		assertNotEquals(40, algooh.getValor()) ;
	}
}
