package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import vista.handlers.BotonActivarTrampasHandler;
import vista.handlers.BotonTomarCartaHandler;

public class ContenedorFaseTrampas extends BorderPane{

	BarraDeMenu menuBar;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	StackPane stackPaneLateral;
	
	public ContenedorFaseTrampas(Stage stage, Scene escenaFaseAtaque, AlGoOh algooh) {
        this.setMenu(stage);
        this.setCentro(algooh);
        
	}
	
	private void setBotonera(Stage stage, Scene escenaFaseAtaque, AlGoOh algooh) {
        
		stackPaneLateral = new StackPane();
		
		VistaPuntajes vistaPuntajes = new VistaPuntajes(stackPaneLateral, algooh);
		vistaPuntajes.dibujarAnotadorChico();
		
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase de Trampas");
		nombreFase.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		Label recordatorio = new Label();
		recordatorio.setText("Antes de calcular el daño...");
		recordatorio.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 15));
		recordatorio.setTextFill(Color.BLACK);
		
		Button botonActivarTrampas = new Button();
        botonActivarTrampas.setText("Activar carta trampa Rival");
        botonActivarTrampas.setMaxWidth(250);
	    botonActivarTrampas.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
	    
        BotonActivarTrampasHandler tomarCartaHandler = new BotonActivarTrampasHandler(stage, escenaFaseAtaque);
        botonActivarTrampas.setOnAction(tomarCartaHandler);

        VBox contenedorVertical = new VBox(nombreFase,stackPaneLateral, recordatorio, botonActivarTrampas);
        contenedorVertical.setSpacing(100);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setPrefWidth(400);
        
        Image imagen = new Image("file:src/vista/imagenes/fondoBotonera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVertical);
	}

	private void setCentro(AlGoOh algooh) {

		stackPaneCentral = new StackPane();
		
		VistaCampoDeBatalla vistaCampo = new VistaCampoDeBatalla(stackPaneCentral, algooh);
		vistaCampo.dibuajarTodoElCampo();
		
		contenedorCentral = new VBox(stackPaneCentral);
        contenedorCentral.setAlignment(Pos.TOP_CENTER);
        contenedorCentral.setPadding(new Insets(20));

        Image imagen = new Image("file:src/vista/imagenes/red-checkered.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        
        this.setCenter(contenedorCentral);
	}

	private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);		
	}
	
	public BarraDeMenu getBarraDeMenu() {
		return menuBar;
	}

	public void asignarEscenaFaseAtaque(Stage stage, Scene escenaAtaque, AlGoOh algooh) {
		this.setBotonera(stage, escenaAtaque, algooh);
	}
}
