package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Event;
import java.time.Duration;
import java.time.LocalTime;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * A view for some event
 */
public class EventView extends JournalEntryView {
  TextField timeH;
  TextField timeM;
  TextField durH;
  TextField durM;
  Event event;

  /**
   *
   * @param name The name of this event
   * @param desc The description for this event
   * @param time the time of this event
   * @param duration the length of this event
   */
  EventView(Event event, SideBarController side) {
    super(event.getName(), event.getDescription(), side);

    HBox timeBox = new HBox();
    Label tLabel = new Label("Time:");
    Label timeHLabel = new Label("Hour:");
    Label timeMLabel = new Label("Min:");
    this.timeH = new TextField(event.getTime().getHour() + "");
    this.timeH.maxWidth(1);
    this.timeM = new TextField(event.getTime().getMinute() + "");
    this.timeM.maxWidth(1);
    timeBox.getChildren().addAll(timeHLabel, timeH, timeMLabel, timeM);
    this.getChildren().addAll(tLabel, timeBox);

    HBox durBox = new HBox();
    Label dLabel = new Label("Duration:");
    Label durHLabel = new Label("Hour:");
    Label durMLabel = new Label("Min:");
    this.durH = new TextField(event.getDuration().toHoursPart() + "");
    this.durH.maxWidth(1);
    this.durM = new TextField(event.getDuration().toMinutesPart() + "");
    this.durM.maxWidth(1);
    durBox.getChildren().addAll(durHLabel, durH, durMLabel, durM);
    this.getChildren().addAll(dLabel, durBox);

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
