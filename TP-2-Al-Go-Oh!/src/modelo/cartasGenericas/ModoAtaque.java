package modelo.cartasGenericas;

public class ModoAtaque extends ModoDeUso {
	

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		otraCarta.recibirPuntosAtaque(miCarta);
		
		miCarta.recibirPuntosAtaque(otraCarta); 
		//Bar: agrego esta linea para que ambas cartas se hagan daño(ModoATAQUE)
		//Si es modo defensa no deberia PASAR NADA. ENTRA AL METODO DE MODO DEFENSA Y NO HACE NADA, TAMPOCO DEBERíA MANDAR ERROR.
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
	

}
