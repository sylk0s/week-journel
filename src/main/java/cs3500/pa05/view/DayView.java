package cs3500.pa05.view;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * The view for one individual day
 */
public class DayView extends VBox {
  /**
   * Box for the top which contains the label and some buttons
   */
  private final HBox topBox;
  /**
   * The name of this day
   */
  private final Label dayName;
  /**
   * The tasks and events under this day
   */
  private final VBox tasksAndEvents;

  private final Map<JournalEntry, JournalEntryView> entryMap = new HashMap<>();

  /**
   * Contructs a DayView object
   *
   * @param name of the day
   * @param entries - list of all entries
   */
  public DayView(String name, List<JournalEntry> entries) {
    BackgroundFill backgroundFill =
        new BackgroundFill(
                Color.valueOf("#f5fffa"),
                new CornerRadii(0),
                new Insets(0)
                );

    Background background =
            new Background(backgroundFill);

    this.setBackground(background);
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

  /**
   * Gets the view for a journal entry
   *
   * @param entry the entry to get a view for
   * @return the view for the entry
   */
  private JournalEntryView getEntryViewFrom(JournalEntry entry) {
    if (entry instanceof Task) {
      return new TaskView(entry.getName(), entry.getDescription());
    } else if (entry instanceof Event) {
      return new EventView(entry.getName(), entry.getDescription(),
          ((Event) entry).getTime(), ((Event) entry).getDuration());
    }
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
    this.entryMap.put(entry, entryView);
  }

  /**
   * Removes a specific entry
   *
   * @param entry a JournalEntry
   */
  public void removeEntry(JournalEntryView entry) {
    tasksAndEvents.getChildren().remove(entry);
  }

  public JournalEntryView getEntryView(JournalEntry entry) {
    return this.entryMap.get(entry);
  }

  private static class ConcreteJournalEntryView extends JournalEntryView {
    public ConcreteJournalEntryView(JournalEntry entry) {
      super(entry.getName(), entry.getDescription());
    }
  }
}