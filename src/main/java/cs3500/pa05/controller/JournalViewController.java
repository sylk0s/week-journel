package cs3500.pa05.controller;

import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.view.JournalView;
import java.util.List;

/**
 * Controls the journal view (which is the whole view)
 */
public class JournalViewController {
  private JournalView view;
  private List<JournalEntry> entries;

  /*public JournalViewController(JournalView view, List<JournalEntry> entries) {
    this.view = view;
    this.entries = entries;
  }

  /**
   * Creates a new journal entry.
   *
   * @param entry The journal entry to add.
   */

  public void createEntry(JournalEntry entry) {
    // implement the creation of a new journal entry here
  }

  /**
   * Edits an existing journal entry.
   *
   * @param index The index of the journal entry to edit.
   * @param entry The updated journal entry.
   */
  public void editEntry(int index, JournalEntry entry) {
    // implement the editing of an existing journal entry here
  }

  /**
   * Deletes a journal entry.
   *
   * @param index The index of the journal entry to delete.
   */
  public void deleteEntry(int index) {
    // implement the deletion of a journal entry here
  }

  /**
   * Displays all journal entries.
   */
  public void displayEntries() {
    // implement the display of all journal entries here
  }
}
