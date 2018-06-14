package Application;

import java.util.ArrayList;

public abstract class Zona {
	
	protected ArrayList<Carta> cartas;
	int capacidad;
	int cantidadDeCartas;
	
	public Zona(int unaCapacidad) {
		cartas = new ArrayList<Carta>();
		capacidad = unaCapacidad;
		cantidadDeCartas = 0;
	}
	
	public Zona() {
		int capacidadMaximaDefault = 100;
		cartas = new ArrayList<Carta>();
		capacidad = capacidadMaximaDefault;
		cantidadDeCartas = 0;
	}
	
	public void agregarCarta (Carta carta) {
		if(cantidadDeCartas <= capacidad) {
			cartas.add(carta);
			cantidadDeCartas++;
		}
	}
	
	public boolean contiene (Carta unaCarta){
		return (cartas.contains(unaCarta));
	}
	
	public void eliminarCarta(Carta carta) {
		
		if(estaVacio()) {
			//lanzar excepcion
		}
		
		cartas.remove(carta);
/*		if (!cartas.remove(carta)) {
			throw new NoSeEncontroLaCartaEnLaZonaError();
		}
*/	}

	public boolean estaVacio() {
		return cartas.isEmpty();
	}
	
	public Carta eliminarCartaMasAntigua() {
		
		if(estaVacio()) {
			//lanzar excepcion
		}
		
		Carta cartaAEliminar = cartas.get(0);
		this.cartas.remove(0);
		return (cartaAEliminar);
	}
}
