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
import vista.handlers.BotonPasarDeFaseHandler;
import vista.handlers.BotonTomarCartaHandler;

public class ContenedorFasePreparacion extends BorderPane {
	
	BarraDeMenu menuBar;
	VBox contenedorCentral;
	StackPane stackPaneCentral;

	public ContenedorFasePreparacion(Stage stage, Scene escenaFaseAtaque) {
        this.setMenu(stage);
        this.setCentro();
        this.setBotonera(stage, escenaFaseAtaque);

	}
	
	
	private void setBotonera(Stage stage, Scene proximaEscena) {
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase Preparacion");
		nombreFase.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
        Button botonColocarCarta = new Button();
        botonColocarCarta.setText("Colocar una carta");
        botonColocarCarta.setMaxWidth(200);
	    botonColocarCarta.setStyle("-fx-font: 19 arial; -fx-base: #b6e7c9;");
	    
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Pasar de fase");
        botonPasarDeFase.setMaxWidth(150);
	    botonPasarDeFase.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonPasarDeFaseHandler botonPasarDeFaseHandler = new BotonPasarDeFaseHandler(stage, proximaEscena);
	    botonPasarDeFase.setOnAction(botonPasarDeFaseHandler);

        VBox contenedorVertical = new VBox(nombreFase, botonColocarCarta, botonPasarDeFase);
        contenedorVertical.setSpacing(290);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setPrefWidth(300);
        Image imagen = new Image("file:src/vista/imagenes/fondoBotonera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVertical);
	}

	private void setCentro() {

		stackPaneCentral = new StackPane();
		
		VistaCampoDeBatalla vistaCampo = new VistaCampoDeBatalla(stackPaneCentral);
		vistaCampo.dibuajarManoYCampoPropio();
		
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
	
}