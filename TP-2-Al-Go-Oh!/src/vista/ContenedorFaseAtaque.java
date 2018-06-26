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

public class ContenedorFaseAtaque extends BorderPane{

	BarraDeMenu menuBar;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	
	public ContenedorFaseAtaque(Stage stage, Scene escenaFaseTrampas, Scene escenaFaseMagia) {
        this.setMenu(stage);
        this.setCentro();
        this.setBotonera(stage, escenaFaseTrampas, escenaFaseMagia);
        
	}
	
	private void setBotonera(Stage stage, Scene escenaFaseTrampas, Scene escenaFaseMagia) {
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase Ataque");
		nombreFase.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		TextField cuadroDeTextoCartaPropia = new TextField("Ingrese el nombre de SU carta");
		TextField cuadroDeTextoCartaRival = new TextField("Ingrese el nombre de la carta del RIVAL");
		
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setMaxWidth(200);
	    botonAtacar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Pasar de fase");
        botonPasarDeFase.setMaxWidth(150);
	    botonPasarDeFase.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(stage, escenaFaseTrampas);
	    botonAtacar.setOnAction(botonAtacarHandler);
	    
	    BotonPasarDeFaseHandler botonPasarDeFaseHandler = new BotonPasarDeFaseHandler(stage, escenaFaseMagia);
	    botonPasarDeFase.setOnAction(botonPasarDeFaseHandler);
	    
        VBox contenedorVerticalBotones = new VBox(botonAtacar, botonPasarDeFase);
        contenedorVerticalBotones.setSpacing(120);
        contenedorVerticalBotones.setAlignment(Pos.TOP_CENTER);
        
        VBox contenedorVerticalTexto = new VBox(cuadroDeTextoCartaPropia, cuadroDeTextoCartaRival);
        contenedorVerticalTexto.setSpacing(50);
        contenedorVerticalTexto.setAlignment(Pos.TOP_CENTER);

	    
        VBox contenedorVerticalPrincipal = new VBox(nombreFase, contenedorVerticalTexto, contenedorVerticalBotones);
        contenedorVerticalPrincipal.setSpacing(180);
        contenedorVerticalPrincipal.setAlignment(Pos.TOP_CENTER);
        contenedorVerticalPrincipal.setPadding(new Insets(20));
        contenedorVerticalPrincipal.setPrefWidth(300);
        
        Image imagen = new Image("file:src/vista/imagenes/fondoBotonera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVerticalPrincipal.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVerticalPrincipal);
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
}
