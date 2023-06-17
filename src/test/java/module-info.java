module cs3500.pa05 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
  requires com.fasterxml.jackson.annotation;

  opens cs3500.pa05 to javafx.fxml;
    exports cs3500.pa05.model;
    opens cs3500.pa05.controller to javafx.fxml;
}