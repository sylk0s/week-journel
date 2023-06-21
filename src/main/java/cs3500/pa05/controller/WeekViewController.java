package cs3500.pa05.controller;

import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.WeekView;
import java.util.List;
import java.util.Optional;
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
  private List<DayController> days;
  SideBarController side;

  WeekViewController(Week week, Stage stage, SideBarController side) { // Stage passed to the constructor
    this.week = week;
    this.stage = stage;
    this.view = new WeekView();
    System.out.println("side is: " + (side == null ? "null" : side));
    this.days = week.getDays().stream()
        .map(d -> new DayController(d, side, this)).collect(Collectors.toList());
    for (DayController d : days) {
      this.addDayToView(d);
    }
  }

  public void run() {
    Scene scene = new Scene(view); // Creating a new Scene using the view
    stage.setScene(scene); // Setting the stage's scene
    stage.show(); // Showing the stage
  }

  private void addDayToView(DayController d) {
    this.view.getChildren().add(d.getView());
  }

  public void addEntryTo(DayType type, JournalEntry entry) {
    this.getDay(type).addEntry(entry);
  }

  public DayController getDay(DayType type) {
    Optional<DayController> result = this.days.stream()
        .filter(d -> d.getDay().getName().equals(type)).findFirst();
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new IllegalStateException("Could not find day");
    }
  }

  public WeekView getWeekView() {
    return this.view;
  }

  public Week getWeek() {
    return this.week;
  }
}
