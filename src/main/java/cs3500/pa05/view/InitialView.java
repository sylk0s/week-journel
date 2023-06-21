package cs3500.pa05.view;

import cs3500.pa05.controller.BujoSerializer;
import cs3500.pa05.model.Bujo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The initial view which prompts the user for a path
 */
public class InitialView extends BorderPane {
  private final TextField filePathField;
  private final Button browseButton;
  private final Button loadButton;
  private final Button newButton;

  public InitialView(Stage primaryStage) {
    Label filePathLabel = new Label("Enter a File Path:");
    filePathField = new TextField();
    browseButton = new Button("Browse");
    loadButton = new Button("Load");
    newButton = new Button("New");

    setTop(filePathLabel);
    setCenter(filePathField);
    setRight(new VBox(browseButton, loadButton, newButton));
    setPadding(new Insets(10));
  }

  public Button getBrowseButton() {
    return browseButton;
  }

  public Button getLoadButton() {
    return loadButton;
  }

  public Button getNewButton() {
    return newButton;
  }

  public TextField getFilePathField() {
    return filePathField;
  }

  public void displayError(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}