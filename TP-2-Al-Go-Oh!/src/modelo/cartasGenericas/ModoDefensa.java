package modelo.cartasGenericas;

import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public class ModoDefensa extends ModoDeUso {


	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		//Aca no hay q tirar excepcion, tuve q hacer unos cambios y entra por aca pero no debería hacer nada este metodo. BAR.
	}

	@Override
	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		int puntosAtaque = cartaAtacante.obtenerPuntosDeAtaque();
		int puntosDefensa = cartaAtacada.obtenerPuntosDeDefensa();
		if (puntosDefensa <= puntosAtaque) {
			cartaAtacada.destruirCarta();
			
		}
	
	}

	@Override
	public void atacarDirectamenteSinContemplarDefensa(Jinzo7 carta, OponenteAtacable oponente) {
		//Nacho: Aca hay que lanzar excepcion
		
	}
	
	public  int obtenerPuntosDeDaño(CartaMonstruo carta) {
		return carta.obtenerPuntosDeDefensa();
	}
}
