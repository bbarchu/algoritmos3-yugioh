package Application;

public abstract class ModoDeUso {

	protected int puntosDefensa;
	
	public ModoDeUso(int defensa) {
		this.puntosDefensa = defensa;
	}

	public abstract void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta);

	public abstract void recibirPuntosAtaque(CartaMonstruo Carta);
}
