package Application;

public class AgujeroNegro extends CartaMagica {

	public AgujeroNegro(Estado unEstado, Jugador unJugador) {
		
		super(unEstado, unJugador);
	}
	
	public void activarEfecto() {
		
		CampoDeBatalla unCampo = this.jugador.obtenerCampoDeBatalla();
		CampoDeBatalla otroCampo = this.jugador.obtenerJugadorRival().obtenerCampoDeBatalla();
		
		unCampo.activarEfectoDe(this);
		otroCampo.activarEfectoDe(this);
	}

}
