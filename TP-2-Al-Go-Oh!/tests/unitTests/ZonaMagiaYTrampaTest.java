package unitTests;

import org.junit.Test;

import excepciones.ErrorZonaSinCapacidad;
import modelo.cartasGenericas.BocaAbajo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaTrampa;
import modelo.tablero.ZonaMagia;
import modelo.tablero.ZonaTrampa;

public class ZonaMagiaYTrampaTest {

	
	@Test (expected = ErrorZonaSinCapacidad.class)
	public void agregarCincoCartasEnZonaMagiaYAlQuererAgregarUnaEnZonaTrampaLanzarExcepcion() {
		
		ZonaMagia zonaMagia = new ZonaMagia();
		ZonaTrampa zonaTrampa = new ZonaTrampa();
		
		int capacidadMaxima = 5;
		
		zonaMagia.observarA(zonaTrampa);
		zonaTrampa.observarA(zonaMagia);
		
		CartaMagica cartaMagica = new CartaMagica(new BocaAbajo());
		
		for(int i = 0; i < capacidadMaxima; i++) {
			
			zonaMagia.agregarCarta(cartaMagica);
		}
		
		CartaTrampa cartaTrampa = new CartaTrampa();
		
		zonaTrampa.agregarCarta(cartaTrampa);
	}
}
