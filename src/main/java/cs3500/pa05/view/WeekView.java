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

  /**
   * Constructs a week view with the following days
   *
   * @param days the day views in this week view
   */
  public WeekView(List<DayView> days) {
    this.days = days;
    for (DayView day : days) {
      this.getChildren().add(day);
    }
  }

  /**
   * Creates a view representation of the model's day
   *
   * @param day the day to create a view for
   * @return the view
   */
  public static DayView getDayFrom(Day day) {
    throw new UnsupportedOperationException();
  }
}
