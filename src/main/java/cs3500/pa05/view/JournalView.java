package cs3500.pa05.view;

import cs3500.pa05.controller.KeyPressHandler;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;

/**
 * The view for the main screen with the sidebar, top bar, week view
 */
public class JournalView extends BorderPane {
  private final SideBar sideBar;
  private final TopBar topBar;
  private final WeekView weekView;
  private KeyPressHandler keyPressHandler;

  private Week week;


  /**
   * Constructs a JournalView object
   */
  public JournalView(Week week) { // week object passed in constructor
    this.week = week;
    sideBar = new SideBar();
    topBar = new TopBar();
    List<DayView> days = createWeekDays();
    weekView = new WeekView(days);

    setLeft(sideBar);
    setTop(topBar);
    setCenter(weekView);
  }

  private List<DayView> createWeekDays() {
    List<DayView> days = new ArrayList<>();
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
   * @return
   */
  // TODO: This is super complicated. Confused abotu how we're not extending the
  //  JournalEntryView class?
  public List<JournalEntry> displayEntries() {
    List<JournalEntry> entries = week.getEntries();
    return entries;
  }
}
