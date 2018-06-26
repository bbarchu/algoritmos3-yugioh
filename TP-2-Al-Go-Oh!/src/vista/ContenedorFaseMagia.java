package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import vista.handlers.BotonAtacarHandler;
import vista.handlers.BotonPasarDeFaseHandler;
import vista.handlers.BotonTomarCartaHandler;

public class ContenedorFaseMagia extends BorderPane {

	BarraDeMenu menuBar;
	Canvas canvasCentral;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	
	public ContenedorFaseMagia(Stage stage) {
        
		this.setMenu(stage);
        this.setCentro();
        
	}
	
	private void setBotonera(Stage stage, Scene escenaFaseInicia) {
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase de Magia");
		nombreFase.setFont(Font.font("courier new", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		TextField cuadroDeTextoCartaPropia = new TextField("Ingrese el nombre de SU carta");
		
        Button botonActivarCartaMagia = new Button();
        botonActivarCartaMagia.setText("Activar carta magica");
        botonActivarCartaMagia.setMaxWidth(200);
	    botonActivarCartaMagia.setStyle("-fx-font: 19 arial; -fx-base: #b6e7c9;");
	    
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Pasar de fase");
        botonPasarDeFase.setMaxWidth(150);
	    botonPasarDeFase.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonPasarDeFaseHandler botonPasarDeFaseHandler = new BotonPasarDeFaseHandler(stage, escenaFaseInicia);
	    botonPasarDeFase.setOnAction(botonPasarDeFaseHandler);

	    
        VBox contenedorVertical = new VBox(nombreFase, cuadroDeTextoCartaPropia, botonActivarCartaMagia, botonPasarDeFase);
        contenedorVertical.setSpacing(190);
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

	public void asignarEscenaFaseInicial(Stage stage, Scene escenaFaseInicial) {
		this.setBotonera(stage,escenaFaseInicial);
		
	}

}
