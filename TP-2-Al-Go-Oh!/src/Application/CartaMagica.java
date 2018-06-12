package Application;

public class CartaMagica extends Carta {
	
	private Estado estado;
	
	// Efecto
	
	public CartaMagica(Estado unEstado) {
		this.estado = estado;
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);		
	}
	
//	public void invocarBocaAbajo() {
	
//		estado = new BocaAbajo();
		
//		campoDeJuego.invocar(this);
//	}
}
