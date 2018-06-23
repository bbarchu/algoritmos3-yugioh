package modelo.tablero;

import java.util.LinkedList;

import modelo.NoSeEncontroLaCartaEnLaZonaError;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMonstruo;

public class ZonaMonstruos extends Zona {
	
	 private static int capacidadMaxima = 5;
	
	 ZonaMonstruos(){
		 
		 super(capacidadMaxima);
	 }
	 
	 ZonaMonstruos(int cantidadMaximaMonstruos){
		 
		 super(cantidadMaximaMonstruos);
	 }
	 
	 public LinkedList<CartaMonstruo> buscarTresCartas(String nombreCartaMonstruo) {
		 int contador = 0;
		 LinkedList<CartaMonstruo> lista = new LinkedList<CartaMonstruo>();
		 iteradorCarta = this.cartas.listIterator(0);
		 while (iteradorCarta.hasNext() != false && contador < 3) {
			 CartaMonstruo monstruoActual = (CartaMonstruo) iteradorCarta.next();
			 if (monstruoActual.getNombre() == nombreCartaMonstruo) {
				 contador += 1;
				 lista.add(monstruoActual);
			 }
			 
		 }
		 if (contador < 3) {
			 //Aca deberia lanzar una excepcion
		 }
		 
		 return lista;
		 
		 
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
	 
	 public CartaMonstruo buscarCarta(String nombreCarta) {
		 
		 iteradorCarta = this.cartas.listIterator(0);
		 while (iteradorCarta.hasNext() ) {
			 CartaMonstruo monstruoActual = (CartaMonstruo) iteradorCarta.next();
			 if (monstruoActual.getNombre() == nombreCarta) {
				return monstruoActual;
			 }
			 
		 }
		 
		 throw new NoSeEncontroLaCartaEnLaZonaError();
		 
	 }
	
	 
}
