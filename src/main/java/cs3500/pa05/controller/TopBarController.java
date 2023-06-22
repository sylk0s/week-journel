package cs3500.pa05.controller;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.TopBar;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controls the top bar
 */
public class TopBarController {
  /**
   * The controller for the week view
   */
  private final WeekViewController week;

  /**
   * The view for the top bar
   */
  private final TopBar view;

  /**
   * The controller for the sidebar
   */
  private final SideBarController side;

  /**
   * the journal application
   */
  private final JournalApp app;

  /**
   * Constructor
   *
   * @param week week controller
   * @param view the view for the top bar
   * @param stage the stage for this app
   * @param side the controller for the sidebar
   * @param app the app this belongs to
   */
  public TopBarController(WeekViewController week, TopBar view,
                          Stage stage, SideBarController side, JournalApp app) {
    this.week = week;
    this.view = view;
    this.side = side;
    this.app = app;
    this.initHandlers(stage);


  }

  /**
   * Initialized the handlers for the top bar
   *
   * @param primaryStage the primary stage for this app
   */
  public void initHandlers(Stage primaryStage) {

    this.view.registerOnSave(e -> handleSave(primaryStage));

    this.view.registerOnAdd(e -> this.showAddDropdown());

    this.view.registerOnToggleBar(e -> this.handleToggleVis());

    this.view.registerOnNewWeek(e -> handleNewWeek(primaryStage));

    this.view.registerOpen(e -> this.handleOpen(primaryStage));

    this.view.registerOnStartDay(e -> this.showDayDropdown());

    this.view.registerMaxEvents(e -> {
      try {
        String text = this.view.getMaxEventsTextField().getText();
        if (text.equals("")) {
          this.week.getWeek().setEventMax(0);
        } else {
          this.week.getWeek()
              .setEventMax(Integer.parseInt(text));
        }
      } catch (NumberFormatException err) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Not a number!");
        alert.setHeaderText(null);
        alert.setContentText("Some invalid input found in the event max field");
        alert.showAndWait();
      }
    });

    this.view.registerMaxTasks(e -> {
      try {
        String text = this.view.getMaxTasksTextField().getText();
        if (text.equals("")) {
          this.week.getWeek().setTaskMax(0);
        } else {
          this.week.getWeek()
              .setTaskMax(Integer.parseInt(text));
        }
      } catch (NumberFormatException err) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Not a number!");
        alert.setHeaderText(null);
        alert.setContentText("Some invalid input found in the task max field");
        alert.showAndWait();
      }
    });




  }

  /**
   * Shows and handles the add dropdown menu for the top bar
   */
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
    popupStage.initOwner(new Stage());
    popupStage.initModality(Modality.WINDOW_MODAL);
    popupStage.setScene(new Scene(dropdown));
    popupStage.show();

    addButton.setOnAction(event -> {
      String selectedOption = choiceBox.getValue();
      popupStage.close();

      // Handle the selected option
      if (selectedOption.equals("Add a new event")) {
        // Perform actions for adding a new event
        this.week.addEntryTo(daySelection.getValue(),
            new Event("", "", LocalTime.now(), Duration.ofHours(1)));
        this.side.updateView();
      } else if (selectedOption.equals("Add a new task")) {
        // Perform actions for adding a new task
        this.week.addEntryTo(daySelection.getValue(),
            new Task("", "", false));
        this.side.updateView();
      }
    });
  }

  /**
   * Shows and handles the day dropdown menu for the topbar
   */
  public void showDayDropdown() {
    ComboBox<DayType> dayDropdown =
        new ComboBox<>(FXCollections.observableArrayList(DayType.values()));
    dayDropdown.setPromptText("Select a day");
    dayDropdown.setValue(week.getWeek().getStartDay());

    Stage popupStage = new Stage();
    VBox vbox = new VBox(dayDropdown);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(10));
    popupStage.initOwner(new Stage());
    popupStage.initModality(Modality.WINDOW_MODAL);
    popupStage.setScene(new Scene(vbox));
    popupStage.show();

    dayDropdown.setOnAction(event -> {
      DayType selectedDay = dayDropdown.getValue();
      week.setWeekStartDay(selectedDay);
      popupStage.close();
    });
  }

  /**
   * Handler for saving
   *
   * @param primaryStage the stage for this app
   */
  public void handleSave(Stage primaryStage) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save");
    fileChooser.setInitialFileName("savefile.bujo");
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Bujo Files", "*.bujo"),
        new FileChooser.ExtensionFilter("All Files", "*.*")
    );

    File selectedFile = fileChooser.showSaveDialog(primaryStage);
    if (selectedFile != null) {
      try {
        BujoSerializer serializer = new BujoSerializer();
        Bujo bujo = new Bujo(this.week.getWeek());
        serializer.write(selectedFile.getAbsolutePath(), bujo);
      } catch (IOException aaa) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Failed to open");
        alert.setHeaderText(null);
        alert.setContentText("Failed to open specified file");
        alert.showAndWait();
      }
    }
  }

  /**
   * handles opening a new file
   *
   * @param stage the primary stage
   */
  public void handleOpen(Stage stage) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File selectedFile = fileChooser.showOpenDialog(stage);
    try {
      Bujo bujo = new BujoSerializer().read(selectedFile.getAbsolutePath());
      stage.setScene(new Scene(app.getJournalView(stage, bujo.getWeek()), 800, 800));
      stage.show();
    } catch (IOException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Failed to open");
      alert.setHeaderText(null);
      alert.setContentText("Failed to open specified file");
      alert.showAndWait();
    }
  }

  /**
   * handler for creating a new week
   *
   * @param primaryStage the stage for this app
   */
  public void handleNewWeek(Stage primaryStage) {
    Scene scene = new Scene(app.getJournalView(primaryStage,
        new Week(5, 5, "New Week")));
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Toggle side bar handler
   */
  public void handleToggleVis() {
    this.side.toggleVis();
  }


}