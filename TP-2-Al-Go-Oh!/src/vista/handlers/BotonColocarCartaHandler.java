package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.aplicacion.AlGoOh;
import vista.VistaCampoDeBatalla;

public class BotonColocarCartaHandler implements EventHandler<ActionEvent> {

	VistaCampoDeBatalla vistaCampo;
	AlGoOh algooh;
	TextField texto;
	
	public BotonColocarCartaHandler(VistaCampoDeBatalla vistaCampo, AlGoOh algooh, TextField texto) {
		this.vistaCampo = vistaCampo;
		this.algooh = algooh;
		this.texto = texto;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		System.out.println (algooh.nombresConcatenadosCartasManoJugadorActual());
		this.algooh.colocarEnElCampoDelJugadorActual(texto.getText());
		this.vistaCampo.actualizarManoYCampoPropio();
		
	}

	
}
