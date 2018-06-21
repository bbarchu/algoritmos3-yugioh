package modelo.aplicacion;

import modelo.jugador.Jugador;
import modelo.jugador.OponenteAtacable;



//bosquejo de turno, bar.
public class Turno {
	
	Jugador jugador;
	Jugador jugadorRival;
	
	public Turno(Jugador jugadorQueTieneElTurno) {
		jugador = jugadorQueTieneElTurno;
		jugadorRival = (Jugador) jugador.obtenerJugadorRival();
		//Debo castear porque el jugador proximo debe ser jugador.
		
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
		//Se colocan todas las cartas magia y trampa que se quiera.
		//Solo 1 Monstruo podemos colocar en el campo y tiene que estar boca ABAJO.
		
		jugador.habilitarParaPonerCartasEnElCampo();
		//Tambien podriamos durante esta etapa inhabilitar las otras funciones del jguador en cuestion
		//y al oponente lo podriamos inhabilitar completamente.
		
		if ( jugador.quierePasarDeFase || time.isOver(15)) {
			faseDeAtaqueYTrampas();
		}
		
		
	}
	
	public void faseDeAtaqueYTrampas() {
		
		//Puede atacar 1 sola vez cada monstruo
		//Despues de un ataque de monstruo se activa la fase de trampas DEL ENEMIGO!!!!! ATENTO
		
		//La fase finaliza cuando el jugador lo requiera o llegamos al tiempo ej 15 Segundos...
		
		jugador.habilitarAtaque();
		
		if ( jugador.quierePasarDeFase || time.isOver( 15)) {
			faseDeActivacionDeCartasMagicas();
		}
	}
	
	

	
	public void faseDeActivacionDeCartasMagicas() {
		
		//El jugador activa sus cartas magicas que desee
		//El turno termina y se le pasa al jugador Rival
		
		jugador.habilitarActivacionDeCartasMagicas();
			
		if (jugador.quierePasarDeFase || tiempo.isOver( 15)) {
			Turno turnoSiguiente = new Turno(jugadorRival);
		}
		
		
		
	}
	
	
}
