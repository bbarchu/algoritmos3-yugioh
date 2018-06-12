package Application;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import fiuba.algo3.tp1.Estadia;


public class Mazo {
	
	int cantidadDeCartas;
	List cartas;
	
	Mazo(){
		cantidadDeCartas = 40;
		cartas = new LinkedList();
		
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
