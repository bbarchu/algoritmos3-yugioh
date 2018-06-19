package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class CartaMonstruo extends Carta{
	
	protected Jugador jugador;
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	protected String nombre;
	
	protected ModoDeUso modo;
	private Estado estado;
	protected Sacrificio sacrificioRequerido;
	
	//Efecto (puede tener o no un efecto)
	
	
public CartaMonstruo(int puntosATK, int puntosDEF, int estrellas, ModoDeUso unModo, Jugador jugador, String nombre) {
		
		this.nombre = nombre;
		this.puntosDeAtaque = puntosATK;
		this.puntosDeDefensa = puntosDEF;
		this.modo = unModo;
		this.jugador = jugador;
		this.estado = new BocaAbajo();
		//Esta parte despues se puede modificar para sacar los if
		if(estrellas <= 4) {
			this.sacrificioRequerido = new NoRequiereSacrificio();
		}else if(estrellas <= 6) {
			this.sacrificioRequerido = new RequiereUnSacrificio();
		}else {
			this.sacrificioRequerido = new RequiereDosSacrificios();
		}
	}
	
	public CartaMonstruo(ModoDeUso unModo) {
		
		this.puntosDeAtaque = 0;
		this.puntosDeDefensa = 0;
		this.modo = unModo;
		this.estado = new BocaAbajo();
		this.sacrificioRequerido = new NoRequiereSacrificio();
	
	}
	
	public CartaMonstruo(int puntosATK, int puntosDEF, int estrellas, ModoDeUso unModo, Jugador jugador) {
		
		this.puntosDeAtaque = puntosATK;
		this.puntosDeDefensa = puntosDEF;
		this.modo = unModo;
		this.jugador = jugador;
		this.estado = new BocaAbajo();
		
		//Esta parte despues se puede modificar para sacar los if
		if(estrellas <= 4) {
			this.sacrificioRequerido = new NoRequiereSacrificio();
		}else if(estrellas <= 6) {
			this.sacrificioRequerido = new RequiereUnSacrificio();
		}else {
			this.sacrificioRequerido = new RequiereDosSacrificios();
		}
	}
	
	public void voltearCarta() {
		
		this.estado = new BocaArriba();
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);
	}

	public void recibirPuntosAtaque(CartaMonstruo otraCarta) {
		this.modo.defender(otraCarta, this);	
	}
		
	//Bar: agrego esta linea para verificar que existan en el cementerio.
	//Lucas: comento este metodo porque el campo elimina las cartas, y no las cartas a ellas mismas.
	
	public void destruirCarta() {
		this.destruite(jugador.obtenerCampoDeBatalla());
	}

	public int obtenerPuntosDeAtaque() {
		return puntosDeAtaque;
	}
	
	public int obtenerPuntosDeDefensa() {
		return this.puntosDeDefensa;
	}
	
	public void atacar(CartaMonstruo otraCarta) {
		
		this.modo.atacar(otraCarta,this);
		
		//else LANZAR EXCEPCION
	}

	public void restarVidaAJugador(int decrementoVida) {
		this.jugador.restarVida(decrementoVida);
		
	}

	public boolean estaBocaArriba() {
		
		return (estado.estaActiva());
	}
	
	@Override
	public void invocate(Jugador jugador) {
		jugador.invocar(this);
	}

	public void realizarSacrificiosNecesariosEn(CampoDeBatalla campoDeBatalla) {
		sacrificioRequerido.sacrificarDeSerNecesario(campoDeBatalla);
	}

	@Override
	public void destruite(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.destruir(this);
	}
	
	public void aumentarPuntosDeAtaqueEn(int puntosAAumentar) {
		this.puntosDeAtaque += puntosAAumentar;
	}
	
	public void aumentarPuntosDeDefensaEn(int puntosAAumentar) {
		this.puntosDeDefensa += puntosAAumentar;
	}

	public String getNombre() {
		return this.nombre;
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
