package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import vista.handlers.BotonReiniciarEventHandler;

public class ContenedorFinal extends VBox{

	Stage stage;
	
	ContenedorFinal(Stage stage, AlGoOh algooh){
	    
		super();
		
	    this.stage = stage;
	
	    this.setAlignment(Pos.CENTER);
	    this.setSpacing(40);
	    this.setPadding(new Insets(0));
	    Image imagen = new Image("file:src/vista/imagenes/263.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	    
	    this.setBackground(new Background(imagenDeFondo));
	
	    Button botonEntrar = new Button();
	    botonEntrar.setText("Salir");
	    
	    botonEntrar.setMaxWidth(200);
	    botonEntrar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
	    Label etiqueta2 = new Label();
	    etiqueta2.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
	
	    if(algooh.ganoJugador1()) {
	   		etiqueta2.setText("Jugador 1 Gana la Partida!!!");
	   	}
	   	else {
	   		etiqueta2.setText("Jugador 2 Gana la Partida!!!");
	   	}
	   	
	    etiqueta2.setTextFill(Color.web("#600a0a"));
	    
	    ImageView gameOver = new ImageView("file:src/vista/imagenes/gameOver2.png");
	    
       BotonReiniciarEventHandler botonReiniciar = new BotonReiniciarEventHandler();
       botonEntrar.setOnAction(botonReiniciar);
	
	
	        this.getChildren().addAll(gameOver, etiqueta2, botonEntrar);
		
		
	}
}
