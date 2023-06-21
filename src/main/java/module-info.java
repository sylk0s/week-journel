module cs3500.pa05 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.datatype.jsr310;

  opens cs3500.pa05 to com.fasterxml.jackson.databind, javafx.fxml;
    exports cs3500.pa05;
    exports cs3500.pa05.model;
    exports cs3500.pa05.controller;
    exports cs3500.pa05.view;
    opens cs3500.pa05.controller to javafx.fxml;
}