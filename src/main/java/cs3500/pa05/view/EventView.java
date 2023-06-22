package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Event;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * A view for some event
 */
public class EventView extends JournalEntryView {
  /**
   * Spinner for time hours
   */
  private final Spinner<Integer> timeH;

  /**
   * Spinner for time min
   */
  private final Spinner<Integer> timeM;

  /**
   * Spinner for duration hours
   */
  private final Spinner<Integer> durH;

  /**
   * Spinner for duration minutes
   */
  private final Spinner<Integer> durM;

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


    Label timeLabel = new Label("Time:");
    Label timeHlabel = new Label("Hour:");
    Label timeMlabel = new Label("Min:");
    this.timeH = createSpinner(0, 23, event.getTime().getHour());
    this.timeH.valueProperty().addListener((obs, oldValue, newValue) -> updateTime());
    this.timeM = createSpinner(0, 59, event.getTime().getMinute());
    this.timeM.valueProperty().addListener((obs, oldValue, newValue) -> updateTime());

    VBox timeBox = new VBox();
    timeBox.getChildren().addAll(timeLabel, timeHlabel, timeH, timeMlabel, timeM);
    this.getChildren().add(timeBox);

// Duration
    Label durLabel = new Label("Duration:");
    Label durHlabel = new Label("Hour:");
    Label durMlabel = new Label("Min:");
    this.durH = createSpinner(0, 23, (int) event.getDuration().toHoursPart());
    this.durH.valueProperty().addListener((obs, oldValue, newValue) -> updateDur());
    this.durM = createSpinner(0, 59, event.getDuration().toMinutesPart());
    this.durM.valueProperty().addListener((obs, oldValue, newValue) -> updateDur());

    VBox durBox = new VBox();
    durBox.getChildren().addAll(durLabel, durHlabel, durH, durMlabel, durM);
    this.getChildren().add(durBox);

    BorderStroke borderStroke = new BorderStroke(
        Color.BLACK,                       // Border color
        BorderStrokeStyle.SOLID,           // Border style
        new CornerRadii(3),
        new BorderWidths(2)              // Border widths
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

  private Spinner<Integer> createSpinner(int min, int max, int initialValue) {
    Spinner<Integer> spinner = new Spinner<>();
    spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initialValue));
    return spinner;
  }

  /**
   * Update the time
   */
  public void updateTime() {
    int hour = this.timeH.getValue();
    int min = this.timeM.getValue();
    this.event.setTime(hour, min);
  }

  /**
   * Update the length
   */
  public void updateDur() {
    int hour = this.durH.getValue();
    int min = this.durM.getValue();
    this.event.setDur(hour, min);
  }
}
