package Application;

public class Jugador {

//		Mazo mazo = new Mazo();
//		Mano mano = new Mano();
		
		int puntosDeVida;
		Carta mazo;
		Carta mano;
		CampoDeBatalla campoDelJugador;
		
		//Lucas: el jugador debe poder interactuar con el jugadorRival para atacarlo
		//Lucas: considero que no es una buena solucion ya que el jugador no debería poder ver los metodos
		//			del otro jugador, debeía implementarse una interfaz que controle ese comportamiento
		//			Ej: interfaz obserbable, que solo permita ver las cartas del campo rival.
		
		Jugador jugadorRival;

	
	public Jugador() {
		this.puntosDeVida = 8000;
		this.mano = null;
		this.mazo = null;
		campoDelJugador = new CampoDeBatalla();
	}
	
	public void presentarJugadorRival(Jugador unJugador){
		jugadorRival = unJugador;
	}

	//bar: Por que el jugador puede agregar una carta al mazo? 
	public void agregarCartaAlMazo(Carta unMonstruo) {
		this.mazo = unMonstruo;
	}

	public void tomarCartaDelMazo() {
		this.mano = this.mazo;
		
		this.mazo = null;
		
	}

	public void invocar(Carta unMonstruo) {
		
		if(this.mano == unMonstruo){
			campoDelJugador.colocar(unMonstruo);
		}
	}

	public void atacarCon_A(CartaMonstruo carta, CartaMonstruo otraCarta) {
		carta.atacar(otraCarta);
		
	}

	public void restarVida(int vida) {
		this.puntosDeVida -= vida;
		
	}
	
	public void destruirCarta(CartaMonstruo carta) {
		this.mano = null;
	}

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public CampoDeBatalla obtenerCampoDeBatalla() {
		return campoDelJugador;
	}
}
