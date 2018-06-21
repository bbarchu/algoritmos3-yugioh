package modelo.aplicacion;

import modelo.jugador.Jugador;

public class AlGoOh {
	
	Jugador jugadorNumeroUno;
	Jugador jugadorNumeroDos;
	
	public AlGoOh(){
		
		//creacion de jugadores.
		jugadorNumeroUno = new Jugador();
		jugadorNumeroDos = new Jugador();
		
		//presentacion
		jugadorNumeroUno.presentarJugadorRival(jugadorNumeroDos);
		jugadorNumeroDos.presentarJugadorRival(jugadorNumeroUno);
		
		//Comienzo de partida
		
		jugadorNumeroUno.tomarCincoCartasDelMazo();
		jugadorNumeroDos.tomarCincoCartasDelMazo();
		
		int numero = (int) (Math.random() * 2) +1 ;
		
		if (numero == 1) {
			//Comienza el jugador numero 1 
			
			Turno turno = new Turno(jugadorNumeroUno);
			turno.faseInicial();
		}
		else {
			
			//Comienza el jugador numero 2
			Turno turno = new Turno(jugadorNumeroDos);
			turno.faseInicial();
		}
		
		
	}
	

}

