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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.handlers.BotonEntrarEventHandler;
import vista.handlers.BotonPasarDeFaseHandler;
import vista.handlers.BotonTomarCartaHandler;


public class ContenedorFaseInicial extends BorderPane {
	
	BarraDeMenu menuBar;
	Canvas canvasCentral;
	VBox contenedorCentral;
	
    public ContenedorFaseInicial(Stage stage, Scene escenaFasePreparacion) {
        this.setMenu(stage);
        this.setCentro();
        this.setBotonera(stage, escenaFasePreparacion);
        
    }

	private void setBotonera(Stage stage, Scene proximaEscena) {
        
		Label nombreFase = new Label();
		nombreFase.setText("Fase Inicial");
		nombreFase.setFont(Font.font("courier new", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		Button botonTomarCarta = new Button();
        botonTomarCarta.setText("Tomar una carta");
        botonTomarCarta.setMaxWidth(200);
	    botonTomarCarta.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
	    BotonTomarCartaHandler botonTomarCartaHandler = new BotonTomarCartaHandler(stage, proximaEscena);
	    botonTomarCarta.setOnAction(botonTomarCartaHandler);

        VBox contenedorVertical = new VBox(nombreFase, botonTomarCarta);
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
		canvasCentral = new Canvas(460, 220);
		 
        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
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
	

	/*
	public ContenedorPrincipal(Stage stage) {
		
		
	    this.stage = stage;
	

	    this.setPadding(new Insets(25));
	    Image imagen = new Image("file:src/vista/imagenes/red-checkered.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	    this.setBackground(new Background(imagenDeFondo));
	    
	    Label etiqueta = new Label();
	    etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	
	    etiqueta.setText("Algooh");
	    etiqueta.setTextFill(Color.web("#66A7C5"));
	
	        this.getChildren().addAll(etiqueta);
	}
*/

}
