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
	
	public VistaCampoDeBatalla(StackPane stackPaneCentral){
		
		this.stack = stackPaneCentral;
		this.canvas = new Canvas(900, 900);
	}

	public void dibuajarTodoElCampo() {
		
		this.setFondoTodoElCampo();
		
		ImageView imagen1 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen1.setFitHeight(150);
		imagen1.setFitWidth(100);
		imagen1.setRotate(180);
		
		ImageView imagen2 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen2.setFitHeight(150);
		imagen2.setFitWidth(100);
		imagen2.setRotate(180);
		
		ImageView imagen3 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen3.setFitHeight(150);
		imagen3.setFitWidth(100);
		imagen3.setRotate(180);
		
		ImageView imagen4 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen4.setFitHeight(150);
		imagen4.setFitWidth(100);
		imagen4.setRotate(180);
		
		ImageView imagen5 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen5.setFitHeight(150);
		imagen5.setFitWidth(100);
		imagen4.setRotate(180);
		
		ImageView imagen6 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen6.setFitHeight(150);
		imagen6.setFitWidth(100);
		imagen6.setRotate(180);
		
		ImageView imagen7 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen7.setFitHeight(150);
		imagen7.setFitWidth(100);
		imagen7.setRotate(180);
		
		ImageView imagen8 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen8.setFitHeight(150);
		imagen8.setFitWidth(100);
		imagen8.setRotate(180);
		
		ImageView imagen9 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen9.setFitHeight(150);
		imagen9.setFitWidth(100);
		imagen9.setRotate(180);
		
		ImageView imagen10 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen10.setFitHeight(150);
		imagen10.setFitWidth(100);
		imagen10.setRotate(180);
		
		ImageView imagen11 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen11.setFitHeight(150);
		imagen11.setFitWidth(100);
		
		ImageView imagen21 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen21.setFitHeight(150);
		imagen21.setFitWidth(100);
		
		ImageView imagen31 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen31.setFitHeight(150);
		imagen31.setFitWidth(100);
		
		ImageView imagen41 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen41.setFitHeight(150);
		imagen41.setFitWidth(100);
		
		ImageView imagen51 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen51.setFitHeight(150);
		imagen51.setFitWidth(100);
		
		ImageView imagen61 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen61.setFitHeight(150);
		imagen61.setFitWidth(100);
		
		ImageView imagen71 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen71.setFitHeight(150);
		imagen71.setFitWidth(100);
		
		ImageView imagen81 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen81.setFitHeight(150);
		imagen81.setFitWidth(100);
		
		ImageView imagen91 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen91.setFitHeight(150);
		imagen91.setFitWidth(100);
		
		ImageView imagen101 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen101.setFitHeight(150);
		imagen101.setFitWidth(100);
		
		HBox contenedorMagiaRival = new HBox(imagen1,imagen2,imagen3,imagen4,imagen5);
		contenedorMagiaRival.setAlignment(Pos.CENTER);
		contenedorMagiaRival.setSpacing(50);

		HBox contenedorMonstruosRival = new HBox(imagen6,imagen7,imagen8,imagen9,imagen10);
		contenedorMonstruosRival.setAlignment(Pos.CENTER);
		contenedorMonstruosRival.setSpacing(50);

		HBox contenedorMonstruosJugador = new HBox(imagen11,imagen21,imagen31,imagen41,imagen51);
		contenedorMonstruosJugador.setAlignment(Pos.CENTER);
		contenedorMonstruosJugador.setSpacing(50);

		HBox contenedorMagiaJugador = new HBox(imagen61,imagen71,imagen81,imagen91,imagen101);
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
		
		ImageView imagen1 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen1.setFitHeight(150);
		imagen1.setFitWidth(100);
		
		ImageView imagen2 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen2.setFitHeight(150);
		imagen2.setFitWidth(100);
		
		ImageView imagen3 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen3.setFitHeight(150);
		imagen3.setFitWidth(100);
		
		ImageView imagen4 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen4.setFitHeight(150);
		imagen4.setFitWidth(100);
		
		ImageView imagen5 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen5.setFitHeight(150);
		imagen5.setFitWidth(100);
		
		ImageView imagen11 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen11.setFitHeight(150);
		imagen11.setFitWidth(100);
		
		ImageView imagen21 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen21.setFitHeight(150);
		imagen21.setFitWidth(100);
		
		ImageView imagen31 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen31.setFitHeight(150);
		imagen31.setFitWidth(100);
		
		ImageView imagen41 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen41.setFitHeight(150);
		imagen41.setFitWidth(100);
		
		ImageView imagen51 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen51.setFitHeight(150);
		imagen51.setFitWidth(100);
		
		ImageView imagen61 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen61.setFitHeight(150);
		imagen61.setFitWidth(100);
		
		ImageView imagen71 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen71.setFitHeight(150);
		imagen71.setFitWidth(100);
		
		ImageView imagen81 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen81.setFitHeight(150);
		imagen81.setFitWidth(100);
		
		ImageView imagen91 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen91.setFitHeight(150);
		imagen91.setFitWidth(100);
		
		ImageView imagen101 = new ImageView("file:src/vista/imagenes/Dragón_blanco_de_ojos_azules.jpg");
		imagen101.setFitHeight(150);
		imagen101.setFitWidth(100);
		
		
		HBox contenedorMonstruosJugador = new HBox(imagen11,imagen21,imagen31,imagen41,imagen51);
		contenedorMonstruosJugador.setAlignment(Pos.CENTER);
		contenedorMonstruosJugador.setSpacing(50);

		HBox contenedorMagiaJugador = new HBox(imagen61,imagen71,imagen81,imagen91,imagen101);
		contenedorMagiaJugador.setAlignment(Pos.CENTER);
		contenedorMagiaJugador.setSpacing(50);

		HBox contenedorManoJugador = new HBox(imagen1,imagen2,imagen3,imagen4,imagen5);
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
