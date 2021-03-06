package modelo.cartasGenericas;


import modelo.jugador.Jugador;
import modelo.jugador.JugadorModificable;
import modelo.jugador.OponenteAtacable;
import modelo.tablero.CampoDeBatalla;

public class CartaMonstruo extends Carta{
	
	protected JugadorModificable jugador;
	
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	protected ModoDeUso modo;
	private Estado estado;
	protected Sacrificio sacrificioRequerido;	
	
	
	
	public CartaMonstruo(int puntosATK, int puntosDEF, int estrellas, ModoDeUso unModo, Jugador jugador, String nombre) {
		
		this.nombre = nombre;
	
		this.puntosDeAtaque = puntosATK;
		this.puntosDeDefensa = puntosDEF;
		
		this.modo = unModo;
		this.jugador = jugador;
		this.estado = new BocaAbajo();
		
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
		

		if(estrellas <= 4) {
			this.sacrificioRequerido = new NoRequiereSacrificio();
		}else if(estrellas <= 6) {
			this.sacrificioRequerido = new RequiereUnSacrificio();
		}else {
			this.sacrificioRequerido = new RequiereDosSacrificios();
		}
	}
	
	public boolean estaEnModoDefensa() {
		
		return (this.modo.modoDefensa());
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
	
	public boolean verificarQueEsteInvocadaEn(CampoDeBatalla campo) {
		
		return (campo.verificarQueEstaEnElCampo(this));
	}

	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
		
		campoDeBatalla.colocar(this);
	}

	public void destruirCarta() {
		this.destruite(jugador.obtenerCampoDeBatalla());
	}

	public int obtenerPuntosDeAtaque() {
		return puntosDeAtaque;
	}
	
	public int obtenerPuntosDeDefensa() {
		return this.puntosDeDefensa;
	}
	
	public void activarCartaTrampa(CartaMonstruo cartaAtacante) {
		
		this.jugador.obtenerCampoDeBatalla().activarCartaTrampa(cartaAtacante, this);
	}
	
	public void desactivarCartaTrampa(CartaMonstruo cartaAtacante) {
		
		this.jugador.obtenerCampoDeBatalla().desactivarCartaTrampa(cartaAtacante, this);
	}
	
	public void atacar(CartaMonstruo otraCarta) {
		
		if(this.estaBocaArriba()) this.modo.atacarSiCorresponde(this, otraCarta);	
	}
	
	public void atacarA(CartaMonstruo cartaAtacada) {
	
		cartaAtacada.recibirAtaque(this);
	}
	
	public void recibirAtaque(CartaMonstruo atacante) {
		
		atacante.comenzarBatalla(this);
	}
	
	public void comenzarBatalla(CartaMonstruo cartaAtacada) {
		
		this.modo.realizarEnfrentamiento(this, cartaAtacada);
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
		modo.atacarDirectamente(this, jugadorRival);		
	}
	
	public boolean sosDelJugador(Jugador unJugador) {
		
		return (this.jugador == unJugador);
	}
	
	public int obtenerPuntosParaElEnfrentamiento() {
		
		return ( this.modo.obtenerPuntosUtilizadosEnElModoActual(this.puntosDeAtaque, this.puntosDeDefensa));
	}


	
	public void destruirSiCorrespondeA(CartaMonstruo cartaQueDestruir) {
		
		this.modo.destruirSiCorresponde(cartaQueDestruir);
	}
	
	public void restarVidaDeMiInvocadorSiCorresponde(int da�o) {
		
		this.modo.restarVidaDeMiInvocador(this, da�o);
	}

	public void restarVidaAlInvocadorDeSiCorresponde(CartaMonstruo cartaPerdedora, int danio) {
		
		this.modo.restarVidaDelInvocadorDe(cartaPerdedora, danio);
	}
	
	public void inhabilitar() {
		this.modo = new ModoInhabilitada();
	}

	public void habilitar() {
		this.modo = new ModoAtaque();
		
	}
	
	public boolean siHayLaCantidadDeSacrificiosNecesarios(CampoDeBatalla campo) {
		
		return (this.sacrificioRequerido.sePuedeRealizarElSacrificio(campo));
	}
}
