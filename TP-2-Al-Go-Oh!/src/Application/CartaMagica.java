package Application;

public class CartaMagica extends Carta {
	
	private Estado estado;
	// Efecto
	
	
	
	public void invocarBocaAbajo() {
	
		estado = new BocaAbajo();
		
		campoDeJuego.invocar(this);
	}
}
