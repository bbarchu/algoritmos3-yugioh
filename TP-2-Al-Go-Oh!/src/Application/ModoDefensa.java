package Application;

public class ModoDefensa extends ModoDeUso {

	public ModoDefensa() {
	}

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		//Aca hay que tirar excepcion
		
	}

	@Override
	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		int puntosAtaque = cartaAtacante.obtenerPuntosDeAtaque();
		int puntosDefensa = cartaAtacada.obtenerPuntosDeDefensa();
		if (puntosDefensa < puntosAtaque) {
			cartaAtacada.destruirCarta();
		}
		else if (puntosAtaque < puntosDefensa) {
			cartaAtacante.destruirCarta();
		}
		
		//Dejo el else {} para lo que se hace en caso de empate
	}
	
	
}
