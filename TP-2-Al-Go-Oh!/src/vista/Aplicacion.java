package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import modelo.tablero.CampoDeBatalla;
import vista.handlers.AplicacionOnKeyPressEventHandler;
import vista.handlers.NuevaEscenaEnPantallaHandler;

public class Aplicacion extends Application{
	
	private static ContenedorFasePreparacion contenedorFasePreparacion;
	private static ContenedorFaseMagia contenedorFaseMagia;
	private static ContenedorFaseAtaque contenedorFaseAtaque;
	
	public static void setCardValue(String value) {
		contenedorFasePreparacion.setCardValue(value);
		contenedorFaseMagia.setCardValue(value);
		contenedorFaseAtaque.setCardValue(value);
	}

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(final Stage stage) throws Exception {
		
		stage.setTitle("AlGoOh!");
		
		AlGoOh alGoOh = new AlGoOh();
		
		
		
		ContenedorCambioDeTurno contenedorCambioDeTurno = new ContenedorCambioDeTurno(stage);
		NuevaEscenaEnPantallaHandler escenaCambioTurnoEnPantallaHandler = new NuevaEscenaEnPantallaHandler((Contenedor)contenedorCambioDeTurno);
		Scene escenaCambioDeTurno = new Scene(contenedorCambioDeTurno, 640, 480);
		escenaCambioDeTurno.setOnMouseEntered(escenaCambioTurnoEnPantallaHandler);
		
		ContenedorFaseMagia contenedorFaseMagia = new ContenedorFaseMagia(stage, escenaCambioDeTurno, alGoOh);
		NuevaEscenaEnPantallaHandler escenaFaseMagiaEnPantallaHandler = new NuevaEscenaEnPantallaHandler((Contenedor)contenedorFaseMagia);
		Scene escenaMagia = new Scene(contenedorFaseMagia, 640, 480);
		escenaMagia.setOnMouseEntered(escenaFaseMagiaEnPantallaHandler);
		
		ContenedorFaseTrampas contenedorFaseTrampas = new ContenedorFaseTrampas(stage, escenaMagia, alGoOh);
		NuevaEscenaEnPantallaHandler escenaFaseTrampasEnPantallaHandler = new NuevaEscenaEnPantallaHandler((Contenedor)contenedorFaseTrampas);
		Scene escenaTrampas = new Scene(contenedorFaseTrampas, 640, 480);
		escenaTrampas.setOnMouseEntered(escenaFaseTrampasEnPantallaHandler);
		
		ContenedorFaseAtaque contenedorFaseAtaque = new ContenedorFaseAtaque(stage, escenaTrampas, escenaMagia, alGoOh);
		NuevaEscenaEnPantallaHandler escenaFaseAtaqueEnPantallaHandler = new NuevaEscenaEnPantallaHandler((Contenedor)contenedorFaseAtaque);
		Scene escenaAtaque = new Scene(contenedorFaseAtaque, 640, 480);
		escenaAtaque.setOnMouseEntered(escenaFaseAtaqueEnPantallaHandler);
		
		ContenedorFasePreparacion contenedorFasePreparacion = new ContenedorFasePreparacion(stage, escenaAtaque, alGoOh);
		NuevaEscenaEnPantallaHandler escenaFasePreparacionEnPantallaHandler = new NuevaEscenaEnPantallaHandler((Contenedor)contenedorFasePreparacion);
		Scene escenaPreparacion = new Scene(contenedorFasePreparacion, 640, 480);
		escenaPreparacion.setOnMouseEntered(escenaFasePreparacionEnPantallaHandler);
		
		ContenedorFaseInicial contenedorFaseInicial = new ContenedorFaseInicial(stage,escenaPreparacion, alGoOh);
		NuevaEscenaEnPantallaHandler escenaFaseInicialEnPantallaHandler = new NuevaEscenaEnPantallaHandler((Contenedor)contenedorFaseInicial);
		Scene escenaFaseInicial = new Scene(contenedorFaseInicial, 640, 480);
		escenaFaseInicial.setOnMouseEntered(escenaFaseInicialEnPantallaHandler);
		
	    ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaFaseInicial);    
	    Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
		
	    
	    contenedorFaseTrampas.asignarEscenaFaseAtaque(stage,escenaAtaque, alGoOh);
	    contenedorCambioDeTurno.asignarEscenaFaseInicial(stage,escenaFaseInicial, alGoOh);
	    
		AplicacionOnKeyPressEventHandler bienvenidosHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseInicial.getBarraDeMenu());
		escenaFaseInicial.setOnKeyPressed(bienvenidosHandler);
		AplicacionOnKeyPressEventHandler preparacionHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFasePreparacion.getBarraDeMenu());
		escenaPreparacion.setOnKeyPressed(preparacionHandler);
		AplicacionOnKeyPressEventHandler ataqueHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseAtaque.getBarraDeMenu());
		escenaAtaque.setOnKeyPressed(ataqueHandler);
		AplicacionOnKeyPressEventHandler trampasHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseTrampas.getBarraDeMenu());
		escenaTrampas.setOnKeyPressed(trampasHandler);
		AplicacionOnKeyPressEventHandler magiaHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseMagia.getBarraDeMenu());
		escenaMagia.setOnKeyPressed(magiaHandler);
		
		
		Aplicacion.contenedorFasePreparacion = contenedorFasePreparacion;
		Aplicacion.contenedorFaseAtaque = contenedorFaseAtaque;
		Aplicacion.contenedorFaseMagia = contenedorFaseMagia;
		
        stage.setScene(escenaBienvenidos);
		stage.setFullScreen(true);

        stage.show();
	}



}
