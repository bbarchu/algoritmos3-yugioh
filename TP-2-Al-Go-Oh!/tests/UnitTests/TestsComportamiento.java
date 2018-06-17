package UnitTests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import Application.AgujeroNegro;
import Application.BocaAbajo;
import Application.BocaArriba;
import Application.CampoDeBatalla;
import Application.Carta;
import Application.CartaMagica;
import Application.CartaMonstruo;
import Application.CartaTrampa;
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
		
		assertEquals(true, unCampo.hayCartasMonstruo());
		
	}
	
	@Test
	public void colocarUnMonstruoEnDefensaEnElCampo() {
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoDefensa();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(true, unCampo.hayCartasMonstruo());
				
		
	}
	
	@Test
	public void colocarUnaCartaMagicaBocaAbajoEnElCampo(){
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaMagica = new CartaMagica(unEstado);
		
		unCampo.colocar(unaCartaMagica);
		
		assertEquals(true, unCampo.hayCartasMagiaOTrampa());
	}
	
	@Test
	public void colocarUnaCartaTrampaBocaAbajoEnElCampo(){
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaTrampa = new CartaTrampa(unEstado);
		
		unCampo.colocar(unaCartaTrampa);
		
		assertEquals(true, unCampo.hayCartasMagiaOTrampa());
	}
			
	@Test
	public void destruirUnMonstruoYVerificarQueEsteEnElCementerio(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		unCampo.destruir(unMonstruo);
		
		assertEquals(false, unCampo.hayCartasMonstruo());
		assertEquals(true, unCampo.estaEnElCementerio(unMonstruo));
	}
	
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
	
	@Test
	public void ColocarDosMonstruosYDestruirlosConElAgujeroNegroSinRecibirDaño(){
		
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
	public void colocarUnMonstruoSeguidoDeOtroQueRequierSacrificioEliminandoAlPrimero(){
		
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
	public void colocarDosMonstruoSeguidoDeOtroQueRequierDosSacrificiosEliminandoALosPrimeros(){
		
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
	
	//Segundas pruebas 
	
	@Test
	public void ColocarDosMonstruosYActivarWastelandDeUnLadoDelCampoAumentaAtaqueDelOtroAumentaDefensa(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		Estado unEstado = new BocaArriba();
		int puntosATK = 100;
		int puntosDEF = 100;
		int estrellas = 1;
		int puntosDeVidaIniciales = 8000;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaMagica wasteland = new Wasteland();
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDefensa);
		unJugador.agregarCartaAlMazo(wasteland);
		otroJugador.agregarCartaAlMazo(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDefensa);
		otroJugador.invocar(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(wasteland);
		
		assertEquals(puntosDeVidaIniciales, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaIniciales,otroJugador.obtenerPuntosDeVida());
		
		
		LinkedList<CartaMonstruo> cartasMonstruoEnElCampo;
		cartasMonstruoEnElCampo = campito.verCartasMonstruo();

		
		LinkedList<CartaMonstruo> CartasMonstruoEnElCampo2;
		CartasMonstruoEnElCampo = campito2.verCartasMonstruo();
//		
//		//faltaria ver el ataque, y la defensa...
//		
//		
//	}
}
