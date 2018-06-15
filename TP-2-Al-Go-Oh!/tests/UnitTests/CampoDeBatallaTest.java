package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import Application.BocaAbajo;
import Application.BocaArriba;
import Application.CampoDeBatalla;
import Application.Carta;
import Application.CartaMagica;
import Application.CartaMonstruo;
import Application.Estado;
import Application.ModoAtaque;
import Application.ModoDeUso;

public class CampoDeBatallaTest {

	@Test
	public void colocarUnaCartaMonstruo(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(true, unCampo.hayCartasMonstruo());
	}
	
	@Test
	public void colocarUnaCartaMagica(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaMagica = new CartaMagica(unEstado);
		
		unCampo.colocar(unaCartaMagica);
		
		assertEquals(true, unCampo.hayCartasMagiaOTrampa());
	}
	
	@Test
	public void colocarUnaCartaMonstruoYDestruirla(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		unCampo.destruir(unMonstruo);
		
		assertEquals(false, unCampo.hayCartasMonstruo());
		assertEquals(true, unCampo.estaEnElCementerio(unMonstruo));
	}
	
	@Test
	public void colocarUnaCartaMagicaYDestruirla(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaMagica = new CartaMagica(unEstado);
		
		unCampo.colocar(unaCartaMagica);
		unCampo.destruir(unaCartaMagica);
		
		assertEquals(false, unCampo.hayCartasMagiaOTrampa());
		assertEquals(true, unCampo.estaEnElCementerio(unaCartaMagica));
		
	}
	
	
	
	
}
