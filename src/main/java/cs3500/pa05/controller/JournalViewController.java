package cs3500.pa05.controller;

import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.JournalView;
import java.util.List;

/**
 * Controls the journal view (which is the whole view)
 */
public class JournalViewController {
  private JournalView view;
  private Week week;

  public JournalViewController(JournalView view, Week week) {
    this.view = view;
    this.week = week;
  }

  /**
   * Creates a new journal entry.
   *
   * @param entry The journal entry to add.
   */
  public void createEntry(JournalEntry entry, DayType day) {
    // Assuming a method in Week to add an entry
    this.week.addEntry(entry, day);
  }

  /**
   * Edits an existing journal entry.
   *
   * @param index The index of the journal entry to edit.
   * @param entry The updated journal entry.
   */
  public void editEntry(int index, JournalEntry entry) {
   // TODO:  implement this
  }

  /**
   * Deletes a journal entry.
   *
   * @param index The index of the journal entry to delete.
   */
  public void deleteEntry(int index) {
   // TODO: implement this
  }

  /**
   * Displays all journal entries.
   */
  public void displayEntries() {
    this.view.displayEntries();
  }

  public void run() {
    // Call methods in here based on your app's logic.
  }
}
