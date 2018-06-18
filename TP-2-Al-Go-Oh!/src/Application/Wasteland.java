package Application;

public class Wasteland extends CartaCampo {
	
	public Wasteland(Jugador unJugador) {
		super(unJugador);
	}
	
	public void activarEfecto() {
		
		CampoDeBatalla unCampo = this.jugador.obtenerCampoDeBatalla();
		CampoDeBatalla otroCampo = this.jugador.obtenerJugadorRival().obtenerCampoDeBatalla();
		
		unCampo.activarEfectoDeMi(this);
		otroCampo.activarEfectoContrarioDe(this);
	}

}
