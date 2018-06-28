package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.Estado;
import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class AgujeroNegro extends CartaMagica {
	

	public AgujeroNegro(Estado unEstado, Jugador unJugador) {
		
		super(unEstado, unJugador);
	}
	
	public AgujeroNegro(String nombreDeLaCarta, Estado unEstado, Jugador unJugador) {
		
		super(nombreDeLaCarta,unEstado, unJugador);
	}
	
	@Override
	public void activarEfecto() {
		
		CampoDeBatalla unCampo = this.jugador.obtenerCampoDeBatalla();
		CampoDeBatalla otroCampo = (this.jugador.obtenerJugadorRival()).obtenerCampoDeBatalla();
		
		unCampo.activarEfectoDe(this);
		otroCampo.activarEfectoDe(this);
	}

}
