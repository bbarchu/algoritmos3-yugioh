package modelo.cartasGenericas;

import modelo.tablero.CampoDeBatalla;

public abstract class Sacrificio {

	public abstract void sacrificarDeSerNecesario(CampoDeBatalla campoDeBatalla);

	public abstract boolean sePuedeRealizarElSacrificio(CampoDeBatalla campoDeBatalla);
	
	protected boolean hayLaCantidadDeMonstruosNecesarios(CampoDeBatalla campoDeBatalla, int cantidadDeSacrificios) {
		
		boolean sePuedeRealizarElSacrificio = false;
		
		if(campoDeBatalla.obtenerCantidadDeMonstruosEnElCampo() >= cantidadDeSacrificios) sePuedeRealizarElSacrificio = true;
	
		return sePuedeRealizarElSacrificio;
	}
	
}