package Application;

public abstract class ModoDeUso {

	protected int puntosParaDefender;
	
	public ModoDeUso(int defensa) {
		this.puntosParaDefender = defensa;
	}

	public abstract void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta);

	public abstract void defender(CartaMonstruo carta, CartaMonstruo cartaAtacada);
}
