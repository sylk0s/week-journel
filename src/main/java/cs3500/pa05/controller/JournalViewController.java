package cs3500.pa05.controller;

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
   * The constructor
   *
   * @param view the journal view
   */
  public JournalViewController(JournalView view) {
    this.view = view;
  }


  /**
   * Get view from the journal
   *
   * @return the view
   */
  public JournalView getView() {
    return this.view;
  }
}