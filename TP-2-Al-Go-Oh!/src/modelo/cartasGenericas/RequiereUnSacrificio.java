package modelo.cartasGenericas;

import modelo.tablero.CampoDeBatalla;

public class RequiereUnSacrificio extends Sacrificio {
	
	private static int cantidadDeSacrificios = 1;

	@Override
	public void sacrificarDeSerNecesario(CampoDeBatalla campoDeBatalla) {
		
		// Lucas: esto debe convertirse en un supuesto o modelar mejor el comportamiento
		//		Comportamiento actual: se destruye el monstruo mas antiguo sobre el campo (posicion 0)
		
		/* Bar: Agrego esto para  cuando modifiquemos la parte de interfaz. Agregue las funciones necesarias.
		 String nombreMonstruoADestruir1;
		String nombreMonstruoADestruir2;

		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 nombreMonstruoADestruir1 = entradaEscaner.nextLine();
		 CartaMonstruo monstruoADestruir1 = campoDeBatalla.buscarMonstruoParaSacrificar(nombreMonstruoADestruir1);
		 
		
		campoDeBatalla.destruir(monstruoADestruir1);
		*/
			
			campoDeBatalla.destruirUnMonstruo();

	}
	
	@Override
	public boolean sePuedeRealizarElSacrificio(CampoDeBatalla campoDeBatalla) {
		
		return (super.hayLaCantidadDeMonstruosNecesarios(campoDeBatalla, cantidadDeSacrificios));
	}

}
