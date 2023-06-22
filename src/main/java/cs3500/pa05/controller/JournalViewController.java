package cs3500.pa05.controller;

import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.JournalView;

/**
 * Controls the journal view (which is the whole view)
 */
public class JournalViewController {
  /**
   * The journal view
   */
  private final JournalView view;
  /**
   * The week model
   */
  private final Week week;

  /**
   * The constructor
   *
   * @param view the journal view
   * @param week the week model
   */
  public JournalViewController(JournalView view, Week week) {
    this.view = view;
    this.week = week;
  }

  /**
   * Gets the view for the journel
   */
  public JournalView getView() {
    return this.view;
  }
}
