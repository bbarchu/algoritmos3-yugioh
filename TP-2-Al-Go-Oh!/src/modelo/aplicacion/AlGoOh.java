package modelo.aplicacion;

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
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDefensa;
import modelo.jugador.Jugador;

public class AlGoOh {
	
	Jugador jugadorNumeroUno;
	Jugador jugadorNumeroDos;
	
	public AlGoOh(){
		
		//creacion de jugadores.
		jugadorNumeroUno = new Jugador();
		jugadorNumeroDos = new Jugador();
		
		BocaAbajo bocaAbajo = new BocaAbajo();
		BocaArriba bocaArriba = new BocaArriba();
		
		ModoAtaque modoAtaque = new ModoAtaque();
		ModoDefensa modoDefensa = new ModoDefensa();
		
		//1° carta AgujeroOscuro
		
		AgujeroNegro agujeroNegroUno = new AgujeroNegro("AgujeroOscuro",bocaAbajo,jugadorNumeroUno);
		AgujeroNegro agujeroNegroDos = new AgujeroNegro("AgujeroOscuro",bocaAbajo,jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(agujeroNegroUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(agujeroNegroDos);
		
		//2° carta BrazoDerechoDelProhibido
		
		CartaMonstruo brazoDerechoDelProhibidoUno = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroUno, "BrazoDerechoDelProhibido");
		CartaMonstruo brazoDerechoDelProhibidoDos = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroDos, "BrazoDerechoDelProhibido");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(brazoDerechoDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(brazoDerechoDelProhibidoDos);
		
		//3° carta BrazoIzquierdoDelProhibido
		
		CartaMonstruo brazoIzquierdoDelProhibidoUno = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroUno,"BrazoIzquierdoDelProhibido");
		CartaMonstruo brazoIzquierdoDelProhibidoDos = new CartaMonstruo(200,300,1,modoAtaque,jugadorNumeroDos,"BrazoIzquierdoDelProhibido");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(brazoIzquierdoDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(brazoIzquierdoDelProhibidoDos);
		
		//4° carta BueyDeBatalla
		
		CartaMonstruo bueyDeBatallaUno = new CartaMonstruo(1700,1000,4,modoAtaque,jugadorNumeroUno,"BueyDeBatalla");
		CartaMonstruo bueyDeBatallaDos = new CartaMonstruo(1700,1000,4,modoAtaque,jugadorNumeroDos,"BueyDeBatalla");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(bueyDeBatallaUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(bueyDeBatallaDos);
		
		//5° carta CaballoDeMar
		
		CartaMonstruo caballoDeMarUno = new CartaMonstruo(1700,1650,4,modoAtaque,jugadorNumeroUno,"CaballoDeMar");
		CartaMonstruo caballoDeMarDos = new CartaMonstruo(1700,1650,4,modoAtaque,jugadorNumeroDos,"CaballoDeMar");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(caballoDeMarUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(caballoDeMarDos);
		
		//6° carta CilindroMagico
		
		CilindroMagico cilindroMagicoUno = new CilindroMagico("CilindroMagico");
		CilindroMagico cilindroMagicoDos = new CilindroMagico("CilindroMagico");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(cilindroMagicoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(cilindroMagicoDos);
		
		//7° carta Craneo
		
		CartaMonstruo craneoUno = new CartaMonstruo(2500,1200,6,modoAtaque,jugadorNumeroUno,"Craneo");
		CartaMonstruo craneoDos = new CartaMonstruo(2500,1200,6,modoAtaque,jugadorNumeroDos,"Craneo");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(craneoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(craneoDos);
		
		//8° carta DarkMaster
		
		CartaMonstruo darkMasterUno = new CartaMonstruo(30000, 30000, 12, modoAtaque, jugadorNumeroUno, "DarkMaster");
		CartaMonstruo darkMasterDos = new CartaMonstruo(30000, 30000, 12, modoAtaque, jugadorNumeroDos, "DarkMaster");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(darkMasterUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(darkMasterDos);
		
		//9° carta DemonioElemental
		
		CartaMonstruo demonioElementalUno = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroUno,"DemonioElemental");
		CartaMonstruo demonioElementalDos = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroDos,"DemonioElemental");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(demonioElementalUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(demonioElementalDos);
		
		//10° carta DragonArmadoOscuro
		
		CartaMonstruo dorsoUno = new CartaMonstruo(2800,1000,7,modoAtaque,jugadorNumeroUno,"DragonArmadoOscuro");
		CartaMonstruo dorsoDos = new CartaMonstruo(2800,1000,7,modoAtaque,jugadorNumeroDos,"DragonArmadoOscuro");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dorsoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dorsoDos);
		
		//11° carta DragonBlancoDeOjosAzules
		
		CartaMonstruo dragonBlancoDeOjosAzulesUno = new CartaMonstruo(3000,2500,8,modoAtaque,jugadorNumeroUno,"DragonBlancoDeOjosAzules");
		CartaMonstruo dragonBlancoDeOjosAzulesDos = new CartaMonstruo(3000,2500,8,modoAtaque,jugadorNumeroDos,"DragonBlancoDeOjosAzules");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonBlancoDeOjosAzulesUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonBlancoDeOjosAzulesDos);
		
		//12° carta DragonDeCuernoBlanco
		
		CartaMonstruo dragonDeCuernoBlancoUno = new CartaMonstruo(2200,1400,6,modoAtaque,jugadorNumeroUno,"DragonDeCuernoBlanco");
		CartaMonstruo dragonDeCuernoBlancoDos = new CartaMonstruo(2200,1400,6,modoAtaque,jugadorNumeroDos,"DragonDeCuernoBlanco");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonDeCuernoBlancoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonDeCuernoBlancoDos);
		
		//13° carta DragonDeLaMuerte
		
		CartaMonstruo dragonDeLaMuerteUno = new CartaMonstruo(1550,1600,3,modoAtaque,jugadorNumeroUno,"DragonDeLaMuerte");
		CartaMonstruo dragonDeLaMuerteDos = new CartaMonstruo(1550,1600,3,modoAtaque,jugadorNumeroDos,"DragonDeLaMuerte");

		this.jugadorNumeroUno.agregarCartaAlMazo(dragonDeLaMuerteUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonDeLaMuerteDos);
		
		//14° carta DragonDeOjosAzulesDefinitivo
		
		DragonDefinitivoDeOjosAzules dragonDefinitivoDeOjosAzulesUno= new DragonDefinitivoDeOjosAzules(modoAtaque,jugadorNumeroUno);
		DragonDefinitivoDeOjosAzules dragonDefinitivoDeOjosAzulesDos= new DragonDefinitivoDeOjosAzules(modoAtaque,jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonDefinitivoDeOjosAzulesUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonDefinitivoDeOjosAzulesDos);
		
		//15° carta DragonElemental
		
		CartaMonstruo dragonElementalUno = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroUno,"DragonElemental");
		CartaMonstruo dragonElementalDos = new CartaMonstruo(1500,1200,4,modoAtaque,jugadorNumeroDos,"DragonElemental");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(dragonElementalUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(dragonElementalDos);
		
		//16° carta ExodiaElProhibido
		
		CartaMonstruo exodiaElProhibidoUno = new CartaMonstruo(1000,1000,3,modoAtaque,jugadorNumeroUno,"ExodiaElProhibido");
		CartaMonstruo exodiaElProhibidoDos = new CartaMonstruo(1000,1000,3,modoAtaque,jugadorNumeroDos,"ExodiaElProhibido");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(exodiaElProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(exodiaElProhibidoDos);
		
		//17° carta Fisura
		
		Fisura fisuraUno = new Fisura(bocaAbajo,jugadorNumeroUno);
		Fisura fisuraDos = new Fisura(bocaAbajo,jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(fisuraUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(fisuraDos);
		
		//18° carta Girochin
		
		CartaMonstruo girochinUno = new CartaMonstruo(1700, 1000, 4, modoAtaque, jugadorNumeroUno,"Girochin");
		CartaMonstruo girochinDos = new CartaMonstruo(1700, 1000, 4, modoAtaque, jugadorNumeroDos,"Girochin");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(girochinUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(girochinDos);
		
		//19° carta GuardianDeLaPuerta
		
		CartaMonstruo guardianDeLaPuertaUno = new CartaMonstruo(3750, 3400, 11, modoAtaque, jugadorNumeroUno, "GuardianDeLaPuerta");
		CartaMonstruo guardianDeLaPuertaDos = new CartaMonstruo(3750, 3400, 11, modoAtaque, jugadorNumeroDos, "GuardianDeLaPuerta");
	
		this.jugadorNumeroUno.agregarCartaAlMazo(guardianDeLaPuertaUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(guardianDeLaPuertaDos);
		
		//20° carta HaneHane
		
		CartaMonstruo haneHaneUno = new CartaMonstruo(450, 500, 2, modoAtaque, jugadorNumeroUno, "HaneHane");
		CartaMonstruo haneHaneDos = new CartaMonstruo(450, 500, 2, modoAtaque, jugadorNumeroDos, "HaneHane");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(haneHaneUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(haneHaneDos);
		
		//21° carta HojaOscura
		
		CartaMonstruo hojaOscuraUno = new CartaMonstruo(1800, 1500, 4, modoAtaque, jugadorNumeroUno, "HojaOscura");
		CartaMonstruo hojaOscuraDos = new CartaMonstruo(1800, 1500, 4, modoAtaque, jugadorNumeroDos, "HojaOscura");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(hojaOscuraUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(hojaOscuraDos);
		
		//22° carta InsectoComeHombres
		
		InsectoComeHombres insectoUno = new InsectoComeHombres(modoAtaque, jugadorNumeroUno);
		InsectoComeHombres insectoDos = new InsectoComeHombres(modoAtaque, jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(insectoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(insectoDos);
		
		//23° carta JineteMistico
		
		CartaMonstruo jineteUno = new CartaMonstruo(1300, 1550, 4, modoAtaque, jugadorNumeroUno, "JineteMistico");
		CartaMonstruo jineteDos = new CartaMonstruo(1300, 1550, 4, modoAtaque, jugadorNumeroDos, "JineteMistico");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(jineteUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(jineteDos);
		
		//24° carta Jinzo7
		
		Jinzo7 jinzoUno = new Jinzo7(modoAtaque, jugadorNumeroUno);
		Jinzo7 jinzoDos = new Jinzo7(modoAtaque, jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(jinzoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(jinzoDos);
		
		//25° carta Kuriboh
		
		CartaMonstruo kuribohUno = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroUno, "Kuriboh");
		CartaMonstruo kuribohDos = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroDos, "Kuriboh");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(kuribohUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(kuribohDos);
		
		//26° carta KuribohAlado
		
		CartaMonstruo kuribohAladoUno = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroUno, "KuribohAlado");
		CartaMonstruo kuribohAladoDos = new CartaMonstruo(300, 200, 1, modoAtaque, jugadorNumeroDos, "KuribohAlado");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(kuribohAladoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(kuribohAladoDos);
		
		//27° carta LordOfD
		
		CartaMonstruo lordUno = new CartaMonstruo(1200, 1100, 4, modoAtaque, jugadorNumeroUno, "LordOfD");
		CartaMonstruo lordDos = new CartaMonstruo(1200, 1100, 4, modoAtaque, jugadorNumeroDos, "LordOfD");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(lordUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(lordDos);
		
		//28° carta MagoOscuro
		
		CartaMonstruo magoOscuroUno = new CartaMonstruo(2500, 2100, 7, modoAtaque, jugadorNumeroUno, "MagoOscuro");
		CartaMonstruo magoOscuroDos = new CartaMonstruo(2500, 2100, 7, modoAtaque, jugadorNumeroDos, "MagoOscuro");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(magoOscuroUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(magoOscuroDos);
		
		//29° carta Obelisk
		
		CartaMonstruo obeliskUno = new CartaMonstruo(4000, 4000, 10, modoAtaque, jugadorNumeroUno, "Obelisk");
		CartaMonstruo obeliskDos = new CartaMonstruo(4000, 4000, 10, modoAtaque, jugadorNumeroDos, "Obelisk");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(obeliskUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(obeliskDos);
		
		//30° carta OgroGrotto
		
		CartaMonstruo ogroUno = new CartaMonstruo(800, 1200, 3, modoAtaque,jugadorNumeroUno, "OgroGrotto");
		CartaMonstruo ogroDos = new CartaMonstruo(800, 1200, 3, modoAtaque,jugadorNumeroDos, "OgroGrotto");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(ogroUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(ogroDos);
		
		//31° carta OllaDeLaCodicia
		
		OllaDeLaCodicia ollaUno = new OllaDeLaCodicia(bocaAbajo, jugadorNumeroUno);
		OllaDeLaCodicia ollaDos = new OllaDeLaCodicia(bocaAbajo, jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(ollaUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(ollaDos);
		
		//32° carta PiernaDerechaDelProhibido
		
		CartaMonstruo piernaDerechaDelProhibidoUno = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroUno, "PiernaDerechaDelProhibido");
		CartaMonstruo piernaDerechaDelProhibidoDos = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroDos, "PiernaDerechaDelProhibido");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(piernaDerechaDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(piernaDerechaDelProhibidoDos);
		
		//33° carta PiernaIzquierdaDelProhibido
		
		CartaMonstruo piernaIzquierdaDelProhibidoUno = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroUno, "PiernaIzquierdaDelProhibido");
		CartaMonstruo piernaIzquierdaDelProhibidoDos = new CartaMonstruo(200, 300, 1, modoAtaque, jugadorNumeroDos, "PiernaIzquierdaDelProhibido");
			
		this.jugadorNumeroUno.agregarCartaAlMazo(piernaIzquierdaDelProhibidoUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(piernaIzquierdaDelProhibidoDos);
		
		//34° carta Reinforcements
		
		Reinforcements reinforcementsUno = new Reinforcements();
		Reinforcements reinforcementsDos = new Reinforcements();
		
		this.jugadorNumeroUno.agregarCartaAlMazo(reinforcementsUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(reinforcementsDos);
		
		//35° carta Ryu
		
		CartaMonstruo ryuUno = new CartaMonstruo(1600, 1200, 4, modoAtaque, jugadorNumeroUno, "Ryu");
		CartaMonstruo ryuDos = new CartaMonstruo(1600, 1200, 4, modoAtaque, jugadorNumeroDos, "Ryu");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(ryuUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(ryuDos);
		
		//36° carta Segadora
		
		CartaMonstruo segadoraUno = new CartaMonstruo(1380, 1930, 5, modoAtaque, jugadorNumeroUno, "Segadora");
		CartaMonstruo segadoraDos = new CartaMonstruo(1380, 1930, 5, modoAtaque, jugadorNumeroDos, "Segadora");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(segadoraUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(segadoraDos);
		
		//37° carta Slifer
		
		CartaMonstruo sliferUno = new CartaMonstruo(20000,20000, 10, modoAtaque, jugadorNumeroUno,"Slifer");
		CartaMonstruo sliferDos = new CartaMonstruo(20000,20000, 10, modoAtaque, jugadorNumeroDos, "Slifer");
		
		this.jugadorNumeroUno.agregarCartaAlMazo(sliferUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(sliferDos);
		
		//38° carta Sogen
		
		Sogen sogenUno = new Sogen(jugadorNumeroUno);
		Sogen sogenDos = new Sogen(jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(sogenUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(sogenDos);
		
		//39° carta Wasteland
		
		Wasteland wastelandUno = new Wasteland(jugadorNumeroUno);
		Wasteland wastelandDos = new Wasteland(jugadorNumeroDos);
		
		this.jugadorNumeroUno.agregarCartaAlMazo(wastelandUno);
		this.jugadorNumeroDos.agregarCartaAlMazo(wastelandUno);
		
	}	

}

