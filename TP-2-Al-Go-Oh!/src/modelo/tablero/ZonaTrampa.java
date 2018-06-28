package modelo.tablero;

import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;

public class ZonaTrampa extends Zona implements Observable, Observador{
	
	private static int capacidadMaxima = 5;
	
	private Observable observado;
	
	public ZonaTrampa() {
		
		super(capacidadMaxima);
		
		observado = null;
	}

	 public ZonaTrampa(int cantidadMaximaCartasMagia){
			
		 super (cantidadMaximaCartasMagia);
		
		 observado = null;
	}
	 
	public void observarA(ZonaMagia zona) {
		
		observado = zona;
	}
	 
	public void activarCartaTrampa(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		if(!this.estaVacio()) {
			
			CartaTrampa cartaTrampa = obtenerPrimerCartaTrampa();
		
			cartaTrampa.activarEfecto(atacante, atacado);
		}
	}
	
	public void desactivarCartaTrampa(CampoDeBatalla campo) {
		
		if(!this.estaVacio()) {
			
			CartaTrampa cartaTrampa = obtenerPrimerCartaTrampa();
			
			cartaTrampa.desactivarEfecto();
			
			cartaTrampa.destruite(campo);
		}
		
	}
	
	private CartaTrampa obtenerPrimerCartaTrampa() {
		
		int posicionPrimerCarta = 0; 
		
		CartaTrampa carta = (CartaTrampa) this.verCartas().get(posicionPrimerCarta);
		
		return carta;
	}
	
	@Override
	public void agregarCarta(Carta carta) {
		
		super.agregarCarta(carta);
		
		if(seEstaObservandoUnaZona()) this.notificarColocacionDeUnaCarta();
	}
	
	@Override
	public void eliminarCarta(Carta carta) {
		
		super.eliminarCarta(carta);
		
		if(seEstaObservandoUnaZona()) this.notificarDestruccionDeUnaCarta();
	}
	
	public boolean seEstaObservandoUnaZona() {
		
		return (this.observado != null);
	}
	
	@Override
	public void seHaColocadoUnaCarta() {
		
		this.cantidadDeCartas++;	
	}

	@Override
	public void seHaDestruidoUnaCarta() {
		
		this.cantidadDeCartas--;
	}

	@Override
	public void notificarColocacionDeUnaCarta() {
		
		this.observado.seHaColocadoUnaCarta();
	}

	@Override
	public void notificarDestruccionDeUnaCarta() {
		
		this.observado.seHaDestruidoUnaCarta();
	}
}
