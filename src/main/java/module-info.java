module com.example.aufgabe_10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aufgabe_10 to javafx.fxml;
    exports com.example.aufgabe_10;
}