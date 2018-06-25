package modelo.cartasGenericas;

import excepciones.ErrorAtaqueNoPermitido;
import excepciones.ErrorCartaInhabilitadaParaUnEnfrentamiento;
import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public class ModoInhabilitada extends ModoDeUso{
	
	public int obtenerPuntosDeDaño(CartaMonstruo carta) {
		return 0;
	}

	@Override
	public int obtenerPuntosUtilizadosEnElModoActual(int puntosAtaque, int puntosDefensa) {
	
		throw(new ErrorCartaInhabilitadaParaUnEnfrentamiento());
	}


	@Override
	public void realizarEnfrentamiento(CartaMonstruo atacante, CartaMonstruo atacada) {
		
		//Si se inhabilita la carta no se realiza ningun enfrentamiento
	}

	@Override
	public void atacarSiCorresponde(CartaMonstruo atacante, CartaMonstruo atacada) {
		
	}

	@Override
	public void destruirSiCorresponde(CartaMonstruo cartaQueDestruir) {
		
		
	}

	@Override
	public void restarVidaDelInvocadorDe(CartaMonstruo cartaPerdedora, int danio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restarVidaDeMiInvocador(CartaMonstruo carta, int daño) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacarDirectamente(Jinzo7 carta, OponenteAtacable oponente) {
		
	}

	@Override
	public void atacarDirectamente(CartaMonstruo carta, OponenteAtacable oponente) {
	
	}

}
