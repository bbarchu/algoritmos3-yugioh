package Application;

public class CartaMonstruo extends Carta{
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private int cantidadEstrellas;
	

	private ModoDeUso modo;
	private Estado estado;
	//Efecto (puede tener o no un efecto)
	
	public CartaMonstruo(ModoDeUso unModo) {
		
		this.puntosDeAtaque = 0;
		this.puntosDeDefensa = 0;
		this.cantidadEstrellas = 0;
		this.modo = unModo;
	}
	
	public CartaMonstruo(int puntosATK, int puntosDEF, int estrellas, ModoDeUso unModo) {
		
		this.puntosDeAtaque = puntosATK;
		this.puntosDeDefensa = puntosDEF;
		this.cantidadEstrellas = estrellas;
		this.modo = unModo;
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);
		
	}
	
	
	
/*	public void invocar(ModoDeUso estadoDeLaInvocacion) {
		
		modo = estadoDeLaInvocacion;
		
		campoDeJuego.invocar(this);
	}
	
	public void colocarEnPosicionDeAtaque() {
		
		posicion = new PosicionDeAtaque();
	}
	
	public void colocarEnPosicionDeDefensa() {
		
		posicion = new PosicionDeDefensa();
	}

*/

}
