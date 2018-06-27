package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;

public class BotonTomarCartaHandler implements EventHandler<ActionEvent>  {
	
    Stage stage;
    Scene proximaEscena;
    AlGoOh algooh;

    public BotonTomarCartaHandler(Stage stage, Scene proximaEscena, AlGoOh algooh) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.algooh = algooh;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algooh.jugadorActualTomaUnaCarta();
    	this.stage.setScene(proximaEscena);
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(true);
    }
}
