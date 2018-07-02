package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import vista.VistaCampoDeBatalla;

public class BotonTomarCartaHandler implements EventHandler<ActionEvent>  {
	
    Stage stage;
    Scene proximaEscena;
    AlGoOh algooh;
    VistaCampoDeBatalla vistaCampo;
   

    public BotonTomarCartaHandler(Stage stage, Scene proximaEscena, AlGoOh algooh, VistaCampoDeBatalla vistaCampo) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.algooh = algooh;
        this.vistaCampo = vistaCampo;
        
   
    }

    @Override
    public void handle(ActionEvent actionEvent) {

		this.vistaCampo.actualizarCampoDeBatalla();
		this.algooh.jugadorActualTomaUnaCarta();
	    this.stage.setScene(proximaEscena);
	    this.stage.setFullScreenExitHint("");
	    this.stage.setFullScreen(true);
    	
    }
}
