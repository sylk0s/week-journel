package cs3500.pa05.controller;

import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import java.io.File;
import java.io.IOException;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.TopBar;
import java.time.Duration;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controls the top bar
 */
public class TopBarController {
  private WeekViewController week;
  private Bujo bujo;
  private TopBar view;
  private SideBarController side;

  public TopBarController(WeekViewController week, Bujo bujo, TopBar view,
                          Stage stage, SideBarController side) {
    System.out.println("constructing controller...");
    this.week = week;
    this.bujo = bujo;
    this.view = view;
    this.side = side;
    this.initHandlers(stage);
  }

  public void initHandlers(Stage primaryStage) {
    System.out.println("initializing handlers...");

    this.view.registerOnSave(e -> {
      System.out.println("save click");
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
          // Perform save operation by writing bujo data to the selected file
          BujoSerializer serializer = new BujoSerializer();
          Bujo bujo = new Bujo(this.week.getWeek()); // Replace with your bujo creation logic
          serializer.write(selectedFile.getAbsolutePath(), bujo);
          System.out.println("Bujo file saved: " + selectedFile.getAbsolutePath());
        } catch (IOException aaa) {
          System.out.println("Error saving bujo file: " + aaa.getMessage());
        }
      }
    });

    this.view.registerOnAdd(e -> {
      System.out.println("add button");
      this.showAddDropdown();
    });

    this.view.registerOnToggleBar(e -> {
      System.out.println("toggled bar");
      this.side.toggleVis();
    });

    System.out.println("all registered...");
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
        System.out.println("Adding a new event...");
        this.week.addEntryTo(daySelection.getValue(),
            new Event("testing", "description", LocalTime.now(), Duration.ofHours(1)));
      } else if (selectedOption.equals("Add a new task")) {
        // Perform actions for adding a new task
        System.out.println("Adding a new task...");
        this.week.addEntryTo(daySelection.getValue(),
            new Task("testing", "description", false));
      }
    });
  }
}

//    // max events and tasks handlers
//    view.getMaxEventsTextField().setOnAction(new EventHandler<ActionEvent>() {
//      @Override
//      public void handle(ActionEvent actionEvent) {
//        String maxEvents = view.getMaxEventsTextField().getText();
//        week.setEventMax(Integer.parseInt(maxEvents));
//      }
//    });
//
//    view.getMaxTasksTextField().setOnAction(new EventHandler<ActionEvent>() {
//      @Override
//      public void handle(ActionEvent actionEvent) {
//        String maxTasks = view.getMaxTasksTextField().getText();
//        week.setTaskMax(Integer.parseInt(maxTasks));
//      }
//    });