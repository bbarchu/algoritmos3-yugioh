package Application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ZonaMonstruos extends Zona {
	
	 Iterator<CartaMonstruo>iteradorMonstruo;
	 LinkedList<CartaMonstruo> cartasMonstruo;		
	
	
	 ZonaMonstruos(int cantidadMaximaMonstruos){
		 super(cantidadMaximaMonstruos);
		 cartasMonstruo = new LinkedList();
		 iteradorMonstruo = cartasMonstruo.iterator();
	 }
	 
	 
	 
	 void aumentarAtaqueEn(int puntosDeAtaque){
		while (iteradorMonstruo.hasNext() != false) {
			CartaMonstruo monstruoActual = iteradorMonstruo.next();
			monstruoActual.aumentarPuntosDeAtaqueEn(puntosDeAtaque);
		}
	 }
	 
	 void aumentarDefensaEn(int puntosDeDefensa){
		 while (iteradorMonstruo.hasNext() != false) {
				CartaMonstruo monstruoActual = iteradorMonstruo.next();
				monstruoActual.aumentarPuntosDeDefensaEn(puntosDeDefensa);
		 }
	 }
	  
	 public LinkedList verCartas() {
		 return cartasMonstruo;
	 }
}
