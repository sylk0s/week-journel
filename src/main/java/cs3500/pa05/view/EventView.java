package cs3500.pa05.view;

import java.time.Duration;
import java.time.LocalTime;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * A view for some event
 */
public class EventView extends JournalEntryView {
  /**
   * The starting time of this event
   */
  Label time;
  /**
   * The length of this event
   */
  Label length;

  /**
   *
   * @param name The name of this event
   * @param desc The description for this event
   * @param time the time of this event
   * @param duration the length of this event
   */
  EventView(String name, String desc, LocalTime time, Duration duration) {
    super(name, desc);
    System.out.println("new event");
    this.time = new Label(time.toString());
    this.length = new Label("   " + duration.toString());

    HBox timeBox = new HBox();
    timeBox.getChildren().add(this.time);
    timeBox.getChildren().add(this.length);
    this.getChildren().add(timeBox);

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#ff0000"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
  }
}
