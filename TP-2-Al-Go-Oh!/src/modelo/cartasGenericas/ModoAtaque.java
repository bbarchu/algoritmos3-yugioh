package modelo.cartasGenericas;

import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public class ModoAtaque extends ModoDeUso {
	

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		otraCarta.recibirAtaque(miCarta);
	
	}

	@Override
	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		int puntosDefensa = cartaAtacada.obtenerPuntosDeAtaque();
		int puntosAtaque = cartaAtacante.obtenerPuntosDeAtaque();
		
		if (puntosDefensa < puntosAtaque) {
			int diferencia = puntosAtaque - puntosDefensa;
			cartaAtacada.destruirCarta();
			cartaAtacada.restarVidaAJugador(diferencia);
		}
		else if (puntosDefensa < puntosAtaque) {
			cartaAtacante.destruirCarta();
		}
		
		//bar:  ambas se destruyen, y no se restan puntos de vida
		
		else if(puntosDefensa == puntosAtaque) {
			cartaAtacante.destruirCarta();
			cartaAtacada.destruirCarta();
		}
	}


	@Override
	public void atacarDirectamenteSinContemplarDefensa(Jinzo7 carta, OponenteAtacable oponente) {
		oponente.restarVida(carta.obtenerPuntosDeAtaque());
		
	}
	
	public  int obtenerPuntosDeDaño(CartaMonstruo carta) {
		return carta.obtenerPuntosDeAtaque();
	}
	

}
