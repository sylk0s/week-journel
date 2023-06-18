package cs3500.pa05.view;

import java.time.Duration;
import java.time.LocalTime;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EventView extends JournalEntryView {
  Label time;
  Label length;
  EventView(String name, String desc, LocalTime time, Duration duration) {
    super(name, desc);
    this.time = new Label(time.toString());
    this.length = new Label(duration.toString());

    HBox timeBox = new HBox();
    timeBox.getChildren().add(this.time);
    timeBox.getChildren().add(this.length);
    this.getChildren().add(timeBox);
  }
}
