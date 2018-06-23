package modelo.tablero;

import modelo.cartasGenericas.Carta;

public class ZonaMagia extends Zona implements Observable, Observador {
	
	private static int capacidadMaxima = 5;
	
	private Observable observado;
	
	public ZonaMagia(int cantidadMaximaCartasMagia){
		
		super (cantidadMaximaCartasMagia);
		
		observado = null;
	}	
	
	public ZonaMagia() {
		
		super(capacidadMaxima);
		
		observado = null;
	}
	
	public void observarA(ZonaTrampa zona) {
		
		observado = zona;
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

