package testComportamiento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.cartasEspecificas.AgujeroNegro;
import modelo.cartasEspecificas.Fisura;
import modelo.cartasEspecificas.InsectoComeHombres;
import modelo.cartasEspecificas.Wasteland;
import modelo.cartasGenericas.BocaAbajo;
import modelo.cartasGenericas.BocaArriba;
import modelo.cartasGenericas.CartaMonstruo;
import modelo.cartasGenericas.ModoAtaque;
import modelo.cartasGenericas.ModoDeUso;
import modelo.cartasGenericas.ModoDefensa;
import modelo.jugador.Jugador;

class PruebasDeIntegracion {

		
		
		private CartaMonstruo crearMonstruoNormal(int ataque, int defensa, Jugador jugador, ModoDeUso modo, String nombre) {
			
			int estrellas = 1;
			
			CartaMonstruo carta = new CartaMonstruo(ataque, defensa, estrellas, modo, jugador, nombre);
			
			return carta;
		}
	
		@Test
		void test001() {
			
			int cantidadDeCartasEnElMazo = 4;
			
			BocaArriba bocaArriba = new BocaArriba();
			BocaAbajo bocaAbajo = new BocaAbajo();
			
			ModoAtaque modoATQ = new ModoAtaque();
			ModoDefensa modoDEF = new ModoDefensa();
			
			//unJugador
			
			Jugador unJugador = new Jugador();
			
			String nombreDeMonstruoDeUnJugador = "Dinosaurio";
			int ATQMonstruoDeUnJugador = 2000;
			int DEFMonstruoDeUnJugador = 1500;
			
			CartaMonstruo monstruoNormalDeUnJugador = crearMonstruoNormal(ATQMonstruoDeUnJugador,ATQMonstruoDeUnJugador, unJugador, modoATQ,nombreDeMonstruoDeUnJugador);
			InsectoComeHombres insectoComeHombres = new InsectoComeHombres(modoDEF, unJugador);
			AgujeroNegro agujeroNegro = new AgujeroNegro(bocaArriba,unJugador);
			
			//creado solamente para que las cartas en el mazo no se acaben
			CartaMonstruo monstruoNoUtilizado = crearMonstruoNormal(ATQMonstruoDeUnJugador,ATQMonstruoDeUnJugador, unJugador, modoATQ,nombreDeMonstruoDeUnJugador);
			
			unJugador.agregarCartaAlMazo(monstruoNormalDeUnJugador);
			unJugador.agregarCartaAlMazo(insectoComeHombres);
			unJugador.agregarCartaAlMazo(agujeroNegro);
			unJugador.agregarCartaAlMazo(monstruoNoUtilizado);
			
			//otroJugador
			
			Jugador otroJugador = new Jugador();
			
			String nombreDeMonstruoDeOtroJugador = "Mago";
			int ATQMonstruoDeOtroJugador = 1000;
			int DEFMonstruoDeOtroJugador = 3500;
		
			CartaMonstruo monstruoNormalDeOtroJugador = crearMonstruoNormal(ATQMonstruoDeOtroJugador,DEFMonstruoDeOtroJugador, otroJugador, modoATQ,nombreDeMonstruoDeOtroJugador);
			Fisura fisura = new Fisura(bocaAbajo, otroJugador);
			Wasteland wasteland = new Wasteland(otroJugador);
			
			//creado solamente para que las cartas en el mazo no se acaben
			CartaMonstruo otroMonstruoNoUtilizado = crearMonstruoNormal(ATQMonstruoDeOtroJugador,DEFMonstruoDeOtroJugador, otroJugador, modoATQ,nombreDeMonstruoDeOtroJugador);
			
			otroJugador.agregarCartaAlMazo(monstruoNormalDeOtroJugador);
			otroJugador.agregarCartaAlMazo(fisura);
			otroJugador.agregarCartaAlMazo(wasteland);
			otroJugador.agregarCartaAlMazo(otroMonstruoNoUtilizado);
			
			
			unJugador.presentarJugadorRival(otroJugador);
			otroJugador.presentarJugadorRival(unJugador);
			
			//Fase inicial
			
			for(int i = 0 ; i < cantidadDeCartasEnElMazo ; i++) {
				
				unJugador.tomarCartaDelMazo();
				otroJugador.tomarCartaDelMazo();
			}
			
			unJugador.invocar(monstruoNormalDeUnJugador);
			unJugador.invocar(insectoComeHombres);
			
			
			otroJugador.invocar(monstruoNormalDeOtroJugador);
			otroJugador.invocar(fisura);
			
			otroJugador.voltearCarta(monstruoNormalDeOtroJugador);
			//se debe destruir el monstruo de otroJugador
			otroJugador.atacarConA(monstruoNormalDeOtroJugador, insectoComeHombres);
			
			int puntosDeVidaEsperadosDeOtroJugador = 8000;
			int puntosDeVidaEsperadosDeUnJugador = 8000;
			
			assertEquals(puntosDeVidaEsperadosDeOtroJugador, otroJugador.obtenerPuntosDeVida());
			assertEquals(puntosDeVidaEsperadosDeUnJugador, unJugador.obtenerPuntosDeVida());
			assertEquals(true, otroJugador.obtenerCampoDeBatalla().estaEnElCementerio(monstruoNormalDeOtroJugador));
			
			//al voltearse debe activar el efecto
			otroJugador.voltearCarta(fisura);
			
			assertEquals(puntosDeVidaEsperadosDeOtroJugador, otroJugador.obtenerPuntosDeVida());
			assertEquals(puntosDeVidaEsperadosDeUnJugador, unJugador.obtenerPuntosDeVida());
			assertEquals(true, unJugador.obtenerCampoDeBatalla().estaEnElCementerio(insectoComeHombres));
	
			
	
		}
}


