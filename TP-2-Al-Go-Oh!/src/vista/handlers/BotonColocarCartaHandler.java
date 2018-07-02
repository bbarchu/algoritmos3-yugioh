package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.aplicacion.AlGoOh;
import vista.ContenedorFasePreparacion;
import vista.VistaCampoDeBatalla;

public class BotonColocarCartaHandler implements EventHandler<ActionEvent> {

	VistaCampoDeBatalla vistaCampo;
	AlGoOh algooh;
	TextField texto;
	ContenedorFasePreparacion contenedor;
	
	public BotonColocarCartaHandler(VistaCampoDeBatalla vistaCampo, AlGoOh algooh, TextField texto,ContenedorFasePreparacion contenedor) {
		this.vistaCampo = vistaCampo;
		this.algooh = algooh;
		this.texto = texto;
		this.contenedor = contenedor;
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		this.algooh.colocarEnElCampoDelJugadorActual(texto.getText());
		this.contenedor.actualizar();
	}

	
}
