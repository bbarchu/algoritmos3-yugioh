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
import vista.handlers.BotonActivarTrampasHandler;
import vista.handlers.BotonTomarCartaHandler;

public class ContenedorFaseTrampas extends BorderPane{

	BarraDeMenu menuBar;
	Canvas canvasCentral;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	
	public ContenedorFaseTrampas(Stage stage, Scene escenaFaseAtaque) {
        this.setMenu(stage);
        this.setCentro();
        
	}
	
	private void setBotonera(Stage stage, Scene escenaFaseAtaque) {
        
		Label nombreFase = new Label();
		nombreFase.setText("Fase de Trampas");
		nombreFase.setFont(Font.font("courier new", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		Button botonActivarTrampas = new Button();
        botonActivarTrampas.setText("Activar carta trampa");
        botonActivarTrampas.setMaxWidth(200);
	    botonActivarTrampas.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
	    
        BotonActivarTrampasHandler tomarCartaHandler = new BotonActivarTrampasHandler(stage, escenaFaseAtaque);
        botonActivarTrampas.setOnAction(tomarCartaHandler);

        VBox contenedorVertical = new VBox(nombreFase, botonActivarTrampas);
        contenedorVertical.setSpacing(200);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setPrefWidth(300);
        Image imagen = new Image("file:src/vista/imagenes/repetible.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVertical);
	}

	private void setCentro() {

		stackPaneCentral = new StackPane();
		
		VistaCampoDeBatalla vistaCampo = new VistaCampoDeBatalla(stackPaneCentral);
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

	public void asignarEscenaFaseAtaque(Stage stage, Scene escenaAtaque) {
		this.setBotonera(stage, escenaAtaque);
	}
}
