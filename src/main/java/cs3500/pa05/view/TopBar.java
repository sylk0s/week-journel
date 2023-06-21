package cs3500.pa05.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    this.sideBarToggle = new Button("Toggle Sidebar");
    this.save = new Button("Save");

    this.add = new Button("Add");
    this.maxEvents = new TextField();
    this.maxTasks = new TextField();

    Label maxEventsLabel = new Label("Max Events:");
    Label maxTasksLabel = new Label("Max Tasks:");

    this.maxEvents.setPrefWidth(40); // Set preferred width for the text field
    this.maxTasks.setPrefWidth(40); // Set preferred width for the text field

    this.setSpacing(10);
    this.setPadding(new Insets(10));
    this.getChildren().addAll(this.sideBarToggle, this.save, this.add, maxEventsLabel,
        this.maxEvents, maxTasksLabel, this.maxTasks);

    BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#bde0ff"),
        new CornerRadii(0), new Insets(0));
    Background background = new Background(backgroundFill);
    this.setBackground(background);
  }

  public void registerOnSave(EventHandler<ActionEvent> handler) {
    System.out.println("registering handler for save...");
    this.save.setOnAction(handler);
  }

  public void registerOnAdd(EventHandler<ActionEvent> handler) {
    System.out.println("registering handler for add...");
    this.add.setOnAction(handler);
  }

  public void registerOnToggleBar(EventHandler<ActionEvent> handler) {
    this.sideBarToggle.setOnAction(handler);
  }

  public void registerMaxEvents(EventHandler<ActionEvent> handler) {
    this.maxEvents.setOnAction(handler);
  }

  public void registerMaxTasks(EventHandler<ActionEvent> handler) {
    this.maxTasks.setOnAction(handler);
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