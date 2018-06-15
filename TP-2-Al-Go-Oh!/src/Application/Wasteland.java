package Application;

public class Wasteland extends CartaCampo {
	
	public void activarEfecto() {
		
		CampoDeBatalla unCampo = this.jugador.obtenerCampoDeBatalla();
		CampoDeBatalla otroCampo = this.jugador.obtenerJugadorRival().obtenerCampoDeBatalla();
		
		unCampo.activarEfectoDe(this);
		otroCampo.activarEfectoContrarioDe(this);
	}

}
