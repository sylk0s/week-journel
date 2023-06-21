package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import java.time.Duration;
import java.time.LocalTime;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
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
  EventView(String name, String desc, LocalTime time, Duration duration, SideBarController side) {
    super(name, desc, side);
    this.time = new Label(time.toString());
    this.length = new Label("   " + duration.toString());

    HBox timeBox = new HBox();
    timeBox.getChildren().add(this.time);
    timeBox.getChildren().add(this.length);
    this.getChildren().add(timeBox);

    BorderStroke borderStroke = new BorderStroke(
        Color.BLACK,                       // Border color
        BorderStrokeStyle.SOLID,           // Border style
        new CornerRadii(0),                 // Corner radii
        new BorderWidths(1)                 // Border widths
    );

    this.setBorder(new Border(borderStroke));

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#D9F0FF"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
  }
}
