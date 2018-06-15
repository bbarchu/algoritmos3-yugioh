package UnitTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Application.BocaArriba;
import Application.CampoDeBatalla;
import Application.CartaMagica;
import Application.CartaMonstruo;
import Application.Estado;
import Application.Jugador;
import Application.ModoAtaque;
import Application.ModoDeUso;
import Application.ModoDefensa;

public class JugadorTest {

	@Test
	public void invocarUnMonstruoDesdeLaMano(){
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 2000;
		int puntosDEF = 500;
		int estrellas = 1;
		CartaMonstruo unMonstruo = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		
		unJugador.agregarCartaAlMazo(unMonstruo);
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(unMonstruo);
		
		assertEquals(true, unJugador.obtenerCampoDeBatalla().hayCartasMonstruo());
	}
	
	@Test
	public void invocarUnaCartaMagicaDesdeLaMano(){
		Jugador unJugador = new Jugador();
		Estado unEstado = new BocaArriba();

		CartaMagica unaCartaMagica = new CartaMagica(unEstado);
		
		unJugador.agregarCartaAlMazo(unaCartaMagica);
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(unaCartaMagica);
		
		assertEquals(false, unJugador.obtenerCampoDeBatalla().hayCartasMagiaOTrampa());
		//Esto debería dar false, porque cuando la das vuelta, se elimina automaticamente, ya que las cartas mágicas tienen un unico uso.
	}
	
	// Para probar los metodos atacar es necesario mas de un jugador, por lo que las puebas se escriben como de "integracion"
	// Son los mismos test que para la entrega
	
	
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
		
		CartaMonstruo monstruoDeUnJugador = new CartaMonstruo(puntosATKPerdedor, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoDeOtroJugador = new CartaMonstruo(puntosATKGanador, puntosDEF, estrellas, modoATK, otroJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDeUnJugador);
		otroJugador.agregarCartaAlMazo(monstruoDeOtroJugador);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDeUnJugador);
		otroJugador.invocar(monstruoDeOtroJugador);
		
		otroJugador.atacarCon_A(monstruoDeOtroJugador, monstruoDeUnJugador);
		
		assertEquals(puntosDeVidaEsperados, unJugador.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void elJugadorQueAtacaConMenorAtaqueEsElQueMuereYLosPuntosDeEsteJugadorBajan(){
		
		Jugador jugadorMalo = new Jugador();
		Jugador jugadorBueno = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATKGanador = 2000;
		int puntosATKPerdedor = 1000;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaEsperados = 7000;
		
		CartaMonstruo monstruoDeJugadorMalo = new CartaMonstruo(puntosATKPerdedor, puntosDEF, estrellas, modoATK, jugadorMalo);
		CartaMonstruo monstruoDeJugadorBueno = new CartaMonstruo(puntosATKGanador, puntosDEF, estrellas, modoATK, jugadorBueno);
		
		jugadorMalo.presentarJugadorRival(jugadorBueno);
		jugadorBueno.presentarJugadorRival(jugadorMalo);
		
		jugadorMalo.agregarCartaAlMazo(monstruoDeJugadorMalo);
		jugadorBueno.agregarCartaAlMazo(monstruoDeJugadorBueno);
		
		jugadorMalo.tomarCartaDelMazo();
		jugadorBueno.tomarCartaDelMazo();
		
		jugadorMalo.invocar(monstruoDeJugadorMalo);
		jugadorBueno.invocar(monstruoDeJugadorBueno);
		
		jugadorMalo.atacarCon_A(monstruoDeJugadorMalo, monstruoDeJugadorBueno);
		
		assertEquals(puntosDeVidaEsperados,jugadorMalo.obtenerPuntosDeVida());
	}
	
	@Test
	public void hayEmpateSeDestruyenAmbasCartasNoSeSufreDañoEnPuntosDeVida(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		
		CampoDeBatalla campitoJugadorUno = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campitoJugadorDos = otroJugador.obtenerCampoDeBatalla();
		
		int puntosATKPerdedor = 1000;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaIniciales = 8000;
		
		CartaMonstruo monstruoDeUnJugador = new CartaMonstruo(puntosATKPerdedor, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoDeOtroJugador = new CartaMonstruo(puntosATKPerdedor, puntosDEF, estrellas, modoATK, otroJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDeUnJugador);
		otroJugador.agregarCartaAlMazo(monstruoDeOtroJugador);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDeUnJugador);
		otroJugador.invocar(monstruoDeOtroJugador);
		
		otroJugador.atacarCon_A(monstruoDeOtroJugador, monstruoDeUnJugador);
		
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		assertEquals(true,campitoJugadorUno.estaEnElCementerio(monstruoDeUnJugador)); 
		assertEquals(true,campitoJugadorDos.estaEnElCementerio(monstruoDeOtroJugador)); 
		
		
	}
	
	@Test
	public void AtacarAUnMonstruoEnDefensaConMenosDefensaQueMiAtaqueLoDestruyeYLosPuntosDeVidaNoSeVenAfectados(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		ModoDeUso modoDEF = new ModoDefensa();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		int puntosATKGanador = 1000;
		int puntosATKPerdedor = 100;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaIniciales = 8000;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATKPerdedor, puntosDEF, estrellas, modoDEF, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATKGanador, puntosDEF, estrellas, modoATK, otroJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDefensa);
		otroJugador.agregarCartaAlMazo(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDefensa);
		otroJugador.invocar(monstruoAtaque);
		
		otroJugador.atacarCon_A(monstruoAtaque, monstruoDefensa);
		
		assertEquals(true,campito.estaEnElCementerio(monstruoDefensa));
		assertEquals(false,campito2.estaEnElCementerio(monstruoAtaque));
		
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void AtacarAMonstruoConMayorDefensaQueMiAtaqueNOPASANADA(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		ModoDeUso modoDEF = new ModoDefensa();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		int puntosATK = 100;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaIniciales = 8000;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoDEF, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDefensa);
		otroJugador.agregarCartaAlMazo(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDefensa);
		otroJugador.invocar(monstruoAtaque);
		
		otroJugador.atacarCon_A(monstruoDefensa, monstruoAtaque);
		
		
		assertEquals(false,campito.estaEnElCementerio(monstruoDefensa)); 
		assertEquals(false,campito2.estaEnElCementerio(monstruoAtaque));
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		
	}
	
}
