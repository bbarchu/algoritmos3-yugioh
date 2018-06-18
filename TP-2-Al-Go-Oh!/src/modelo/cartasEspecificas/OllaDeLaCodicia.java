package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.Estado;
import modelo.jugador.Jugador;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia(Estado unEstado, Jugador unJugador) {
		super(unEstado, unJugador);
	}
	
	@Override
	public void activarEfecto() {
		this.jugador.tomarCartaDelMazo();
		this.jugador.tomarCartaDelMazo();
	}
}
