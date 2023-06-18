module cs3500.pa05 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires org.junit.jupiter.api;
  requires org.mockito;
  requires junit;
  requires cs3500.pa05;

  opens cs3500.pa05 to javafx.fxml, org.junit.jupiter.api, com.fasterxml.jackson.databind;

  exports cs3500.pa05.model;
}