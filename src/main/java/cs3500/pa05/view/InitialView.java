package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

    Label filePathLabel = new Label("Enter a File Path");
    filePathLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    VBox spacing = new VBox(150);
    setTop(spacing);
    VBox topContainer = new VBox(15, filePathLabel, filePathField);
    topContainer.setAlignment(Pos.CENTER_LEFT);
    setCenter(topContainer);

    HBox buttonContainer = new HBox(15); // Adjust the spacing as needed
    buttonContainer.getChildren().addAll(browseButton, loadButton, newButton);
    buttonContainer.setAlignment(Pos.CENTER);
    setBottom(buttonContainer);

    setPadding(new Insets(10));

    // Set VBox height to occupy remaining space in the center
    VBox.setVgrow(topContainer, javafx.scene.layout.Priority.ALWAYS);
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
   * @param title   error title
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
