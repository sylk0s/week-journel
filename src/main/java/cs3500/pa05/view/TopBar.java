package cs3500.pa05.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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

  /**
   * Constructing a new TopBar object
   */
  public TopBar() {
    primaryStage = new Stage();
    sideBarToggle = new Button("Toggle Sidebar");
    save = new Button("Save");
    save.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.out.println("henry");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialFileName("save file");
        fileChooser.getExtensionFilters().addAll
            (new FileChooser.ExtensionFilter("All Files", "*.*"));
        fileChooser.showSaveDialog(primaryStage);
      }
    });

    add = new Button("Add");
    add.setOnAction(e -> {
      showAddDropdown();
    });
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

  private void showAddDropdown() {
    ObservableList<String>
        options = FXCollections.observableArrayList("Add a new event", "Add a new task");
    ChoiceBox<String> choiceBox = new ChoiceBox<>(options);
    choiceBox.getSelectionModel().selectFirst();

    Button addButton = new Button("Add");

    VBox dropdown = new VBox(10);
    dropdown.getChildren().addAll(new Label("Select an option:"), choiceBox, addButton);
    dropdown.setAlignment(Pos.CENTER);
    dropdown.setPadding(new Insets(10));

    Stage popupStage = new Stage();
    popupStage.initOwner(primaryStage);
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
      } else if (selectedOption.equals("Add a new task")) {
        // Perform actions for adding a new task
        System.out.println("Adding a new task...");
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