package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoDeUso;
import modelo.jugador.Jugador;

public class InsectoComeHombres extends CartaMonstruo{
	
	private static int puntosDeAtaque = 450;
	private static int puntosDeDefensa = 600;
	private static int estrellas = 2;
	
	public InsectoComeHombres(ModoDeUso modo, Jugador jugador) {
		
		super(puntosDeAtaque, puntosDeDefensa, estrellas, modo, jugador);
	}

	public void recibirPuntosAtaque(CartaMonstruo otraCarta) {
		
		if(!this.estaBocaArriba()) otraCarta.destruirCarta();
		
		else super.recibirPuntosAtaque(otraCarta);
	}
	
//	public void voltearCarta() {
//		
//		super.voltearCarta();
//		
//	}
}
