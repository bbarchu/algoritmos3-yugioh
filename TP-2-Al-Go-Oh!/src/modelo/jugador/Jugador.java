package modelo.jugador;

import java.util.LinkedList;

import excepciones.ElJugadorNoPuedeAtacarASusPropiasCartasError;
import modelo.cartasEspecificas.Jinzo7;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaCampo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.tablero.CampoDeBatalla;

public class Jugador implements OponenteAtacable, JugadorModificable{
		
	//Lucas: el jugador debe poder interactuar con el jugadorRival para atacarlo
	//Lucas: considero que no es una buena solucion ya que el jugador no debería poder ver los metodos
	//			del otro jugador, debeía implementarse una interfaz que controle ese comportamiento
	//			Ej: interfaz obserbable, que solo permita ver las cartas del campo rival.
		int puntosDeVida;
		Mazo mazo;
		Mano mano;
		CampoDeBatalla campoDelJugador;	
		OponenteAtacable jugadorRival;
		boolean perdioLaPartida;
		boolean ganoLaPartida;
		String nombre;
	
	public Jugador() {
		
		nombre = "";
		this.puntosDeVida = 8000;
		this.mano = new Mano();
		this.mazo = new Mazo();
		this.campoDelJugador = new CampoDeBatalla();
		this.jugadorRival = null;
		this.ganoLaPartida = false;
		this.perdioLaPartida = false;
		
	}
	
	public void presentarJugadorRival(Jugador unJugador){
		
		jugadorRival = unJugador;
	}
	
	public void agregarNombre(String nombreJugador) {
		this.nombre = nombreJugador;
	}
	
	public String verNombre() {
		
		return this.nombre;
	}

	public void agregarCartaAlMazo(Carta unMonstruo) {
		this.mazo.agregarUnaCarta(unMonstruo);
	}

	public void tomarCartaDelMazo() {
		this.mano.tomarUnaCartaDel(this.mazo);
		
		if(mano.contieneLas5PartesDeExodia()) {
			this.ganoLaPartida = true;
		}
		if(mazo.estaVacio()) {
			this.perdioLaPartida = true;
		}
	}
	
	public void tomarCincoCartasDelMazo() {
		for(int i =0 ; i < 6 ; i++) {
			tomarCartaDelMazo();			
		}
	}

	public void invocar(Carta unaCarta) {
		unaCarta.invocate(this);
	}
	
	public void invocar(CartaMonstruo unMonstruo) {
		
		if(this.mano.contiene(unMonstruo)){
			
			campoDelJugador.colocar(unMonstruo);
			this.eliminarDeLaMano(unMonstruo);
		}
	
	}
	
	public void invocar(CartaTrampa trampa) {
		
		if(this.mano.contiene(trampa)) {
			
			campoDelJugador.colocar(trampa);
			this.eliminarDeLaMano(trampa);
		}
	}
	
	public void invocar(CartaMagica unaCartaMagica) {
		
		if(this.mano.contiene(unaCartaMagica)){
			
			campoDelJugador.colocar(unaCartaMagica);
			this.eliminarDeLaMano(unaCartaMagica);
		}
		
	}
	
	public void invocar(CartaCampo unaCartaCampo) {
		
		if(this.mano.contiene(unaCartaCampo)){
			
			campoDelJugador.colocar(unaCartaCampo);
			this.eliminarDeLaMano(unaCartaCampo);
		}
	}
	
	public void voltearCarta(Carta carta) {
		
		if(this.campoDelJugador.estaInvocadaEnElCampo(carta)) {
			
			carta.voltearCarta();
		}
	}
	
	public void atacarDirectamenteAlOponenteCon(CartaMonstruo carta) {
		carta.atacarDirectoAlJugadorRival();
	}

	public void atacarConA(CartaMonstruo carta, CartaMonstruo otraCarta){
		
		if (otraCarta.sosDelJugador(this)) {
			
			throw new ElJugadorNoPuedeAtacarASusPropiasCartasError();
		}
		carta.atacar(otraCarta);
		
	}

	
	// Lucas: me parece un poco raro que un metodo que mata al jugador sea publico
	public void restarVida(int decrementoVida) {
		this.puntosDeVida -= decrementoVida;
		
		if(puntosDeVida <= 0) {
			this.perdioLaPartida = true;
			Jugador jugadorOponente = (Jugador) (jugadorRival);
			jugadorOponente.convertirEnGanador();
		}
		
	}
	
	private void eliminarDeLaMano(Carta unaCarta) {
		this.mano.eliminar(unaCarta);
	}

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public CampoDeBatalla obtenerCampoDeBatalla() {
		return campoDelJugador;
	}
	
	public OponenteAtacable obtenerJugadorRival() {
		return jugadorRival;
	}
	
	// este metodo fue creado para verificar el resultado de una prueba. Debe ser eliminado
	public int cantidadDeCartasEnLaMano(){
		int cantidad;
		
		cantidad = this.mano.obtenerCantidadDeCartas();
		
		return cantidad;
	}

	public boolean perdioLaPartida() {
		return this.perdioLaPartida;
	}

	public boolean ganoLaPartida() {
		return this.ganoLaPartida;
	}
	
	public void convertirEnGanador() {
		this.ganoLaPartida = true;
	}
	
	public void convertirEnPerdedor() {
		this.perdioLaPartida = false;
	}

	public LinkedList<String> obtenerNombresDeCartasMonstruoBocaArriba() {
		
		LinkedList<Carta> cartas = this.campoDelJugador.verCartasMonstruo();
		
		return (pasarNombreDeLasCartasAUnaLista(cartas));
	}

	public LinkedList<String> obtenerNombresDeCartaTrampaBocaArriba() {
		
		LinkedList<Carta> cartas = this.campoDelJugador.verCartasTrampa();
		
		return (pasarNombreDeLasCartasAUnaLista(cartas));	
	}
	
	public LinkedList<String> obtenerNombresDeCartaMagiaBocaArriba() {
		
		LinkedList<Carta> cartas = this.campoDelJugador.verCartasMagicas();
		
		return (pasarNombreDeLasCartasAUnaLista(cartas));	
	}
	
	private LinkedList<String> pasarNombreDeLasCartasAUnaLista(LinkedList<Carta> cartas) {
		
		LinkedList<String> nombres = new LinkedList<String>();
		
		for(int i = 0 ; i < cartas.size() ; i++) {
			
			ombres.add(cartas.get(i).getNombre());
			else nombres.add("Dorso");
		}
		
		return nombres;
	}

	public LinkedList<String> obtenerNombresDeCartaEnLaMano() {
		
		LinkedList<Carta> cartas = this.mano.verCartas();
		
		return (pasarNombreDeLasCartasAUnaLista(cartas));
	}
	

	
}
