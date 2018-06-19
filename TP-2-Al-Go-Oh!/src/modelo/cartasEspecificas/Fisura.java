package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.Estado;
import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class Fisura extends CartaMagica{
	
public Fisura(Estado unEstado, Jugador unJugador) {
		
		super(unEstado, unJugador);
	}
	
	public void activarEfecto() {
		
		CampoDeBatalla otroCampo = this.jugador.obtenerJugadorRival().obtenerCampoDeBatalla();
	
		otroCampo.activarEfectoDe(this);
	}
}
