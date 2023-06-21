package cs3500.pa05.controller;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.InitialView;

import cs3500.pa05.view.JournalView;
import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controls the initial view which asks the user for a path
 */
public class InitialController {
  private BujoSerializer serializer;
  private Bujo bujo;
  private InitialView view;
  private final JournalApp app;

  public InitialController(InitialView view, BujoSerializer serializer, Stage stage,
                           JournalApp app) {
    this.view = view;
    this.serializer = serializer;
    this.initViewEvents(stage);
    this.app = app;
  }

  void initViewEvents(Stage stage) {
    view.getBrowseButton().setOnAction(e -> browseFile(stage));
    view.getLoadButton().setOnAction(e -> loadBujo(stage));
    view.getNewButton().setOnAction(e -> createNewBujo(stage));
    view.getFilePathField().setOnAction(e -> loadBujo(stage));
  }

  private void browseFile(Stage stage) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
    if (selectedFile != null) {
      view.getFilePathField().setText(selectedFile.getAbsolutePath());
      loadBujo(stage);
    }
  }

  private void loadBujo(Stage stage) {
    String filePath = view.getFilePathField().getText();
    if (!filePath.isEmpty()) {
      try {
        bujo = serializer.read(filePath);
        // navigate to JournalView or perform other actions
        stage.setScene(new Scene(app.getJournalView(stage, bujo.getWeek()), 800, 800));
        stage.show();
      } catch (IOException e) {
        view.displayError("Error opening file",
            "An error occurred while opening the file.");
        e.printStackTrace();
      }
    } else {
      view.displayError("Invalid file path", "Please enter a valid file path.");
    }
  }

  private void createNewBujo(Stage stage) {
    // Create a new Bujo object with an empty Week
    // Perform any necessary actions with the new JournalView
    stage.setScene(new Scene(app.getJournalView(stage,
        new Week(5, 5, "New week")), 800, 800));
    stage.show();
  }
}
