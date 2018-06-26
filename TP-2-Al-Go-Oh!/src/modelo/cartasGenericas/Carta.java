package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public abstract class Carta {
	
	protected String nombre;
	
	public String getNombre() {
		
		return nombre;
	}

	public abstract void colocateEn(CampoDeBatalla campoDeBatalla);

	public abstract boolean estaBocaArriba();

	public abstract void invocate(Jugador jugador);

	public abstract void destruite(CampoDeBatalla campoDeBatalla);
	
//	public abstract String getNombre();
	
	public abstract void voltearCarta();
	
	public abstract boolean verificarQueEsteInvocadaEn(CampoDeBatalla campo);
	
	
//	public abstract void activarEfecto(CampoDeBatalla unCampo, CampoDeBatalla otroCampo);	
//	protected static CampoDeBatalla campoDeJuego;
//	protected Carta() {	
//		campoDeJuego = new CampoDeBatalla();
//	}

}

