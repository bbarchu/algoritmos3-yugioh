package Application;

public class ModoAtaque extends ModoDeUso {
	
	private int puntosParaAtacar;
	
	public ModoAtaque(int defensa, int ataque) {
		super(defensa);
		this.puntosAtaque = ataque;
	}

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		otraCarta.recibirPuntosAtaque(miCarta);
	}
	
	

}
