package modelo.cartasGenericas;

import modelo.tablero.CampoDeBatalla;

public class NoRequiereSacrificio extends Sacrificio {

	@Override
	public void sacrificarDeSerNecesario(CampoDeBatalla campoDeBatalla) {
		
	
	}

	@Override
	public boolean sePuedeRealizarElSacrificio(CampoDeBatalla campoDeBatalla) {
		
		return true;
	}

}
