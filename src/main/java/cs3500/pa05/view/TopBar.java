package cs3500.pa05.view;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * The bar on the top of the page
 */
public class TopBar extends HBox {
  private final Button sideBarToggle;
  private final Button save;
  private final Button add;
  private final TextField maxEvents;
  private final TextField maxTasks;

  /**
   * Constructing a new TopBar object
   */
  public TopBar() {
    sideBarToggle = new Button("Toggle Sidebar");
    save = new Button("Save");
    add = new Button("Add");
    maxEvents = new TextField();
    maxTasks = new TextField();

    Label maxEventsLabel = new Label("Max Events:");
    Label maxTasksLabel = new Label("Max Tasks:");

    maxEvents.setPrefWidth(80); // Set preferred width for the text field
    maxTasks.setPrefWidth(80); // Set preferred width for the text field

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(sideBarToggle, save, add, maxEventsLabel, maxEvents, maxTasksLabel, maxTasks);

    BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#00ffff"),
        new CornerRadii(0), new Insets(0));
    Background background = new Background(backgroundFill);
    setBackground(background);
  }

  /**
   * Getter method for side bar toggle
   *
   * @return sideBarToggle
   */
  public Button getSideBarToggle() {
    return sideBarToggle;
  }

  /**
   * Getter method for save
   *
   * @return save
   */
  public Button getSaveButton() {
    return save;
  }

  /**
   * Getter method for add
   *
   * @return add
   */
  public Button getAddButton() {
    return add;
  }

  /**
   * Getter method for max events
   *
   * @return maxEvents
   */
  public TextField getMaxEventsTextField() {
    return maxEvents;
  }

  /**
   * Getter method for max tasks
   *
   * @return maxTasks
   */
  public TextField getMaxTasksTextField() {
    return maxTasks;
  }

  public void displayError(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}