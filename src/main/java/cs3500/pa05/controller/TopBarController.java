package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.TopBar;

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
    // save button handler
    view.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        try {
          // placeholder bujo file path
          serializer.write("bujo_file_path", bujo);
        } catch (IOException e) {
          // handle exception
          e.printStackTrace();
        }
      }
    });

    // add button handler
    view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        Day newDay = new Day(DayType.MONDAY); // create a new Day object with any DayType
        week.getDays().add(newDay); // add new Day to the current week
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("A new day has been added!");
        alert.showAndWait();
      }
    });

    // max events and tasks handlers
    view.getMaxEventsTextField().setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        String maxEvents = view.getMaxEventsTextField().getText();
        week.setEventMax(Integer.parseInt(maxEvents));
      }
    });

    view.getMaxTasksTextField().setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        String maxTasks = view.getMaxTasksTextField().getText();
        week.setTaskMax(Integer.parseInt(maxTasks));
      }
    });


    // sidebar toggle handler
    view.getSideBarToggle().setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        // implement sidebar toggle functionality
      }
    });
  }
}
