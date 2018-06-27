package modelo.jugador;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMonstruo;

public class Mano {
	int cantidad;
	//bar = tiene capacidad infinita... o al menos de 40 cartas...
	LinkedList<Carta> cartas;
	
	Mano(){
		cantidad = 0;
		cartas = new LinkedList<Carta>();	
	} 
	
	public void tomarCincoCartasDel(Mazo mazo){
		
		for (int i = 0; i<5 ; i++) {
			cartas.add(mazo.sacarUnaCarta());
			cantidad ++;
		}
		
	}
	
	public void tomarUnaCartaDel(Mazo mazo) {
		cartas.add(mazo.sacarUnaCarta());
		cantidad ++;
	}

	public boolean contiene(Carta unaCarta) {
		return (cartas.contains(unaCarta));
	}
	
	public void eliminar(Carta unaCarta) {
		cartas.remove(unaCarta);
		cantidad --;
	}
	
	public int obtenerCantidadDeCartas() {
		return this.cantidad;
	}

	public boolean contieneLas5PartesDeExodia() {
		boolean resultado = false;
		int cantidadDePartes = 0;
		
		Iterator<Carta>iteradorCarta = this.cartas.listIterator(0);
		while (iteradorCarta.hasNext() == true && cantidadDePartes < 5) {
			Carta monstruoActual = iteradorCarta.next();
			
			if (monstruoActual.getNombre() == "ExodiaElProhibido") {
				cantidadDePartes ++;
				}
			if (monstruoActual.getNombre() == "BrazoDerechoDelProhibido") {
					cantidadDePartes ++;
				}
			if (monstruoActual.getNombre() == "BrazoIzquierdoDelProhibido") {
					cantidadDePartes ++;
				}
			if (monstruoActual.getNombre() == "PiernaDerechaDelProhibido") {
					cantidadDePartes ++;
				}
			if (monstruoActual.getNombre() == "PiernaIzquierdaDelProhibido") {
					cantidadDePartes ++;
				}
		}
		
		if(cantidadDePartes == 5) {
			resultado = true;
		}
		
		return resultado;
	}
	
	public Carta buscarCartaPorNombre(String nombreCarta){
		if (cantidad == 0) {
			//Excepcion crear
			
		}
		 ListIterator<Carta> iteradorCarta = this.cartas.listIterator(0);
		 while (iteradorCarta.hasNext() ) {
			 Carta cartaActual = (CartaMonstruo) iteradorCarta.next();
			 if (cartaActual.getNombre() == nombreCarta) {
				return cartaActual;
			 }
			 
		 }
		 
		 //Si llegamos aca es porq no se encontro la carta
		return null;
	}
	
	public boolean quedanCartas() {
		if (cantidad == 0) {
			return false;
		}
		return true;
	}
	
	public LinkedList<Carta> verCartas(){
		
		return this.cartas;
	}
}
