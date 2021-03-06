package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoDeUso;
import modelo.jugador.Jugador;
import modelo.jugador.OponenteAtacable;

public class Jinzo7 extends CartaMonstruo{
	private static int puntosDeAtaque = 500;
	private static int puntosDeDefensa = 400;
	private static int estrellas = 2;

	public Jinzo7 (ModoDeUso unModo, Jugador unJugador) {
		super(puntosDeAtaque, puntosDeDefensa, estrellas, unModo, unJugador,"Jinzo7");
	}
	
	public void atacarDirectoAlJugadorRival() {
		OponenteAtacable rival = this.jugador.obtenerJugadorRival();
		modo.atacarDirectamente(this, rival);
		
	}
}
