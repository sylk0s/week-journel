package cs3500.pa05.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Handles keybind in the program
 */
public class KeyPressHandler {
  /**
   * The controller for the top bar
   */
  private final TopBarController topBarController;
  /**
   * The primary stage for this app
   */
  private final Stage primaryStage;

  /**
   * Constructor
   *
   * @param topBarController the controller for the top bar
   */
  public KeyPressHandler(TopBarController topBarController) {
    this.topBarController = topBarController;
    this.primaryStage = new Stage();
  }

  /**
   * Handles a key event
   *
   * @param event the key event
   */
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
    KeyCodeCombination startDayCombination =
        new KeyCodeCombination(KeyCode.D, KeyCombination.SHORTCUT_DOWN);
    KeyCodeCombination toggleSideCombination =
        new KeyCodeCombination(KeyCode.V, KeyCombination.SHORTCUT_DOWN);

    if (newEventCombination.match(event)) {
      System.out.println("Create New Event command triggered.");
      topBarController.showAddDropdown();
    } else if (newTaskCombination.match(event)) {
      System.out.println("Create New Task command triggered.");
      topBarController.showAddDropdown();
    } else if (saveCombination.match(event)) {
      topBarController.handleSave(primaryStage);
      System.out.println("Save command triggered.");
    } else if (openCombination.match(event)) {
      topBarController.handleOpen(primaryStage);
      System.out.println("Open command triggered.");
    } else if (newWeekCombination.match(event)) {
      topBarController.handleNewWeek(primaryStage);
      System.out.println("New Week command triggered.");
    } else if (startDayCombination.match(event)) {
      topBarController.showDayDropdown();
    } else if (toggleSideCombination.match(event)) {
      this.topBarController.handleToggleVis();
    }
  }
}