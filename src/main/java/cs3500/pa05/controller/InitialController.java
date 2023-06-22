package cs3500.pa05.controller;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.InitialView;
import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controls the initial view which asks the user for a path
 */
public class InitialController {

  /**
   * The serializer for BUJO files
   */
  private final BujoSerializer serializer;

  /**
   * The initial view object
   */
  private final InitialView view;

  /**
   * The journal app object that runs this controller
   */
  private final JournalApp app;

  /**
   * constructor
   *
   * @param view the view for this controller
   * @param serializer the serializer for bujo files
   * @param stage the stage for this app
   * @param app the app object
   */
  public InitialController(InitialView view, BujoSerializer serializer, Stage stage,
                           JournalApp app) {
    this.view = view;
    this.serializer = serializer;
    this.initViewEvents(stage);
    this.app = app;
  }

  /**
   * Initializes the view's events
   *
   * @param stage the stage for this app
   */
  void initViewEvents(Stage stage) {
    view.getBrowseButton().setOnAction(e -> browseFile(stage));
    view.getLoadButton().setOnAction(e -> loadBujo(stage));
    view.getNewButton().setOnAction(e -> createNewBujo(stage));
    view.getFilePathField().setOnAction(e -> loadBujo(stage));
  }

  /**
   * Browse for a file in the filesystem to open
   *
   * @param stage the stage of this app
   */
  private void browseFile(Stage stage) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
    if (selectedFile != null) {
      view.getFilePathField().setText(selectedFile.getAbsolutePath());
      loadBujo(stage);
    }
  }

  /**
   * Load a bujo file from the text input box
   *
   * @param stage the stage for this app
   */
  private void loadBujo(Stage stage) {
    String filePath = view.getFilePathField().getText();
    if (!filePath.isEmpty()) {
      try {
        Bujo bujo = serializer.read(filePath);
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

  /**
   * Creates the new week and switches the view
   *
   * @param stage the stage for the app
   */
  private void createNewBujo(Stage stage) {
    // Perform any necessary actions with the new JournalView
    stage.setScene(new Scene(app.getJournalView(stage,
        new Week(5, 5, "New week")), 800, 800));
    stage.show();
  }
}