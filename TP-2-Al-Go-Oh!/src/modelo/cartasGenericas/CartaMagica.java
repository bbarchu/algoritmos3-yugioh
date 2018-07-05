package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.jugador.JugadorModificable;
import modelo.tablero.CampoDeBatalla;

public class CartaMagica extends Carta {
	
	private Estado estado;
	protected JugadorModificable jugador;

	
	public CartaMagica(Estado unEstado, Jugador unJugador) {
		
		this.estado = unEstado;
		this.jugador = unJugador;
		this.nombre = "";
	}
	
	public CartaMagica(String nombreDeLaCarta, Estado unEstado, Jugador unJugador) {
		
		this.estado = unEstado;
		this.jugador = unJugador;
		this.nombre = nombreDeLaCarta;
	}
	
	public CartaMagica(Estado unEstado) {
		
		this.estado = unEstado;
		this.nombre = "";
	}
	
	@Override
	public void destruite(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.destruir(this);
	}
	
	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);		
	}


	public boolean estaBocaArriba() {
		
		return (estado.estaActiva());
	}
	
	public void voltearCarta() {
		
		this.estado = new BocaArriba();
		activarEfecto();
		this.destruite(jugador.obtenerCampoDeBatalla());
	}

	public void activarEfecto() {
	}

	@Override
	public void invocate(Jugador unJugador) {
		unJugador.invocar(this);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean verificarQueEsteInvocadaEn(CampoDeBatalla campo) {
		
		return (campo.verificarQueEstaEnElCampo(this));
	}

}
