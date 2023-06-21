package cs3500.pa05.controller;

import cs3500.pa05.view.WeekView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Handles keybind in the program
 */
public class KeyPressHandler {
  private final TopBarController topBarController;
  private final Stage primaryStage;

  public KeyPressHandler(TopBarController topBarController) {
    this.topBarController = topBarController;
    this.primaryStage = new Stage();
  }

  public void handle(KeyEvent event) {
    KeyCodeCombination newEventCombination =
        new KeyCodeCombination(KeyCode.E, KeyCombination.SHORTCUT_DOWN);
    KeyCodeCombination newTaskCombination =
        new KeyCodeCombination(KeyCode.T, KeyCombination.SHORTCUT_DOWN);
    KeyCodeCombination saveCombination =
        new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    KeyCodeCombination openCombination =
        new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN);
    KeyCodeCombination newWeekCombination =
        new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN);

    if (newEventCombination.match(event)) {
      System.out.println("Create New Event command triggered.");
      topBarController.showAddDropdown();
    } else if (newTaskCombination.match(event)) {
      System.out.println("Create New Task command triggered.");
      topBarController.showAddDropdown();
    } else if (saveCombination.match(event)) {
      topBarController.initHandlers(primaryStage);
      System.out.println("Save command triggered.");
    } else if (openCombination.match(event)) {
      System.out.println("Open command triggered.");
      // Call the corresponding method or perform the necessary action
    } else if (newWeekCombination.match(event)) {
      System.out.println("New Week command triggered.");

    }
  }
}