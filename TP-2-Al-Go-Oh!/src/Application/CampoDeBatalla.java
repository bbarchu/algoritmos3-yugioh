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
	
	public CampoDeBatalla() {
		cartaMonstruo = null;
		cartaMagica = null;
	}
	
	public void colocar(Carta unaCarta) {
		unaCarta.colocateEn(this);	
	}
	public void colocar(CartaMonstruo unMonstruo) {
		cartaMonstruo = unMonstruo;	
	}
	public void colocar(CartaMagica unaCartaMagica ) {
		cartaMagica = unaCartaMagica;	
	}
	

	public void destruir(Carta unaCarta) {
		//----------------------------------------------------//
		//					ME QUEDE POR ACA				  //
		//----------------------------------------------------//
		
	}
	
	// Lucas: Los metodos HayCartas deberían ser eliminados ya que se crearon solo para las pruebas
	// Lucas: Dichas pruebas también deberían ser eliminadas ya que no prueban comportamiento
	
	public Boolean hayCartasMonstruo() {
		
		return (cartaMonstruo != null);
	}

	public Boolean hayCartasMagicas() {
		
		return (cartaMagica != null);
	}

	

}
