package modelo.tablero;

import java.util.LinkedList;

import modelo.cartasEspecificas.AgujeroNegro;
import modelo.cartasEspecificas.Fisura;
import modelo.cartasEspecificas.Sogen;
import modelo.cartasEspecificas.Wasteland;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaCampo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;

public class CampoDeBatalla {

//	Zona cartasMagicas;
//	Zona cartasCampo;
//	Zona cartasTrampa;
	
	ZonaMonstruos cartasMonstruo;
	Zona cartasMagiaTrampa;
	Zona cartaCampo;
	
	
	Carta cartaMagica;
	Cementerio cementerio;
	
	public CampoDeBatalla() {
		
		int cantidadMaximaMonstruos = 5;
		int cantidadMaximaDeMagiaTrampa = 5;
		int cantidadMaximaCampo = 1;
		
		
		cartasMonstruo = new ZonaMonstruos(cantidadMaximaMonstruos);
		cartasMagiaTrampa = new ZonaMagiaTrampa(cantidadMaximaDeMagiaTrampa);
		cartaCampo = new ZonaCartaCampo(cantidadMaximaCampo);
		cementerio = new Cementerio();
		
		
		
	}
	
	public CartaMonstruo buscarCartaMonstruo (String nombreCartaMonstruo) {
		CartaMonstruo carta = cartasMonstruo.buscar(nombreCartaMonstruo);
		return carta;
	}

	public void colocar(Carta unaCarta) {
		unaCarta.colocateEn(this);	
	}
	
	public void colocar(CartaMagica unaCartaMagica ) {
		
		
		this.cartasMagiaTrampa.agregarCarta(unaCartaMagica);
		
		if(unaCartaMagica.estaBocaArriba()) {		
			unaCartaMagica.activarEfecto();
			// Solo un uso van al cementerio : bar;
			
			unaCartaMagica.destruite(this);
		}
	}
	
	public void colocar(CartaTrampa unaCartaTrampa ) {
		
		
		this.cartasMagiaTrampa.agregarCarta(unaCartaTrampa);
	}
	
	public void colocar(CartaCampo unaCartaCampo ) {		
		this.cartaCampo.agregarCarta(unaCartaCampo);
		
		if(unaCartaCampo.estaBocaArriba()) {		
			unaCartaCampo.activarEfecto();
			
		}
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
		
		
		cartasMagiaTrampa.eliminarCarta(unaCartaMagica);
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

	
	public Boolean hayCartasMagiaOTrampa() {
		return (!cartasMagiaTrampa.estaVacio());
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
 	
 	public void activarEfectoDeMi(Wasteland carta) {
 		
 		cartasMonstruo.aumentarAtaqueEn(200);
 		
 	}
 	
 	public void activarEfectoContrarioDe(Wasteland carta) {
 		cartasMonstruo.aumentarDefensaEn(300);
 		
 	}
 	
 	public LinkedList<Carta> verCartasMonstruo() {
 		return cartasMonstruo.verCartas();
 	}
 	
 	public void activarEfectoDeMi(Sogen carta) {
 		
 		cartasMonstruo.aumentarDefensaEn(500);

 	}
 	public void activarEfectoContrarioDe(Sogen carta) {
		cartasMonstruo.aumentarAtaqueEn(200);
		
	}
 	
public void activarEfectoDe(Fisura carta) {
 		
 		cartasMonstruo.destruirLaDeMenorAtaque();
	}
	
/*	public Boolean hayCartasEnElCementerio() {
	
		return (!cementerio.estaVacio());
	}
*/	

}
