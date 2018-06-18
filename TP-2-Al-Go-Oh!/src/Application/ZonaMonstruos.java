package Application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ZonaMonstruos extends Zona {
	
	 	
	
	
	 ZonaMonstruos(int cantidadMaximaMonstruos){
		 super(cantidadMaximaMonstruos);
	 }
	 
	 
	 
	 public void aumentarAtaqueEn(int puntosDeAtaque){
		iteradorCarta = cartas.listIterator(0);
		while (iteradorCarta.hasNext() != false) {
			CartaMonstruo monstruoActual = (CartaMonstruo) iteradorCarta.next();
			monstruoActual.aumentarPuntosDeAtaqueEn(puntosDeAtaque);
		}
	 }
	 
	 public void aumentarDefensaEn(int puntosDeDefensa){
		 iteradorCarta = cartas.listIterator(0);
		 while (iteradorCarta.hasNext() != false) {
				CartaMonstruo monstruoActual = (CartaMonstruo) iteradorCarta.next();
				monstruoActual.aumentarPuntosDeDefensaEn(puntosDeDefensa);
		 }
	 }
	  
	 public LinkedList<Carta> verCartas() {
		 return cartas;
	 }
}
