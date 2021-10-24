package cz.jocv.trainbreeze.controller;

import cz.jocv.trainbreeze.datamodel.DataSource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/cz/jocv/trainbreeze/view/trainbreeze.fxml"));
        Parent root = fxmlLoader.load();
        ControllerMainWindow controller = fxmlLoader.getController();
        controller.zobrazTrasy();

        Scene scene = new Scene(root, dimension.getWidth()* 2/3, dimension.getHeight()*2/3);
        stage.setTitle("Kalkulačka IN karet");

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!DataSource.getInstance().open()) {
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }
    @Override
    public void stop() throws Exception {
        super.stop();
        DataSource.getInstance().close();
    }
}