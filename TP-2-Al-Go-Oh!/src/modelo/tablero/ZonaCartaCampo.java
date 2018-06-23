package modelo.tablero;

public class ZonaCartaCampo extends Zona {
	
	private static int capacidadMaxima = 1;
	
	public ZonaCartaCampo(){
		
		super(capacidadMaxima);
	}
	
	public ZonaCartaCampo(int cantidadMaximaCartasCampo){
		
		super(cantidadMaximaCartasCampo);	
	}	 

}
