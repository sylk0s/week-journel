package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
//public class InitialController {
//  private BujoSerializer serializer;
//  private Bujo bujo;
//  private InitialView view;
//
//  public InitialController(InitialView view, BujoSerializer serializer) {
//    this.view = view;
//    this.serializer = serializer;
//    this.initViewEvents();
//  }
//
//  void initViewEvents() {
//    /*
//    view.getBrowseButton().setOnAction(e -> {
//      String path = view.getFilePathField().getText();
//      loadBujo(path);
//    });
//     */
//
//    view.getFilePathField().setOnAction(e -> {
//      String path = view.getFilePathField().getText();
//      loadBujo(path);
//    });
//  }
//
//  private void loadBujo(String path) {
//    try {
//      bujo = serializer.read(path);
//      view.displayWeek(bujo.toString());
//    } catch (IOException e) {
//      view.displayError("Error opening file",
//          "An error occurred while opening the file.");
//    }
//  }
//}

public class InitialController {
  private BujoSerializer serializer;
  private Bujo bujo;
  private InitialView view;
  private final JournalView nextView;

  public InitialController(InitialView view, BujoSerializer serializer, Stage stage,
                           JournalView nextView) {
    this.view = view;
    this.serializer = serializer;
    this.initViewEvents(stage);
    this.nextView = nextView;
  }

  void initViewEvents(Stage stage) {
    view.getBrowseButton().setOnAction(e -> browseFile());
    view.getLoadButton().setOnAction(e -> loadBujo());
    view.getNewButton().setOnAction(e -> createNewBujo(stage));
    view.getFilePathField().setOnAction(e -> loadBujo());
  }

  private void browseFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
    if (selectedFile != null) {
      view.getFilePathField().setText(selectedFile.getAbsolutePath());
      loadBujo();
    }
  }

  private void loadBujo() {
    String filePath = view.getFilePathField().getText();
    if (!filePath.isEmpty()) {
      try {
        bujo = serializer.read(filePath);
        JournalView journal = nextView;
        // navigate to JournalView or perform other actions
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
    Week week = new Week(10, 10, "Untitled");

    // Perform any necessary actions with the new JournalView
    stage.setScene(new Scene(nextView, 800, 800));
    stage.show();
  }
}
