package cs3500.pa05.view;

import cs3500.pa05.model.Day;
import java.util.List;
import javafx.scene.layout.HBox;

/**
 * The area containing the 7 days on the journal
 */
public class WeekView extends HBox {
  /**
   * The days in this week
   */
  List<DayView> days;

  public WeekView(List<DayView> days) {
    this.days = days;
    for (DayView day : days) {
      this.getChildren().add(day);
    }
  }

  public static DayView getDayFrom(Day day) {
    throw new UnsupportedOperationException();
  }
}
