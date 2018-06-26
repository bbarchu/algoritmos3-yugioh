package vista;

import java.util.HashMap;

import javafx.scene.image.ImageView;

public class CatalogoImagenes {
	
	private HashMap<String,ImageView> mapaImagenes;

	public CatalogoImagenes() {
		
		this.mapaImagenes = new HashMap<String,ImageView>();
		this.rellenarMapa();
	}

	private void rellenarMapa() {
		
		this.colocarEnElMapa("AgujeroOscuro");
		this.colocarEnElMapa("BrazoDerechoDelProhibido");
		this.colocarEnElMapa("BrazoIzquierdoDelProhibido");
		this.colocarEnElMapa("BueyDeBatalla");
		this.colocarEnElMapa("CaballoDeMar");
		this.colocarEnElMapa("CilindroMagico");
		this.colocarEnElMapa("Craneo");
		this.colocarEnElMapa("DarkMaster");
		this.colocarEnElMapa("DemonioElemental");
		this.colocarEnElMapa("Dorso");
		this.colocarEnElMapa("DragonArmadoOscuro");
		this.colocarEnElMapa("DragonBlancoDeOjosAzules");
		this.colocarEnElMapa("DragonDeCuernoBlanco");
		this.colocarEnElMapa("DragonDeLaMuerte");
		this.colocarEnElMapa("DragonDeOjosAzulesDefinitivo");
		this.colocarEnElMapa("DragonElemental");
		this.colocarEnElMapa("DragonNegro");
		this.colocarEnElMapa("ExodiaElProhibido");
		this.colocarEnElMapa("Fisura");
		this.colocarEnElMapa("Girochin");
		this.colocarEnElMapa("GuardianDeLaPuerta");
		this.colocarEnElMapa("HaneHane");
		this.colocarEnElMapa("HojaOscura");
		this.colocarEnElMapa("InsectoComeHombres");
		this.colocarEnElMapa("JineteMistico");
		this.colocarEnElMapa("Jinzo7");
		this.colocarEnElMapa("Kuriboh");
		this.colocarEnElMapa("KuribohAlado");
		this.colocarEnElMapa("LordOfD");
		this.colocarEnElMapa("MagoOscuro");
		this.colocarEnElMapa("Obelisk");
		this.colocarEnElMapa("OgroGrotto");
		this.colocarEnElMapa("OllaDeLaCodicia");
		this.colocarEnElMapa("PiernaDerechaDelProhibido");
		this.colocarEnElMapa("PiernaIzquierdaDelProhibido");
		this.colocarEnElMapa("Reinforcements");
		this.colocarEnElMapa("Ryu");
		this.colocarEnElMapa("Segadora");
		this.colocarEnElMapa("Slifer");
		this.colocarEnElMapa("Sogen");
		this.colocarEnElMapa("Wasteland");			
		
	}
	
	private void colocarEnElMapa(String nombreCarta) {
		
		this.mapaImagenes.put(nombreCarta, crearImageView(nombreCarta+".jpg"));		
	}

	private ImageView crearImageView(String nombreArchivo) {
		ImageView imagen = new ImageView("file:src/vista/imagenes/cartas/"+nombreArchivo);
		imagen.setFitHeight(150);
		imagen.setFitWidth(100);
		
		return imagen;
	}
	
	public ImageView get(String nombreCarta){
		
		ImageView ocurrioUnError = new ImageView("file:src/vista/imagenes/cartas/ChuckNorris.jpg");
		ocurrioUnError.setFitHeight(150);
		ocurrioUnError.setFitWidth(100);
		
		return (this.mapaImagenes).getOrDefault(nombreCarta, ocurrioUnError);
		
	}
}