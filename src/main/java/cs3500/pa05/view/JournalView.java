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
  //private final WeekView weekView;
  /**
   * A handler for keybinds and such
   */
  private KeyPressHandler keyPressHandler;

  /**
   * Constructs a JournalView object
   */
  public JournalView(SideBar sideBar, TopBar topBar, WeekView weekView) {
    this.sideBar = sideBar;
    this.topBar = topBar;
    //List<DayView> days = createWeekDays();

    // temporarily removed to focus on week view
    setLeft(sideBar);
    setTop(topBar);
    setCenter(weekView);

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#FAA4BD"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
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
