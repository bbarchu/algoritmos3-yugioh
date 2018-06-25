package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.jugador.JugadorModificable;
import modelo.tablero.CampoDeBatalla;

public class CartaMagica extends Carta {
	
	private Estado estado;
	protected JugadorModificable jugador;
	protected String nombre;
	// Efecto
	
	public CartaMagica(Estado unEstado, Jugador unJugador) {
		
		this.estado = unEstado;
		this.jugador = unJugador;
		this.nombre = "";
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

/*	@Override
	public void atacarA(Carta monstruoDelRival) {
		// Deberia lanzar una excepcion ya que una carta de magia no puede atacar.
		
	}
*/	
	public boolean estaBocaArriba() {
		
		return (estado.estaActiva());
	}
	
	public void voltearCarta() {
		
		activarEfecto();
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

}
