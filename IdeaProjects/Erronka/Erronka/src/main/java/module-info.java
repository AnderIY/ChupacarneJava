module com.example.erronka {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.erronka to javafx.fxml;
    exports com.example.erronka;
}