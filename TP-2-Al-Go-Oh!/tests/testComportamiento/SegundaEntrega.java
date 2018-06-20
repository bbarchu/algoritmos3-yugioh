package testComportamiento;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import modelo.cartasEspecificas.CilindroMagico;
import modelo.cartasEspecificas.DragonDefinitivoDeOjosAzules;
import modelo.cartasEspecificas.Fisura;
import modelo.cartasEspecificas.InsectoComeHombres;
import modelo.cartasEspecificas.Jinzo7;
import modelo.cartasEspecificas.OllaDeLaCodicia;
import modelo.cartasEspecificas.Reinforcements;
import modelo.cartasEspecificas.Sogen;
import modelo.cartasEspecificas.Wasteland;
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

public class SegundaEntrega {
	
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
		int puntosATKEsperados = 300;
		int puntosDEFEsperados = 600;
		
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
		
		assertEquals(puntosDEFEsperados,primerMonstruo.obtenerPuntosDeDefensa());
		assertEquals(puntosATKEsperados,segundoMonstruo.obtenerPuntosDeAtaque());	
	}
	
	
	@Test
	public void testActivarOllaDeLaCodiciaTomandoDosCartasDelMazo(){
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		Estado unEstado = new BocaArriba();
		int puntosATK = 100;
		int puntosDEF = 100;
		int estrellas = 1;
		int cantidadDeCartasEsperadas = 2;
		
		CartaMonstruo primerMonstruo = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo segundoMonstruo = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMonstruo tercerMonstruo = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		CartaMagica ollaDeLaCodicia = new OllaDeLaCodicia(unEstado, unJugador);
		
		
		unJugador.agregarCartaAlMazo(ollaDeLaCodicia);
		unJugador.tomarCartaDelMazo();
		unJugador.agregarCartaAlMazo(primerMonstruo);
		unJugador.agregarCartaAlMazo(segundoMonstruo);
		unJugador.agregarCartaAlMazo(tercerMonstruo);
		
		unJugador.invocar(ollaDeLaCodicia);
		
		assertEquals(cantidadDeCartasEsperadas,unJugador.cantidadDeCartasEnLaMano());
	}
	
	@Test
	public void testColocarDosMonstruosEnemigosYActivarLaCartaMagicaFisuraElDeMenorAtaqueSeDestruira() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		CampoDeBatalla campito2 = otroJugador.obtenerCampoDeBatalla();
		Estado unEstado = new BocaArriba();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 100;
		int puntosDEF = 100;
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
	public void testColocarJinzo7YUnMonstruoEnemigoYAtacarDirectamenteALosPuntosDeVida() {
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
	public void testColocarTrampaCilindroMagicoYColocarCartaMonstruoEnAmbosLadosYAtacarALaCartaConTrampaYDisminuyeVidaAtacante() {
	
		Jugador jugadorConCilindro = new Jugador();
		Jugador jugadorAtacante = new Jugador();
	
		ModoDeUso modoATK = new ModoAtaque();
		
		int ATKMonstruos = 1000;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaEsperados = 7000;
		
		CartaMonstruo monstruoDefensor = new CartaMonstruo(ATKMonstruos, puntosDEF, estrellas, modoATK, jugadorConCilindro);
		CartaMonstruo monstruoAtacante = new CartaMonstruo(ATKMonstruos, puntosDEF, estrellas, modoATK, jugadorAtacante);
		
		CartaTrampa cilindro = new CilindroMagico();
		
		jugadorConCilindro.presentarJugadorRival(jugadorAtacante);
		jugadorAtacante.presentarJugadorRival(jugadorConCilindro);
		
		jugadorConCilindro.agregarCartaAlMazo(monstruoDefensor);
		jugadorAtacante.agregarCartaAlMazo(monstruoAtacante);
		
		jugadorConCilindro.tomarCartaDelMazo();
		jugadorAtacante.tomarCartaDelMazo();
		
		jugadorConCilindro.invocar(monstruoDefensor);
		jugadorAtacante.invocar(monstruoAtacante);
		
		jugadorConCilindro.agregarCartaAlMazo(cilindro);
		jugadorConCilindro.tomarCartaDelMazo();
		jugadorConCilindro.invocar(cilindro);
		
		jugadorAtacante.atacarCon_A(monstruoAtacante, monstruoDefensor);
		
		assertEquals(puntosDeVidaEsperados, jugadorAtacante.obtenerPuntosDeVida());
		assertEquals(false,jugadorAtacante.obtenerCampoDeBatalla().estaEnElCementerio(monstruoAtacante));
		assertEquals(false,jugadorConCilindro.obtenerCampoDeBatalla().estaEnElCementerio(monstruoDefensor));
		
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
		assertEquals(puntosDeVidaSinAfectar, unJugador.obtenerPuntosDeVida());
		assertEquals(puntosDeVidaSinAfectar, jugadorAtacante.obtenerPuntosDeVida());
	}
	
	@Test
	public void testColocarMonstruoCon400PuntosDeAtaqueMenosQueElDelRivalYAlAtacarmeSeActivaReinforcementsYElAtacanteSeDestruyeYPierde100PuntosDeVidaElRival() {
	
		Jugador jugadorConReinforcements = new Jugador();
		Jugador jugadorAtacante = new Jugador();
	
		ModoDeUso modoATK = new ModoAtaque();
		
		int ATQMonstruoConReinforcements = 2000;
		int ATKMonstruoAtacante = 2400;
		int puntosDEF = 500;
		int estrellas = 1;
		int puntosDeVidaEsperados = 7900;
		
		CartaMonstruo monstruoConReinforcement = new CartaMonstruo(ATQMonstruoConReinforcements, puntosDEF, estrellas, modoATK, jugadorConReinforcements);
		CartaMonstruo monstruoAtacante = new CartaMonstruo(ATKMonstruoAtacante, puntosDEF, estrellas, modoATK, jugadorAtacante);
		
		CartaTrampa reinforcements = new Reinforcements();
		
		jugadorConReinforcements.presentarJugadorRival(jugadorAtacante);
		jugadorAtacante.presentarJugadorRival(jugadorConReinforcements);
		
		jugadorConReinforcements.agregarCartaAlMazo(monstruoConReinforcement);
		jugadorAtacante.agregarCartaAlMazo(monstruoAtacante);
		
		jugadorConReinforcements.tomarCartaDelMazo();
		jugadorAtacante.tomarCartaDelMazo();
		
		jugadorConReinforcements.invocar(monstruoConReinforcement);
		jugadorAtacante.invocar(monstruoAtacante);
		
		jugadorConReinforcements.agregarCartaAlMazo(reinforcements);
		jugadorConReinforcements.tomarCartaDelMazo();
		jugadorConReinforcements.invocar(reinforcements);
		
		jugadorAtacante.atacarCon_A(monstruoAtacante, monstruoConReinforcement);
		
		assertEquals(true, jugadorAtacante.obtenerCampoDeBatalla().estaEnElCementerio(monstruoAtacante));
		assertEquals(puntosDeVidaEsperados, jugadorAtacante.obtenerPuntosDeVida());
	}
	
	@Test
	public void testElJugadorPierdeYaQueSeQuedaSinCartasEnElMazo() {
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 1;
		int puntosDEF = 1;
		int estrellas = 1;
		
		CartaMonstruo unMonstruo = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador);
		
		unJugador.agregarCartaAlMazo(unMonstruo);
		assertEquals(false, unJugador.perdioLaPartida());
		
		unJugador.tomarCartaDelMazo();
		assertEquals(true, unJugador.perdioLaPartida());
	}
	@Test
	public void testElJugadorGanaYaQueTieneLas5PartesDeExodiaEnLaMano() {
		Jugador unJugador = new Jugador();
		ModoDeUso modoATK = new ModoAtaque();
		int puntosATK = 1;
		int puntosDEF = 1;
		int estrellas = 1;
		
		CartaMonstruo elProhibido = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador,"ExodiaElProhibido");
		CartaMonstruo brazoDerechoDelProhibido = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador,"BrazoDerechoDelProhibido");
		CartaMonstruo brazoIzquierdoDelProhibido = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador,"BrazoIzquierdoDelProhibido");
		CartaMonstruo piernaDerechaDelProhibido = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador,"PiernaDerechaDelProhibido");
		CartaMonstruo piernaIzquierdaDelProhibido = new CartaMonstruo(puntosATK, puntosDEF, estrellas, modoATK, unJugador,"PiernaIzquierdaDelProhibido");
		
		unJugador.agregarCartaAlMazo(elProhibido);
		unJugador.agregarCartaAlMazo(brazoDerechoDelProhibido);
		unJugador.agregarCartaAlMazo(brazoIzquierdoDelProhibido);
		unJugador.agregarCartaAlMazo(piernaDerechaDelProhibido);
		unJugador.agregarCartaAlMazo(piernaIzquierdaDelProhibido);
		
		unJugador.tomarCartaDelMazo();
		unJugador.tomarCartaDelMazo();
		unJugador.tomarCartaDelMazo();
		unJugador.tomarCartaDelMazo();
		unJugador.tomarCartaDelMazo();
		
		assertEquals(true, unJugador.ganoLaPartida());
	}
	
	

}
