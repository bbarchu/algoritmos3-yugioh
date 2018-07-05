package modelo.jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import excepciones.ElJugadorNoPuedeAtacarASusPropiasCartasError;
import excepciones.ErrorSacrificiosInsuficientes;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaCampo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.tablero.CampoDeBatalla;

public class Jugador implements OponenteAtacable, JugadorModificable{
		
		int puntosDeVida;
		Mazo mazo;
		Mano mano;
		CampoDeBatalla campoDelJugador;	
		OponenteAtacable jugadorRival;
		boolean perdioLaPartida;
		boolean ganoLaPartida;
		String nombre;
		ArrayList<CartaMonstruo> cartasInhabilitadas;
	
	public Jugador() {
		
		nombre = "";
		this.puntosDeVida = 8000;
		this.mano = new Mano();
		this.mazo = new Mazo();
		this.campoDelJugador = new CampoDeBatalla();
		this.jugadorRival = null;
		this.ganoLaPartida = false;
		this.perdioLaPartida = false;
		this.cartasInhabilitadas = new ArrayList<CartaMonstruo>();
		
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
		for(int i =0 ; i < 5 ; i++) {
			tomarCartaDelMazo();			
		}
	}

	public void invocar(Carta unaCarta) {
		unaCarta.invocate(this);
	}
	
	public void invocar(CartaMonstruo unMonstruo) {
		
		try {
			
			if(this.mano.contiene(unMonstruo)){
				
				campoDelJugador.colocar(unMonstruo);
				this.eliminarDeLaMano(unMonstruo);
			}
		}catch(ErrorSacrificiosInsuficientes error) {
			
			//Si no hay sacrificios suficientes, no se invoca la carta.
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
		carta.inhabilitar();
		this.cartasInhabilitadas.add(carta);
		
	}
	
	public void habilitarCartas() {
		
		Iterator<CartaMonstruo> iterador = this.cartasInhabilitadas.iterator();
		
		while (iterador.hasNext()) {
			CartaMonstruo cartaActual = iterador.next();
			cartaActual.habilitar();	
			iterador.remove();
		}
	}
	
	
	public void restarVida(int decrementoVida) {
		
		int vida = this.puntosDeVida - decrementoVida;
		
		this.puntosDeVida = vida;
		
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
		
		return (pasarNombresDeLasCartasBocaArriba(cartas));
	}

	public LinkedList<String> obtenerNombresDeCartaTrampaBocaArriba() {
		
		LinkedList<Carta> cartas = this.campoDelJugador.verCartasTrampa();
		
		return (pasarNombresDeLasCartasBocaArriba(cartas));	
	}
	
	public LinkedList<String> obtenerNombresDeCartaMagiaBocaArriba() {
		
		LinkedList<Carta> cartas = this.campoDelJugador.verCartasMagicas();
		
		return (pasarNombresDeLasCartasBocaArriba(cartas));	
	}
	
	private LinkedList<String> pasarNombresDeLasCartasBocaArriba(LinkedList<Carta> cartas) {
		
		LinkedList<String> nombres = new LinkedList<String>();
		
		for(int i = 0 ; i < cartas.size() ; i++) {
			
			String nombreActual;
			
			if((cartas.get(i).estaBocaArriba())) nombreActual = cartas.get(i).getNombre();
			
			else nombreActual = "Dorso";
			
			if(cartas.get(i).getClass() == CartaMonstruo.class) {
				
				CartaMonstruo carta = (CartaMonstruo)cartas.get(i);
				
				if(carta.estaEnModoDefensa()) nombreActual = nombreActual + "-DEF";
					
			}
			
			nombres.add(nombreActual);
		}
		
		return nombres;
	}
	
	private LinkedList<String> pasarNombresDeTodasLasCartas(LinkedList<Carta> cartas){
		
		LinkedList<String> nombres = new LinkedList<String>();
		
		for(int i = 0 ; i < cartas.size() ; i++) {
			
			nombres.add(cartas.get(i).getNombre());
		}
		
		return nombres;
	}

	public LinkedList<String> obtenerNombresDeCartaEnLaMano() {
		
		LinkedList<Carta> cartas = this.mano.verCartas();
		
		return (pasarNombresDeTodasLasCartas(cartas));
	}

	public LinkedList<String> obtenerNombresDeCartaMagia() {
		
		return (pasarNombresDeTodasLasCartas(this.campoDelJugador.verCartasMagicas()));
	}

	public LinkedList<String> obtenerNombresDeCartasMonstruo() {
		
		return (pasarNombresDeTodasLasCartas(this.campoDelJugador.verCartasMonstruo()));
	}
	
	public void voltearLasCartasMonstruos() {
		
		LinkedList<Carta> cartas = this.campoDelJugador.verCartasMonstruo();
		
		for(int i = 0 ; i < cartas.size() ; i++) cartas.get(i).voltearCarta();
		
		
	}
	

	
}
