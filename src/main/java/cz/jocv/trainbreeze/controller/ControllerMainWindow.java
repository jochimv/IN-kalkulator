package cz.jocv.trainbreeze.controller;

import cz.jocv.trainbreeze.datamodel.DataSource;
import cz.jocv.trainbreeze.datamodel.InKarta;
import cz.jocv.trainbreeze.datamodel.Trasa;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerMainWindow {
    @FXML
    private Button tlacitkoSpocti;
    @FXML
    private TextArea vyslednyText;
    @FXML
    private TableView trasy;
    @FXML
    private MenuItem pridejTrasu;
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    public void zobrazTrasy(){
        Task<ObservableList<Trasa>> task = new GetAllTrasyTask();
        trasy.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    @FXML
    public void dropVsechnyTrasy(){
        DataSource.getInstance().dropVsechnyTrasy();
        zobrazTrasy();
    }
    @FXML
    public void odeberTrasu(){
        Trasa t = (Trasa) trasy.getSelectionModel().getSelectedItem();
        String pocatecniStanice = t.getPocatecniStanice();
        String cilovaStanice = t.getCilovaStanice();
        int pocetKilometru = t.getPocetKilometru();
        int pocetJizd = t.getPocetJizd();

        DataSource.getInstance().dropTrasa(pocatecniStanice,cilovaStanice,pocetKilometru,pocetJizd);
        zobrazTrasy();
    }
    @FXML
    protected void otevriDialogPridej(){
        Dialog<ButtonType> dialog = new Dialog<>();

        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(event -> window.hide());
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/cz/jocv/trainbreeze/view/DialogPridej.fxml"));

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        dialog.showAndWait();
        zobrazTrasy();
    }

    @FXML
    public void vypocitejKartu(){
        vyslednyText.clear();
        GetAllTrasyTask getAllTrasyTask = new GetAllTrasyTask();
        ObservableList<Trasa> t = getAllTrasyTask.call();
        List<Trasa> trasy = new ArrayList<>(t);
        InKarta nejlepsi = Engine.getInstance().spoctiVysledek(trasy);
        String text = "- cena j??zdn??ho za rok: " + Engine.getRocne() + "K??\n- nejlep???? karta: " + nejlepsi.getTyp() + "\n- cena " + nejlepsi.getTyp() + " za rok: " + nejlepsi.getCenaZaRok() + "K??\n- ??spora v ??ist??m: " + nejlepsi.getPenezinaUspora() + "K??\n- nov?? cena s " + nejlepsi.getTyp() + ": " + (Engine.getRocne() - nejlepsi.getPenezinaUspora()) + "K??";
        vyslednyText.appendText(text);

    }

}