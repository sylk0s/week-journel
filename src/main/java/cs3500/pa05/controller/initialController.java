package cs3500.pa05.controller;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.view.InitialView;

import java.io.IOException;

/**
 * Controls the initial view which asks the user for a path
 */
public class initialController {
  private BujoSerializer serializer;
  private Bujo bujo;
  private InitialView view;

  public initialController(InitialView view, BujoSerializer serializer) {
    this.view = view;
    this.serializer = serializer;
    this.initViewEvents();
  }

  private void initViewEvents() {
    view.getBrowseButton().setOnAction(e -> {
      String path = view.getFilePathField().getText();
      loadBujo(path);
    });

    view.getFilePathField().setOnAction(e -> {
      String path = view.getFilePathField().getText();
      loadBujo(path);
    });
  }

  private void loadBujo(String path) {
    try {
      bujo = serializer.read(path);
      view.displayWeek(bujo.toString());
    } catch (IOException e) {
      view.displayError("Error opening file",
          "An error occurred while opening the file.");
    }
  }
}
