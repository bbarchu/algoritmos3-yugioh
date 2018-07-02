package vista.handlers;

import java.util.LinkedList;

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

			this.algooh.activarCartaMagicaDelJugadorActual(texto.getText());
		
	}
	
	
}
