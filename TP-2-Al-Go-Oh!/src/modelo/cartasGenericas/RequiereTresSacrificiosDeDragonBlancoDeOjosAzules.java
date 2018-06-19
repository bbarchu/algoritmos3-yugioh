package modelo.cartasGenericas;

import java.util.LinkedList;

import modelo.tablero.CampoDeBatalla;

public class RequiereTresSacrificiosDeDragonBlancoDeOjosAzules extends Sacrificio {
	
	public static String nombreCartaSacrificada = "DragonBlancoDeOjosAzules";
	
	public RequiereTresSacrificiosDeDragonBlancoDeOjosAzules() {
		super();
	}

	@Override
	public void sacrificarDeSerNecesario(CampoDeBatalla campoDeBatalla) {
		
		LinkedList<CartaMonstruo> cartas = campoDeBatalla.buscarTresCartasMonstruoIguales(nombreCartaSacrificada);
		while(!cartas.isEmpty()) {
			campoDeBatalla.destruir(cartas.removeFirst());
		}
		
	}
}
