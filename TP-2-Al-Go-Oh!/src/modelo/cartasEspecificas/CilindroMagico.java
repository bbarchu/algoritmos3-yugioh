package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.cartasGenericas.Estado;
import modelo.cartasGenericas.ModoDeUso;
import modelo.cartasGenericas.ModoInhabilitada;
import modelo.jugador.Jugador;

public class CilindroMagico extends CartaTrampa{
	private ModoDeUso modoAtacanteAnterior;
	private ModoDeUso modoAtacadaAnterior;
	private CartaMonstruo cartaAtacada;
	private CartaMonstruo cartaAtacante;

	public CilindroMagico() {
		super();
	}
	
	private void inhabilitarCarta(CartaMonstruo carta) {
		carta.cambiarModoDeUso(new ModoInhabilitada());
	}
	
	private void habilitarCarta(CartaMonstruo carta, ModoDeUso modo) {
		carta.cambiarModoDeUso(modo);
	}
	
	public void activarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
		this.cartaAtacada = atacado;
		this.cartaAtacante = atacante;
		
		int puntosDeAtaque = atacante.obtenerPuntosDeAtaque();
		atacante.restarVidaAJugador(puntosDeAtaque);
		
		this.modoAtacanteAnterior = atacante.getModoDeUsoActual();
		this.modoAtacadaAnterior = atacante.getModoDeUsoActual();
		
		this.inhabilitarCarta(atacante);
		this.inhabilitarCarta(atacado);		
	}
	
	public void desacrivarEfecto() {
		this.habilitarCarta(cartaAtacada, modoAtacadaAnterior);
		this.habilitarCarta(cartaAtacante, modoAtacanteAnterior);
	}
	
}
