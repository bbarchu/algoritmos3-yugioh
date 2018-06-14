package Application;

public class CampoDeBatalla {

//	ZonaCartasMagicas cartasMagicas;
//	ZonaCartasCampo cartasCampo;
//	ZonaCartasTrampa cartasTrampa;
//	Cementerio cementerio;
//	Mazo mazo;
//	Mano mano;
	
	Zona cartasMonstruo;
	CartaMagica cartaMagica;
	Cementerio cementerio;
	
	public CampoDeBatalla() {
		int cantidadMaximaMonstruos = 5;
		
		cartasMonstruo = new ZonaMonstruos(cantidadMaximaMonstruos);
		cartaMagica = null;
		cementerio = new Cementerio();
	}
	
	public void colocar(Carta unaCarta) {
		unaCarta.colocateEn(this);	
	}
	
	public void colocar(CartaMonstruo unMonstruo) {
		
		verificarEstrellasDelMonstruo(unMonstruo);
		this.cartasMonstruo.agregarCarta(unMonstruo);
	}
	
	private void verificarEstrellasDelMonstruo(CartaMonstruo unMonstruo) {
		unMonstruo.realizarSacrificiosNecesariosEn(this);	
	}

	public void colocar(CartaMagica unaCartaMagica ) {
		
		this.cartaMagica = unaCartaMagica;	
		
		if(cartaMagica.estaBocaArriba()) {		
			cartaMagica.activarEfecto();
		}
	}
	
	public void destruir(Carta unaCarta) {
		
		unaCarta.destruite(this);
	
	}
	
	public void destruir(CartaMonstruo unMonstruo) {
		
		// Aca puede lanzar una excepcion si no la encuentra
		
		cartasMonstruo.eliminarCarta(unMonstruo);
		cementerio.agregarCarta(unMonstruo);
	}
	
	public void destruirUnMonstruo() {
		
		cementerio.agregarCarta(cartasMonstruo.eliminarMonstruo());
	}
	
	// Lucas: Los metodos HayCartas deberían ser eliminados ya que se crearon solo para las pruebas
	// Lucas: Dichas pruebas también deberían ser eliminadas ya que no prueban comportamiento
	
	public Boolean hayCartasMonstruo() {
		
		return (!cartasMonstruo.estaVacio());
	}

	public Boolean hayCartasMagicas() {
		
		return (cartaMagica != null);
	}
	
	public Boolean hayCartasEnElCementerio() {
		
		return (!cementerio.estaVacio());
	}
	
	public void activarEfectoDe(AgujeroNegro carta) {
		
		while(!cartasMonstruo.estaVacio()) {
			
			Carta cartaAEliminar = cartasMonstruo.eliminarMonstruo();
			this.cementerio.agregarCarta(cartaAEliminar);
		}
	}
	

}
