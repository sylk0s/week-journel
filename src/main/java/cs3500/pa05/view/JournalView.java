package cs3500.pa05.view;

import cs3500.pa05.controller.KeyPressHandler;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * The view for the main screen with the sidebar, top bar, week view
 */
public class JournalView extends BorderPane {
  private final SideBar sideBar;
  private final TopBar topBar;
  private final WeekView weekView;
  private KeyPressHandler keyPressHandler;

  /**
   * Constructs a JournalView object
   */
  public JournalView() {
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
    for (DayType dayType : DayType.values()) {
      List<JournalEntry> entries = null; //change this
      DayView dayView = WeekView.getDayFrom(dayType, entries);
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
}
