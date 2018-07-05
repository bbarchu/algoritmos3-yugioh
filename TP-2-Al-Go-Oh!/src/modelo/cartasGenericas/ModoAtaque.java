package modelo.cartasGenericas;

import excepciones.TodaviaQuedanMonstruosParaAtacarEnElCampoError;
import modelo.cartasEspecificas.Jinzo7;
import modelo.jugador.OponenteAtacable;

public class ModoAtaque extends ModoDeUso {
	
	
	public int obtenerPuntosUtilizadosEnElModoActual(int puntosAtaque, int puntosDefensa) {
		
		return puntosAtaque;
	}

	public void restarVidaDeMiInvocador(CartaMonstruo carta, int daño) {
		
		carta.restarVidaAJugador(daño);
	}
	
	
	public void atacarSiCorresponde(CartaMonstruo atacante, CartaMonstruo atacada) {
		
		atacada.activarCartaTrampa(atacante);
		atacante.atacarA(atacada);
		atacada.desactivarCartaTrampa(atacante);
	}
	
	public void realizarEnfrentamiento(CartaMonstruo atacante, CartaMonstruo atacada) {
		
		Batalla batalla = (new Batalla(atacante, atacada));
	}

	@Override
	public void destruirSiCorresponde(CartaMonstruo cartaQueDestruir) {
		
		cartaQueDestruir.destruirCarta();
	}

	@Override
	public void restarVidaDelInvocadorDe(CartaMonstruo cartaPerdedora, int danio) {
		
		cartaPerdedora.restarVidaDeMiInvocadorSiCorresponde(danio);
		
	}

	@Override
	public void atacarDirectamente(Jinzo7 carta, OponenteAtacable oponente) {
		oponente.restarVida(carta.obtenerPuntosDeAtaque());
		
	}

	@Override
	public void atacarDirectamente(CartaMonstruo carta, OponenteAtacable oponente) {
		if (oponente.obtenerCampoDeBatalla().hayCartasMonstruo()) {
			
			throw new TodaviaQuedanMonstruosParaAtacarEnElCampoError();
		}
		
		oponente.restarVida(carta.obtenerPuntosDeAtaque());
	}

	@Override
	public boolean modoDefensa() {

		return false;
	}
	
	



}
