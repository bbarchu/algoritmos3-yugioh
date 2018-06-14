package Application;

public class Jugador {
		
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
	//			momento este metodo va a pasar a ser privado y llamado únicamente en el constructor.
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

	public void atacarCon_A(CartaMonstruo carta, CartaMonstruo otraCarta) {
		carta.atacar(otraCarta);
		
	}

	public void restarVida(int decrementoVida) {
		this.puntosDeVida -= decrementoVida;
		
	}
	
	public void eliminarDeLaMano(Carta unaCarta) {
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
}
