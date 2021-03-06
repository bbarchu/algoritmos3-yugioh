package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.cartasGenericas.ModoDeUso;
import modelo.cartasGenericas.ModoInhabilitada;

public class CilindroMagico extends CartaTrampa{
	private ModoDeUso modoAtacanteAnterior;
	private ModoDeUso modoAtacadaAnterior;
	private CartaMonstruo cartaAtacada;
	private CartaMonstruo cartaAtacante;

	public CilindroMagico() {
		super();
	}
	
	public CilindroMagico(String nombreDeLaCarta) {
		super(nombreDeLaCarta);
	}
	
	private void inhabilitarCarta(CartaMonstruo carta) {
		carta.cambiarModoDeUso(new ModoInhabilitada());
	}
	
	private void habilitarCarta(CartaMonstruo carta, ModoDeUso modo) {
		carta.cambiarModoDeUso(modo);
	}
	
	public void activarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		super.voltearCarta();
		
		this.cartaAtacada = atacado;
		this.cartaAtacante = atacante;
		
		int puntosDeAtaque = atacante.obtenerPuntosDeAtaque();
		atacante.restarVidaAJugador(puntosDeAtaque);
		
		this.modoAtacanteAnterior = atacante.getModoDeUsoActual();
		this.modoAtacadaAnterior = atacante.getModoDeUsoActual();
		
		this.inhabilitarCarta(atacante);
		this.inhabilitarCarta(atacado);		
	}
	
	public void desactivarEfecto() {
		this.habilitarCarta(cartaAtacada, modoAtacadaAnterior);
		this.habilitarCarta(cartaAtacante, modoAtacanteAnterior);
	}
	
}
