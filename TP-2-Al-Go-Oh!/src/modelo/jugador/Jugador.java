package modelo.jugador;

import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaCampo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.tablero.CampoDeBatalla;

public class Jugador implements OponenteAtacable{
		
		int puntosDeVida;
		Mazo mazo;
		Mano mano;
		CampoDeBatalla campoDelJugador;
		
		//Lucas: el jugador debe poder interactuar con el jugadorRival para atacarlo
		//Lucas: considero que no es una buena solucion ya que el jugador no debería poder ver los metodos
		//			del otro jugador, debeía implementarse una interfaz que controle ese comportamiento
		//			Ej: interfaz obserbable, que solo permita ver las cartas del campo rival.
		
		Jugador jugadorRival;
	
	public Jugador() {
		
		this.puntosDeVida = 8000;
		this.mano = new Mano();
		this.mazo = new Mazo();
		this.campoDelJugador = new CampoDeBatalla();
		this.jugadorRival = null;
		
	}
	
	public void presentarJugadorRival(Jugador unJugador){
		
		jugadorRival = unJugador;
	}

	//bar: Por que el jugador puede agregar una carta al mazo?
	//Lucas: Respuesta -> es para controlar el comportamiento mientras se desarrolla el TP, en algun 
	//			momento este metodo va a pasar a ser privado y llamado únicamente en el constructor (cuando se llena el mazo).
	
	public void agregarCartaAlMazo(Carta unMonstruo) {
		this.mazo.agregarUnaCarta(unMonstruo);
	}

	public void tomarCartaDelMazo() {
		this.mano.tomarUnaCartaDel(this.mazo);	
	}

	public void invocar(Carta unaCarta) {
		unaCarta.invocate(this);
	}
	
	public void invocar(CartaMonstruo unMonstruo) {
		
		if(this.mano.contiene(unMonstruo)){
			campoDelJugador.colocar(unMonstruo);
		}
		this.eliminarDeLaMano(unMonstruo);
	}
	
	public void invocar(CartaMagica unaCartaMagica) {
		
		if(this.mano.contiene(unaCartaMagica)){
			campoDelJugador.colocar(unaCartaMagica);
		}
		this.eliminarDeLaMano(unaCartaMagica);
	}
	
	public void invocar(CartaCampo unaCartaCampo) {
		
		if(this.mano.contiene(unaCartaCampo)){
			campoDelJugador.colocar(unaCartaCampo);
		}
		this.eliminarDeLaMano(unaCartaCampo);
	}

	public void atacarCon_A(CartaMonstruo carta, CartaMonstruo otraCarta) {
		carta.atacar(otraCarta);
		
	}

	
	// Lucas: me parece un poco raro que un metodo que mata al jugador sea publico
	public void restarVida(int decrementoVida) {
		this.puntosDeVida -= decrementoVida;
		
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
	
	public Jugador obtenerJugadorRival() {
		return jugadorRival;
	}
	
	// este metodo fue creado para verificar el resultado de una prueba. Debe ser eliminado
	public int cantidadDeCartasEnLaMano(){
		int cantidad;
		
		cantidad = this.mano.obtenerCantidadDeCartas();
		
		return cantidad;
	}
}
