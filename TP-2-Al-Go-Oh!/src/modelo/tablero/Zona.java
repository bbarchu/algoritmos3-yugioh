package modelo.tablero;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.cartasGenericas.Carta;

public abstract class Zona {
	
	protected LinkedList<Carta> cartas;
	int capacidad;
	int cantidadDeCartas;
	Iterator<Carta>iteradorCarta;
	
	public Zona(int unaCapacidad) {
		cartas = new LinkedList<Carta>();
		capacidad = unaCapacidad;
		cantidadDeCartas = 0;
	}
	
	public Zona() {
		int capacidadMaximaDefault = 100;
		cartas = new LinkedList<Carta>();
		capacidad = capacidadMaximaDefault;
		cantidadDeCartas = 0;
	}
	
	public void agregarCarta (Carta carta) {
		if(cantidadDeCartas <= capacidad) {
			cartas.add(carta);
			cantidadDeCartas++;
		}
		//else {La ZONA esta llena! MovimientoIncorrectoError }
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

	public LinkedList<Carta> verCartas() {
		// TODO Auto-generated method stub
		return cartas;
	}

	public void aumentarDefensaEn(int i) {
		// TODO Auto-generated method stub
		
	}

	public void aumentarAtaqueEn(int i) {
		// TODO Auto-generated method stub
		
	}

	public void destruirLaDeMenorAtaque() {
		// TODO Auto-generated method stub
		
	}
}
