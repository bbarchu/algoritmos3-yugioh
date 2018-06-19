package modelo.cartasGenericas;

import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.Jugador;
import modelo.jugador.OponenteAtacable;

public class ModoAtaque extends ModoDeUso {
	

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		otraCarta.recibirPuntosAtaque(miCarta);
		
		//miCarta.recibirPuntosAtaque(otraCarta); 
		//Bar: agrego esta linea para que ambas cartas se hagan da�o(ModoATAQUE)
		//Si es modo defensa no deberia PASAR NADA. ENTRA AL METODO DE MODO DEFENSA Y NO HACE NADA, TAMPOCO DEBER�A MANDAR ERROR.
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
	

}
