package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.view.DayView;

public class DayController {

  DayView view;

  public DayController(Day day) {
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
    return new DayView(name, day.getEntries());
  }

  /**
   * Adds an entry
   *
   * @param entry
   */
  public void addEntry(JournalEntry entry) {
    this.view.addEntry(entry);
  }

  public void removeEntry(JournalEntry entry) {
    this.view.removeEntry(this.view.getEntryView(entry));
  }

  public DayView getView() {
    return this.view;
  }
}
