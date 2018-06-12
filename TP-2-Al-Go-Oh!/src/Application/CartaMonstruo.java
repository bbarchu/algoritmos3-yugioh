package Application;

public class CartaMonstruo extends Carta{
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private int cantidadEstrellas;
	
	private Posicion posicion;
	private Estado estado;
	
	
	//Efecto (puede tener o no un efecto)
	
	public CartaMonstruo(int puntosATK, int puntosDEF, int estrellas) {
		
		this.puntosDeAtaque = puntosATK;
		this.puntosDeDefensa = puntosDEF;
		this.cantidadEstrellas = estrellas;
	}
	
	public void invocar(Estado estadoDeLaInvocacion) {
		
		estado = estadoDeLaInvocacion;
		
		campoDeJuego.invocar(this);
	}
	
	public void colocarEnPosicionDeAtaque() {
		
		posicion = new PosicionDeAtaque();
	}
	
	public void colocarEnPosicionDeDefensa() {
		
		posicion = new PosicionDeDefensa();
	}



}
