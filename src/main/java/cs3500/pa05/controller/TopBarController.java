package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.TopBar;
import javafx.stage.FileChooser;

/**
 * Controls the top bar
 */
public class TopBarController {
  private Week week;
  private Bujo bujo;
  private BujoSerializer serializer;
  private TopBar view;

  public TopBarController(Week week, Bujo bujo, BujoSerializer serializer, TopBar view) {
    this.week = week;
    this.bujo = bujo;
    this.serializer = serializer;
    this.view = view;
    initHandlers();
  }

  private void initHandlers() {
    view.getSaveButton().setOnAction(e -> {
      if (bujo == null) {
        // new file, prompt for file name and location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Create New Bujo File");
        fileChooser.setInitialFileName("my_bujo.bujo");

        File file = fileChooser.showSaveDialog(view.getScene().getWindow());
        if (file != null) {
          String filePath = file.getAbsolutePath();
          bujo = new Bujo(week); // create a new Bujo object with the provided week
          try {
            serializer.write(filePath, bujo);
          } catch (IOException ex) {
            view.displayError("Error saving file",
                "An error occurred while saving the file.");
          }
        }
      } else {
        // Existing file, write to the file
        try {
          serializer.write("", bujo); // provide an empty string to write to existing file path
        } catch (IOException ex) {
          view.displayError("Error saving file",
              "An error occurred while saving the file.");
        }
      }
    });
  }
}

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

