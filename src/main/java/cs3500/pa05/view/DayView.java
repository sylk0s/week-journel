package cs3500.pa05.view;

import cs3500.pa05.model.JournalEntry;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The view for one individual day
 */
public class DayView extends VBox {
  private final HBox topBox;
  private final Label dayName;
  private final VBox tasksAndEvents;

  /**
   * Contructs a DayView object
   *
   * @param name of the day
   * @param entries - list of all entries
   */
  public DayView(String name, List<JournalEntry> entries) {
    this.dayName = new Label(name);

    this.topBox = new HBox();
    this.topBox.getChildren().add(this.dayName);

    this.tasksAndEvents = new VBox();
    for (JournalEntry entry : entries) {
      this.addEntry(entry);
    }

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(topBox, tasksAndEvents);
  }

  private JournalEntryView getEntryViewFrom(JournalEntry entry) {
    return new ConcreteJournalEntryView(entry);
  }

  /**
   * Adds an entry
   *
   * @param entry a JournalEntry
   */
  public void addEntry(JournalEntry entry) {
    JournalEntryView entryView = getEntryViewFrom(entry);
    tasksAndEvents.getChildren().add(entryView);
    entryView.setOnDeleteListener(() -> removeEntry(entryView));
  }

  /**
   * Removes a specific entry
   *
   * @param entry a JournalEntry
   */
  public void removeEntry(JournalEntryView entry) {
    tasksAndEvents.getChildren().remove(entry);
  }

  private static class ConcreteJournalEntryView extends JournalEntryView {
    public ConcreteJournalEntryView(JournalEntry entry) {
      super(entry.getName(), entry.getDescription());
    }
  }
}