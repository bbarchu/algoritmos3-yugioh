package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TODO falta hacer que la aplicacion le haga tomar una carta al jugador


public class BotonAtacarHandler implements EventHandler<ActionEvent>  {
	
  Stage stage;
  Scene proximaEscena;

  public BotonAtacarHandler(Stage stage, Scene proximaEscena) {
      this.stage = stage;
      this.proximaEscena = proximaEscena;
  }

  @Override
  public void handle(ActionEvent actionEvent) {
      stage.setScene(proximaEscena);
      stage.setFullScreenExitHint("");
      stage.setFullScreen(true);
  }
}
