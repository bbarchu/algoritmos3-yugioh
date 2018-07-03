package modelo.tablero;

import java.util.Iterator;
import java.util.LinkedList;

import excepciones.ErrorZonaSinCapacidad;
import excepciones.NoSeEncontroLaCartaEnLaZonaError;
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
		
		if(cantidadDeCartas < capacidad) {
			cartas.add(carta);
			cantidadDeCartas++;
		}
		else throw(new ErrorZonaSinCapacidad());
	}
	
	public boolean contiene (Carta unaCarta){
		return (cartas.contains(unaCarta));
	}
	
	public void eliminarCarta(Carta carta) {
		
		if(estaVacio()) throw (new NoSeEncontroLaCartaEnLaZonaError());
		
		cartas.remove(carta);
		
		this.cantidadDeCartas--;
}

	public boolean estaVacio() {
		
		return cartas.isEmpty();
	}
	
	public Carta eliminarCartaMasAntigua() {
		
		if(estaVacio()) {
			//lanzar excepcion
		}
		
		Carta cartaAEliminar = cartas.get(0);
		this.cartas.remove(0);
		
		this.cantidadDeCartas--;
		
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
