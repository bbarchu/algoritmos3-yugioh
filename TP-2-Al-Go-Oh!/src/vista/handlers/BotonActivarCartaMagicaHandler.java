package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.aplicacion.AlGoOh;
import vista.ContenedorFaseMagia;
import vista.VistaCampoDeBatalla;

public class BotonActivarCartaMagicaHandler implements EventHandler<ActionEvent>{

	VistaCampoDeBatalla vistaCampo;
	AlGoOh algooh;
	TextField texto;
	ContenedorFaseMagia contenedor;
	
	int contador;
	
	public BotonActivarCartaMagicaHandler(VistaCampoDeBatalla vistaCampo, AlGoOh algooh, TextField texto, ContenedorFaseMagia contenedor) {
		this.vistaCampo = vistaCampo;
		this.algooh = algooh;
		this.texto = texto;
		this.contenedor = contenedor;
		
		this.contador = 0;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(contador == 0) {
			this.vistaCampo.actualizarCampoDeBatalla();
			this.contenedor.actualizarLabel();
			contador++;
		}
		else {
			this.algooh.activarCartaMagicaDelJugadorActual(texto.getText());
			this.vistaCampo.actualizarCampoDeBatalla();
			this.contenedor.actualizarLabel();
		}
		
	}
	
	
}
