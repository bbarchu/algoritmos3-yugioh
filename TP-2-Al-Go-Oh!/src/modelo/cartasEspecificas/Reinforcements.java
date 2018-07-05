package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;

public class Reinforcements extends CartaTrampa {
	
	private static String nombreDeLaCarta = "Reinforcements";
	private static int puntosDeAtaqueIncrementados = 500;
	private CartaMonstruo cartaAtacada;

	public Reinforcements() {
		
		super(nombreDeLaCarta);	
	}
	
	public void activarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		super.voltearCarta();
		this.cartaAtacada = atacado;
		atacado.aumentarPuntosDeAtaqueEn(puntosDeAtaqueIncrementados);
	}
	
	public void desactivarEfecto() {
		
		this.cartaAtacada.disminuirPuntosDeAtaque(puntosDeAtaqueIncrementados);
		
	}

}
