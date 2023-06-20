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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The initial view which prompts the user for a path
 */
//public class InitialView extends BorderPane {
//  private final TextField filePathField;
//  private final Button browseButton;
//
//  public InitialView(Stage primaryStage) {
//    Label filePathLabel = new Label("Enter a File Path:");
//    filePathField = new TextField();
//    browseButton = new Button("Browse");
//    browseButton.setOnAction(e -> {
//      browseFile(primaryStage);
//      System.out.println("aaa");
//    });
//
//    setTop(filePathLabel);
//    setCenter(filePathField);
//    setRight(browseButton);
//    setPadding(new Insets(10));
//
//    //filePathField.setOnAction(e -> openBujoFile(filePathField.getText()));
//  }
//
//  public Button getBrowseButton() {
//    return browseButton;
//  }
//
//  public TextField getFilePathField() {
//    return filePathField;
//  }
//
//  private void browseFile(Stage primaryStage) {
//    FileChooser fileChooser = new FileChooser();
//    //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BuJo Files", "*.bujo"));
//    fileChooser.setTitle("Open Resource File");
//    fileChooser.showOpenDialog(primaryStage);
//    System.out.println("Hey");
////    File selectedFile = fileChooser.showOpenDialog(primaryStage);
////    if (selectedFile != null) {
////      filePathField.setText(selectedFile.getAbsolutePath());
////      openBujoFile(selectedFile.getAbsolutePath());
////    }
//  }
//
//  private void openBujoFile(String filePath) {
//    try {
//      //String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
//      Bujo bujo = new BujoSerializer().read(filePath);
//      JournalView journal = new JournalView(bujo.getWeek());
//    } catch (IOException e) {
//      displayError("Error opening file", "An error occurred while opening the file.");
//    }
//  }
//
//  public void displayWeek(String fileContent) {
//    System.out.println("File contents:");
//    System.out.println(fileContent);
//  }
//
//  public void displayError(String title, String message) {
//    Alert alert = new Alert(Alert.AlertType.ERROR);
//    alert.setTitle(title);
//    alert.setHeaderText(null);
//    alert.setContentText(message);
//    alert.showAndWait();
//  }
//}

public class InitialView extends BorderPane {
  private final TextField filePathField;
  private final Button browseButton;

  public InitialView(Stage primaryStage) {
    Label filePathLabel = new Label("Enter a File Path:");
    filePathField = new TextField();
    browseButton = new Button("Browse");

    setTop(filePathLabel);
    setCenter(filePathField);
    setRight(browseButton);
    setPadding(new Insets(10));
  }

  public Button getBrowseButton() {
    return browseButton;
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