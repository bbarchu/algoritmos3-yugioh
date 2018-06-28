package modelo.aplicacion;

import java.util.Hashtable;
import java.util.LinkedList;

import modelo.cartasEspecificas.AgujeroNegro;
import modelo.cartasEspecificas.CilindroMagico;
import modelo.cartasEspecificas.DragonDefinitivoDeOjosAzules;
import modelo.cartasEspecificas.Fisura;
import modelo.cartasEspecificas.InsectoComeHombres;
import modelo.cartasEspecificas.Jinzo7;
import modelo.cartasEspecificas.OllaDeLaCodicia;
import modelo.cartasEspecificas.Reinforcements;
import modelo.cartasEspecificas.Sogen;
import modelo.cartasEspecificas.Wasteland;
import modelo.cartasGenericas.BocaAbajo;
import modelo.cartasGenericas.BocaArriba;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDefensa;
import modelo.jugador.Jugador;

public class AlGoOh {
	Jugador jugadorActual;
	Jugador jugadorRival;
	
	Jugador jugadorNumeroUno;
	Jugador jugadorNumeroDos;
	
	Hashtable<String, Carta> cartasJugadorActual;
	Hashtable<String, Carta> cartasJugadorRival;
	
	Hashtable<String, Carta> cartasJugadorUno;
	Hashtable<String, Carta> cartasJugadorDos;
	
	public AlGoOh(){
		
		//creacion del diccionario de cartas de ambos jugadores.
		cartasJugadorUno = new Hashtable<String, Carta>();
		cartasJugadorDos = new Hashtable<String, Carta>();
		
		//creacion de jugadores.
		jugadorNumeroUno = new Jugador();
		jugadorNumeroDos = new Jugador();
		
		//Asigno el primer turno a el jugador numero uno.
		jugadorActual = jugadorNumeroUno;
		cartasJugadorActual = cartasJugadorUno;
		
		jugadorRival = jugadorNumeroDos;
		cartasJugadorRival = cartasJugadorDos;
		
		BocaAbajo bocaAbajo = new BocaAbajo();
		BocaArriba bocaArriba = new BocaArriba();
		
		ModoAtaque modoAtaque = new ModoAtaque();
		ModoDefensa modoDefensa = new ModoDefensa();
		
		//1° carta AgujeroOscuro
		
		AgujeroNegro agujeroNegroUno = new AgujeroNegro("AgujeroOscuro",bocaAbajo,jugadorNumeroUno);
		AgujeroNegro agujeroNegroDos = new AgujeroNegro("AgujeroOscuro",bocaAbajo,jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(agujeroNegroUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(agujeroNegroDos);
		
		this.cartasJugadorUno.put("AgujeroOscuro", agujeroNegroUno);
		this.cartasJugadorDos.put("AgujeroOscuro", agujeroNegroDos);
		
		//2° carta BrazoDerechoDelProhibido
		
		CartaMonstruo brazoDerechoDelProhibidoUno = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroUno, "BrazoDerechoDelProhibido");
		CartaMonstruo brazoDerechoDelProhibidoDos = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroDos, "BrazoDerechoDelProhibido");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(brazoDerechoDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(brazoDerechoDelProhibidoDos);
		
		this.cartasJugadorUno.put("BrazoDerechoDelProhibido", brazoDerechoDelProhibidoUno);
		this.cartasJugadorDos.put("BrazoDerechoDelProhibido", brazoDerechoDelProhibidoDos);
		
		//3° carta BrazoIzquierdoDelProhibido
		
		CartaMonstruo brazoIzquierdoDelProhibidoUno = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroUno,"BrazoIzquierdoDelProhibido");
		CartaMonstruo brazoIzquierdoDelProhibidoDos = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroDos,"BrazoIzquierdoDelProhibido");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(brazoIzquierdoDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(brazoIzquierdoDelProhibidoDos);
		
		this.cartasJugadorUno.put("BrazoIzquierdoDelProhibido", brazoIzquierdoDelProhibidoUno);
		this.cartasJugadorDos.put("BrazoIzquierdoDelProhibido", brazoIzquierdoDelProhibidoDos);
		
		//4° carta BueyDeBatalla
		
		CartaMonstruo bueyDeBatallaUno = new CartaMonstruo(1700,1000,4,modoAtaque,jugadorNumeroUno,"BueyDeBatalla");
		CartaMonstruo bueyDeBatallaDos = new CartaMonstruo(1700,1000,4,modoAtaque,jugadorNumeroDos,"BueyDeBatalla");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(bueyDeBatallaUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(bueyDeBatallaDos);
		
		this.cartasJugadorUno.put("BueyDeBatalla", bueyDeBatallaUno);
		this.cartasJugadorDos.put("BueyDeBatalla", bueyDeBatallaDos);
		
		//5° carta CaballoDeMar
		
		CartaMonstruo caballoDeMarUno = new CartaMonstruo(1700,1650,4,modoAtaque,jugadorNumeroUno,"CaballoDeMar");
		CartaMonstruo caballoDeMarDos = new CartaMonstruo(1700,1650,4,modoAtaque,jugadorNumeroDos,"CaballoDeMar");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(caballoDeMarUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(caballoDeMarDos);
		
		this.cartasJugadorUno.put("CaballoDeMar", caballoDeMarUno);
		this.cartasJugadorDos.put("CaballoDeMar", caballoDeMarDos);
		
		//6° carta CilindroMagico
		
		CilindroMagico cilindroMagicoUno = new CilindroMagico("CilindroMagico");
		CilindroMagico cilindroMagicoDos = new CilindroMagico("CilindroMagico");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(cilindroMagicoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(cilindroMagicoDos);
		
		this.cartasJugadorUno.put("CilindroMagico", cilindroMagicoUno);
		this.cartasJugadorDos.put("CilindroMagico", cilindroMagicoDos);
		
		//7° carta Craneo
		
		CartaMonstruo craneoUno = new CartaMonstruo(2500,1200,6,modoAtaque,jugadorNumeroUno,"Craneo");
		CartaMonstruo craneoDos = new CartaMonstruo(2500,1200,6,modoAtaque,jugadorNumeroDos,"Craneo");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(craneoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(craneoDos);
		
		this.cartasJugadorUno.put("Craneo", craneoUno);
		this.cartasJugadorDos.put("Craneo", craneoDos);
		
		//8° carta DarkMaster
		
		CartaMonstruo darkMasterUno = new CartaMonstruo(30000, 30000, 12, modoAtaque, jugadorNumeroUno, "DarkMaster");
		CartaMonstruo darkMasterDos = new CartaMonstruo(30000, 30000, 12, modoAtaque, jugadorNumeroDos, "DarkMaster");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(darkMasterUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(darkMasterDos);
		
		this.cartasJugadorUno.put("DarkMaster", darkMasterUno);
		this.cartasJugadorDos.put("DarkMaster", darkMasterDos);
		
		//9° carta DemonioElemental
		
		CartaMonstruo demonioElementalUno = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroUno,"DemonioElemental");
		CartaMonstruo demonioElementalDos = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroDos,"DemonioElemental");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(demonioElementalUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(demonioElementalDos);
		
		this.cartasJugadorUno.put("DemonioElemental", demonioElementalUno);
		this.cartasJugadorDos.put("DemonioElemental", demonioElementalDos);
		
		//10° carta DragonArmadoOscuro
		
		CartaMonstruo dorsoUno = new CartaMonstruo(2800,1000,7,modoAtaque,jugadorNumeroUno,"DragonArmadoOscuro");
		CartaMonstruo dorsoDos = new CartaMonstruo(2800,1000,7,modoAtaque,jugadorNumeroDos,"DragonArmadoOscuro");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dorsoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dorsoDos);
		
		this.cartasJugadorUno.put("DragonArmadoOscuro", dorsoUno);
		this.cartasJugadorDos.put("DragonArmadoOscuro", dorsoDos);
		
		//11° carta DragonBlancoDeOjosAzules
		
		CartaMonstruo dragonBlancoDeOjosAzulesUno = new CartaMonstruo(3000,2500,8,modoAtaque,jugadorNumeroUno,"DragonBlancoDeOjosAzules");
		CartaMonstruo dragonBlancoDeOjosAzulesDos = new CartaMonstruo(3000,2500,8,modoAtaque,jugadorNumeroDos,"DragonBlancoDeOjosAzules");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonBlancoDeOjosAzulesUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonBlancoDeOjosAzulesDos);
		
		this.cartasJugadorUno.put("DragonBlancoDeOjosAzules", dragonBlancoDeOjosAzulesUno);
		this.cartasJugadorDos.put("DragonBlancoDeOjosAzules", dragonBlancoDeOjosAzulesDos);
		
		//12° carta DragonDeCuernoBlanco
		
		CartaMonstruo dragonDeCuernoBlancoUno = new CartaMonstruo(2200,1400,6,modoAtaque,jugadorNumeroUno,"DragonDeCuernoBlanco");
		CartaMonstruo dragonDeCuernoBlancoDos = new CartaMonstruo(2200,1400,6,modoAtaque,jugadorNumeroDos,"DragonDeCuernoBlanco");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonDeCuernoBlancoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonDeCuernoBlancoDos);
		
		this.cartasJugadorUno.put("DragonDeCuernoBlanco", dragonDeCuernoBlancoUno);
		this.cartasJugadorDos.put("DragonDeCuernoBlanco", dragonDeCuernoBlancoDos);
		
		//13° carta DragonDeLaMuerte
		
		CartaMonstruo dragonDeLaMuerteUno = new CartaMonstruo(1550,1600,3,modoAtaque,jugadorNumeroUno,"DragonDeLaMuerte");
		CartaMonstruo dragonDeLaMuerteDos = new CartaMonstruo(1550,1600,3,modoAtaque,jugadorNumeroDos,"DragonDeLaMuerte");

		this.jugadorNumeroUno.agregarCartaAlMazo(dragonDeLaMuerteUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonDeLaMuerteDos);
		
		this.cartasJugadorUno.put("DragonDeLaMuerte", dragonDeLaMuerteUno);
		this.cartasJugadorDos.put("DragonDeLaMuerte", dragonDeLaMuerteDos);
		
		//14° carta DragonDeOjosAzulesDefinitivo
		
		DragonDefinitivoDeOjosAzules dragonDefinitivoDeOjosAzulesUno= new DragonDefinitivoDeOjosAzules(modoAtaque,jugadorNumeroUno);
		DragonDefinitivoDeOjosAzules dragonDefinitivoDeOjosAzulesDos= new DragonDefinitivoDeOjosAzules(modoAtaque,jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonDefinitivoDeOjosAzulesUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonDefinitivoDeOjosAzulesDos);
		
		this.cartasJugadorUno.put("DragonDeOjosAzulesDefinitivo", dragonDefinitivoDeOjosAzulesUno);
		this.cartasJugadorDos.put("DragonDeOjosAzulesDefinitivo", dragonDefinitivoDeOjosAzulesDos);
		
		//15° carta DragonElemental
		
		CartaMonstruo dragonElementalUno = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroUno,"DragonElemental");
		CartaMonstruo dragonElementalDos = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroDos,"DragonElemental");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonElementalUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonElementalDos);
		
		this.cartasJugadorUno.put("DragonElemental", dragonElementalUno);
		this.cartasJugadorDos.put("DragonElemental", dragonElementalDos);
		
		//16° carta ExodiaElProhibido
		
		CartaMonstruo exodiaElProhibidoUno = new CartaMonstruo(1000,1000,3,modoAtaque,jugadorNumeroUno,"ExodiaElProhibido");
		CartaMonstruo exodiaElProhibidoDos = new CartaMonstruo(1000,1000,3,modoAtaque,jugadorNumeroDos,"ExodiaElProhibido");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(exodiaElProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(exodiaElProhibidoDos);
		
		this.cartasJugadorUno.put("ExodiaElProhibido", exodiaElProhibidoUno);
		this.cartasJugadorDos.put("ExodiaElProhibido", exodiaElProhibidoDos);
		
		//17° carta Fisura
		
		Fisura fisuraUno = new Fisura(bocaAbajo,jugadorNumeroUno);
		Fisura fisuraDos = new Fisura(bocaAbajo,jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(fisuraUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(fisuraDos);
		
		this.cartasJugadorUno.put("Fisura", fisuraUno);
		this.cartasJugadorDos.put("Fisura", fisuraDos);
		
		//18° carta Girochin
		
		CartaMonstruo girochinUno = new CartaMonstruo(1700, 1000, 4, modoAtaque, jugadorNumeroUno,"Girochin");
		CartaMonstruo girochinDos = new CartaMonstruo(1700, 1000, 4, modoAtaque, jugadorNumeroDos,"Girochin");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(girochinUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(girochinDos);
		
		this.cartasJugadorUno.put("Girochin", girochinUno);
		this.cartasJugadorDos.put("Girochin", girochinDos);
		
		//19° carta GuardianDeLaPuerta
		
		CartaMonstruo guardianDeLaPuertaUno = new CartaMonstruo(3750, 3400, 11, modoAtaque, jugadorNumeroUno, "GuardianDeLaPuerta");
		CartaMonstruo guardianDeLaPuertaDos = new CartaMonstruo(3750, 3400, 11, modoAtaque, jugadorNumeroDos, "GuardianDeLaPuerta");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(guardianDeLaPuertaUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(guardianDeLaPuertaDos);
		
		this.cartasJugadorUno.put("GuardianDeLaPuerta", guardianDeLaPuertaUno);
		this.cartasJugadorDos.put("GuardianDeLaPuerta", guardianDeLaPuertaDos);
		
		//20° carta HaneHane
		
		CartaMonstruo haneHaneUno = new CartaMonstruo(450, 500, 2, modoAtaque, jugadorNumeroUno, "HaneHane");
		CartaMonstruo haneHaneDos = new CartaMonstruo(450, 500, 2, modoAtaque, jugadorNumeroDos, "HaneHane");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(haneHaneUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(haneHaneDos);
		
		this.cartasJugadorUno.put("HaneHane", haneHaneUno);
		this.cartasJugadorDos.put("HaneHane", haneHaneDos);
		
		//21° carta HojaOscura
		
		CartaMonstruo hojaOscuraUno = new CartaMonstruo(1800, 1500, 4, modoAtaque, jugadorNumeroUno, "HojaOscura");
		CartaMonstruo hojaOscuraDos = new CartaMonstruo(1800, 1500, 4, modoAtaque, jugadorNumeroDos, "HojaOscura");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(hojaOscuraUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(hojaOscuraDos);
		
		this.cartasJugadorUno.put("HojaOscura", hojaOscuraUno);
		this.cartasJugadorDos.put("HojaOscura", hojaOscuraDos);
		
		//22° carta InsectoComeHombres
		
		InsectoComeHombres insectoUno = new InsectoComeHombres(modoAtaque, jugadorNumeroUno);
		InsectoComeHombres insectoDos = new InsectoComeHombres(modoAtaque, jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(insectoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(insectoDos);
		
		this.cartasJugadorUno.put("InsectoComeHombres", insectoUno);
		this.cartasJugadorDos.put("InsectoComeHombres", insectoDos);
		
		//23° carta JineteMistico
		
		CartaMonstruo jineteUno = new CartaMonstruo(1300, 1550, 4, modoAtaque, jugadorNumeroUno, "JineteMistico");
		CartaMonstruo jineteDos = new CartaMonstruo(1300, 1550, 4, modoAtaque, jugadorNumeroDos, "JineteMistico");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(jineteUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(jineteDos);
		
		this.cartasJugadorUno.put("JineteMistico", jineteUno);
		this.cartasJugadorDos.put("JineteMistico", jineteDos);
		
		//24° carta Jinzo7
		
		Jinzo7 jinzoUno = new Jinzo7(modoAtaque, jugadorNumeroUno);
		Jinzo7 jinzoDos = new Jinzo7(modoAtaque, jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(jinzoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(jinzoDos);
		
		this.cartasJugadorUno.put("Jinzo7", jinzoUno);
		this.cartasJugadorDos.put("Jinzo7", jinzoDos);
		
		//25° carta Kuriboh
		
		CartaMonstruo kuribohUno = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroUno, "Kuriboh");
		CartaMonstruo kuribohDos = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroDos, "Kuriboh");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(kuribohUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(kuribohDos);
		
		this.cartasJugadorUno.put("Kuriboh", kuribohUno);
		this.cartasJugadorDos.put("Kuriboh", kuribohDos);
		
		//26° carta KuribohAlado
		
		CartaMonstruo kuribohAladoUno = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroUno, "KuribohAlado");
		CartaMonstruo kuribohAladoDos = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroDos, "KuribohAlado");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(kuribohAladoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(kuribohAladoDos);
		
		this.cartasJugadorUno.put("KuribohAlado", kuribohAladoUno);
		this.cartasJugadorDos.put("KuribohAlado", kuribohAladoDos);
		
		//27° carta LordOfD
		
		CartaMonstruo lordUno = new CartaMonstruo(1200, 1100, 4, modoAtaque, jugadorNumeroUno, "LordOfD");
		CartaMonstruo lordDos = new CartaMonstruo(1200, 1100, 4, modoAtaque, jugadorNumeroDos, "LordOfD");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(lordUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(lordDos);
		
		this.cartasJugadorUno.put("LordOfD", lordUno);
		this.cartasJugadorDos.put("LordOfD", lordDos);
		
		//28° carta MagoOscuro
		
		CartaMonstruo magoOscuroUno = new CartaMonstruo(2500, 2100, 7, modoAtaque, jugadorNumeroUno, "MagoOscuro");
		CartaMonstruo magoOscuroDos = new CartaMonstruo(2500, 2100, 7, modoAtaque, jugadorNumeroDos, "MagoOscuro");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(magoOscuroUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(magoOscuroDos);
		
		this.cartasJugadorUno.put("MagoOscuro", magoOscuroUno);
		this.cartasJugadorDos.put("MagoOscuro", magoOscuroDos);
		
		//29° carta Obelisk
		
		CartaMonstruo obeliskUno = new CartaMonstruo(4000, 4000, 10, modoAtaque, jugadorNumeroUno, "Obelisk");
		CartaMonstruo obeliskDos = new CartaMonstruo(4000, 4000, 10, modoAtaque, jugadorNumeroDos, "Obelisk");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(obeliskUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(obeliskDos);
		
		this.cartasJugadorUno.put("Obelisk", obeliskUno);
		this.cartasJugadorDos.put("Obelisk", obeliskDos);
		
		//30° carta OgroGrotto
		
		CartaMonstruo ogroUno = new CartaMonstruo(800, 1200, 3, modoAtaque,jugadorNumeroUno, "OgroGrotto");
		CartaMonstruo ogroDos = new CartaMonstruo(800, 1200, 3, modoAtaque,jugadorNumeroDos, "OgroGrotto");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(ogroUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(ogroDos);
		
		this.cartasJugadorUno.put("OgroGrotto", ogroUno);
		this.cartasJugadorDos.put("OgroGrotto", ogroDos);
		
		//31° carta OllaDeLaCodicia
		
		OllaDeLaCodicia ollaUno = new OllaDeLaCodicia(bocaAbajo, jugadorNumeroUno);
		OllaDeLaCodicia ollaDos = new OllaDeLaCodicia(bocaAbajo, jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(ollaUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(ollaDos);
		
		this.cartasJugadorUno.put("OllaDeLaCodicia", ollaUno);
		this.cartasJugadorDos.put("OllaDeLaCodicia", ollaDos);
		
		//32° carta PiernaDerechaDelProhibido
		
		CartaMonstruo piernaDerechaDelProhibidoUno = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroUno, "PiernaDerechaDelProhibido");
		CartaMonstruo piernaDerechaDelProhibidoDos = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroDos, "PiernaDerechaDelProhibido");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(piernaDerechaDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(piernaDerechaDelProhibidoDos);
		
		this.cartasJugadorUno.put("PiernaDerechaDelProhibido", piernaDerechaDelProhibidoUno);
		this.cartasJugadorDos.put("PiernaDerechaDelProhibido", piernaDerechaDelProhibidoDos);
		
		//33° carta PiernaIzquierdaDelProhibido
		
		CartaMonstruo piernaIzquierdaDelProhibidoUno = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroUno, "PiernaIzquierdaDelProhibido");
		CartaMonstruo piernaIzquierdaDelProhibidoDos = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroDos, "PiernaIzquierdaDelProhibido");
			
		this.jugadorNumeroUno.agregarCartaAlMazo(piernaIzquierdaDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(piernaIzquierdaDelProhibidoDos);
		
		this.cartasJugadorUno.put("PiernaIzquierdaDelProhibido", piernaIzquierdaDelProhibidoUno);
		this.cartasJugadorDos.put("PiernaIzquierdaDelProhibido", piernaIzquierdaDelProhibidoDos);
		
		//34° carta Reinforcements
		
		Reinforcements reinforcementsUno = new Reinforcements();
		Reinforcements reinforcementsDos = new Reinforcements();
		
		this.jugadorNumeroUno.agregarCartaAlMazo(reinforcementsUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(reinforcementsDos);
		
		this.cartasJugadorUno.put("Reinforcements", reinforcementsUno);
		this.cartasJugadorDos.put("Reinforcements", reinforcementsDos);
		
		//35° carta Ryu
		
		CartaMonstruo ryuUno = new CartaMonstruo(1600, 1200, 4, modoAtaque, jugadorNumeroUno, "Ryu");
		CartaMonstruo ryuDos = new CartaMonstruo(1600, 1200, 4, modoAtaque, jugadorNumeroDos, "Ryu");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(ryuUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(ryuDos);
		
		this.cartasJugadorUno.put("Ryu", ryuUno);
		this.cartasJugadorDos.put("Ryu", ryuDos);
		
		//36° carta Segadora
		
		CartaMonstruo segadoraUno = new CartaMonstruo(1380, 1930, 5, modoAtaque, jugadorNumeroUno, "Segadora");
		CartaMonstruo segadoraDos = new CartaMonstruo(1380, 1930, 5, modoAtaque, jugadorNumeroDos, "Segadora");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(segadoraUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(segadoraDos);
		
		this.cartasJugadorUno.put("Segadora", segadoraUno);
		this.cartasJugadorDos.put("Segadora", segadoraDos);
		
		//37° carta Slifer
		
		CartaMonstruo sliferUno = new CartaMonstruo(20000,20000, 10, modoAtaque, jugadorNumeroUno,"Slifer");
		CartaMonstruo sliferDos = new CartaMonstruo(20000,20000, 10, modoAtaque, jugadorNumeroDos, "Slifer");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(sliferUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(sliferDos);
		
		this.cartasJugadorUno.put("Slifer", sliferUno);
		this.cartasJugadorDos.put("Slifer", sliferDos);
		
		//38° carta Sogen
		
		Sogen sogenUno = new Sogen(jugadorNumeroUno);
		Sogen sogenDos = new Sogen(jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(sogenUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(sogenDos);
		
		this.cartasJugadorUno.put("Sogen", sogenUno);
		this.cartasJugadorDos.put("Sogen", sogenDos);
		
		//39° carta Wasteland
		
		Wasteland wastelandUno = new Wasteland(jugadorNumeroUno);
		Wasteland wastelandDos = new Wasteland(jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(wastelandUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(wastelandDos);
		
		this.cartasJugadorUno.put("Wasteland", wastelandUno);
		this.cartasJugadorDos.put("Wasteland", wastelandDos);
	
		this.jugadorActual.tomarCincoCartasDelMazo();
	
		this.jugadorRival.tomarCincoCartasDelMazo();
		
	}

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
	
	public void activarCartaMagicaDelJugadorActual(String nombreCarta) {
		Carta cartaMagica;
		cartaMagica = cartasJugadorActual.get(nombreCarta);
		jugadorActual.invocar(cartaMagica);
		
		
	}

	public void jugadorActualAtacaConA(String cartaAtacante, String cartaAtacada) {
		CartaMonstruo cartaMonstruoAtacante;
		CartaMonstruo cartaMonstruoAtacada;
		cartaMonstruoAtacante = (CartaMonstruo)cartasJugadorActual.get(cartaAtacante);
		cartaMonstruoAtacada = (CartaMonstruo)cartasJugadorRival.get(cartaAtacada);
		jugadorActual.atacarConA(cartaMonstruoAtacante, cartaMonstruoAtacada);
	}

	public void cambiarDeTurno() {
		
		jugadorActual.habilitarCartas();
		
		//Swap jugadores.
		Jugador aux = jugadorActual;
		jugadorActual = jugadorRival;
		jugadorRival = aux;
		
		//Swap cartas.
		Hashtable<String, Carta> cartasAux = cartasJugadorActual;
		cartasJugadorActual = cartasJugadorRival;
		cartasJugadorRival = cartasAux;
	}

	public void colocarEnElCampoDelJugadorActual(String text) {
		
		Carta carta = this.cartasJugadorActual.get(text);
		
		this.jugadorActual.invocar(carta);
		
	}

	public void jugadorActualTomaUnaCarta() {
		
		this.jugadorActual.tomarCartaDelMazo();
	}

	public String getPuntosJugador1() {
		int puntosDeVida = jugadorNumeroUno.obtenerPuntosDeVida();
		return Integer.toString(puntosDeVida);
	}

	public String getPuntosJugador2() {
		int puntosDeVida = jugadorNumeroDos.obtenerPuntosDeVida();
		return Integer.toString(puntosDeVida);
	}
	
	private void rellenarListaDeNombres(LinkedList<String> nombres, int tamaño) {
		
		for(int i = nombres.size() ; i < tamaño ; i++) nombres.add("Vacio");
	}

	public LinkedList<String> obtenerArregloDe5CartasMagiaTrampaRival() {
		
		int tamañoEsperado = 5;
		
		LinkedList<String> nombres = this.jugadorRival.obtenerNombresDeCartaMagiaBocaArriba();
		nombres.addAll(this.jugadorRival.obtenerNombresDeCartaTrampaBocaArriba());
		
		if(nombres.size() < tamañoEsperado) rellenarListaDeNombres(nombres,tamañoEsperado);
		
		return nombres;
	}

	public LinkedList<String> obtenerArregloDe5CartasMonstruoRival() {
		
		int tamañoEsperado = 5;
		
		LinkedList<String> nombres = this.jugadorRival.obtenerNombresDeCartasMonstruoBocaArriba();
		
		if(nombres.size() < tamañoEsperado) rellenarListaDeNombres(nombres,tamañoEsperado);
	
		return nombres;
	}

	public LinkedList<String> obtenerArregloDe5CartasMonstruoJugadorActual() {
		
		int tamañoEsperado = 5;
		
		LinkedList<String> nombres = this.jugadorActual.obtenerNombresDeCartasMonstruoBocaArriba();
		
		if(nombres.size() < tamañoEsperado) rellenarListaDeNombres(nombres,tamañoEsperado);
	
		return nombres;
	}

	public LinkedList<String> obtenerArregloDe5CartasMagiaTrampaJugadorActual() {
		
		int tamañoEsperado = 5;
		
		LinkedList<String> nombres = this.jugadorActual.obtenerNombresDeCartaMagiaBocaArriba();
		
		nombres.addAll(this.jugadorActual.obtenerNombresDeCartaTrampaBocaArriba());
		
		if(nombres.size() < tamañoEsperado) rellenarListaDeNombres(nombres,tamañoEsperado);
		
		return nombres;
		
	}

	public LinkedList<String> obtenerArregloDe10CartasEnLaManoDelJugadorActual() {
		
		int tamañoEsperado = 10;
		
		LinkedList<String> nombres = this.jugadorActual.obtenerNombresDeCartaEnLaMano();
		
		if(nombres.size() < tamañoEsperado) rellenarListaDeNombres(nombres,tamañoEsperado);
	
		return nombres;
	}
	
	private String concatenarNombresDeCartas(LinkedList<String> nombres) {
		
		String nombresConcatenados = " ";
		
		for(int i = 0 ; i < nombres.size() ; i++) {
			
			nombresConcatenados = nombresConcatenados + nombres.get(i) + " / ";
		}
		if (nombresConcatenados.isEmpty()) nombresConcatenados = "NoHayCartas";
		
		return nombresConcatenados;
	}

	public String nombresConcatenadosCartasManoJugadorActual() {
		
		return(concatenarNombresDeCartas(this.jugadorActual.obtenerNombresDeCartaEnLaMano()));
	}

	public String nombresConcatenadosCartasMagicasJugadorActual() {
		
		return (concatenarNombresDeCartas(this.jugadorActual.obtenerNombresDeCartaMagia()));
	}

	public String nombresConcatenadosCartasMonstruoEnCampoJugadorActual() {
	
		return (concatenarNombresDeCartas(this.jugadorActual.obtenerNombresDeCartasMonstruo()));
	}

	public String nombresConcatenadosCartasMonstruoEnCampoRival() {
	
		return (concatenarNombresDeCartas(this.jugadorRival.obtenerNombresDeCartasMonstruo()));
	}	

}

