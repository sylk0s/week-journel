package cs3500.pa05.view;

import cs3500.pa05.controller.KeyPressHandler;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * The view for the main screen with the sidebar, top bar, week view
 */
public class JournalView extends BorderPane {
  /**
   * The sidebar object for the view
   */
  private final SideBar sideBar;
  /**
   * The top bar in the view
   */
  private final TopBar topBar;
  /**
   * The week view which contains all of the days
   */
  private final WeekView weekView;
  /**
   * A handler for keybinds and such
   */
  private KeyPressHandler keyPressHandler;

  /**
   * the week
   * TODO remove this because the view shouldn't have direct access to this data
   */
  private Week week;


  /**
   * Constructs a JournalView object
   *
   * @param week the week that this view should be created from
   */
  public JournalView(Week week) { // week object passed in constructor
    this.week = week;
    sideBar = new SideBar();
    topBar = new TopBar();
    List<DayView> days = createWeekDays();
    weekView = new WeekView(days);

    // temporarily removed to focus on week view
    setLeft(sideBar);
    setTop(topBar);
    setCenter(weekView);

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#ffff00"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
  }

  /**
   * Creates the day views from the things in the week
   *
   * @return a list of the views for the days
   */
  private List<DayView> createWeekDays() {
    List<DayView> days = new ArrayList<>();
    week.getDays().get(0).add(new Task("EX: Task", "desc", false));
    week.getDays().get(1).add(new Event("EX: Event", "desc 2", LocalTime.NOON, Duration.ofHours(2)));
    // create and add DayView objects for each day of the week
    for(Day d: week.getDays()){
      // get Day object using getDay method of Week
      List<JournalEntry> entries = d.getEntries();
      DayView dayView = WeekView.getDayFrom(d.getName(), entries);
      days.add(dayView);
    }
    return days;
  }

  /**
   * Gets the sidebar
   *
   * @return sideBar
   */
  public SideBar getSideBar() {
    return sideBar;
  }

  /**
   * Gets the top bar
   *
   * @return topBar
   */
  public TopBar getTopBar() {
    return topBar;
  }

  /**
   * Gets the week view
   *
   * @return weekView
   */
  public WeekView getWeekView() {
    return weekView;
  }

  /**
   * Gets the key press handler
   *
   * @return keyPressHnadler
   */
  public KeyPressHandler getKeyPressHandler() {
    return keyPressHandler;
  }

  /**
   * Sets the key press handler
   *
   * @param keyPressHandler - handles keybind
   */
  public void setKeyPressHandler(KeyPressHandler keyPressHandler) {
    this.keyPressHandler = keyPressHandler;
  }


  /**
   * returns the given list of journal entries.
   *
   * @return the list of journal entries in this week
   */
  // TODO: This is super complicated. Confused about how we're not extending the
  //  JournalEntryView class?
  public List<JournalEntry> displayEntries() {
    List<JournalEntry> entries = week.getEntries();
    return entries;
  }
}
