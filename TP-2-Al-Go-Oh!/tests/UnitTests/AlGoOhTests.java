package UnitTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Application.AlGoOh;

public class AlGoOhTests {
	
	@Test
	public void obtenerValor() {
		
		AlGoOh algooh = new AlGoOh();
		
		assertEquals(20, algooh.getValor() );
	}
	
}
