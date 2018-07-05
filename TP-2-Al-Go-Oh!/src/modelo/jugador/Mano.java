package modelo.jugador;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMonstruo;

public class Mano {
	
	int cantidad;
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
		
		if(contieneBrazoDerechoDelProhibido() && contieneBrazoIzquierdoDelProhibido() && contienePiernaDerechaDelProhibido() && contienePiernaIzquierdaDelProhibido()) {
			if(contieneCabezaDelProhibido()) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	private boolean contieneBrazoDerechoDelProhibido() {
		String nombreDeLaCarta = "BrazoDerechoDelProhibido";
		
		Iterator<Carta>iteradorCarta = this.cartas.listIterator(0);
		
		while (iteradorCarta.hasNext() == true) {
			Carta monstruoActual = iteradorCarta.next();
			if (monstruoActual.getNombre() == nombreDeLaCarta) {
					return true;
			}
		}

			return false;
	}
	private boolean contieneBrazoIzquierdoDelProhibido() {
		String nombreDeLaCarta = "BrazoIzquierdoDelProhibido";
		
		Iterator<Carta>iteradorCarta = this.cartas.listIterator(0);
		
		while (iteradorCarta.hasNext() == true) {
			Carta monstruoActual = iteradorCarta.next();
			if (monstruoActual.getNombre() == nombreDeLaCarta) {
					return true;
			}
		}

			return false;
	}
	
	private boolean contienePiernaIzquierdaDelProhibido() {
		String nombreDeLaCarta = "PiernaIzquierdaDelProhibido";
		
		Iterator<Carta>iteradorCarta = this.cartas.listIterator(0);
		
		while (iteradorCarta.hasNext() == true) {
			Carta monstruoActual = iteradorCarta.next();
			if (monstruoActual.getNombre() == nombreDeLaCarta) {
					return true;
			}
		}

			return false;
	}

	
	private boolean contienePiernaDerechaDelProhibido() {
		String nombreDeLaCarta = "PiernaDerechaDelProhibido";
		
		Iterator<Carta>iteradorCarta = this.cartas.listIterator(0);
		
		while (iteradorCarta.hasNext() == true) {
			Carta monstruoActual = iteradorCarta.next();
			if (monstruoActual.getNombre() == nombreDeLaCarta) {
					return true;
			}
		}

			return false;
	}
	
	
	private boolean contieneCabezaDelProhibido() {
		String nombreDeLaCarta = "ExodiaElProhibido";
		
		Iterator<Carta>iteradorCarta = this.cartas.listIterator(0);
		
		while (iteradorCarta.hasNext() == true) {
			Carta monstruoActual = iteradorCarta.next();
			if (monstruoActual.getNombre() == nombreDeLaCarta) {
					return true;
			}
		}

			return false;
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
