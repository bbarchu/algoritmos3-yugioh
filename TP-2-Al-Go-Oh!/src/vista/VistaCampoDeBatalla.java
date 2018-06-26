package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


// Lucas: una idea es que el campo de batalla devuelva una lista de string con el nombre de cada carta.
//			Aca hay dos opciones:
//								-hacer una especie de concatenado para agregarle la extension.
//								-hacer un diccionario nombreMosntruo - nombreImagen.
//			Esas imagenes son colocadas en el espacio central de cada contenedor.
//			Los nombres se podrían escribir en una especie de lista para facilitar la escritura al usuario.

public class VistaCampoDeBatalla {
	
	Canvas canvas;
	StackPane stack;
	CatalogoImagenes imagenes;
	
	public VistaCampoDeBatalla(StackPane stackPaneCentral){
		
		this.stack = stackPaneCentral;
		this.canvas = new Canvas(900, 900);
		this.imagenes = new CatalogoImagenes();
	}

	public void dibuajarTodoElCampo() {
		
		this.setFondoTodoElCampo();
		
		ImageView imagen1 = imagenes.get("AgujeroOscuro");
		ImageView imagen2 = imagenes.get("BrazoDerechoDelProhibido");
		ImageView imagen3 = imagenes.get("BrazoIzquierdoDelProhibido");
		ImageView imagen4 = imagenes.get("BueyDeBatalla");
		ImageView imagen5 = imagenes.get("CaballoDeMar");
		ImageView imagen6 = imagenes.get("CilindroMagico");
		ImageView imagen7 = imagenes.get("Craneo");
		ImageView imagen8 = imagenes.get("DarkMaster");
		ImageView imagen9 = imagenes.get("DemonioElemental");
		ImageView imagen10 = imagenes.get("DragonArmadoOscuro");
		ImageView imagen11 = imagenes.get("DragonBlancoDeOjosAzules");
		ImageView imagen12 = imagenes.get("DragonDeCuernoBlanco");
		ImageView imagen13 = imagenes.get("DragonDeLaMuerte");
		ImageView imagen14 = imagenes.get("DragonDeOjosAzulesDefinitivo");
		ImageView imagen15 = imagenes.get("DragonElemental");
		ImageView imagen16 = imagenes.get("DragonNegro");
		ImageView imagen17 = imagenes.get("ExodiaElProhibido");
		ImageView imagen18 = imagenes.get("Fisura");
		ImageView imagen19 = imagenes.get("Girochin");
		ImageView imagen20 = imagenes.get("GuardianDeLaPuerta");
		
		
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
		
		ImageView imagen1 = imagenes.get("HaneHane");
		ImageView imagen2 = imagenes.get("HojaOscura");
		ImageView imagen3 = imagenes.get("InsectoComeHombres");
		ImageView imagen4 = imagenes.get("JineteMistico");
		ImageView imagen5 = imagenes.get("Jinzo7");
		ImageView imagen6 = imagenes.get("Kuriboh");
		ImageView imagen7 = imagenes.get("KuribohAlado");
		ImageView imagen8 = imagenes.get("LordOfD");
		ImageView imagen9 = imagenes.get("MagoOscuro");
		ImageView imagen10 = imagenes.get("Obelisk");
		ImageView imagen11 = imagenes.get("OgroGrotto");
		ImageView imagen12 = imagenes.get("OllaDeLaCodicia");
		ImageView imagen13 = imagenes.get("PiernaDerechaDelProhibido");
		ImageView imagen14 = imagenes.get("PiernaIzquierdaDelProhibido");
		ImageView imagen15 = imagenes.get("Reinforcements");
		
		
		HBox contenedorMonstruosJugador = new HBox(imagen1,imagen2,imagen3,imagen4,imagen5);
		contenedorMonstruosJugador.setAlignment(Pos.CENTER);
		contenedorMonstruosJugador.setSpacing(50);

		HBox contenedorMagiaJugador = new HBox(imagen6,imagen7,imagen8,imagen9,imagen10);
		contenedorMagiaJugador.setAlignment(Pos.CENTER);
		contenedorMagiaJugador.setSpacing(50);

		HBox contenedorManoJugador = new HBox(imagen11,imagen12,imagen13,imagen14,imagen15);
		contenedorManoJugador.setAlignment(Pos.CENTER);
		contenedorManoJugador.setSpacing(50);

		
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
}
