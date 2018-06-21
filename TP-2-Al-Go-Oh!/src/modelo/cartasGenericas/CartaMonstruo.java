package modelo.cartasGenericas;

import modelo.TodaviaQuedanMonstruosParaAtacarEnElCampoError;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorModificable;
import modelo.jugador.OponenteAtacable;
import modelo.tablero.CampoDeBatalla;

public class CartaMonstruo extends Carta{
	
	protected JugadorModificable jugador;
	
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
	
	public void cambiarModoDeUso (ModoDeUso nuevoModo) {
		this.modo = nuevoModo;
	}
	
	public ModoDeUso getModoDeUsoActual () {
		return this.modo;
	}
	
	public void voltearCarta() {
		
		this.estado = new BocaArriba();
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.colocar(this);
	}

	public void recibirAtaque(CartaMonstruo otraCarta) {
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
	
	private void activarCartaTrampa(CartaMonstruo cartaAtacante) {
		
		this.jugador.obtenerCampoDeBatalla().activarCartaTrampa(cartaAtacante, this);
	}
	
	private void desactivarCartaTrampa(CartaMonstruo cartaAtacante) {
		
		this.jugador.obtenerCampoDeBatalla().desactivarCartaTrampa(cartaAtacante, this);
	}
	
	public void atacaConTuModo(CartaMonstruo unaCarta) {
		this.modo.atacar(unaCarta,this);
	}
	public void atacar(CartaMonstruo otraCarta) {
		
		otraCarta.activarCartaTrampa(this);
		this.modo.atacar(otraCarta,this);
		otraCarta.atacaConTuModo(this);
		
		
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
	
	public void disminuirPuntosDeAtaque(int decremento) {
		
		this.puntosDeAtaque = puntosDeAtaque - decremento;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void atacarDirectoAlJugadorRival() {
		OponenteAtacable jugadorRival = jugador.obtenerJugadorRival();
		if (jugadorRival.obtenerCampoDeBatalla().hayCartasMonstruo()) {
			throw new TodaviaQuedanMonstruosParaAtacarEnElCampoError();
			
		}
		
		int puntosDeDaño = modo.obtenerPuntosDeDaño(this);
		jugadorRival.restarVida(puntosDeDaño);	
				
	}
	
	public boolean sosDelJugador(Jugador unJugador) {
		return (this.jugador == unJugador);
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
