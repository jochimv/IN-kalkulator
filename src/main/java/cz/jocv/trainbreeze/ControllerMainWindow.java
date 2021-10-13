package cz.jocv.trainbreeze;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class ControllerMainWindow {
    @FXML
    private Button tlacitkoSpocti;
    @FXML
    private TextArea vyslednyText;
    @FXML
    private ListView listTras;
    @FXML
    private MenuItem pridejTrasu;
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    protected void zobrazText() {
        vyslednyText.appendText("Zkouška");

    }
    @FXML
    protected void otevriDialogPridej(){
        Dialog<ButtonType> dialog = new Dialog<>();

        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(event -> window.hide());


        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DialogPridej.fxml"));

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        dialog.show();

    }
}