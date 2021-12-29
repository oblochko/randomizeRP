module com.example.randomizerp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires lombok;


    opens com.example.randomizerp to javafx.fxml;
    exports com.example.randomizerp;
}