package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDeUso;
import modelo.jugador.Jugador;

public class CartaMonstruoTest {
	
	@Test
	public void simularAtaqueALaCartaYDescontarPuntosAlJugador(){
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 2000;
		int puntosDEF = 500;
		int estrellas = 1;
		int decrementoVida = 1000;
		int puntosDeVidaEsperados = 7000;
		CartaMonstruo monstruoDeUnJugador = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		
		monstruoDeUnJugador.restarVidaAJugador(decrementoVida);
		
		assertEquals(puntosDeVidaEsperados, unJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void cartaDe5EstrellasRealizaUnSacrificio(){
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 2000;
		int puntosDEF = 500;
		int unasEstrellas = 1;
		int otrasEstrellas = 5;
		CartaMonstruo monstruoDeUnJugador = new CartaMonstruo(puntosATK, puntosDEF, unasEstrellas, modoATK, unJugador);
		CartaMonstruo monstruoDeUnJugadorConUnSacrificio = new CartaMonstruo(puntosATK, puntosDEF, otrasEstrellas, modoATK, unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDeUnJugador);
		unJugador.tomarCartaDelMazo();
		monstruoDeUnJugador.invocate(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDeUnJugadorConUnSacrificio);
		unJugador.tomarCartaDelMazo();
		monstruoDeUnJugadorConUnSacrificio.invocate(unJugador);
		
		assertEquals(true, unJugador.obtenerCampoDeBatalla().estaEnElCementerio(monstruoDeUnJugador));
	}
	
	@Test
	public void cartaDe7EstrellasRealizaDosSacrificio(){
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 2000;
		int puntosDEF = 500;
		int unasEstrellas = 1;
		int otrasEstrellas = 7;
		CartaMonstruo monstruoDeUnJugador = new CartaMonstruo(puntosATK, puntosDEF, unasEstrellas, modoATK, unJugador);
		CartaMonstruo otroMonstruoDeUnugador = new CartaMonstruo(puntosATK, puntosDEF, unasEstrellas, modoATK, unJugador);
		CartaMonstruo monstruoDeUnJugadorConUnSacrificio = new CartaMonstruo(puntosATK, puntosDEF, otrasEstrellas, modoATK, unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDeUnJugador);
		unJugador.tomarCartaDelMazo();
		monstruoDeUnJugador.invocate(unJugador);
		unJugador.agregarCartaAlMazo(otroMonstruoDeUnugador);
		unJugador.tomarCartaDelMazo();
		otroMonstruoDeUnugador.invocate(unJugador);

		unJugador.agregarCartaAlMazo(monstruoDeUnJugadorConUnSacrificio);
		unJugador.tomarCartaDelMazo();
		monstruoDeUnJugadorConUnSacrificio.invocate(unJugador);
		
		assertEquals(true, unJugador.obtenerCampoDeBatalla().estaEnElCementerio(monstruoDeUnJugador));
		assertEquals(true, unJugador.obtenerCampoDeBatalla().estaEnElCementerio(otroMonstruoDeUnugador));
	}
	

	
/*	@Test
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
*/	
}
