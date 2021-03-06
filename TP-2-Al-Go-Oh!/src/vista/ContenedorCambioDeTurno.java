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
import vista.handlers.BotonCambiarDeTurnoHandler;

public class ContenedorCambioDeTurno extends BorderPane implements Contenedor{
	
	BarraDeMenu menuBar;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	VistaPuntajes vistaPuntajes;
	AlGoOh algooh;
	BotonCambiarDeTurnoHandler botonCambiarDeTurnoHandler;
	Stage stage;
	private Scene proximaEscena;
	
	public ContenedorCambioDeTurno(Stage stage) {
        
		this.setMenu(stage);
        this.setCentro();
	}
	private void setBotonera(Stage stage, Scene proximaEscena, AlGoOh algooh) {
		
		Label atencion = new Label();
		atencion.setText("Puntos de Vida");
		atencion.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, 50));
		atencion.setTextFill(Color.DARKRED);
		
		Label recordatorio1 = new Label();
		recordatorio1.setText("Es momento de cambiar de Jugador");
		recordatorio1.setFont(Font.font("Impact", FontWeight.BOLD, 30));
		recordatorio1.setTextFill(Color.DARKRED);
		
		Label recordatorio2 = new Label();
		recordatorio2.setText("Haga click una vez que el nuevo jugador est� en su posici�n");
		recordatorio2.setFont(Font.font("Impact", FontWeight.BOLD, 30));
		recordatorio2.setTextFill(Color.DARKRED);
		
		
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Comenzar Turno");
        botonPasarDeFase.setMaxWidth(200);
	    botonPasarDeFase.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");
	
	    	    
	   

	   	botonCambiarDeTurnoHandler = new BotonCambiarDeTurnoHandler(stage, proximaEscena, algooh);
	    
	    botonPasarDeFase.setOnAction(botonCambiarDeTurnoHandler);
		    
	    
		stackPaneCentral = new StackPane();
	
		vistaPuntajes = new VistaPuntajes(stackPaneCentral, algooh);
		vistaPuntajes.dibujarAnotadorGrande();
		

	    
        VBox contenedorVertical = new VBox(atencion, stackPaneCentral, recordatorio1, recordatorio2, botonPasarDeFase);
        contenedorVertical.setSpacing(55);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setPrefWidth(600);
        Image imagen = new Image("file:src/vista/imagenes/fondoBotonera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorVertical);
	}

	private void setCentro() {
		 
		contenedorCentral = new VBox();
		contenedorCentral.setAlignment(Pos.TOP_CENTER);
		contenedorCentral.setPadding(new Insets(20));
		contenedorCentral.setPrefWidth(200);
       
        Image imagen1 = new Image("file:src/vista/imagenes/red-checkered.jpg");
        BackgroundImage imagenDeFondo1 = new BackgroundImage(imagen1, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo1));
        
        VBox contenedorAuxiliar = new VBox();
        
        contenedorAuxiliar.setAlignment(Pos.TOP_CENTER);
        contenedorAuxiliar.setPadding(new Insets(20));
        contenedorAuxiliar.setPrefWidth(200);
       
        Image imagen2 = new Image("file:src/vista/imagenes/red-checkered.jpg");
        BackgroundImage imagenDeFondo2 = new BackgroundImage(imagen2, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorAuxiliar.setBackground(new Background(imagenDeFondo2));
        
        
        
        this.setRight(contenedorCentral);
        this.setLeft(contenedorAuxiliar);
       
	}

	private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);		
	}
	
	public void asignarEscenaFaseInicial(Stage stage, Scene escenaFaseInicial, AlGoOh algooh) {
		this.setBotonera(stage,escenaFaseInicial, algooh);
		this.algooh = algooh;
		this.stage = stage;
		this.proximaEscena = escenaFaseInicial;
		
	}
	@Override
	public void actualizar() {
		this.vistaPuntajes.actualizarAnotadorGrande();
	 
		
	}
}

