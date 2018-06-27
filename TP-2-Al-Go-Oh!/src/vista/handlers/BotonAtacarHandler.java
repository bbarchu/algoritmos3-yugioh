package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;



public class BotonAtacarHandler implements EventHandler<ActionEvent>  {
	
  Stage stage;
  Scene proximaEscena;
  AlGoOh algooh;
  TextField textoPropio;
  TextField textoRival;

  public BotonAtacarHandler(Stage stage, Scene proximaEscena, AlGoOh algooh, TextField textoPropio, TextField textoRival) {
      
	  this.stage = stage;
      this.proximaEscena = proximaEscena;
      this.algooh = algooh;
      this.textoPropio = textoPropio;
      this.textoRival = textoRival;
  }

  @Override
  public void handle(ActionEvent actionEvent) {
      this.algooh.jugadorActualAtacaConA(textoPropio.getText(), textoRival.getText());
	  stage.setScene(proximaEscena);
      stage.setFullScreenExitHint("");
      stage.setFullScreen(true);
  }
}
