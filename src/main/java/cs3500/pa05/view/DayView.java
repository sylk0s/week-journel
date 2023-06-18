package cs3500.pa05.view;

import cs3500.pa05.model.JournalEntry;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The view for one individual day
 */
public class DayView extends VBox {
  HBox topBox;
  Label dayName;
  VBox tasksAndEvents;

  DayView(String name, List<JournalEntry> entries) {
    this.dayName = new Label(name);

    this.topBox = new HBox();
    this.topBox.getChildren().add(this.dayName);

    // adds all the subitems
    this.tasksAndEvents = new VBox();
    for (JournalEntry entry : entries) {
      this.addEntry(entry);
    }

    this.getChildren().add(topBox);
    this.getChildren().add(tasksAndEvents);
  }

  /**
   * Creates an entry view from this entry
   *
   * @param entry the given entry
   * @return the resulting view
   */
  private JournalEntryView getEntryFrom(JournalEntry entry) {
    // todo
    throw new UnsupportedOperationException();
  }

  /**
   * Adds an entry to this list of entries
   *
   * @param entry the entry to add
   */
  public void addEntry(JournalEntry entry) {
    this.tasksAndEvents.getChildren().add(this.getEntryFrom(entry));
  }

  /**
   * Removes an entry to this list of entries
   *
   * @param entry the entry to remove
   */
  public void removeEntry(JournalEntryView entry) {
    this.tasksAndEvents.getChildren().remove(entry);
  }
}
