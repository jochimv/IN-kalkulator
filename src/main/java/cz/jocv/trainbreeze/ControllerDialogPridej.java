package cz.jocv.trainbreeze;

import cz.jocv.trainbreeze.datamodel.DataSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.ExceptionListener;
import java.io.IOException;

public class ControllerDialogPridej {
    @FXML
    private Button pridejButton;
    @FXML
    private Spinner<Integer> jizdySpinner;
    @FXML
    private TextField cilovyField;
    @FXML
    private TextField pocatecniField;
    @FXML
    private TextField kilometryField;


    @FXML
    private void zpracujVysledky() {
        String pocatecniStanice = pocatecniField.getText();
        String cilovaStanice = cilovyField.getText();
        int kilometry;
        int pocetJizd = jizdySpinner.getValue();

        if (pocatecniStanice.equals("") || cilovaStanice.equals("")){
            closeWindow();
            return;
        }

        try {
            String kilometryText = kilometryField.getText();
            kilometry = Integer.parseInt(kilometryText);

        } catch (NumberFormatException e) {
            closeWindow();
            return;
        }

        DataSource.getInstance().insertTrasa(pocatecniStanice, cilovaStanice, kilometry, pocetJizd);

        closeWindow();


    }

    private void closeWindow() {
        Stage stage = (Stage) pridejButton.getScene().getWindow();
        stage.close();
    }
}
