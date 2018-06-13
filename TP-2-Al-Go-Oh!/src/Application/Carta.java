package Application;

public abstract class Carta {

	public abstract void colocateEn(CampoDeBatalla campoDeBatalla);

	public abstract boolean estaBocaArriba();
	
	public abstract void activarEfecto(CampoDeBatalla unCampo, CampoDeBatalla otroCampo);
//	protected static CampoDeBatalla campoDeJuego;
//	protected Carta() {	
//		campoDeJuego = new CampoDeBatalla();
//	}

}

