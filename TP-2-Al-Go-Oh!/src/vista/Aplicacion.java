package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application{

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(final Stage stage) throws Exception {
		
		stage.setTitle("AlGoOh!");
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
		Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
		
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
		
        stage.setScene(escenaBienvenidos);
		stage.setFullScreen(true);

        stage.show();
	}

}
