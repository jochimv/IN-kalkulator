package cz.jocv.trainbreeze;

import cz.jocv.trainbreeze.datamodel.DataSource;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;

public class GetAllTrasyTask extends Task {
    @Override
    protected Object call() throws Exception {
        return FXCollections.observableArrayList(DataSource.getInstance().queryTrasy());
    }
}
