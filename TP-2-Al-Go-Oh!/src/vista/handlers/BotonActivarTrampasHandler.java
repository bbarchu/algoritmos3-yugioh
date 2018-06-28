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
	
	int contador;
 

  public BotonActivarTrampasHandler(Stage stage, Scene proximaEscena, VistaCampoDeBatalla vistaCampo) {
    this.stage = stage;
    this.proximaEscena = proximaEscena;
  
  	this.contador = 0;
  }

  @Override
  public void handle(ActionEvent actionEvent) {
	  if(contador == 0) {
		  //this.vistaCampo.actualizarCampoDeBatalla();
		  contador ++;
	  }
	  else {
	      stage.setScene(proximaEscena);
	     // this.vistaCampo.actualizarCampoDeBatalla();
	      stage.setFullScreenExitHint("");
	      stage.setFullScreen(true);
	  }
  }
}