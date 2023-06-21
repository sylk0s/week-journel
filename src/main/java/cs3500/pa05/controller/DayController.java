package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Task;
import cs3500.pa05.view.DayView;

public class DayController {

  DayView view;
  Day day;
  SideBarController side;
  WeekViewController week;

  public DayController(Day day, SideBarController side, WeekViewController week) {
    this.day = day;
    this.side = side;
    this.week = week;
    this.view = this.fromModel(day);
  }

  /**
   * Creates a view from the model
   *
   * @param day
   * @return
   */
  private DayView fromModel(Day day) {
    String name = day.getName().name();
    return new DayView(name, day.getEntries(), this.side, this);
  }

  /**
   * Adds an entry
   *
   * @param entry
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

  public void removeEntry(JournalEntry entry) {
    this.view.removeEntry(entry);
    this.day.remove(entry);
    this.side.updateView();
  }

  public DayView getView() {
    return this.view;
  }
  public Day getDay() {
    return this.day;
  }

  // todo marks task as finished, does any other stuff as needed?
  public void toggleTaskFinish(Task task) {

  }
}
