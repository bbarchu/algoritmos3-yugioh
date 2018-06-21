package modelo.aplicacion;

import modelo.jugador.Jugador;
import modelo.jugador.OponenteAtacable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import java.awt.event.*; // Para el manejo de eventos, necesario para el Timer.
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.KeyStroke;


//bosquejo de turno, bar.
public class Turno {
	
	Jugador jugador;
	Jugador jugadorRival;
	
	public Turno(Jugador jugadorQueTieneElTurno) {
		jugador = jugadorQueTieneElTurno;
		jugadorRival = (Jugador) jugador.obtenerJugadorRival();
		//Debo castear porque el jugador proximo debe ser jugador.
		faseInicial();
		
	}
	
	public void faseInicial() {
		jugador.tomarCartaDelMazo();
		fasePreparacion();
	}
	
	public void fasePreparacion(){
		
		
		//El jugador debe colocar cartas en el campo
		
		//Si ya hay cartas en el campo, se puede cambiar?
		
		
		//Si la carta campo que estaba anteriormente se puede cambiar, entonces
		//hay que desactivar los efectos.
		
		//--->Lucas: me parece que el jugador no puede sacar cartas del tablero
		
		//Se colocan todas las cartas magia y trampa que se quiera.
		//Solo 1 Monstruo podemos colocar en el campo y tiene que estar boca ABAJO.

		while (!(jugador.quierePasarDeFase()) {
			jugador.habilitarParaPonerCartasEnElCampo();
		}
		//Tambien podriamos durante esta etapa inhabilitar las otras funciones del jguador en cuestion
		//y al oponente lo podriamos inhabilitar completamente.
		
		
		faseDeAtaqueYTrampas();
		
		
	}
	
	public void faseDeAtaqueYTrampas() {
		
		//Puede atacar 1 sola vez cada monstruo
		//Despues de un ataque de monstruo se activa la fase de trampas DEL ENEMIGO!!!!! ATENTO
		
		//La fase finaliza cuando el jugador lo requiera o llegamos al tiempo ej 15 Segundos...
		while (!(jugador.quierePasarDeFase())) {
			jugador.habilitarAtaque();
		}
		
		faseDeActivacionDeCartasMagicas();
		
	}
	
	

	
	public void faseDeActivacionDeCartasMagicas() {
		
		//El jugador activa sus cartas magicas que desee
		//El turno termina y se le pasa al jugador Rival
		
		//Lucas: no entiendo donde sigue el juego, porque se está creando un turno dentro del turno anterior y asi sucesivamente.
		
		new TimerEx();
		while (!(jugador.quierePasarDeFase()) || !(time.isOver(15))) {
			
			
			jugador.habilitarActivacionDeCartasMagicas();
		}
		
		if (jugador.ganoLaPartida() || jugador.perdioLaPartida()) {
			System.out.println("Termino la partida");
			String nombreJugador = jugador.verNombre();
			String nombreOponente = jugadorRival.verNombre();
			if (jugador.ganoLaPartida()) {
				
				System.out.println("Gano jugador %s y perdió");
			}
			else {
				System.out.println("Perdio jugador tal");				
			}
			return;
		}
		
		Turno turnoSiguiente = new Turno(jugadorRival);
		
		
		
		
	}
		
	
}
