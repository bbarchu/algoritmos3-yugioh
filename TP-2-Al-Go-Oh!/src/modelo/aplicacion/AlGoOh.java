package modelo.aplicacion;

import modelo.jugador.Jugador;

public class AlGoOh {
	
	Jugador jugadorNumeroUno;
	Jugador jugadorNumeroDos;
	
	public AlGoOh(){
		
		//creacion de jugadores.
		jugadorNumeroUno = new Jugador();
		jugadorNumeroDos = new Jugador();
		
		//Lucas: Falta decidir como agregar todas las cartas al mazo de cada jugador (el orden tiene que ser aleatorio)
		//Opciones: -dar a elegir las cartas (más dificil)
		//			-colocar cartas random en cada uno
		//			-colocar las mismas cartas en ambos (diferente orden)
		
		
		//presentacion
		jugadorNumeroUno.presentarJugadorRival(jugadorNumeroDos);
		jugadorNumeroDos.presentarJugadorRival(jugadorNumeroUno);
		
		//Comienzo de partida
		//Lucas: Esta parte me parece que la podemos hacer en el constructor del jugador
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

