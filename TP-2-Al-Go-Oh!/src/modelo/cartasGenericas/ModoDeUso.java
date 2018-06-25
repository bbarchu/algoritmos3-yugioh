package modelo.cartasGenericas;

import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public abstract class ModoDeUso {
	
	
	public abstract void atacarDirectamente(Jinzo7 carta, OponenteAtacable oponente);
	
	public abstract void atacarDirectamente(CartaMonstruo carta, OponenteAtacable oponente);
	
	public abstract int obtenerPuntosUtilizadosEnElModoActual(int puntosAtaque, int puntosDefensa);
	
	public abstract void realizarEnfrentamiento(CartaMonstruo atacante, CartaMonstruo atacada);
	
	public abstract void atacarSiCorresponde(CartaMonstruo atacante, CartaMonstruo atacada);
	
	public abstract void destruirSiCorresponde(CartaMonstruo cartaQueDestruir);
	
	public abstract void restarVidaDelInvocadorDe(CartaMonstruo cartaPerdedora, int danio);

	public abstract void restarVidaDeMiInvocador(CartaMonstruo carta, int daño);
}
