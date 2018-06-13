package Application;

public class CampoDeBatalla {

	
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
		// EL PROBLEMA ES QUE LA CARTA NO CONOCE LOS CAMPOS, PODRIA MANDARLE UN COMO PARAMETRO
		// PERO NO CONOCE EL ENEMIGO. LAS CARTAS DEBERIAN CONOCER DONDE ESTAN O CONOCER EL CAMPO
		// A TRAVES DE UN ATRIBUTO DE CLASE
		if(cartaMagica.estaBocaArriba()) cartaMagica.activarEfecto();
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
	
	public void activarEfectoDe(AgujeroNegro carta) {
		
		this.cementerio = this.cartaMonstruo;
		this.cartaMonstruo = null;
		
	}
	

}
