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
import Application.Jugador;
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
		
		assertEquals(unCampo.hayCartasMonstruo(), false);
		assertEquals(unCampo.hayCartasEnElCementerio(), true);
	}
	
	/*
	@Test
	public void dosJugadoresSeAtacanConMostruosYLosPuntosDeVidaCambian(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATKGanador = 2000;
		int puntosATKPerdedor = 1000;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaEsperados = 7000;
		
		Carta monstruoDeUnJugador = new CartaMonstruo(puntosATKPerdedor, puntosDEF, estrellas, modoATK);
		Carta monstruoDeOtroJugador = new CartaMonstruo(puntosATKGanador, puntosDEF, estrellas, modoATK);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDeUnJugador);
		otroJugador.agregarCartaAlMazo(monstruoDeOtroJugador);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDeUnJugador);
		otroJugador.invocar(monstruoDeOtroJugador);
		
		otroJugador.atacarCon_A(monstruoDeOtroJugador,monstruoDeUnJugador);
		
		assertEquals(unJugador.obtenerPuntosDeVida(),puntosDeVidaEsperados);
	}
	*/
}
