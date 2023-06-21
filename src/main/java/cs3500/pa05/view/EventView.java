package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Event;
import java.text.ParseException;
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
  TextField timeH;
  TextField timeM;
  TextField durH;
  TextField durM;
  Event event;

  /**
   * @param event the event that this view is displaying
   * @param side the controller for the sidebar, which contains the task queue with this event view
   */
  EventView(Event event, SideBarController side) {
    super(event.getName(), event.getDescription(), side, event);
    this.event = event;

    HBox timeBox = new HBox();
    Label tLabel = new Label("Time:");
    Label timeHLabel = new Label("Hour:");
    Label timeMLabel = new Label("Min:");

    this.timeH = new TextField(event.getTime().getHour() + "");
    this.timeH.setPrefSize(35, 10);
    this.timeH.setOnAction(e -> updateTime());

    this.timeM = new TextField(event.getTime().getMinute() + "");
    this.timeM.setPrefSize(35, 10);
    this.timeM.setOnAction(e -> updateTime());

    timeBox.getChildren().addAll(timeHLabel, timeH, timeMLabel, timeM);
    this.getChildren().addAll(tLabel, timeBox);

    HBox durBox = new HBox();
    Label dLabel = new Label("Duration:");
    Label durHLabel = new Label("Hour:");
    Label durMLabel = new Label("Min:");

    this.durH = new TextField(event.getDuration().toHoursPart() + "");
    this.durH.setPrefSize(35, 10);
    this.durH.setOnAction(e -> updateDur());

    this.durM = new TextField(event.getDuration().toMinutesPart() + "");
    this.durM.setPrefSize(35, 10);
    this.durM.setOnAction(e -> updateDur());

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

  public void updateTime() {
    String h = this.timeH.getText();
    String m = this.timeM.getText();
    try {
      int hour = Integer.parseInt(h);
      int min = Integer.parseInt(m);
      this.event.setTime(hour, min);
    } catch (NumberFormatException err) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Not a number!");
      alert.setHeaderText(null);
      alert.setContentText("Some invalid input found in the time field");
      alert.showAndWait();
    }
  }

  public void updateDur() {
    String h = this.durH.getText();
    String m = this.durM.getText();
    try {
      int hour = Integer.parseInt(h);
      int min = Integer.parseInt(m);
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
