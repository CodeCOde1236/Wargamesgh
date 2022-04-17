module com.example.wargames {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.wargames to javafx.fxml;
    exports com.example.wargames;
}