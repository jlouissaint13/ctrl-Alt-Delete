module com.example.ctrlaltdelete {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.ctrlaltdelete to javafx.fxml;
    exports com.example.ctrlaltdelete;
    exports com.example.ctrlaltdelete.Login;
    opens com.example.ctrlaltdelete.Login to javafx.fxml;
    exports com.example.ctrlaltdelete.Login.ValidationException;
    opens com.example.ctrlaltdelete.Login.ValidationException to javafx.fxml;
    exports com.example.ctrlaltdelete.Menu;
    opens com.example.ctrlaltdelete.Menu to javafx.fxml;
    exports com.example.ctrlaltdelete.Homepage;
    opens  com.example.ctrlaltdelete.Homepage to javafx.fxml;
    exports com.example.ctrlaltdelete.OrderConfirmation;
}