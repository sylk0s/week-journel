package cs3500.pa05.view;

import cs3500.pa05.model.Day;
import java.util.List;
import javafx.scene.layout.HBox;

/**
 * The area containing the 7 days on the journal
 */
public class WeekView extends HBox {
  List<DayView> days;
  HBox dayContainer;
}
