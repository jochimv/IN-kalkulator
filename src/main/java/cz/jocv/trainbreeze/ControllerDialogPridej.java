package cz.jocv.trainbreeze;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ControllerDialogPridej {
    @FXML
    private Button tlacitkoPridej;
    @FXML
    private TextField pocatecniStanice;
    @FXML
    private TextField koncovaStanice;
    @FXML
    private Spinner<Integer> pocetJizd;


    @FXML
    private void zpracujVysledky(){
        System.out.println("Počáteční stanice: " + pocatecniStanice.getText());
        System.out.println("Koncová stanice: " + koncovaStanice.getText());
        System.out.println("Počet jízd: " + pocetJizd.getValue());
    }
}
