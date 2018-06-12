package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import Application.BocaAbajo;
import Application.CampoDeBatalla;
import Application.Carta;
import Application.CartaMagica;
import Application.CartaMonstruo;
import Application.Estado;
import Application.ModoAtaque;
import Application.ModoDeUso;
import Application.ModoDefensa;

public class TestsComportamiento {
	
	@Test
	public void colocarUnMonstruoEnAtaqueEnElCampo() {
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(unCampo.hayCartasMonstruo(), true);
				
		
	}
	
	@Test
	public void colocarUnMonstruoEnDefensaEnElCampo() {
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoDefensa();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(unCampo.hayCartasMonstruo(), true);
				
		
	}
	
	@Test
	public void colocarUnaCartaMagicaBocaAbajoEnElCampo(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaMagica = new CartaMagica(unEstado);
		
		unCampo.colocar(unaCartaMagica);
		
		assertEquals(unCampo.hayCartasMagicas(), true);
	}
	
	@Test
	public void destruirUnMonstruoYVerificarQueEsteEnElCementerio(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		unCampo.destruir(unMonstruo);
		
		//Falta Implementar Destruir
	}
	
}
