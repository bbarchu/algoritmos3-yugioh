package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
        System.exit(0);		
	}

}
