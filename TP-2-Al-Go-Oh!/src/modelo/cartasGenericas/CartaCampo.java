package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.jugador.JugadorModificable;
import modelo.tablero.CampoDeBatalla;

public class CartaCampo extends Carta {
	

	protected JugadorModificable jugador;

	
	public CartaCampo(Jugador unJugador) {
		this.jugador = unJugador;
		this.nombre = "";
	}
	
	public CartaCampo(Jugador unJugador, String nombreDeLaCarta) {
		this.jugador = unJugador;
		this.nombre = nombreDeLaCarta;
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);		
	}

	
	@Override
	public void invocate(Jugador jugador) {
		jugador.invocar(this);
	}

	@Override
	public void destruite(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.destruir(this);
	}

	@Override
	public boolean estaBocaArriba() {
		return true;
		
	}
	
	public void activarEfecto() {
		
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void voltearCarta() {
		
		
	}

	@Override
	public boolean verificarQueEsteInvocadaEn(CampoDeBatalla campo) {
		
		return (campo.verificarQueEstaEnElCampo(this));
	}
}
