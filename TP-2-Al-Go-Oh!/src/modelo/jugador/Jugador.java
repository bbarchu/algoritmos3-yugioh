package modelo.jugador;

import java.util.Scanner;

import modelo.ElJugadorNoPuedeAtacarASusPropiasCartasError;
import modelo.TodaviaQuedanMonstruosParaAtacarEnElCampoError;
import modelo.aplicacion.TimerEx;
import modelo.cartasGenericas.Carta;
import modelo.cartasGenericas.CartaCampo;
import modelo.cartasGenericas.CartaMagica;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.CartaTrampa;
import modelo.tablero.CampoDeBatalla;

public class Jugador implements OponenteAtacable, JugadorModificable{
		
	//Lucas: el jugador debe poder interactuar con el jugadorRival para atacarlo
	//Lucas: considero que no es una buena solucion ya que el jugador no debería poder ver los metodos
	//			del otro jugador, debeía implementarse una interfaz que controle ese comportamiento
	//			Ej: interfaz obserbable, que solo permita ver las cartas del campo rival.
		int puntosDeVida;
		Mazo mazo;
		Mano mano;
		CampoDeBatalla campoDelJugador;	
		OponenteAtacable jugadorRival;
		boolean perdioLaPartida;
		boolean ganoLaPartida;
		String nombre;
	
	public Jugador() {
		
		nombre = "";
		this.puntosDeVida = 8000;
		this.mano = new Mano();
		this.mazo = new Mazo();
		this.campoDelJugador = new CampoDeBatalla();
		this.jugadorRival = null;
		this.ganoLaPartida = false;
		this.perdioLaPartida = false;
		
	}
	
	public void presentarJugadorRival(Jugador unJugador){
		
		jugadorRival = unJugador;
	}
	
	public void agregarNombre(String nombreJugador) {
		this.nombre = nombreJugador;
	}
	
	public String verNombre() {
		return this.nombre;
	}

	//bar: Por que el jugador puede agregar una carta al mazo?
	//Lucas: Respuesta -> es para controlar el comportamiento mientras se desarrolla el TP, en algun 
	//			momento este metodo va a pasar a ser privado y llamado únicamente en el constructor (cuando se llena el mazo).
	
	public void agregarCartaAlMazo(Carta unMonstruo) {
		this.mazo.agregarUnaCarta(unMonstruo);
	}

	public void tomarCartaDelMazo() {
		this.mano.tomarUnaCartaDel(this.mazo);
		
		if(mano.contieneLas5PartesDeExodia()) {
			this.ganoLaPartida = true;
		}
		if(mazo.estaVacio()) {
			this.perdioLaPartida = true;
		}
	}
	
	public void tomarCincoCartasDelMazo() {
		for(int i =0 ; i < 6 ; i++) {
			tomarCartaDelMazo();			
		}
	}

	public void invocar(Carta unaCarta) {
		unaCarta.invocate(this);
	}
	
	public void invocar(CartaMonstruo unMonstruo) {
		
		if(this.mano.contiene(unMonstruo)){
			campoDelJugador.colocar(unMonstruo);
		}
		this.eliminarDeLaMano(unMonstruo);
	}
	
	public void invocar(CartaTrampa trampa) {
		
		if(this.mano.contiene(trampa)) {
			
			campoDelJugador.colocar(trampa);
			this.eliminarDeLaMano(trampa);
		}
	}
	
	public void invocar(CartaMagica unaCartaMagica) {
		
		if(this.mano.contiene(unaCartaMagica)){
			campoDelJugador.colocar(unaCartaMagica);
		}
		this.eliminarDeLaMano(unaCartaMagica);
	}
	
	public void invocar(CartaCampo unaCartaCampo) {
		
		if(this.mano.contiene(unaCartaCampo)){
			campoDelJugador.colocar(unaCartaCampo);
		}
		this.eliminarDeLaMano(unaCartaCampo);
	}

	public void atacarConA(CartaMonstruo carta, CartaMonstruo otraCarta){
		if (otraCarta.sosDelJugador(this)) {
			throw new ElJugadorNoPuedeAtacarASusPropiasCartasError();
		}
		carta.atacar(otraCarta);
		
	}

	
	// Lucas: me parece un poco raro que un metodo que mata al jugador sea publico
	public void restarVida(int decrementoVida) {
		this.puntosDeVida -= decrementoVida;
		
		if(puntosDeVida <= 0) {
			this.perdioLaPartida = true;
			Jugador jugadorOponente = (Jugador) (jugadorRival);
			jugadorOponente.convertirEnGanador();
		}
		
	}
	
	private void eliminarDeLaMano(Carta unaCarta) {
		this.mano.eliminar(unaCarta);
	}

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public CampoDeBatalla obtenerCampoDeBatalla() {
		return campoDelJugador;
	}
	
	public OponenteAtacable obtenerJugadorRival() {
		return jugadorRival;
	}
	
	// este metodo fue creado para verificar el resultado de una prueba. Debe ser eliminado
	public int cantidadDeCartasEnLaMano(){
		int cantidad;
		
		cantidad = this.mano.obtenerCantidadDeCartas();
		
		return cantidad;
	}

	public boolean perdioLaPartida() {
		return this.perdioLaPartida;
	}

	public boolean ganoLaPartida() {
		return this.ganoLaPartida;
	}
	
	public void convertirEnGanador() {
		this.ganoLaPartida = true;
	}
	
	public void convertirEnPerdedor() {
		this.perdioLaPartida = false;
	}
	
	public boolean quierePasarDeFase() {
		String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); 
        entradaTeclado = entradaEscaner.nextLine ();
		while (entradaTeclado!="pasarfase") {
			//No hace nada
		}
		
		return true;
		//La onda aca es apretar un boton...
	}
	
	public void habilitarParaPonerCartasEnElCampo() {
		System.out.println("Es hora de poner cartas en el campo");
		System.out.println("Elige una carta de tu mano y colocala en el campo de batalla");
		        
        
        while (mano.quedanCartas()) {
        	
        	System.out.println("Escribe el nombre de la carta que quieres colocar o escribe pasarFase");
        	String entradaTeclado = "";
            Scanner entradaEscaner = new Scanner (System.in); 
            entradaTeclado = entradaEscaner.nextLine ();
            if (entradaTeclado == "pasarfase") {
            	return;
            }
            Carta cartaAColocar = mano.buscarCartaPorNombre(entradaTeclado);
            mano.eliminar(cartaAColocar);
            this.campoDelJugador.colocar(cartaAColocar);
            
            System.out.println("Quieres seguir poniendo cartas?");
        }
        
        System.out.println("Ups! no te quedan mas cartas en la mano );
        
		
		
	}
	
	public void habilitarAtaque() {
		System.out.println("Es hora de atacar");
		System.out.println("Elige una carta de tu campo seguido de un objetivo");
		
        
        While( quedanMonstruosSinAtacar()){
        	System.out.println("Escribe el nombre de la carta que quieres que ataque");
    		System.out.println("Si no quieres atacar, escribe pasarFase");
    		
    		String entradaTeclado = "";
            Scanner entradaEscaner = new Scanner (System.in); 
            entradaTeclado = entradaEscaner.nextLine ();
            if (entradaTeclado == "pasarfase") {
            	return;
            }
            
            //aca debe haber unn try catch porque si no lo encuentra este metodo tira excepcion, y no estaria bueno parar el juego
            CartaMonstruo cartaAtacante = this.campoDelJugador.buscarMonstruo(entradaTeclado);
            System.out.println("Escribe el nombre de la carta que quieres atacar");
            entradaTeclado = "";
            entradaTeclado = entradaEscaner.nextLine ();
            if (entradaTeclado == "pasarfase") {
            	return;
            }
            CartaMonstruo cartaAtacada = jugadorRival.obtenerCampoDeBatalla().buscarMonstruo(entradaTeclado);
            
            //aca no contemplo modos!
            cartaAtacante.atacar(cartaAtacada);
            //Eliminar de monstruosSinAtacar
        }
        
        System.out.println("Ups! ya atacaste con todos tus monstruos ");
	}
	
	public void habilitarActivacionDeCartasMagicas() {
		System.out.println("Activa las cartas mágicas que creas necesarias");		
		System.out.println("Elige una carta de tu campo y si no quieres activar ninguna escribe pasarfase");
		
		while (campoDelJugador.quedanCartasMagicasSinActivar()) {
        	
        	System.out.println("Escribe el nombre de la carta que quieres colocar o escribe pasarFase");
        	String entradaTeclado = "";
            Scanner entradaEscaner = new Scanner (System.in); 
            entradaTeclado = entradaEscaner.nextLine ();
            if (entradaTeclado == "pasarfase") {
            	return;
            }
            Carta cartaAActivar = buscarCarta..;
           
            
            
            System.out.println("Quieres seguir activando cartas?");
        }
		
		System.out.println("Ups! ya activaste todas tus cartas magicas del campo ");
	}
}
