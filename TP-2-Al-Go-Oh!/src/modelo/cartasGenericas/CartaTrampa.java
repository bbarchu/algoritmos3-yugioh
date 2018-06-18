package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class CartaTrampa extends Carta{
	
	Estado estado;
	// Efecto

	public CartaTrampa(Estado unEstado){
				
		this.estado = unEstado;		
	}
	
	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		// TODO Auto-generated method stub
		campoDeBatalla.colocar(this);
	}

	@Override
	public void invocate(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruite(CampoDeBatalla campoDeBatalla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaBocaArriba() {
		// TODO Auto-generated method stub
		return false;
	}
	
/*	public void invocar() {
	
		campoDeJuego.invocar(this);
	}
	
	public boolean estaBocaArriba() {
		
		return (estado.estaActiva());
	}
*/
}
