package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Task;
import cs3500.pa05.view.DayView;

/**
 * A controller for the day object and view
 */
public class DayController {

  /**
   * This day's view
   */
  private final DayView view;

  /**
   * The day;s model
   */
  private final Day day;

  /**
   * The controller for the sidebar
   */
  private final SideBarController side;

  /**
   * The controller for the week view
   */
  private final WeekViewController week;

  /**
   * consturctor
   *
   * @param day the day model
   * @param side the sidebar controller
   * @param week the week controller
   */
  public DayController(Day day, SideBarController side, WeekViewController week) {
    this.day = day;
    this.side = side;
    this.week = week;
    this.view = this.fromModel(day);
  }

  /**
   * Creates a view from the model
   *
   * @param day the day to turn into a model
   * @return the dayView associated with the model
   */
  private DayView fromModel(Day day) {
    String name = day.getName().name();
    return new DayView(name, day.getItems(), this.side, this);
  }

  /**
   * Adds an entry
   *
   * @param entry the journal entry to add
   */
  public void addEntry(JournalEntry entry) {
    if (entry instanceof Task
        && this.day.numTasks() >= this.week.getWeek().getTaskMax()) {
      this.view.dispOverError("task");
    }
    if (entry instanceof Event
        && this.day.numEvents() >= this.week.getWeek().getEventMax()) {
      this.view.dispOverError("event");
    }
    this.view.addEntry(entry);
    this.day.add(entry);
    this.side.updateView();
  }

  /**
   * Remove a specific entry
   *
   * @param entry the entry to remove
   */
  public void removeEntry(JournalEntry entry) {
    this.view.removeEntry(entry);
    this.day.remove(entry);
    this.side.updateView();
  }

  /**
   * Gets the view object
   *
   * @return the view object
   */
  public DayView getView() {
    return this.view;
  }

  /**
   * Get the day model
   *
   * @return the day model
   */
  public Day getDay() {
    return this.day;
  }

}