module com.example.trainbreeze {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens cz.jocv.trainbreeze to javafx.fxml;
    exports cz.jocv.trainbreeze;
}