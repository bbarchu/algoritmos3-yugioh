package Application;

public class CampoDeBatalla {

//	Zona cartasMagicas;
//	Zona cartasCampo;
//	Zona cartasTrampa;
	
	Zona cartasMonstruo;
	Carta cartaMagica;
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
	
	public void colocar(CartaMagica unaCartaMagica ) {
		
		this.cartaMagica = unaCartaMagica;	
		
		if(unaCartaMagica.estaBocaArriba()) {		
			unaCartaMagica.activarEfecto();
		}
	}
	
	public void colocar(CartaTrampa unaCartaTrampa ) {
		
		this.cartaMagica = unaCartaTrampa;
	}
	
	public void colocar(CartaMonstruo unMonstruo) {
		
		verificarEstrellasDelMonstruo(unMonstruo);
		this.cartasMonstruo.agregarCarta(unMonstruo);
	}
	
	private void verificarEstrellasDelMonstruo(CartaMonstruo unMonstruo) {
		unMonstruo.realizarSacrificiosNecesariosEn(this);	
	}
	
	public void destruir(Carta unaCarta) {
		
		unaCarta.destruite(this);
	
	}
	
	public void destruir(CartaMonstruo unMonstruo) {
		
		// Aca puede lanzar una excepcion si no la encuentra
		
		cartasMonstruo.eliminarCarta(unMonstruo);
		cementerio.agregarCarta(unMonstruo);
	}
	
	public void destruir(CartaMagica unaCartaMagica) {
		
		// Aca puede lanzar una excepcion si no la encuentra
		
		cartaMagica = null;
		cementerio.agregarCarta(unaCartaMagica);
	}
	
	public void destruirUnMonstruo() {
		
		cementerio.agregarCarta(cartasMonstruo.eliminarCartaMasAntigua());
	}
	
	// Lucas: Los metodos HayCartas deberían ser eliminados ya que se crearon solo para las pruebas
	// Lucas: Dichas pruebas también deberían ser eliminadas ya que no prueban comportamiento
	
	public Boolean hayCartasMonstruo() {
		
		return (!cartasMonstruo.estaVacio());
	}

	public Boolean hayCartasMagicas() {
		
		return (cartaMagica != null);
	}
	
	public boolean estaEnElCementerio(Carta unaCarta){
		return (cementerio.contiene(unaCarta));
	}
	
 	public void activarEfectoDe(AgujeroNegro carta) {
		
		while(!cartasMonstruo.estaVacio()) {
			
			Carta cartaAEliminar = cartasMonstruo.eliminarCartaMasAntigua();
			this.cementerio.agregarCarta(cartaAEliminar);
		}
	}
	
/*	public Boolean hayCartasEnElCementerio() {
	
		return (!cementerio.estaVacio());
	}
*/	

}
