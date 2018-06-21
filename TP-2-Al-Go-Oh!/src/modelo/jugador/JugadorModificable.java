package modelo.jugador;

import modelo.tablero.CampoDeBatalla;

public interface JugadorModificable {
	
	public CampoDeBatalla obtenerCampoDeBatalla();
	
	public void restarVida(int decrementoVida);
	
	public OponenteAtacable obtenerJugadorRival();
	
	public void tomarCartaDelMazo();
}
