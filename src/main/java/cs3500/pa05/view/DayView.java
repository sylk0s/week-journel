package cs3500.pa05.view;

import static cs3500.pa05.view.WeekView.getDayFrom;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Task;
import java.util.ArrayList;
import java.util.List;
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
    BackgroundFill backgroundFill =
        new BackgroundFill(
                Color.valueOf("#ff00ff"),
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