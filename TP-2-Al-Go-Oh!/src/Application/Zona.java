package Application;

import java.util.ArrayList;

public abstract class Zona {
	
	private ArrayList<Carta> cartas;
	int capacidad;
	int cantidad;
	
	public Zona() {
		cartas = new ArrayList<Carta>();
	}
	
	public void agregarCarta (Carta carta) {
		cartas.add(carta);
	}
	
	public void eliminarCarta(Carta carta) {
		if (!cartas.remove(carta)) {
			throw new NoSeEncontroLaCartaEnLaZonaError();
		};
	}
}
