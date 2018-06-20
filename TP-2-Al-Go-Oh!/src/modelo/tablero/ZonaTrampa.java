package modelo.tablero;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;

public class ZonaTrampa extends Zona {

	 public ZonaTrampa(int cantidadMaximaCartasMagia){
			super (cantidadMaximaCartasMagia);
	}
	 
	public void activarCartaTrampa(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		CartaTrampa cartaTrampa = obtenerPrimerCartaTrampa();
		
		cartaTrampa.activarEfecto(atacante, atacado);
	}
	
	public void desactivarCartaTrampa(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		CartaTrampa cartaTrampa = obtenerPrimerCartaTrampa();
		
		cartaTrampa.desactivarEfecto(atacante, atacado);
	}
	
	private CartaTrampa obtenerPrimerCartaTrampa() {
		
		int posicionPrimerCarta = 0; 
		
		CartaTrampa carta = (CartaTrampa) this.verCartas().get(posicionPrimerCarta);
		
		return carta;
	}
}
