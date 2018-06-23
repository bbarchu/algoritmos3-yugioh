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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends HBox {
	
	Stage stage;
	
	public ContenedorPrincipal(Stage stage) {
		
		super();
		
	    this.stage = stage;
	
	    this.setAlignment(Pos.CENTER);
	    this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	    this.setBackground(new Background(imagenDeFondo));
	    
	    Label etiqueta = new Label();
	    etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
	
	    etiqueta.setText("Algooh");
	    etiqueta.setTextFill(Color.web("#66A7C5"));
	
	        this.getChildren().addAll(etiqueta);
	}
}
