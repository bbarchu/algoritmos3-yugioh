package vista.handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import vista.Aplicacion;

public class CartaClickeadaHandler implements EventHandler<Event>{

	@Override
	public void handle(Event imagenCarta) {
		
		Aplicacion.setCardValue(((ImageView)imagenCarta.getSource()).getAccessibleHelp());
		
	}

}
