package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import vista.ContenedorFinal;

public class BotonCambiarDeTurnoHandler implements EventHandler<ActionEvent> {
    
	Stage stage;
    Scene proximaEscena;
    AlGoOh algooh;

    public BotonCambiarDeTurnoHandler(Stage stage, Scene proximaEscena, AlGoOh algooh) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.algooh = algooh;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
       
    	this.algooh.cambiarDeTurno();
    	
    	if(algooh.terminoLaPartida()) {
    	   	ContenedorFinal contenedorFinal = new ContenedorFinal(stage, algooh);
    	   	Scene escenaFinal = new Scene(contenedorFinal, 640, 480);
    		this.stage.setScene(escenaFinal);
    	}
    	else {
    		this.stage.setScene(proximaEscena);
    	}
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(true);
    }
}