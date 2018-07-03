package unitTests;

import static org.junit.Assert.assertEquals;

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
	public void testObtenerNombresDeCartasMagicaInvocada() {
		
		System.out.println("testObtenerNombresDeCartasMagicaYTrampaCorrectamenteAlEstarBocaAbajoYBocaArriba");
		
		AlGoOh juego = new AlGoOh();
		
		LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		System.out.println("\nCartas en la mano que se invocaran\n");
		for(int i = 0 ; i < nombresCartasEnLaMano.size() ; i++) System.out.println(nombresCartasEnLaMano.get(i));
		
		juego.colocarEnElCampoDelJugadorActual("AgujeroOscuro");
		
		
		
		LinkedList<String> nombresDeCartasMagiaInvocadas = juego.obtenerArregloDe5CartasMagiaTrampaJugadorActual();
		
		System.out.println("\n\tCartas Magicas Invocadas (deberian decir dorso)\n");
		for(int i = 0 ; i < nombresDeCartasMagiaInvocadas.size() ; i++) System.out.println(nombresDeCartasMagiaInvocadas.get(i));
		
		
		
		
	
	}
	
	@Test
	public void testObtenerNombresDeCartasMagicaYTrampaCorrectamenteAlEstarBocaAbajoYBocaArriba() {
		
		System.out.println("testObtenerNombresDeCartasMagicaYTrampaCorrectamenteAlEstarBocaAbajoYBocaArriba");
		
		AlGoOh juego = new AlGoOh();
		
		LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		System.out.println("\nCartas en la mano que se invocaran\n");
		for(int i = 0 ; i < nombresCartasEnLaMano.size() ; i++) System.out.println(nombresCartasEnLaMano.get(i));
		
		juego.colocarEnElCampoDelJugadorActual("AgujeroOscuro");
		
		LinkedList<String> nombresCartasMagicas =juego.obtenerArregloDe5CartasMagiaTrampaJugadorActual();
		for(int i = 0 ; i < nombresCartasMagicas.size() ; i++) System.out.println(nombresCartasMagicas.get(i));
	}
	
	@Test
	public void test() {
		
		AlGoOh juego = new AlGoOh();
		
		//invoca todas sus cartas el jugador
		
		LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) {
			
			System.out.println(nombresCartasEnLaMano.get(i));
			juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
		}
		
		juego.cambiarDeTurno();
		
		//invoca todas sus cartas el otro jugador
		
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
		
		//no deberia poder atacar, porque es el primer turno y sus monstruos estan bocas abajo
		juego.jugadorActualAtacaConA("BueyDeBatalla","BrazoIzquierdoDelProhibido");
		
		System.out.println("\nSi hubiera atacado el brazoIzquierdo no deberia aparecer en el campo");
		
		LinkedList<String> monstruosEnElCampo = juego.obtenerArregloDe5CartasMonstruoRival();
		
		for(int i = 0 ; i < monstruosEnElCampo.size() ; i++) System.out.println(monstruosEnElCampo.get(i));
		
		assertEquals(Integer.toString(8000), juego.getPuntosJugador1());
		assertEquals(Integer.toString(8000), juego.getPuntosJugador2());
		
		//despues sigo con dar vueltas monstruos y realizar ataques, cuando nacho agregue los metodos
	}
	
	@Test
	public void testPProbarQueAlInvocarCilindroMagicoSeEliminaDeLaMano(){
		
		System.out.println("\ntestPProbarQueAlInvocarCilindroMagicoSeEliminaDeLaMano\n");
		
		AlGoOh juego = new AlGoOh();
		
		juego.jugadorActualTomaUnaCarta();
			
		LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		System.out.println("Cartas en la mano inicialmente\n");
		
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) {
			
			System.out.println(nombresCartasEnLaMano.get(i));
			juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
		}
		
		System.out.println("\nCartas en la mano luego de invocar todas (deberia decir vacio en todas)\n");
		
		nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) System.out.println(nombresCartasEnLaMano.get(i));
	
}

@Test
public void testProbarCapacidadDeLaZonaMonstruo(){
	
	System.out.println("\ntestProbarCapacidadDeLaZonaMonstruo\n");
	
	AlGoOh juego = new AlGoOh();
	
	juego.jugadorActualTomaUnaCarta();
	juego.jugadorActualTomaUnaCarta();
	juego.jugadorActualTomaUnaCarta();
		
	LinkedList<String> nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
	
	System.out.println("Cartas en la mano inicialmente\n");
	
	for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) {
		
		System.out.println(nombresCartasEnLaMano.get(i));
	}
	
	for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) {
		
		juego.colocarEnElCampoDelJugadorActual(nombresCartasEnLaMano.get(i));
	}
	
	
	System.out.println("\nCartas monstruos en el campo (deben ser 5)\n");
	
	LinkedList<String> monstruosEnElCampo = juego.obtenerArregloDe5CartasMonstruoJugadorActual();
	
	for(int i = 0 ; i < monstruosEnElCampo.size(); i++) System.out.println(monstruosEnElCampo.get(i));
	
	
	System.out.println("\nCartas en la mano luego de invocar todas (deberia decir vacio exceptos en las que no fueron invocadas)\n");
	
	nombresCartasEnLaMano = juego.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
	
	for(int i = 0 ; i < nombresCartasEnLaMano.size(); i++) System.out.println(nombresCartasEnLaMano.get(i));
	
	
	}
}
