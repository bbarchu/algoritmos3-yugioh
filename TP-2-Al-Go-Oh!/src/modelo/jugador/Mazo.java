package modelo.jugador;


import java.util.LinkedList;
import java.util.List;

import excepciones.MazoEstaVacioError;
import modelo.cartasGenericas.Carta;

public class Mazo {
	
	int cantidadDeCartas;
	List<Carta> cartas;
	
	Mazo(){
		cantidadDeCartas = 40;
		cartas = new LinkedList<Carta>();
		
	}
	
	public void agregarUnaCarta(Carta unaCarta) {
		cartas.add(unaCarta);
	}
	
	public boolean contiene (Carta unaCarta){
		return (cartas.contains(unaCarta));
	}
	
	public Carta sacarUnaCarta(){
		
		
		if(!estaVacio()) {
			return (Carta) (cartas.remove(0));
		}
		else {
			throw new MazoEstaVacioError();
		}
	}
	
	public boolean estaVacio() {
		return cartas.isEmpty();
	}
	
}
