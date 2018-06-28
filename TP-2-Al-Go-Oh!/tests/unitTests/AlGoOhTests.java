package unitTests;

import java.util.LinkedList;

import org.junit.Test;

import modelo.aplicacion.AlGoOh;


public class AlGoOhTests {

	
	@Test
	public void testObtenerLosNombresDeLasCartasQueElJugadorActualTieneEnLaMano() {
		
		System.out.println("\nPRUEBA testObtenerLosNombresDeLasCartasQueElJugadorActualTieneEnLaMano\n");
		
		AlGoOh juego = new AlGoOh();
		
		String nombresConcatenadosDeCartasEnLaManoJugadorActual = juego.nombresConcatenadosCartasManoJugadorActual();
		
		System.out.println(nombresConcatenadosDeCartasEnLaManoJugadorActual);
	
	}
	
	@Test
	public void testSiNoHayMonstruosInvocadosAlObtenerNombresDebeObtenerseLaPalabraVacio() {
		
		System.out.println("\nPRUEBA testSiNoHayMonstruosInvocadosAlObtenerNombresDebeObtenerseLaPalabraVacio\n");
		
		
		AlGoOh juego = new AlGoOh();
		
		LinkedList<String> nombresMonstruosJugadorActual = juego.obtenerArregloDe5CartasMonstruoJugadorActual();	
		LinkedList<String> nombresMonstruosJugadorRival = juego.obtenerArregloDe5CartasMonstruoRival();
		
		for(int i = 0 ; i < nombresMonstruosJugadorActual.size() ; i++) System.out.println(nombresMonstruosJugadorActual.get(i));
		for(int i = 0 ; i < nombresMonstruosJugadorRival.size() ; i++) System.out.println(nombresMonstruosJugadorRival.get(i));
	
	}
	
	@Test
	public void testObtenerLosNombresDeLasCartasMonstruosInvocadas() {
		
		System.out.println("\nPRUEBA testObtenerLosNombresDeLasCartasMonstruosInvocadas\n");
		
		AlGoOh juego = new AlGoOh();
		
		LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) {
			
			juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
		}
		
		LinkedList<String> nombresDeMonstruosInvocados = juego.obtenerArregloDe5CartasMonstruoJugadorActual();
		
		for(int i = 0 ; i < nombresDeMonstruosInvocados.size() ; i++) System.out.println(nombresDeMonstruosInvocados.get(i));
		
	}
	
	@Test
	public void testObtenerNombresDeCartasMagicaYTrampaCorrectamenteAlEstarBocaAbajoYBocaArriba() {
		
		System.out.println("testObtenerNombresDeCartasMagicaYTrampaCorrectamenteAlEstarBocaAbajoYBocaArriba");
		
		AlGoOh juego = new AlGoOh();
		
		LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		System.out.println("\nCartas en la mano que se invocaran\n");
		for(int i = 0 ; i < nombresCartasEnLaMano.size() ; i++) System.out.println(nombresCartasEnLaMano.get(i));
		
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) {
			
			juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
		}
		
		//Deberia obtener la palabra Dorso por cada una de las que se invoco (empiezan boca abajo)
		
		LinkedList<String> nombresDeCartasMagiaInvocadas = juego.obtenerArregloDe5CartasMagiaTrampaJugadorActual();
		System.out.println("\n\tCartas Magicas Invocadas (deberian decir dorso)\n");
		for(int i = 0 ; i < nombresDeCartasMagiaInvocadas.size() ; i++) System.out.println(nombresDeCartasMagiaInvocadas.get(i));
	
		//volteo las cartas (AgujeroOscuro es la unica magica que tendra
		
		juego.activarCartaMagicaDelJugadorActual("AgujeroOscuro");
		
		//Ahora si deberia devolver los nombres de las cartas magicas, porque fueron volteadas
		nombresDeCartasMagiaInvocadas = juego.obtenerArregloDe5CartasMagiaTrampaJugadorActual();
		
		System.out.println("\n\tCartas Magicas Invocadas ( las activadas deberian decir sus nombres y las que dicen Dorso deben ser Trampas, si dice vacio es por no habia la cartas suficiente y se relleno)\n");
		for(int i = 0 ; i < nombresDeCartasMagiaInvocadas.size() ; i++) System.out.println(nombresDeCartasMagiaInvocadas.get(i));
		
		 
	
	}
}
