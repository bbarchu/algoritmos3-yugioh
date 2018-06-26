package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaCampo;
import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class Sogen extends CartaCampo {
	
	private static String nombreDeLaCarta = "Sogen";
	
	public Sogen(Jugador unJugador) {
		super(unJugador, nombreDeLaCarta);
	}
	
	public void activarEfecto() {
		
		CampoDeBatalla unCampo = this.jugador.obtenerCampoDeBatalla();
		CampoDeBatalla otroCampo = this.jugador.obtenerJugadorRival().obtenerCampoDeBatalla();
		
		unCampo.activarEfectoDeMi(this);
		otroCampo.activarEfectoContrarioDe(this);
	}

}
