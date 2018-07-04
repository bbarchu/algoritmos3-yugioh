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
import modelo.aplicacion.AlGoOh;
import vista.handlers.BotonAtacarHandler;
import vista.handlers.BotonPasarDeFaseHandler;
import vista.handlers.BotonTomarCartaHandler;

public class ContenedorFaseAtaque extends BorderPane implements Contenedor{

	BarraDeMenu menuBar;
	VBox contenedorCentral;
	StackPane stackPaneCentral;
	VistaCampoDeBatalla vistaCampo;
	AlGoOh algooh;
	Label cartasJugador;
	Label cartasRival;
	TextField cuadroPropio = new TextField("Ingrese el nombre de SU carta");
	TextField cuadroRival = new TextField("Ingrese el nombre de la carta del RIVAL");
	
	public ContenedorFaseAtaque(Stage stage, Scene escenaFaseTrampas, Scene escenaFaseMagia, AlGoOh algooh) {
        this.setMenu(stage);
        this.setCentro(algooh);
        this.setBotonera(stage, escenaFaseTrampas, escenaFaseMagia, algooh);
        this.algooh = algooh;
        
	}
	
	private void setBotonera(Stage stage, Scene escenaFaseTrampas, Scene escenaFaseMagia, AlGoOh algooh) {
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase Ataque");
		nombreFase.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
		Label titulo1 = new Label();
		titulo1.setText("Sus cartas");
		titulo1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		titulo1.setTextFill(Color.BLACK);
		
		cartasJugador= new Label();
		cartasJugador.setText(algooh.nombresConcatenadosCartasMonstruoEnCampoJugadorActual());
		cartasJugador.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 10));
		cartasJugador.setTextFill(Color.BLACK);
		
		Label titulo2 = new Label();
		titulo2.setText("Cartas del rival");
		titulo2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		titulo2.setTextFill(Color.BLACK);
		
		cartasRival= new Label();
		cartasRival.setText(algooh.nombresConcatenadosCartasMonstruoEnCampoRival());
		cartasRival.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 10));
		cartasRival.setTextFill(Color.BLACK);
		
		
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setMaxWidth(200);
	    botonAtacar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Pasar de fase");
        botonPasarDeFase.setMaxWidth(150);
	    botonPasarDeFase.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(stage, escenaFaseTrampas, algooh, cuadroPropio, cuadroRival, vistaCampo,this);
	    botonAtacar.setOnAction(botonAtacarHandler);
	    
	    BotonPasarDeFaseHandler botonPasarDeFaseHandler = new BotonPasarDeFaseHandler(stage, escenaFaseMagia);
	    botonPasarDeFase.setOnAction(botonPasarDeFaseHandler);
	    
        VBox contenedorVerticalBotones = new VBox(botonAtacar, botonPasarDeFase);
        contenedorVerticalBotones.setSpacing(120);
        contenedorVerticalBotones.setAlignment(Pos.TOP_CENTER);
        
        VBox contenedorVerticalTexto = new VBox(titulo2, cartasRival, cuadroRival,titulo1, cartasJugador, cuadroPropio);
        contenedorVerticalTexto.setSpacing(50);
        contenedorVerticalTexto.setAlignment(Pos.TOP_CENTER);

	    
        VBox contenedorVerticalPrincipal = new VBox(nombreFase, contenedorVerticalTexto, contenedorVerticalBotones);
        contenedorVerticalPrincipal.setSpacing(55);
        contenedorVerticalPrincipal.setAlignment(Pos.TOP_CENTER);
        contenedorVerticalPrincipal.setPadding(new Insets(20));
        contenedorVerticalPrincipal.setPrefWidth(300);
        
        Image imagen = new Image("file:src/vista/imagenes/fondoBotonera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVerticalPrincipal.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVerticalPrincipal);
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
	
	public void actualizarLabel() {
		cartasJugador.setText(algooh.nombresConcatenadosCartasMonstruoEnCampoJugadorActual());
		cartasJugador.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 10));
		cartasJugador.setTextFill(Color.BLACK);		
		
		cartasRival.setText(algooh.nombresConcatenadosCartasMonstruoEnCampoRival());
		cartasRival.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 10));
		cartasRival.setTextFill(Color.BLACK);		
	}

	public void setCardValue(String nombreCarta) {
		
		if(algooh.obtenerArregloDe5CartasMonstruoJugadorActual().contains(nombreCarta)) {
			cuadroPropio.setText(nombreCarta);
		}
		else {
			cuadroRival.setText(nombreCarta);
		}
			
	}

	@Override
	public void actualizar() {
		this.vistaCampo.actualizarCampoDeBatalla();
		this.actualizarLabel();
		
	}
}
