package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.cartasGenericas.Estado;

public class Reinforcements extends CartaTrampa {
	
	private static int puntosDeAtaqueIncrementados = 500;
	private CartaMonstruo cartaAtacada;

	public Reinforcements() {
		
		super();	
	}
	
	public void activarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		super.voltearCarta();
		this.cartaAtacada = atacado;
		atacado.aumentarPuntosDeAtaqueEn(puntosDeAtaqueIncrementados);
	}
	
	public void desactivarEfecto() {
		
		this.cartaAtacada.disminuirPuntosDeAtaque(puntosDeAtaqueIncrementados);
		//se tiene que destruir cuando termine el turno, tendra que verse como hacerlo desde
		//el juego
	}

}
