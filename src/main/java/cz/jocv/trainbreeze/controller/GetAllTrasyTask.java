package cz.jocv.trainbreeze.controller;

import cz.jocv.trainbreeze.datamodel.DataSource;
import cz.jocv.trainbreeze.datamodel.Trasa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class GetAllTrasyTask extends Task {
    @Override
    protected ObservableList<Trasa> call() throws Exception {
        return FXCollections.observableArrayList(DataSource.getInstance().queryTrasy());
    }
}
