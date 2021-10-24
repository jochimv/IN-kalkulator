module com.example.trainbreeze {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens cz.jocv.trainbreeze to javafx.fxml, javafx.base;
    opens cz.jocv.trainbreeze.datamodel to javafx.base;
    exports cz.jocv.trainbreeze;
    exports cz.jocv.trainbreeze.datamodel;
}