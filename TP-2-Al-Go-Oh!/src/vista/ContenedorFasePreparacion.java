package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import vista.handlers.BotonColocarCartaAtaqueHandler;
import vista.handlers.BotonColocarCartaDefensaHandler;
import vista.handlers.BotonPasarDeFaseHandler;

public class ContenedorFasePreparacion extends BorderPane implements Contenedor{
	
	BarraDeMenu menuBar;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	VistaCampoDeBatalla vistaCampo;
	Label cartas;
	AlGoOh algooh;
	TextField cuadroDeTextoCartaPropia = new TextField("Ingrese el nombre de la carta a colocar");

	
	public ContenedorFasePreparacion(Stage stage, Scene escenaFaseAtaque, AlGoOh algooh) {
        this.setMenu(stage);
        this.setCentro(algooh);
        this.setBotonera(stage, escenaFaseAtaque, algooh);
        this.algooh = algooh;

	}
	
	
	private void setBotonera(Stage stage, Scene proximaEscena, AlGoOh algooh) {
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase Preparacion");
		nombreFase.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		Label titulo = new Label();
		titulo.setText("Sus cartas");
		titulo.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		titulo.setTextFill(Color.BLACK);
		
		Label titulo2 = new Label();
		titulo2.setText("Para Magia y Trampa");
		titulo2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		titulo2.setTextFill(Color.BLACK);
		
		Label titulo3 = new Label();
		titulo3.setText("Para Monstruos");
		titulo3.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		titulo3.setTextFill(Color.BLACK);
		
		cartas = new Label();
		cartas.setText(algooh.nombresConcatenadosCartasManoJugadorActual().toString());
		cartas.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 10));
		cartas.setTextFill(Color.BLACK);
		
		
        Button botonColocarCarta = new Button();
        botonColocarCarta.setText("Colocar carta");
        botonColocarCarta.setMaxWidth(200);
	    botonColocarCarta.setStyle("-fx-font: 19 arial; -fx-base: #b6e7c9;");
	    
        Button botonColocarCartaATK = new Button();
        botonColocarCartaATK.setText("Modo Ataque");
        botonColocarCartaATK.setMaxWidth(200);
	    botonColocarCartaATK.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
        
	    Button botonColocarCartaDEF = new Button();
        botonColocarCartaDEF.setText("Modo Defensa");
        botonColocarCartaDEF.setMaxWidth(200);
	    botonColocarCartaDEF.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonColocarCartaAtaqueHandler botonColocarCartaHandler = new BotonColocarCartaAtaqueHandler(vistaCampo, algooh, cuadroDeTextoCartaPropia, this);
	    botonColocarCarta.setOnAction(botonColocarCartaHandler);
	    
	    BotonColocarCartaAtaqueHandler botonColocarCartaATKHandler = new BotonColocarCartaAtaqueHandler(vistaCampo, algooh, cuadroDeTextoCartaPropia, this);
	    botonColocarCartaATK.setOnAction(botonColocarCartaATKHandler);
	    
	    BotonColocarCartaDefensaHandler botonColocarCartaDEFHandler = new BotonColocarCartaDefensaHandler(vistaCampo, algooh, cuadroDeTextoCartaPropia, this);
	    botonColocarCartaDEF.setOnAction(botonColocarCartaDEFHandler);
	    
	    
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Pasar de fase");
        botonPasarDeFase.setMaxWidth(150);
	    botonPasarDeFase.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonPasarDeFaseHandler botonPasarDeFaseHandler = new BotonPasarDeFaseHandler(stage, proximaEscena);
	    botonPasarDeFase.setOnAction(botonPasarDeFaseHandler);

	    HBox contenedorBotones = new HBox(botonColocarCartaATK, botonColocarCartaDEF);
	    contenedorBotones.setSpacing(20);
	    contenedorBotones.setAlignment(Pos.CENTER);
	    
        VBox contenedorVertical = new VBox(nombreFase, titulo, cartas,cuadroDeTextoCartaPropia, titulo2, botonColocarCarta, titulo3, contenedorBotones, botonPasarDeFase);
        contenedorVertical.setSpacing(60);
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


	public void actualizarLabel() {
		cartas.setText(algooh.nombresConcatenadosCartasManoJugadorActual().toString());
		cartas.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 10));
		cartas.setTextFill(Color.BLACK);		
	}


	public void setCardValue(String nombreCarta) {
		cuadroDeTextoCartaPropia.setText(nombreCarta);
	}


	@Override
	public void actualizar() {
		this.vistaCampo.actualizarManoYCampoPropio();
		this.actualizarLabel();
		
		
	}



	
}
