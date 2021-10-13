package cz.jocv.trainbreeze;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("trainbreeze.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), dimension.getWidth()* 2/3, dimension.getHeight()*2/3);

        stage.setTitle("Kalkulačka IN karet");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}