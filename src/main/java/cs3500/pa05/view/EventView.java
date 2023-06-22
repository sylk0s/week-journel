package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Event;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
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

/**
 * A view for some event
 */
public class EventView extends JournalEntryView {
  /**
   * Field for time hours
   */
  private final TextField timeH;

  /**
   * Field for time min
   */
  private final TextField timeM;

  /**
   * Field for duration hours
   */
  private final TextField durH;

  /**
   * Field for duration minutes
   */
  private final TextField durM;

  /**
   * The event for this view
   */
  private final Event event;

  /**
   * @param event the event that this view is displaying
   * @param side the controller for the sidebar, which contains the task queue with this event view
   */
  EventView(Event event, SideBarController side) {
    super(event.getName(), event.getDescription(), side, event);
    this.event = event;

    this.timeH = new TextField(event.getTime().getHour() + "");
    this.timeH.setPrefSize(35, 10);
    this.timeH.setOnKeyTyped(e -> updateTime());

    this.timeM = new TextField(event.getTime().getMinute() + "");
    this.timeM.setPrefSize(35, 10);
    this.timeM.setOnKeyTyped(e -> updateTime());

    Label timeLabel = new Label("Time:");
    Label timeHlabel = new Label("Hour:");
    Label timeMlabel = new Label("Min:");
    HBox timeBox = new HBox();
    timeBox.getChildren().addAll(timeHlabel, timeH, timeMlabel, timeM);
    this.getChildren().addAll(timeLabel, timeBox);

    this.durH = new TextField(event.getDuration().toHoursPart() + "");
    this.durH.setPrefSize(35, 10);
    this.durH.setOnKeyTyped(e -> updateDur());

    this.durM = new TextField(event.getDuration().toMinutesPart() + "");
    this.durM.setPrefSize(35, 10);
    this.durM.setOnKeyTyped(e -> updateDur());

    Label durLabel = new Label("Duration:");
    Label durHlabel = new Label("Hour:");
    Label durMlabel = new Label("Min:");
    HBox durBox = new HBox();
    durBox.getChildren().addAll(durHlabel, durH, durMlabel, durM);
    this.getChildren().addAll(durLabel, durBox);

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

  /**
   * Update the time
   */
  public void updateTime() {
    String h = this.timeH.getText();
    String m = this.timeM.getText();
    try {
      int hour;
      int min;

      if (h.equals("")) {
        hour = 0;
      } else {
        hour = Integer.parseInt(h);
      }

      if (m.equals("")) {
        min = 0;
      } else {
        min = Integer.parseInt(m);
      }
      this.event.setTime(hour, min);
    } catch (NumberFormatException err) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Not a number!");
      alert.setHeaderText(null);
      alert.setContentText("Some invalid input found in the time field");
      alert.showAndWait();
    }
  }

  /**
   * Update the length
   */
  public void updateDur() {
    String h = this.durH.getText();
    String m = this.durM.getText();
    try {
      int hour;
      int min;

      if (h.equals("")) {
        hour = 0;
      } else {
        hour = Integer.parseInt(h);
      }

      if (m.equals("")) {
        min = 0;
      } else {
        min = Integer.parseInt(m);
      }
      this.event.setDur(hour, min);
    } catch (NumberFormatException err) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Not a number!");
      alert.setHeaderText(null);
      alert.setContentText("Some invalid input found in the duration field");
      alert.showAndWait();
    }
  }
}
