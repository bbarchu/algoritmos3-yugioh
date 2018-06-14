package Application;

public class CartaMagica extends Carta {
	
	private Estado estado;
	protected Jugador jugador;
	
	// Efecto
	
	public CartaMagica(Estado unEstado, Jugador unJugador) {
		
		this.estado = unEstado;
		this.jugador = unJugador;
	}
	
	public CartaMagica(Estado unEstado) {
		
		this.estado = unEstado;
	}
	
	@Override
	public void destruite(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.destruir(this);
	}
	
	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);		
	}

/*	@Override
	public void atacarA(Carta monstruoDelRival) {
		// Deberia lanzar una excepcion ya que una carta de magia no puede atacar.
		
	}
*/	
	public boolean estaBocaArriba() {
		
		return (estado.estaActiva());
	}

	public void activarEfecto() {
		// TODO Auto-generated method stub
	}

	@Override
	public void invocate(Jugador jugador) {
		jugador.invocar(this);
	}
	
	
	
//	public void invocarBocaAbajo() {
	
//		estado = new BocaAbajo();
		
//		campoDeJuego.invocar(this);
//	}
}
