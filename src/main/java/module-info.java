module monopoly.gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens monopoly.gui to javafx.fxml;
    exports monopoly.gui;
}