package modelo.tablero;

public interface Observador {

	public void notificarColocacionDeUnaCarta();
	
	public void notificarDestruccionDeUnaCarta();
}
