package vista;

import java.lang.reflect.Array;
import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.aplicacion.AlGoOh;



public class VistaCampoDeBatalla {
	
	Canvas canvas;
	StackPane stack;
	CatalogoImagenes imagenes;
	AlGoOh algooh;
	
	public VistaCampoDeBatalla(StackPane stackPaneCentral, AlGoOh algooh){
		
		this.stack = stackPaneCentral;
		this.canvas = new Canvas(900, 900);
		this.imagenes = new CatalogoImagenes();
		this.algooh = algooh;
	}

	public void dibuajarTodoElCampo() {
		
		this.setFondoTodoElCampo();
		
		LinkedList<String> cartasMagiaRival = algooh.obtenerArregloDe5CartasMagiaTrampaRival();
		LinkedList<String> cartasMonstruoRival = algooh.obtenerArregloDe5CartasMonstruoRival();
		LinkedList<String> cartasMonstruoJugador = algooh.obtenerArregloDe5CartasMonstruoJugadorActual();
		LinkedList<String> cartasMagiaJugador = algooh.obtenerArregloDe5CartasMagiaTrampaJugadorActual();
		
		ImageView imagen1 = imagenes.get(cartasMagiaRival.get(0));
		ImageView imagen2 = imagenes.get(cartasMagiaRival.get(1));
		ImageView imagen3 = imagenes.get(cartasMagiaRival.get(2));
		ImageView imagen4 = imagenes.get(cartasMagiaRival.get(3));
		ImageView imagen5 = imagenes.get(cartasMagiaRival.get(4));
		ImageView imagen6 = imagenes.get(cartasMonstruoRival.get(0));
		ImageView imagen7 = imagenes.get(cartasMonstruoRival.get(1));
		ImageView imagen8 = imagenes.get(cartasMonstruoRival.get(2));
		ImageView imagen9 = imagenes.get(cartasMonstruoRival.get(3));
		ImageView imagen10 = imagenes.get(cartasMonstruoRival.get(4));
		ImageView imagen11 = imagenes.get(cartasMonstruoJugador.get(0));
		ImageView imagen12 = imagenes.get(cartasMonstruoJugador.get(1));
		ImageView imagen13 = imagenes.get(cartasMonstruoJugador.get(2));
		ImageView imagen14 = imagenes.get(cartasMonstruoJugador.get(3));
		ImageView imagen15 = imagenes.get(cartasMonstruoJugador.get(4));
		ImageView imagen16 = imagenes.get(cartasMagiaJugador.get(0));
		ImageView imagen17 = imagenes.get(cartasMagiaJugador.get(0));
		ImageView imagen18 = imagenes.get(cartasMagiaJugador.get(0));
		ImageView imagen19 = imagenes.get(cartasMagiaJugador.get(0));
		ImageView imagen20 = imagenes.get(cartasMagiaJugador.get(0));
		
		
		
		HBox contenedorMagiaRival = new HBox(imagen1,imagen2,imagen3,imagen4,imagen5);
		contenedorMagiaRival.setAlignment(Pos.CENTER);
		contenedorMagiaRival.setSpacing(50);

		HBox contenedorMonstruosRival = new HBox(imagen6,imagen7,imagen8,imagen9,imagen10);
		contenedorMonstruosRival.setAlignment(Pos.CENTER);
		contenedorMonstruosRival.setSpacing(50);

		HBox contenedorMonstruosJugador = new HBox(imagen11,imagen12,imagen13,imagen14,imagen15);
		contenedorMonstruosJugador.setAlignment(Pos.CENTER);
		contenedorMonstruosJugador.setSpacing(50);

		HBox contenedorMagiaJugador = new HBox(imagen16,imagen17,imagen18,imagen19,imagen20);
		contenedorMagiaJugador.setAlignment(Pos.CENTER);
		contenedorMagiaJugador.setSpacing(50);

		
		VBox contenedorPrincipal = new VBox(contenedorMagiaRival, contenedorMonstruosRival, contenedorMonstruosJugador, contenedorMagiaJugador);
		contenedorPrincipal.setPadding(new Insets(10));
		contenedorPrincipal.setSpacing(30);
		
		stack.getChildren().addAll(canvas,contenedorPrincipal);
		stack.setAlignment(Pos.CENTER);
		
	}


	public void dibuajarManoYCampoPropio() {
		this.setFondoManoYCampoPropio();
		
		LinkedList<String> cartasMonstruoJugador = algooh.obtenerArregloDe5CartasMonstruoJugadorActual();
		LinkedList<String> cartasMagiaJugador = algooh.obtenerArregloDe5CartasMagiaTrampaJugadorActual();
		LinkedList<String> cartasManoJugador = algooh.obtenerArregloDe10CartasEnLaManoDelJugadorActual();
		
		ImageView imagen1 = imagenes.get(cartasMonstruoJugador.get(0));
		ImageView imagen2 = imagenes.get(cartasMonstruoJugador.get(1));
		ImageView imagen3 = imagenes.get(cartasMonstruoJugador.get(2));
		ImageView imagen4 = imagenes.get(cartasMonstruoJugador.get(3));
		ImageView imagen5 = imagenes.get(cartasMonstruoJugador.get(4));
		ImageView imagen6 = imagenes.get(cartasMagiaJugador.get(0));
		ImageView imagen7 = imagenes.get(cartasMagiaJugador.get(1));
		ImageView imagen8 = imagenes.get(cartasMagiaJugador.get(2));
		ImageView imagen9 = imagenes.get(cartasMagiaJugador.get(3));
		ImageView imagen10 = imagenes.get(cartasMagiaJugador.get(4));
		ImageView imagen11 = imagenes.get(cartasManoJugador.get(0));
		ImageView imagen12 = imagenes.get(cartasManoJugador.get(1));
		ImageView imagen13 = imagenes.get(cartasManoJugador.get(2));
		ImageView imagen14 = imagenes.get(cartasManoJugador.get(3));
		ImageView imagen15 = imagenes.get(cartasManoJugador.get(4));
		ImageView imagen16 = imagenes.get(cartasManoJugador.get(5));
		ImageView imagen17 = imagenes.get(cartasManoJugador.get(6));
		ImageView imagen18 = imagenes.get(cartasManoJugador.get(7));
		ImageView imagen19 = imagenes.get(cartasManoJugador.get(8));
		ImageView imagen20 = imagenes.get(cartasManoJugador.get(9));
		
		
		
		HBox contenedorMonstruosJugador = new HBox(imagen1,imagen2,imagen3,imagen4,imagen5);
		contenedorMonstruosJugador.setAlignment(Pos.CENTER);
		contenedorMonstruosJugador.setSpacing(50);

		HBox contenedorMagiaJugador = new HBox(imagen6,imagen7,imagen8,imagen9,imagen10);
		contenedorMagiaJugador.setAlignment(Pos.CENTER);
		contenedorMagiaJugador.setSpacing(50);

		HBox contenedorManoJugador = new HBox(imagen11,imagen12,imagen13,imagen14,imagen15, imagen16, imagen17, imagen18, imagen19, imagen20);
		contenedorManoJugador.setAlignment(Pos.CENTER);
		contenedorManoJugador.setSpacing(10);

		
		VBox contenedorAuxiliar = new VBox(contenedorMonstruosJugador, contenedorMagiaJugador);
		contenedorAuxiliar.setPadding(new Insets(10));
		contenedorAuxiliar.setSpacing(30);
		
		VBox contenedorPrincipal = new VBox(contenedorAuxiliar, contenedorManoJugador);
		contenedorPrincipal.setPadding(new Insets(80));
		contenedorPrincipal.setSpacing(100);
		
		stack.getChildren().addAll(canvas,contenedorPrincipal);
		stack.setAlignment(Pos.CENTER);
	}
	

	private void setFondoTodoElCampo() {
		canvas.getGraphicsContext2D().setFill(Color.DARKRED);
		canvas.getGraphicsContext2D().fillRect(0, 0, 900, 710);
		
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillRect(0, 355, 900, 5);
		
		canvas.getGraphicsContext2D().fillRect(0, 0, 900, 5);
		canvas.getGraphicsContext2D().fillRect(0, 0, 5, 710);
		canvas.getGraphicsContext2D().fillRect(895, 0, 5, 710);
		canvas.getGraphicsContext2D().fillRect(0, 710, 900, 5);
	}
	

	private void setFondoManoYCampoPropio() {
		canvas.getGraphicsContext2D().setFill(Color.DARKRED);
		canvas.getGraphicsContext2D().fillRect(0, 0, 900, 710);
		
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillRect(0, 500, 900, 5);
		
		canvas.getGraphicsContext2D().fillRect(0, 0, 900, 5);
		canvas.getGraphicsContext2D().fillRect(0, 0, 5, 710);
		canvas.getGraphicsContext2D().fillRect(895, 0, 5, 710);
		canvas.getGraphicsContext2D().fillRect(0, 710, 900, 5);
	}
	
	public void actualizarManoYCampoPropio() {
		this.dibuajarManoYCampoPropio();
	}
	
	public void actualizarCampoDeBatalla() {
		this.dibuajarTodoElCampo();
	}
}
