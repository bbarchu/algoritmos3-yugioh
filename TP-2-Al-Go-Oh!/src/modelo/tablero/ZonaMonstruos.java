package modelo.tablero;

import java.util.LinkedList;

import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMonstruo;

public class ZonaMonstruos extends Zona {
	
	 	
	
	
	 ZonaMonstruos(int cantidadMaximaMonstruos){
		 super(cantidadMaximaMonstruos);
	 }
	 
	 public CartaMonstruo buscar(String nombreCartaMonstruo) {
		 iteradorCarta = this.cartas.listIterator(0);
		 while (iteradorCarta.hasNext() != false) {
			 CartaMonstruo monstruoActual = (CartaMonstruo) iteradorCarta.next();
			 if (monstruoActual.getNombre() == nombreCartaMonstruo) {
				 return monstruoActual;
			 }
			 
		 }
		 return null;
		 
		 
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
	 
	 public void destruirLaDeMenorAtaque() {
		 int menorAtaque = 0;
		 int puntosAtaqueAuxiliar=0;
		 CartaMonstruo cartaADestruir;
		 
		 iteradorCarta = cartas.listIterator(0);
		 
		 //inicializo
		 cartaADestruir = (CartaMonstruo) cartas.get(0);
		 menorAtaque = cartaADestruir.obtenerPuntosDeAtaque();
		 
		 while (iteradorCarta.hasNext() != false) {
				CartaMonstruo monstruoActual = (CartaMonstruo) iteradorCarta.next();
				puntosAtaqueAuxiliar = monstruoActual.obtenerPuntosDeAtaque();
				
				if (menorAtaque > puntosAtaqueAuxiliar) {
					menorAtaque = puntosAtaqueAuxiliar;
					cartaADestruir = monstruoActual;
				}
		 }
		 cartaADestruir.destruirCarta();
	 }
}
