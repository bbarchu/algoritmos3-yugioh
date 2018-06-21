package testComportamiento;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.cartasEspecificas.AgujeroNegro;
import modelo.cartasGenericas.BocaAbajo;
import modelo.cartasGenericas.BocaArriba;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.cartasGenericas.Estado;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDeUso;
import modelo.cartasGenericas.ModoDefensa;
import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;



public class PrimeraEntrega {
	
	@Test
	public void testColocarUnMonstruoEnAtaqueEnElCampo() {
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(true, unCampo.hayCartasMonstruo());
		
	}
	
	@Test
	public void testColocarUnMonstruoEnDefensaEnElCampo() {
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoDefensa();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(true, unCampo.hayCartasMonstruo());
				
		
	}
	
	@Test
	public void testColocarUnaCartaMagicaBocaAbajoEnElCampo(){
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaMagica = new CartaMagica(unEstado);
		
		unCampo.colocar(unaCartaMagica);
		
		assertEquals(true, unCampo.hayCartasMagiaOTrampa());
	}
	
	@Test
	public void testColocarUnaCartaTrampaBocaAbajoEnElCampo(){
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Carta unaCartaTrampa = new CartaTrampa();
		
		unCampo.colocar(unaCartaTrampa);
		
		assertEquals(true, unCampo.hayCartasTrampa());
	}
			
	@Test
	public void testDestruirUnMonstruoYVerificarQueEsteEnElCementerio(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		unCampo.destruir(unMonstruo);
		
		assertEquals(false, unCampo.hayCartasMonstruo());
		assertEquals(true, unCampo.estaEnElCementerio(unMonstruo));
	}
	
	@Test
	public void testDosJugadoresSeAtacanConMostruosYLosPuntosDeVidaCambian(){
		
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
	public void testElJugadorQueAtacaConMenorAtaqueEsElQueMuereYLosPuntosDeEsteJugadorBajan(){
		
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
	public void testHayEmpateSeDestruyenAmbasCartasNoSeSufreDañoEnPuntosDeVida(){
		
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
	public void testAtacarAUnMonstruoEnDefensaConMenosDefensaQueMiAtaqueLoDestruyeYLosPuntosDeVidaNoSeVenAfectados(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		ModoDeUso modoDEF = new ModoDefensa();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		int puntosATK = 1000;
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
		
		otroJugador.atacarCon_A(monstruoAtaque, monstruoDefensa);
		
		assertEquals(true,campito.estaEnElCementerio(monstruoDefensa));
		assertEquals(false,campito2.estaEnElCementerio(monstruoAtaque));
		
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void testAtacarAMonstruoConMayorDefensaQueMiAtaqueNOPASANADA(){
		
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
		
		otroJugador.atacarCon_A(monstruoAtaque, monstruoDefensa);
		
		
		assertEquals(false,campito.estaEnElCementerio(monstruoDefensa)); 
		assertEquals(false,campito2.estaEnElCementerio(monstruoAtaque));
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void testColocarDosMonstruosYDestruirlosConElAgujeroNegroSinRecibirDaño(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		Estado unEstado = new BocaArriba();
		int puntosATK = 100;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaIniciales = 8000;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaMagica agujeroNegro = new AgujeroNegro(unEstado, unJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDefensa);
		unJugador.agregarCartaAlMazo(agujeroNegro);
		otroJugador.agregarCartaAlMazo(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDefensa);
		otroJugador.invocar(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(agujeroNegro);
		
		assertEquals(true,campito.estaEnElCementerio(monstruoDefensa)); 
		assertEquals(true,campito2.estaEnElCementerio(monstruoAtaque));
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		
	}
	
	@Test
	public void testColocarUnMonstruoSeguidoDeOtroQueRequierSacrificioEliminandoAlPrimero(){
		
		Jugador unJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 500;
		int unasEstrellas = 1;
		int otrasEstrellas = 5;
		
		CartaMonstruo unMonstruo = new CartaMonstruo(puntosATK, puntosDEF, unasEstrellas, modoATK, unJugador);
		CartaMonstruo unMonstruoConSacrificio = new CartaMonstruo(puntosATK, puntosDEF, otrasEstrellas, modoATK, unJugador);
		
	
		unJugador.agregarCartaAlMazo(unMonstruo);
		unJugador.tomarCartaDelMazo();		
		unJugador.invocar(unMonstruo);
		
		unJugador.agregarCartaAlMazo(unMonstruoConSacrificio);
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(unMonstruoConSacrificio);
		
		
		assertEquals(true,campito.estaEnElCementerio(unMonstruo)); 		
	}
	
	@Test
	public void testColocarDosMonstruoSeguidoDeOtroQueRequierDosSacrificiosEliminandoALosPrimeros(){
		
		Jugador unJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 500;
		int unasEstrellas = 1;
		int otrasEstrellas = 7;
		
		CartaMonstruo unMonstruo = new CartaMonstruo(puntosATK, puntosDEF, unasEstrellas, modoATK, unJugador);
		CartaMonstruo otroMonstruo = new CartaMonstruo(puntosATK, puntosDEF, unasEstrellas, modoATK, unJugador);
		CartaMonstruo unMonstruoConSacrificio = new CartaMonstruo(puntosATK, puntosDEF, otrasEstrellas, modoATK, unJugador);
		
	
		unJugador.agregarCartaAlMazo(unMonstruo);
		unJugador.tomarCartaDelMazo();		
		unJugador.invocar(unMonstruo);
		
		unJugador.agregarCartaAlMazo(otroMonstruo);
		unJugador.tomarCartaDelMazo();		
		unJugador.invocar(otroMonstruo);
		
		unJugador.agregarCartaAlMazo(unMonstruoConSacrificio);
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(unMonstruoConSacrificio);
		
		
		assertEquals(true,campito.estaEnElCementerio(unMonstruo));
		assertEquals(true,campito.estaEnElCementerio(otroMonstruo));
	}
	
}
