package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.WeekView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.stream.Collectors;

/**
 * Controls the week view
 */
public class WeekViewController {
  private Week week;
  private WeekView view;
  private Stage stage;  // Added the stage object to be able to display the week

  WeekViewController(Week week, Stage stage) { // Stage passed to the constructor
    this.week = week;
    this.stage = stage;
    this.view = new WeekView(week.getDays().stream()
        .map(day -> WeekView.getDayFrom(day.getName(), day.getItems())) // lambda function to pass both parameters
        .collect(Collectors.toList()));
  }

  public void run() {
    Scene scene = new Scene(view); // Creating a new Scene using the view
    stage.setScene(scene); // Setting the stage's scene
    stage.show(); // Showing the stage
  }
}
