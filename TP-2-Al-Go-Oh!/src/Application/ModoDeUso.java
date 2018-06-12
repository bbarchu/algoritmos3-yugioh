package Application;

public abstract class ModoDeUso {
	
	public ModoDeUso() {
	}

	public abstract void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta);

	public abstract void defender(CartaMonstruo carta, CartaMonstruo cartaAtacada);
}
