package Application;

public class CampoDeBatalla {


	
	//bar: Campo a que se debe? no entendi si es la zona campo, o a que se refiere? De todas maneras extendi zona, a sus herederas.
	
//	ZonaCartasMonstruos cartasMonstruo;
//	ZonaCartasMagicas cartasMagicas;
//	ZonaCartasCampo cartasCampo;
//	ZonaCartasTrampa cartasTrampa;
//	Cementerio cementerio;
//	Mazo mazo;
//	Mano mano;
	
	Carta cartaMonstruo;
	Carta cartaMagica;
	Carta cementerio;
	
	public CampoDeBatalla() {
		cartaMonstruo = null;
		cartaMagica = null;
		cementerio = null;
	}
	
	public void colocar(Carta unaCarta) {
		unaCarta.colocateEn(this);	
	}
	public void colocar(CartaMonstruo unMonstruo) {
		this.cartaMonstruo = unMonstruo;	
	}
	public void colocar(CartaMagica unaCartaMagica ) {
		this.cartaMagica = unaCartaMagica;	
	}
	

	public void destruir(Carta unaCarta) {
		// Esta es una solucion mala, pero es lo que propone TDD
		
		if(cartaMonstruo == unaCarta) {
			cartaMonstruo = null;
		}
		else if(cartaMagica == unaCarta) {
			cartaMagica = null;
		}
		
		this.cementerio = unaCarta;
	}
	
	// Lucas: Los metodos HayCartas deberían ser eliminados ya que se crearon solo para las pruebas
	// Lucas: Dichas pruebas también deberían ser eliminadas ya que no prueban comportamiento
	
	public Boolean hayCartasMonstruo() {
		
		return (cartaMonstruo != null);
	}

	public Boolean hayCartasMagicas() {
		
		return (cartaMagica != null);
	}
	
	public Boolean hayCartasEnElCementerio() {
		
		return (cementerio != null);
	}
	

}
