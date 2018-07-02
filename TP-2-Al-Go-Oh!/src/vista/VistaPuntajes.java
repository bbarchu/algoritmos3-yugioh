package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.aplicacion.AlGoOh;

public class VistaPuntajes {

	Canvas canvas;
	StackPane stack;
	AlGoOh algooh;
	
	public VistaPuntajes(StackPane stackPaneCentral, AlGoOh algooh) {
		
		this.stack = stackPaneCentral;
		this.algooh = algooh;
		
	}

	public void dibujarAnotadorGrande() {
		
		this.canvas = new Canvas(510, 310);
		this.setFondoAnotadorGrande();
		
		Label jugador1 = new Label();
		jugador1.setText("Jugador 1: "+ (algooh.getPuntosJugador1()) );
		jugador1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		jugador1.setTextFill(Color.BLACK);
		
		Label jugador2 = new Label();
		jugador2.setText("Jugador 2: "+(algooh.getPuntosJugador2()));
		jugador2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 25));
		jugador2.setTextFill(Color.BLACK);
		
		VBox contenedorPrincipal = new VBox(jugador1, jugador2);
		contenedorPrincipal.setPadding(new Insets(0));
		contenedorPrincipal.setSpacing(120);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		
		stack.getChildren().addAll(canvas,contenedorPrincipal);
		stack.setAlignment(Pos.CENTER);
		
	}

	private void setFondoAnotadorGrande() {
		
		canvas.getGraphicsContext2D().setFill(Color.DARKRED);
		canvas.getGraphicsContext2D().fillRect(0, 0, 500, 300);
		
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillRect(0, 150, 500, 5);
		
		canvas.getGraphicsContext2D().fillRect(0, 0, 500, 5);
		canvas.getGraphicsContext2D().fillRect(0, 0, 5, 300);
		canvas.getGraphicsContext2D().fillRect(495, 0, 5, 300);
		canvas.getGraphicsContext2D().fillRect(0, 300, 500, 5);		
	}
	
	public void dibujarAnotadorChico() {
		
		this.canvas = new Canvas(260, 260);
		this.setFondoAnotadorChico();
		
		Label jugador1 = new Label();
		jugador1.setText("Jugador 1: "+ (algooh.getPuntosJugador1().toString()) );
		jugador1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		jugador1.setTextFill(Color.BLACK);
		
		Label jugador2 = new Label();
		jugador2.setText("Jugador 2: "+ (algooh.getPuntosJugador2().toString()) );
		jugador2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		jugador2.setTextFill(Color.BLACK);
		
		VBox contenedorPrincipal = new VBox(jugador1, jugador2);
		contenedorPrincipal.setPadding(new Insets(0));
		contenedorPrincipal.setSpacing(100);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		
		stack.getChildren().addAll(canvas,contenedorPrincipal);
		stack.setAlignment(Pos.CENTER);
		
	}

	private void setFondoAnotadorChico() {
		
		canvas.getGraphicsContext2D().setFill(Color.DARKRED);
		canvas.getGraphicsContext2D().fillRect(0, 0, 250, 250);
		
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillRect(0, 125, 250, 5);
		
		canvas.getGraphicsContext2D().fillRect(0, 0, 250, 5);
		canvas.getGraphicsContext2D().fillRect(0, 0, 5, 250);
		canvas.getGraphicsContext2D().fillRect(245, 0, 5, 250);
		canvas.getGraphicsContext2D().fillRect(0, 250, 250, 5);
		
	}
	
	public void actualizarAnotadorChico() {
		this.dibujarAnotadorChico();
	}
	
	public void actualizarAnotadorGrande() {
		this.dibujarAnotadorGrande();
	}

}
