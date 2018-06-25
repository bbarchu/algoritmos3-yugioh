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
		// Lucas: este metodo debería luego sacar cartas de forma aleatoria
		//Bar: Me parece que las cartas se sacan desde arriba o abajo, no sacas aleatoriamente.
		//Bar: Si la necesidad de mezclarlas antes... que se ubiquen aleatoriamente.
		//Bar: Eso es depende como este pensado el armado de mazo. Si Siempre es igual, entonces si tiene 
		//Bar: sentido, el sacarlo random.
		
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
