package Application;

public class RequiereUnSacrificio extends Sacrificio {

	@Override
	public void sacrificarDeSerNecesario(CampoDeBatalla campoDeBatalla) {
		
		// Lucas: esto debe convertirse en un supuesto o modelar mejor el comportamiento
		//		Comportamiento actual: se destruye el monstruo mas antiguo sobre el campo (posicion 0)
		campoDeBatalla.destruirUnMonstruo();
	}

}
