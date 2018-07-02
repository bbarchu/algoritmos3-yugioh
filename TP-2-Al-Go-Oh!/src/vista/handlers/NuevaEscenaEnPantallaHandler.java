package vista.handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import vista.Contenedor;

public class NuevaEscenaEnPantallaHandler implements EventHandler<Event> {

	Contenedor contenedor;

    public NuevaEscenaEnPantallaHandler(Contenedor contenedor) {
        this.contenedor = contenedor;
    
    }
    
    
	@Override
	public void handle(Event event) {
		this.contenedor.actualizar();
		
	}


}
