package modelo.cartasGenericas;

import excepciones.ErrorAtaqueNoPermitido;
import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public class ModoDefensa extends ModoDeUso {

	@Override
	public void atacarDirectamenteSinContemplarDefensa(Jinzo7 carta, OponenteAtacable oponente) {
		
		throw(new ErrorAtaqueNoPermitido());
	}
	
	public int obtenerPuntosUtilizadosEnElModoActual(int puntosAtaque, int puntosDefensa) {
		
		return puntosDefensa;
	}

	
	public void impactarJugadorInvocadorDe(CartaMonstruo cartaInvocada, int danio) {
		
		//Si esta en modo defensa los puntos de vida del jugador no son afectados
	}

	@Override
	public void realizarEnfrentamiento(CartaMonstruo atacante, CartaMonstruo atacada) {
		
		throw(new ErrorAtaqueNoPermitido());
	}

	@Override
	public void atacarSiCorresponde(CartaMonstruo atacante, CartaMonstruo atacada) {
		
		throw(new ErrorAtaqueNoPermitido());
	}

	@Override
	public void destruirSiCorresponde(CartaMonstruo cartaQueDestruir) {
		
		//Si estoy en modo defensa no se destruye la carta
	}

	@Override
	public void restarVidaDelInvocadorDe(CartaMonstruo cartaPerdedora, int danio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restarVidaDeMiInvocador(CartaMonstruo carta, int daño) {
		// TODO Auto-generated method stub
		
	}
}
