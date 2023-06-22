package cs3500.pa05.view;

import cs3500.pa05.controller.DayController;
import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * The view for one individual day
 */
public class DayView extends VBox {
  /**
   * The tasks and events under this day
   */
  private final VBox tasksAndEvents;

  /**
   * the controller for the sidebar
   */
  private final SideBarController controller;

  /**
   * the controller for this
   */
  private final DayController parent;

  /**
   * the progress bar for this day
   */
  private final ProgressBar prog;

  /**
   * Maps all entries to their view
   */
  private final Map<JournalEntry, JournalEntryView> entryMap = new HashMap<>();

  /**
   * Costructs a DayView object
   *
   * @param name of the day
   * @param entries - list of all entries
   * @param controller the sidebar controller
   * @param parent the controller for this
   */
  public DayView(String name, List<JournalEntry> entries,
                 SideBarController controller, DayController parent) {
    this.parent = parent;
    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#f0f8ff"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.controller = controller;

    this.setBackground(background);
    // The border for the scene
    this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    Label dayName = new Label(name);

    HBox topBox = new HBox();
    topBox.getChildren().add(dayName);

    // Add a line (Separator) under each day
    Separator separator = new Separator();


    this.tasksAndEvents = new VBox();

    this.prog = new ProgressBar();
    for (JournalEntry entry : entries) {
      this.addEntry(entry);
    }
    this.updateProgress();

    this.setSpacing(10);
    this.setPadding(new Insets(10));
    this.getChildren().addAll(topBox, separator, tasksAndEvents, this.prog);
  }

  /**
   * Updates the progress bar
   */
  public void updateProgress() {
    int total = this.parent.getDay().numTasks();
    this.prog.setProgress(
        total > 0 ? this.parent.getDay().numFinishedTasks() / (float) total
            : 0
    );
  }

  /**
   * Gets the view for a journal entry
   *
   * @param entry the entry to get a view for
   * @return the view for the entry
   */
  private JournalEntryView getEntryViewFrom(JournalEntry entry) {
    if (entry instanceof Task) {
      return new TaskView((Task) entry, this.controller, this);
    } else if (entry instanceof Event) {
      return new EventView((Event) entry, this.controller);
    }
    throw new IllegalStateException("invalid journal entry type");
  }

  /**
   * Adds an entry
   *
   * @param entry a JournalEntry
   */
  public void addEntry(JournalEntry entry) {
    JournalEntryView entryView = getEntryViewFrom(entry);
    tasksAndEvents.getChildren().add(entryView);
    entryView.setOnDeleteListener(() -> this.parent.removeEntry(entry));
    this.entryMap.put(entry, entryView);
    this.updateProgress();
  }

  /**
   * Removes a specific entry
   *
   * @param entry a JournalEntry
   */
  public void removeEntry(JournalEntry entry) {
    tasksAndEvents.getChildren().remove(this.entryMap.get(entry));
    this.updateProgress();
  }

  /**
   * Displays a warning for counts over the max
   *
   * @param type the type of thing over the max
   */
  public void dispOverError(String type) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Over " + type + " maximum value!");
    alert.setHeaderText(null);
    alert.setContentText(type + " will be added, to make this error go away next time,"
        + " set a higher " + type + " max or remove " + type);
    alert.showAndWait();
  }
}