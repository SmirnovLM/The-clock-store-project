module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.google.gson;

    opens com.example.demo to javafx.fxml;
    requires java.sql;
    opens com.example.demo.Logic to com.google.gson;
    exports com.example.demo;
}