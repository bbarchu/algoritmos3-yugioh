package Application;

public class ModoDefensa extends ModoDeUso {

	public ModoDefensa(int defensa) {
		super(defensa);
	}

	@Override
	public void atacar(CartaMonstruo otraCarta) {
		//Aca hay que tirar excepcion
		
	}

	@Override
	public void recibirPuntosAtaque(int puntosDeAtaqueEntrantes) {
		if (this.puntosDefensa < puntosDeAtaqueEntrantes) {
			
		}
	}
	
	
}
