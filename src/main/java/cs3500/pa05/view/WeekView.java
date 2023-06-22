package cs3500.pa05.view;

import cs3500.pa05.controller.DayController;
import java.util.List;
import javafx.scene.layout.HBox;

/**
 * The area containing the 7 days on the journal
 */
public class WeekView extends HBox {
  /**
   * The days in this week
   */
  private List<DayController> days;

  /**
   * Constructs a week view with the following days
   */
  public WeekView() {

  }
}
