package cs3500.pa05.controller;

import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.WeekView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javafx.stage.Stage;

/**
 * Controls the week view
 */
public class WeekViewController {

  /**
   * The model for this week
   */
  private final Week week;

  /**
   * The view for this week
   */
  private final WeekView view;

  /**
   * The day controllers in this week
   */
  private final List<DayController> days;

  /**
   * Constructor
   *
   * @param week the week model
   * @param stage the app stage
   * @param side the sidebar controller
   */
  WeekViewController(Week week, Stage stage, SideBarController side) {
    this.week = week;
    // Added the stage object to be able to display the week
    this.view = new WeekView();
    this.days = week.getDays().stream()
        .map(d -> new DayController(d, side, this)).collect(Collectors.toList());
    for (DayController d : days) {
      this.addDayToView(d);
    }
    //error
    this.setWeekStartDay(this.week.getStartDay());
  }

  private void addDayToView(DayController d) {
    this.view.getChildren().add(d.getView());
  }

  /**
   * Add an entry to a specific day
   *
   * @param type the day to add to
   * @param entry the entry to add
   */
  public void addEntryTo(DayType type, JournalEntry entry) {
    this.getDay(type).addEntry(entry);
  }

  /**
   * Get a day model
   *
   * @param type the day to get
   * @return the day model
   */
  public DayController getDay(DayType type) {
    Optional<DayController> result = this.days.stream()
        .filter(d -> d.getDay().getName().equals(type)).findFirst();
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new IllegalStateException("Could not find day");
    }
  }

  /**
   * Sets the start day for the week
   *
   * @param startDay the desired start day
   */
  public void setWeekStartDay(DayType startDay) {
    List<DayType> dayTypes = new ArrayList<>(Arrays.asList(DayType.values()));
    int startIndex = dayTypes.indexOf(startDay);
    this.week.setStartDay(startDay);
    List<DayController> reorderedDays = new ArrayList<>(days.subList(startIndex, days.size()));
    reorderedDays.addAll(days.subList(0, startIndex));

    this.view.getChildren().clear();
    for (DayController d : reorderedDays) {
      this.addDayToView(d);
    }
  }

  /**
   * Gets the week view
   *
   * @return the week view
   */
  public WeekView getWeekView() {
    return this.view;
  }

  /**
   * Gets the week model
   *
   * @return week model
   */
  public Week getWeek() {
    return this.week;
  }
}