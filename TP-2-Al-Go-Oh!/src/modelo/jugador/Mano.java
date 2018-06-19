package modelo.jugador;

import java.util.LinkedList;
import java.util.List;

import modelo.cartasGenericas.Carta;

public class Mano {
	int cantidad;
	//bar = tiene capacidad infinita... o al menos de 40 cartas...
	List<Carta> cartas;
	
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
	}
	
	public int obtenerCantidadDeCartas() {
		return this.cantidad;
	}
}