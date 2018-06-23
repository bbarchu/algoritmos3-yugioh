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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

	Stage stage;
	
	
	public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {
	
	    super();
	
	    this.stage = stage;
	
	    this.setAlignment(Pos.CENTER);
	    this.setSpacing(200);
	    this.setPadding(new Insets(25));
	    Image imagen = new Image("file:src/vista/imagenes/repetibleAzul.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	    
	    this.setBackground(new Background(imagenDeFondo));
	
	    Button botonEntrar = new Button();
	    botonEntrar.setText("Entrar");
	    
	    botonEntrar.setMaxWidth(200);
	    botonEntrar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
	    Label etiqueta1 = new Label();
	    Label etiqueta2 = new Label();
	    etiqueta1.setFont(Font.font("Impact", FontWeight.BOLD, 100));
	    etiqueta2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 45));
	
	    etiqueta1.setText("AlGoOh!");
	   	etiqueta2.setText("Para continuar, haga click en Entrar");
	    etiqueta1.setTextFill(Color.web("#9b0606"));
	    etiqueta2.setTextFill(Color.web("#600a0a"));
	    
       // BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        //botonEntrar.setOnAction(botonEntrarHandler);
	
	
	        this.getChildren().addAll(etiqueta1, etiqueta2, botonEntrar);
	 }
	
}

