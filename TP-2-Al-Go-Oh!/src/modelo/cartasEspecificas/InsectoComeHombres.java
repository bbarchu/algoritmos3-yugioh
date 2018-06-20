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

	public void recibirAtaque(CartaMonstruo otraCarta) {
		
		if(!this.estaBocaArriba()) {
			
			otraCarta.destruirCarta();
			super.voltearCarta();
		}
		
		else super.recibirAtaque(otraCarta);
	}
	
	public void voltearCarta() {
		
		super.voltearCarta();
		
		this.jugador.obtenerJugadorRival().obtenerCampoDeBatalla().destruirUnMonstruo();
		
	}
}
