package cs3500.pa05.view;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The initial view which prompts the user for a path
 */

public class InitialView extends BorderPane {

  public InitialView(Stage primaryStage) {
    Label filePathLabel = new Label("File Path:");
    TextField filePathField = new TextField();
    Button browseButton = new Button("Browse");
    browseButton.setOnAction(e -> browseFile(primaryStage, filePathField));

    setTop(filePathLabel);
    setCenter(filePathField);
    setRight(browseButton);
    setPadding(new Insets(10));

    filePathField.setOnAction(e -> openBujoFile(filePathField.getText()));
  }

  private void browseFile(Stage primaryStage, TextField filePathField) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BuJo Files", "*.bujo"));
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null) {
      filePathField.setText(selectedFile.getAbsolutePath());
      openBujoFile(selectedFile.getAbsolutePath());
    }
  }

  private void openBujoFile(String filePath) {
    try {
      String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
      displayWeek(fileContent);
    } catch (IOException e) {
      displayError("Error opening file", "An error occurred while opening the file.");
    }
  }

  private void displayWeek(String fileContent) {
    System.out.println("File contents:");
    System.out.println(fileContent);
  }

  private void displayError(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
