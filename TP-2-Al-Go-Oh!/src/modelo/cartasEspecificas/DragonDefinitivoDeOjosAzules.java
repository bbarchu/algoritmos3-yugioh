package modelo.cartasEspecificas;

import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoDeUso;
import modelo.cartasGenericas.RequiereTresSacrificiosDeDragonBlancoDeOjosAzules;
import modelo.cartasGenericas.Sacrificio;
import modelo.jugador.Jugador;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo{
	private static String nombre = "DragonDefinitivoDeOjosAzules";
	private static int puntosDeAtaque = 4500;
	private static int puntosDeDefensa = 3800;
	private static int estrellas = 12;
	private static Sacrificio sacrificioDragon = new RequiereTresSacrificiosDeDragonBlancoDeOjosAzules();
	
	public DragonDefinitivoDeOjosAzules(ModoDeUso unModo, Jugador unJugador) {
		super(puntosDeAtaque, puntosDeDefensa, estrellas, unModo, unJugador, nombre);
		this.sacrificioRequerido = sacrificioDragon;
	}

}
