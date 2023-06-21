package cs3500.pa05.view;

import cs3500.pa05.controller.DayController;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.layout.HBox;

/**
 * The area containing the 7 days on the journal
 */
public class WeekView extends HBox {
  /**
   * The days in this week
   */
  List<DayController> days;

  /**
   * Constructs a week view with the following days
   */
  public WeekView() {

  }
}
