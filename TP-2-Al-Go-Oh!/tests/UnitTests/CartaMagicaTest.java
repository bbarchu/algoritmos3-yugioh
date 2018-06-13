package UnitTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Application.AgujeroNegro;
import Application.BocaArriba;
import Application.CampoDeBatalla;
import Application.Carta;
import Application.CartaMagica;
import Application.CartaMonstruo;
import Application.Jugador;
import Application.ModoAtaque;
import Application.ModoDeUso;
import Application.ModoDefensa;

public class CartaMagicaTest {

	@Test 
	public void colocarCartaMagicaBocaAbajoNoActivaNingunEfecto() {
		
		Carta cartaMagica = new CartaMagica();
		
		cartaMagica.invocarBocaAbajo();
	}
	
	public void colocarAgujeroNegroBocaArribaDestruyeTodosLosMonstruosEnElCampoYNoAfectaLosPuntosDeVida() {
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		
		ModoDeUso modoATK = new ModoAtaque();
		ModoDeUso modoDEF = new ModoDefensa();
		
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		
		int puntosATK = 100;
		int puntosDEF = 500;
		int estrellas = 1;
		
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoDEF, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaMagica agujeroNegro = new AgujeroNegro(new BocaArriba());
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDefensa);
		otroJugador.agregarCartaAlMazo(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDefensa);
		otroJugador.invocar(monstruoAtaque);
		
		unJugador.agregarCartaAlMazo(agujeroNegro);
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(agujeroNegro);
		
		assertEquals(campito.hayCartasMonstruo(), false);
		assertEquals(campito2.hayCartasMonstruo(), false);
		
		assertEquals(campito.hayCartasEnElCementerio(), true);
		assertEquals(campito2.hayCartasEnElCementerio(), true);
		
	}
	
}
