module com.example.projekti {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.projekti to javafx.fxml;
    exports com.example.projekti;

}