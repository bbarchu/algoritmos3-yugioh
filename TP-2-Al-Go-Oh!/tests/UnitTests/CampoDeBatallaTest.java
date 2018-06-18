package UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.cartasGenericas.BocaAbajo;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.Estado;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDeUso;
import modelo.tablero.CampoDeBatalla;

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
