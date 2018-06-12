package Application;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class CartaMonstruo extends Carta{
	
	private Jugador jugador;
	
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
	
	public CartaMonstruo(int puntosATK, int puntosDEF, int estrellas, ModoDeUso unModo, Jugador jugador) {
		
		this.puntosDeAtaque = puntosATK;
		this.puntosDeDefensa = puntosDEF;
		this.cantidadEstrellas = estrellas;
		this.modo = unModo;
		this.jugador = jugador;
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);
		
	}

	public void recibirPuntosAtaque(CartaMonstruo otraCarta) {
		this.modo.defender(otraCarta, this);
		
	}
	
	public void destruirCarta() {
		this.jugador.destruirCarta(this);
	}

	public int obtenerPuntosDeAtaque() {
		return puntosDeAtaque;
	}

	public void atacar(CartaMonstruo otraCarta) {
		this.modo.atacar(otraCarta,this);
		
	}

	public void restarVidaAJugador(int vida) {
		this.jugador.restarVida(vida);
		
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
