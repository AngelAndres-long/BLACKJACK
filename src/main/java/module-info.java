module com.example.blackjack {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    // Dependencias de terceros que estás usando
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    // Permite que JavaFX pueda acceder a tu clase principal por reflexión
    opens com.example.blackjack.app to javafx.graphics, javafx.fxml;

    // Si tienes más paquetes que JavaFX necesite (controladores FXML, etc.)
    // opens com.example.blackjack.controller to javafx.fxml;
    // opens com.example.blackjack.view to javafx.fxml;
}