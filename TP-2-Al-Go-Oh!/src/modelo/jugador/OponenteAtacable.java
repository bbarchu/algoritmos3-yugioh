package modelo.jugador;

import modelo.tablero.CampoDeBatalla;

public interface OponenteAtacable {

	public CampoDeBatalla obtenerCampoDeBatalla();
	
	public void restarVida(int decrementoVida);
}
