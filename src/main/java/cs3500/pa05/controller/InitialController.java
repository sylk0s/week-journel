package cs3500.pa05.controller;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.view.InitialView;

import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;

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

  public InitialController(InitialView view, BujoSerializer serializer) {
    this.view = view;
    this.serializer = serializer;
    this.initViewEvents();
  }

  void initViewEvents() {
    view.getBrowseButton().setOnAction(e -> browseFile());
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
    try {
      bujo = serializer.read(filePath);
      //view.displayWeek(bujo.toString());
    } catch (IOException e) {
      view.displayError("Error opening file",
          "An error occurred while opening the file.");
    }
  }
}