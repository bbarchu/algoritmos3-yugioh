package Application;

public abstract class Carta {

	protected static Campo campoDeJuego;
	
	protected Carta() {
		
		campoDeJuego = new Campo();
	}
	
	public abstract void invocar(Estado estadoDeLaInvocacion);
}
