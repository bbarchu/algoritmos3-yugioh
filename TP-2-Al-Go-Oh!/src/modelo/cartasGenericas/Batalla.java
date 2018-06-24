package modelo.cartasGenericas;

public class Batalla {
	
	private CartaMonstruo atacante, atacada;
	
	private int puntosAtacante, puntosAtacado;
	
	public Batalla(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		
		this.atacante = cartaAtacante;
		this.atacada = cartaAtacada;
		
		this.puntosAtacante = this.atacante.obtenerPuntosParaElEnfrentamiento();
		this.puntosAtacado =  this.atacada.obtenerPuntosParaElEnfrentamiento();
		
		realizarEnfrentamiento();
		
	}

	
	private void realizarEnfrentamiento() {
		
		if (esUnEmpate()) destruccionMutua();
	
		else realizarBatalla();
	}
	
	private void realizarBatalla() {
		
		if(this.puntosAtacante > this.puntosAtacado) {
			
			this.atacante.restarVidaAlInvocadorDeSiCorresponde(this.atacada, puntosAtacante - puntosAtacado);
			this.atacante.destruirSiCorrespondeA(this.atacada);
		}
		
		else {
			
			this.atacada.restarVidaAlInvocadorDeSiCorresponde(this.atacante, puntosAtacado - puntosAtacante);
			this.atacada.destruirSiCorrespondeA(this.atacante);
		}
	}
	
	private boolean esUnEmpate() {
		
		return( this.puntosAtacante == this.puntosAtacado);
	}
	
	
	private void destruccionMutua() {
		
		this.atacante.destruirCarta();
		this.atacada.destruirCarta();
	}
}
