package vista.handlers;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import vista.ContenedorFaseAtaque;
import vista.VistaCampoDeBatalla;



public class BotonAtacarHandler implements EventHandler<ActionEvent>  {
	
  Stage stage;
  Scene proximaEscena;
  AlGoOh algooh;
  TextField textoPropio;
  TextField textoRival;
  VistaCampoDeBatalla vistaCampo;
  ContenedorFaseAtaque contenedor;

  public BotonAtacarHandler(Stage stage, Scene proximaEscena, AlGoOh algooh, TextField textoPropio, TextField textoRival, VistaCampoDeBatalla vistaCampo, ContenedorFaseAtaque contenedor) {
      
	  this.stage = stage;
      this.proximaEscena = proximaEscena;
      this.algooh = algooh;
      this.textoPropio = textoPropio;
      this.textoRival = textoRival;
      this.vistaCampo = vistaCampo;
      this.contenedor = contenedor;
      
  }

  @Override
  public void handle(ActionEvent actionEvent) {
	 
	  
	  LinkedList<String> cartasMonstruoJugador = algooh.obtenerArregloDe5CartasMonstruoJugadorActual();

		if(cartasMonstruoJugador.contains(textoPropio.getText())) {
  
    	  this.algooh.jugadorActualAtacaConA(textoPropio.getText(), textoRival.getText());
    	  this.contenedor.actualizar();

    	  stage.setScene(proximaEscena);
          stage.setFullScreenExitHint("");
          stage.setFullScreen(true);
      }
  }
}
