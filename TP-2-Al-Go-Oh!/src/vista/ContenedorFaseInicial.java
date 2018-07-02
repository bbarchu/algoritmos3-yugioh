package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import vista.handlers.BotonTomarCartaHandler;


public class ContenedorFaseInicial extends BorderPane implements Contenedor{
	
	BarraDeMenu menuBar;
	VBox contenedorCentral;
	VBox contenedorVertical;
	StackPane stackPaneCentral;
	VistaCampoDeBatalla vistaCampo;

	
    public ContenedorFaseInicial(Stage stage, Scene escenaFasePreparacion, AlGoOh algooh) {
        this.setMenu(stage);
        this.setCentro(algooh);
        this.setBotonera(stage, escenaFasePreparacion, algooh);
        
    }

	private void setBotonera(Stage stage, Scene proximaEscena, AlGoOh algooh) {
        
		Label nombreFase = new Label();
		nombreFase.setText("Fase Inicial");
		nombreFase.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		Button botonTomarCarta = new Button();
        botonTomarCarta.setText("Tomar una carta");
        botonTomarCarta.setMaxWidth(200);
	    botonTomarCarta.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
	    BotonTomarCartaHandler botonTomarCartaHandler = new BotonTomarCartaHandler(stage, proximaEscena, algooh, vistaCampo);
	    botonTomarCarta.setOnAction(botonTomarCartaHandler);

	    contenedorVertical = new VBox(nombreFase, botonTomarCarta);
        contenedorVertical.setSpacing(300);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setPrefWidth(300);
        Image imagen = new Image("file:src/vista/imagenes/fondoBotonera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVertical);
	}

	private void setCentro(AlGoOh algooh) {
		
		stackPaneCentral = new StackPane();
		
		vistaCampo = new VistaCampoDeBatalla(stackPaneCentral, algooh);
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

	public void actualizar() {
		this.vistaCampo.actualizarCampoDeBatalla();
	}
	



}
