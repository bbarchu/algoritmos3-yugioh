package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.ContenedorFaseTrampas;
import vista.VistaCampoDeBatalla;

//TODO falta hacer que la aplicacion active las trampas


public class BotonActivarTrampasHandler implements EventHandler<ActionEvent>  {
	
	Stage stage;
	Scene proximaEscena;
	VistaCampoDeBatalla vistaCampo;
	ContenedorFaseTrampas contenedor;
 

  public BotonActivarTrampasHandler(Stage stage, Scene proximaEscena, VistaCampoDeBatalla vistaCampo, ContenedorFaseTrampas contenedor) {
    this.stage = stage;
    this.proximaEscena = proximaEscena;
    this.contenedor = contenedor;
  
  }

  @Override
  public void handle(ActionEvent actionEvent) {

      stage.setScene(proximaEscena);
      stage.setFullScreenExitHint("");
      stage.setFullScreen(true);
  
  }
}