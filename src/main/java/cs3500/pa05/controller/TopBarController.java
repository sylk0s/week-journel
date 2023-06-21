package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import java.io.File;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.TopBar;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controls the top bar
 */
public class TopBarController {
  private Week week;
  private Bujo bujo;
  private TopBar view;

  public TopBarController(Week week, Bujo bujo, TopBar view, Stage stage) {
    System.out.println("constructing controller...");
    this.week = week;
    this.bujo = bujo;
    this.view = view;
    this.initHandlers(stage);
  }

  public void initHandlers(Stage primaryStage) {
    System.out.println("initializing handlers...");

//    this.view.registerOnSave(e -> {
//      System.out.println("save click");
//      FileChooser fileChooser = new FileChooser();
//      fileChooser.setTitle("Save");
//      fileChooser.setInitialFileName("savefile.bujo");
//      fileChooser.getExtensionFilters().addAll(
//          new FileChooser.ExtensionFilter("Bujo Files", "*.bujo"),
//          new FileChooser.ExtensionFilter("All Files", "*.*")
//      );
//
//      File selectedFile = fileChooser.showSaveDialog(primaryStage);
//      if (selectedFile != null) {
//        try {
//          // Perform save operation by writing bujo data to the selected file
//          BujoSerializer serializer = new BujoSerializer();
//          Bujo bujo = new Bujo(this.week); // Replace with your bujo creation logic
//          serializer.write(selectedFile.getAbsolutePath(), bujo);
//          System.out.println("Bujo file saved: " + selectedFile.getAbsolutePath());
//        } catch (IOException aaa) {
//          System.out.println("Error saving bujo file: " + aaa.getMessage());
//        }
//      }
//    });
//
//    this.view.registerOnAdd(e -> {
//      System.out.println("add button");
//      this.view.showAddDropdown();
//    });

    System.out.println("all registered...");
  }
}

//  public void initHandlers(Stage primaryStage) {
//    System.out.println("hey");
//    FileChooser fileChooser = new FileChooser();
//    fileChooser.setTitle("Save Bujo File");
//    System.out.println("hi");
//    Button b = view.getSaveButton();
//    System.out.println("hi2");
//    b.setOnAction(e -> {
//      System.out.println("hello");
//      File file = fileChooser.showSaveDialog(primaryStage);
//      System.out.println("hiiiii");
//      if (file != null) {
//        System.out.println("h");
//        String filePath = file.getAbsolutePath();
//        bujo = new Bujo(week); // Create a new Bujo object with the provided Week
//        try {
//          serializer.write(filePath, bujo);
//          // Perform any necessary actions after saving the Bujo file
//        } catch (IOException ex) {
//          view.displayError("Error saving file", "An error occurred while saving the file.");
//        }
//      }
//    });
//
//    view.getAddButton().setOnAction(e -> {
//      List<String> choices = List.of("Add a new event", "Add a new task");
//      ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
//      dialog.setTitle("Add");
//      dialog.setHeaderText("Select an option");
//      dialog.setContentText("Choose whether to add a new event or a new task:");
//
//      Optional<String> result = dialog.showAndWait();
//      result.ifPresent(choice -> {
//        if (choice.equals("Add a new event")) {
//          // Perform actions for adding a new event
//        } else if (choice.equals("Add a new task")) {
//          // Perform actions for adding a new task
//        }
//      });
//    });
//  }


//    // add button handler
//    view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
//      @Override
//      public void handle(ActionEvent actionEvent) {
//        Day newDay = new Day(DayType.MONDAY); // create a new Day object with any DayType
//        week.getDays().add(newDay); // add new Day to the current week
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("A new day has been added!");
//        alert.showAndWait();
//      }
//    });
//
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
//
//
//    // sidebar toggle handler
//    view.getSideBarToggle().setOnAction(new EventHandler<ActionEvent>() {
//      @Override
//      public void handle(ActionEvent actionEvent) {
//        // implement sidebar toggle functionality
//      }
//    });
//  }

