package cs3500.pa05.view;

import cs3500.pa05.controller.BujoSerializer;
import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The bar on the top of the page
 */
public class TopBar extends HBox {
  private final Button sideBarToggle;
  private final Button save;
  private final Button add;
  private final TextField maxEvents;
  private final TextField maxTasks;
  private final Stage primaryStage;
  private final Week week;

  /**
   * Constructing a new TopBar object
   */
  public TopBar(Week week, SideBarController side) {
    this.week = week;

    this.primaryStage = new Stage();
    this.sideBarToggle = new Button("Toggle Sidebar");
    this.save = new Button("Save");

    this.add = new Button("Add");
    this.maxEvents = new TextField();
    this.maxTasks = new TextField();

    Label maxEventsLabel = new Label("Max Events:");
    Label maxTasksLabel = new Label("Max Tasks:");

    this.maxEvents.setPrefWidth(80); // Set preferred width for the text field
    this.maxTasks.setPrefWidth(80); // Set preferred width for the text field

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

  // todo attempt to move this to controller as well?
  public void showAddDropdown() {
    ObservableList<String>
        options = FXCollections.observableArrayList("Add a new event", "Add a new task");
    ChoiceBox<String> choiceBox = new ChoiceBox<>(options);
    choiceBox.getSelectionModel().selectFirst();

    ObservableList<DayType> days = FXCollections.observableArrayList(DayType.values());
    ChoiceBox<DayType> daySelection = new ChoiceBox<>(days);
    daySelection.getSelectionModel().selectFirst();


    VBox dropdown = new VBox(10);
    dropdown.getChildren().addAll(new Label("Select an option:"), choiceBox);
    dropdown.setAlignment(Pos.CENTER);
    dropdown.setPadding(new Insets(10));

    dropdown.getChildren().addAll(new Label("Select a day"), daySelection);

    Button addButton = new Button("Add");
    dropdown.getChildren().addAll(addButton);

    Stage popupStage = new Stage();
    popupStage.initOwner(this.primaryStage);
    popupStage.initModality(Modality.WINDOW_MODAL);
    popupStage.setScene(new Scene(dropdown));
    popupStage.show();

    addButton.setOnAction(event -> {
      String selectedOption = choiceBox.getValue();
      popupStage.close();

      // Handle the selected option
      if (selectedOption.equals("Add a new event")) {
        // Perform actions for adding a new event
        System.out.println("Adding a new event...");
        this.week.getDay(daySelection.getValue()).add(new Event("testing", "description", LocalTime.now(), Duration.ofHours(1)));
      } else if (selectedOption.equals("Add a new task")) {
        // Perform actions for adding a new task
        System.out.println("Adding a new task...");
        this.week.getDay(daySelection.getValue()).add(new Task("testing", "description", false));
      }
    });
  }

  public void displayError(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}