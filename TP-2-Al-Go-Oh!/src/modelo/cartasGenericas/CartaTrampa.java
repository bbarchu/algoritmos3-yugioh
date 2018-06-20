package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class CartaTrampa extends Carta{
	
	Estado estado;
	protected String nombre;
	

	public CartaTrampa(){
				
		this.estado = new BocaAbajo();
		this.nombre = "";
	}
	
	public void activarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
		
	}
	
	public void voltearCarta() {
		
		this.estado = new BocaArriba();
	}
	
	public void desactivarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
		
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
	
	public String getNombre() {
		return this.nombre;
	}
	
/*	public void invocar() {
	
		campoDeJuego.invocar(this);
	}
	
	public boolean estaBocaArriba() {
		
		return (estado.estaActiva());
	}
*/
}
