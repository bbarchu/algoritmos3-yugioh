package Application;

/*public class AlGoOh {
	
	// Lucas: la forma de guardar el campo la estuvimos discutiendo con Franco pero no decidimos nada
	
//	Campo campoJugador1;
	Campo campoJugador2;
	
	
	public AlGoOh() {
//		campoJugador1 = new Campo();
//		campoJugador2 = new Campo();
	}
}*/


public class AlGoOh {
	Jugador jugadorNumeroUno;
	jugador jugadorNumeroDos;
	CampoDeBatalla campoJugador1;
	CampoDeBatalla campojugador2;
	
	AlgoOh(){
		
		jugadorNumeroUno = new Jugador();
		jugadorNumeroDos = new Jugador();
		campoJugador1 = new CampoDeBatalla();
		campoJugador2 = new CampoDeBatalla();
	}
	

}

