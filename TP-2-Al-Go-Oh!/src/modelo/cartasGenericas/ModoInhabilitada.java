package modelo.cartasGenericas;

import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public class ModoInhabilitada extends ModoDeUso{

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
	
	}

	@Override
	public void defender(CartaMonstruo carta, CartaMonstruo cartaAtacada) {
		
	}

	@Override
	public void atacarDirectamenteSinContemplarDefensa(Jinzo7 carta, OponenteAtacable oponente) {

		
	}
	
	public int obtenerPuntosDeDaño(CartaMonstruo carta) {
		return 0;
	}

}
