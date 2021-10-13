package cz.jocv.trainbreeze;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MainController {
    @FXML
    private Button spoctiTlacitko;
    @FXML
    private TextArea vyslednyText;

    @FXML
    protected void zobrazText() {
        vyslednyText.appendText("Zkouška");

    }
}