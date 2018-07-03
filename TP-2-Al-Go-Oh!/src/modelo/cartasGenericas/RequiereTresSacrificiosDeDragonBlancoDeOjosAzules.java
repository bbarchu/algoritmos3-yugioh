package modelo.cartasGenericas;

import java.util.LinkedList;

import modelo.tablero.CampoDeBatalla;

public class RequiereTresSacrificiosDeDragonBlancoDeOjosAzules extends Sacrificio {
	
	private static int cantidadDeSacrificios = 3;
	
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

	@Override
	public boolean sePuedeRealizarElSacrificio(CampoDeBatalla campoDeBatalla) {
		
		return (super.hayLaCantidadDeMonstruosNecesarios(campoDeBatalla, cantidadDeSacrificios));
	}
}
