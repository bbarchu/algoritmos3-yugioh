package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.jugador.JugadorModificable;
import modelo.tablero.CampoDeBatalla;

public class CartaCampo extends Carta {
	
	// Efecto que abarca a todo el campo, camo amigo y campo enemigo, bar.
	//Cuando se destrute una carta de campo? ya que no dice nada al respecto, no tiene un unico uso.
	protected JugadorModificable jugador;
	protected String nombre;
	
	public CartaCampo(Jugador unJugador) {
		this.jugador = unJugador;
		this.nombre = "";
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);		
	}

	/*public void invocate(Jugador jugador) {
		jugador.invocar(this);
	}*/
	
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
		
		//Podes activar el efecto desde la mano colocandolas boca arriba! Siempre estan boca arriba, bar.
	}
	
	public void activarEfecto() {
		
	}
/*	public void invocar() {
	
	}
	
	public boolean estaBocaArriba() {
		
		return true;
	}
*/

	@Override
	public String getNombre() {
		return nombre;
	}
}
