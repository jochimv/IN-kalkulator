package cz.jocv.trainbreeze;

import cz.jocv.trainbreeze.datamodel.DataSource;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private void zpracujVysledky(){
        System.out.println("Zpracovávám výsledky");
        String pocatedniStanice = pocatecniField.getText();
        String cilovaStanice = cilovyField.getText();
        int kilometry;
        try{
            String kilometryText = kilometryField.getText();
            kilometry = Integer.parseInt(kilometryText);

        } catch (NumberFormatException e){
            return;
        }
        int pocetJizd = jizdySpinner.getValue();

        DataSource.getInstance().insertTrasa(pocatedniStanice,cilovaStanice,kilometry,pocetJizd);
        Stage stage = (Stage) pridejButton.getScene().getWindow();
        stage.close();

        F
    }
}
