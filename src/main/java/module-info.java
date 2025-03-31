/**
 * Module definition for the com.example.projekti module.
 *
 * Dependencies:
 * - Requires the javafx.controls module for JavaFX UI components.
 * - Requires the javafx.fxml module for JavaFX FXML functionality.
 *
 * Accessibility:
 * - Opens the com.example.projekti package to the javafx.fxml module, allowing reflection for FXML features.
 * - Exports the com.example.projekti package to make it available to other modules.
 */
module com.example.projekti {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.projekti to javafx.fxml;
    exports com.example.projekti;

}