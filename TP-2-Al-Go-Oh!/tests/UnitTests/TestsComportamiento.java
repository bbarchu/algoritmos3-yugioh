package UnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import modelo.cartasEspecificas.AgujeroNegro;
import modelo.cartasEspecificas.DragonDefinitivoDeOjosAzules;
import modelo.cartasEspecificas.Fisura;
import modelo.cartasEspecificas.InsectoComeHombres;
import modelo.cartasEspecificas.Jinzo7;
import modelo.cartasEspecificas.Sogen;
import modelo.cartasEspecificas.Wasteland;
import modelo.cartasGenericas.BocaAbajo;
import modelo.cartasGenericas.BocaArriba;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaCampo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.cartasGenericas.Estado;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDeUso;
import modelo.cartasGenericas.ModoDefensa;
import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;



public class TestsComportamiento {
	
	@Test
	public void testcolocarUnMonstruoEnAtaqueEnElCampo() {
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(true, unCampo.hayCartasMonstruo());
		
	}
	
	@Test
	public void testcolocarUnMonstruoEnDefensaEnElCampo() {
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoDefensa();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		
		assertEquals(true, unCampo.hayCartasMonstruo());
				
		
	}
	
	@Test
	public void testcolocarUnaCartaMagicaBocaAbajoEnElCampo(){
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaMagica = new CartaMagica(unEstado);
		
		unCampo.colocar(unaCartaMagica);
		
		assertEquals(true, unCampo.hayCartasMagiaOTrampa());
	}
	
	@Test
	public void testcolocarUnaCartaTrampaBocaAbajoEnElCampo(){
		
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Estado unEstado = new BocaAbajo();
		Carta unaCartaTrampa = new CartaTrampa(unEstado);
		
		unCampo.colocar(unaCartaTrampa);
		
		assertEquals(true, unCampo.hayCartasMagiaOTrampa());
	}
			
	@Test
	public void testdestruirUnMonstruoYVerificarQueEsteEnElCementerio(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		ModoDeUso unModo = new ModoAtaque();
		Carta unMonstruo = new CartaMonstruo(unModo);
		
		unCampo.colocar(unMonstruo);
		unCampo.destruir(unMonstruo);
		
		assertEquals(false, unCampo.hayCartasMonstruo());
		assertEquals(true, unCampo.estaEnElCementerio(unMonstruo));
	}
	
	@Test
	public void testdosJugadoresSeAtacanConMostruosYLosPuntosDeVidaCambian(){
		
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
	public void testelJugadorQueAtacaConMenorAtaqueEsElQueMuereYLosPuntosDeEsteJugadorBajan(){
		
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
	public void testhayEmpateSeDestruyenAmbasCartasNoSeSufreDañoEnPuntosDeVida(){
		
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
		
		otroJugador.atacarCon_A(monstruoDefensa, monstruoAtaque);
		
		
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
	public void testcolocarUnMonstruoSeguidoDeOtroQueRequierSacrificioEliminandoAlPrimero(){
		
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
	public void testcolocarDosMonstruoSeguidoDeOtroQueRequierDosSacrificiosEliminandoALosPrimeros(){
		
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
	public void testColocarDosMonstruosYActivarWastelandDeUnLadoDelCampoAumentaAtaqueDelOtroAumentaDefensa(){
		
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 100;
		int puntosATKEsperados = 300;
		int puntosDEFEsperados = 400;
		int estrellas = 1;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaCampo wasteland = new Wasteland(unJugador);
		
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
		
		
		LinkedList<Carta> cartasMonstruoEnElCampo;
		cartasMonstruoEnElCampo = campito.verCartasMonstruo();

		
		LinkedList<Carta> cartasMonstruoEnElCampo2;
		cartasMonstruoEnElCampo2 = campito2.verCartasMonstruo();
		
		Iterator<Carta>iterador1;
		Iterator<Carta>iterador2;
		iterador1 = cartasMonstruoEnElCampo.iterator();
		iterador2 = cartasMonstruoEnElCampo2.iterator();
		
		CartaMonstruo primerMonstruo = (CartaMonstruo) iterador1.next();
		CartaMonstruo segundoMonstruo = (CartaMonstruo) iterador2.next();
		
		assertEquals(puntosATKEsperados,primerMonstruo.obtenerPuntosDeAtaque());
		assertEquals(puntosDEFEsperados,segundoMonstruo.obtenerPuntosDeDefensa());	

	}
	
		
	@Test
	public void testColocarDosMonstruosYActivarSogenDeUnLadoDelCampoAumentaDefensaDelOtroAumentaAtaque(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 100;
		int estrellas = 1;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaCampo sogen = new Sogen(unJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		unJugador.agregarCartaAlMazo(monstruoDefensa);
		unJugador.agregarCartaAlMazo(sogen);
		otroJugador.agregarCartaAlMazo(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		unJugador.invocar(monstruoDefensa);
		otroJugador.invocar(monstruoAtaque);
		
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(sogen);
		
		
		LinkedList<Carta> cartasMonstruoEnElCampo;
		cartasMonstruoEnElCampo = campito.verCartasMonstruo();

		
		LinkedList<Carta> cartasMonstruoEnElCampo2;
		cartasMonstruoEnElCampo2 = campito2.verCartasMonstruo();
		
		Iterator<Carta>iterador1;
		Iterator<Carta>iterador2;
		iterador1 = cartasMonstruoEnElCampo.iterator();
		iterador2 = cartasMonstruoEnElCampo2.iterator();
		
		CartaMonstruo primerMonstruo = (CartaMonstruo) iterador1.next();
		CartaMonstruo segundoMonstruo = (CartaMonstruo) iterador2.next();
		
		assertEquals(600,primerMonstruo.obtenerPuntosDeDefensa());
		assertEquals(300,segundoMonstruo.obtenerPuntosDeAtaque());	
	}
	
	
	@Test
	public void testActivarOllaDeLaCodiciaTomandoDosCartasDelMazo(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 100;
		int puntosATKEsperados = 300;
		int puntosDEFEsperados = 400;
		int estrellas = 1;
		
		CartaMonstruo monstruoDefensa = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo monstruoAtaque = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaCampo wasteland = new Wasteland(unJugador);
		
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
		
		
		LinkedList<Carta> cartasMonstruoEnElCampo;
		cartasMonstruoEnElCampo = campito.verCartasMonstruo();

		
		LinkedList<Carta> cartasMonstruoEnElCampo2;
		cartasMonstruoEnElCampo2 = campito2.verCartasMonstruo();
		
		Iterator<Carta>iterador1;
		Iterator<Carta>iterador2;
		iterador1 = cartasMonstruoEnElCampo.iterator();
		iterador2 = cartasMonstruoEnElCampo2.iterator();
		
		CartaMonstruo primerMonstruo = (CartaMonstruo) iterador1.next();
		CartaMonstruo segundoMonstruo = (CartaMonstruo) iterador2.next();
		
		assertEquals(puntosATKEsperados,primerMonstruo.obtenerPuntosDeAtaque());
		assertEquals(puntosDEFEsperados,segundoMonstruo.obtenerPuntosDeDefensa());	
	}
	
	@Test
	public void testColocarDosMonstruosEnemigosYActivarLaCartaMagicaFisuraElDeMenorAtaqueSeDestruira() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito = unJugador.obtenerCampoDeBatalla();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		Estado unEstado = new BocaArriba();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 100;
		int puntosATKEsperados = 300;
		int puntosDEFEsperados = 400;
		int estrellas = 1;
		
		CartaMonstruo monstruoAtaqueMenor = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaMonstruo monstruoAtaqueMayor = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, otroJugador);
		CartaMagica fisura = new Fisura(unEstado,unJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		otroJugador.agregarCartaAlMazo(monstruoAtaqueMenor);
		otroJugador.agregarCartaAlMazo(monstruoAtaqueMayor);
		
		otroJugador.tomarCartaDelMazo();
		otroJugador.tomarCartaDelMazo();
		
		otroJugador.invocar(monstruoAtaqueMenor);
		otroJugador.invocar(monstruoAtaqueMayor);
		
		unJugador.agregarCartaAlMazo(fisura);
		unJugador.tomarCartaDelMazo();
		unJugador.invocar(fisura);
		
		assertEquals(true,campito2.estaEnElCementerio(monstruoAtaqueMenor));
		assertEquals(false,campito2.estaEnElCementerio(monstruoAtaqueMayor));
		
	}
	
	@Test
	public void testcolocarJinzo7YUnMonstruoEnemigoYAtacarDirectamenteALosPuntosDeVida() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		
		int vidaEsperada = 7500;
		
		int puntosATKRival = 100;
		int puntosDEFRival = 100;
		int estrellasRival = 2;
		ModoDeUso modoRival = new ModoDefensa();
		
		ModoDeUso modoAtaque = new ModoAtaque();
		
		CartaMonstruo monstruoRival = new CartaMonstruo (puntosATKRival, puntosDEFRival, estrellasRival, modoRival, otroJugador);
		Jinzo7 jinzo7 = new Jinzo7 (modoAtaque, unJugador);
		
		unJugador.presentarJugadorRival(otroJugador);
		otroJugador.presentarJugadorRival(unJugador);
		
		otroJugador.agregarCartaAlMazo(monstruoRival);
		unJugador.agregarCartaAlMazo(jinzo7);
		
		otroJugador.tomarCartaDelMazo();
		unJugador.tomarCartaDelMazo();
		
		otroJugador.invocar(monstruoRival);
		unJugador.invocar(jinzo7);
		
		jinzo7.atacarJugador(otroJugador);
		
		assertEquals(vidaEsperada,otroJugador.obtenerPuntosDeVida());
	}
	
	@Test
	public void testInvocarTresDragonesBlancosDeOjosAzulesYUnDragonDefinitivoDeOjosAzules() {
		Jugador jugador = new Jugador();
		int ataqueDragonBlanco = 3000;
		int defensaDragonBlanco = 2500;
		int estrellasDragonBlanco = 1;
		ModoDeUso modoAtaque = new ModoAtaque();
		String nombreDragonBlanco = "DragonBlancoDeOjosAzules";
		
		CartaMonstruo dragonBlancoUno = new CartaMonstruo(ataqueDragonBlanco, defensaDragonBlanco, estrellasDragonBlanco, modoAtaque, jugador, nombreDragonBlanco);
		CartaMonstruo dragonBlancoDos = new CartaMonstruo(ataqueDragonBlanco, defensaDragonBlanco, estrellasDragonBlanco, modoAtaque, jugador, nombreDragonBlanco);
		CartaMonstruo dragonBlancoTres = new CartaMonstruo(ataqueDragonBlanco, defensaDragonBlanco, estrellasDragonBlanco, modoAtaque, jugador, nombreDragonBlanco);
		CartaMonstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules(modoAtaque, jugador);
		
		jugador.agregarCartaAlMazo(dragonBlancoUno);
		jugador.tomarCartaDelMazo();
		
		jugador.agregarCartaAlMazo(dragonBlancoDos);
		jugador.tomarCartaDelMazo();
		
		jugador.agregarCartaAlMazo(dragonBlancoTres);
		jugador.tomarCartaDelMazo();
		
		jugador.agregarCartaAlMazo(dragonDefinitivo);
		jugador.tomarCartaDelMazo();
		
		jugador.invocar(dragonBlancoUno);
		jugador.invocar(dragonBlancoDos);
		jugador.invocar(dragonBlancoTres);
		jugador.invocar(dragonDefinitivo);
		
		boolean estaEnCementerioUno = jugador.obtenerCampoDeBatalla().estaEnElCementerio(dragonBlancoUno);
		assertEquals(true, estaEnCementerioUno);
		
		boolean estaEnCementerioDos = jugador.obtenerCampoDeBatalla().estaEnElCementerio(dragonBlancoDos);
		assertEquals(true, estaEnCementerioDos);
		
		boolean estaEnCementerioTres = jugador.obtenerCampoDeBatalla().estaEnElCementerio(dragonBlancoTres);
		assertEquals(true, estaEnCementerioTres);
	}
@Test
public void testColocarInsectoComeHombresEnPosicionDefensaBocaAbajoYVerificarQueAlSerAtacadoSeVolteaYDestruyeAlAtacante() {
		
		int puntosDeVidaSinAfectar = 8000;
		
		Jugador unJugador = new Jugador();
		Jugador jugadorAtacante = new Jugador();
		
		int puntosATKAtacante = 100;
		int puntosDEFAtacante = 100;
		int estrellasAtacante = 2;
		
		ModoDeUso modoDefensa = new ModoDefensa();
		ModoDeUso modoAtaque = new ModoAtaque();
		
		CartaMonstruo monstruoAtacante = new CartaMonstruo (puntosATKAtacante, puntosDEFAtacante, estrellasAtacante, modoAtaque, jugadorAtacante);
		
		InsectoComeHombres insectoComeHombres = new InsectoComeHombres(modoDefensa, unJugador);
	
		unJugador.presentarJugadorRival(jugadorAtacante);
		jugadorAtacante.presentarJugadorRival(unJugador);
		
		jugadorAtacante.agregarCartaAlMazo(monstruoAtacante);
		unJugador.agregarCartaAlMazo(insectoComeHombres);
		
		jugadorAtacante.tomarCartaDelMazo();
		unJugador.tomarCartaDelMazo();
		
		jugadorAtacante.invocar(monstruoAtacante);
		unJugador.invocar(insectoComeHombres);
		
		jugadorAtacante.atacarCon_A(monstruoAtacante, insectoComeHombres);
		
		assertEquals(true, jugadorAtacante.obtenerCampoDeBatalla().estaEnElCementerio(monstruoAtacante));
		assertEquals(false, unJugador.obtenerCampoDeBatalla().estaEnElCementerio(insectoComeHombres));
		//agregado
		assertEquals(puntosDeVidaSinAfectar, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaSinAfectar, jugadorAtacante.obtenerPuntosDeVida());
	}

}
