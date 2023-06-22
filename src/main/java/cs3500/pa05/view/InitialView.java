package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * The initial view which prompts the user for a path
 */
public class InitialView extends BorderPane {

  /**
   * The field to enter a file path
   */
  private final TextField filePathField;

  /**
   * Button to open file explorer
   */
  private final Button browseButton;

  /**
   * Button to load a file from the text box
   */
  private final Button loadButton;

  /**
   * Button for a new week
   */
  private final Button newButton;

  /**
   * constructor
   */
  public InitialView() {
    filePathField = new TextField();
    browseButton = new Button("Browse");
    loadButton = new Button("Load");
    newButton = new Button("New");

    Label filePathLabel = new Label("Enter a File Path:");
    setTop(filePathLabel);
    setCenter(filePathField);
    setRight(new VBox(browseButton, loadButton, newButton));
    setPadding(new Insets(10));
  }

  /**
   * Gets the browse button
   *
   * @return the browse button
   */
  public Button getBrowseButton() {
    return browseButton;
  }

  /**
   * Gets the load button
   *
   * @return the load button
   */
  public Button getLoadButton() {
    return loadButton;
  }

  /**
   * Gets the new button
   *
   * @return the new button
   */
  public Button getNewButton() {
    return newButton;
  }

  /**
   * Gets the file path field
   *
   * @return the file path field
   */
  public TextField getFilePathField() {
    return filePathField;
  }

  /**
   * Displays the error
   *
   * @param title error title
   * @param message error message
   */
  public void displayError(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}