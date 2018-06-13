package Application;

public class AgujeroNegro extends CartaMagica {

	public AgujeroNegro(Estado unEstado) {
		
		super(unEstado);
	}
	
	public void activarEfecto(CampoDeBatalla unCampo, CampoDeBatalla otroCampo) {
		
		unCampo.activarEfectoDe(this);
		otroCampo.activarEfectoDe(this);
	}

}
