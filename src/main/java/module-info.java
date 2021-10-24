module com.example.trainbreeze {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens cz.jocv.trainbreeze.datamodel to javafx.base;
    exports cz.jocv.trainbreeze.datamodel;
    opens cz.jocv.trainbreeze.view to javafx.base, javafx.fxml;
    exports cz.jocv.trainbreeze.controller;
    opens cz.jocv.trainbreeze.controller to javafx.base, javafx.fxml;

}