package modelo.cartasGenericas;

import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.Jugador;
import modelo.jugador.OponenteAtacable;

public abstract class ModoDeUso {
	

	public abstract void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta);

	public abstract void defender(CartaMonstruo carta, CartaMonstruo cartaAtacada);
	
	public abstract void atacarDirectamenteSinContemplarDefensa(Jinzo7 carta, OponenteAtacable oponente);
	
	public abstract int obtenerPuntosDeDaño(CartaMonstruo carta);
}
