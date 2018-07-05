package modelo.cartasGenericas;

import modelo.tablero.CampoDeBatalla;

public class RequiereUnSacrificio extends Sacrificio {
	
	private static int cantidadDeSacrificios = 1;

	@Override
	public void sacrificarDeSerNecesario(CampoDeBatalla campoDeBatalla) {
		

		//	Comportamiento actual: se destruye el monstruo mas antiguo sobre el campo (posicion 0)
		
			
			campoDeBatalla.destruirUnMonstruo();

	}
	
	@Override
	public boolean sePuedeRealizarElSacrificio(CampoDeBatalla campoDeBatalla) {
		
		return (super.hayLaCantidadDeMonstruosNecesarios(campoDeBatalla, cantidadDeSacrificios));
	}

}
