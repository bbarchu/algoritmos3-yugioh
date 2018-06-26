package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OpcionAyudaEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Reglamento");
        String mensaje = "Para conocer el reglamento visite: http://www.yugioh-card.com/es/rulebook/es.pdf";
        alert.setContentText(mensaje);
        alert.show();
    }
}
