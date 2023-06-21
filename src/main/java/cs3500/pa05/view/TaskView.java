package cs3500.pa05.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class TaskView extends JournalEntryView {
  /**
   * A checkbox indicating if a task is finished
   */
  CheckBox finished;
  public TaskView(String name, String desc) {
    super(name, desc);

    BorderStroke borderStroke = new BorderStroke(
        Color.BLACK,                       // Border color
        BorderStrokeStyle.SOLID,           // Border style
        new CornerRadii(0),                 // Corner radii
        new BorderWidths(1)                 // Border widths
    );

    this.setBorder(new Border(borderStroke));

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#c7d3fc"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
  }

  public void registerOnCheck(EventHandler<ActionEvent> handler) {
    this.finished.setOnAction(handler);
  }

  @Override
  protected void createNameLabel(HBox box, String name) {
    this.finished = new CheckBox(name);
    box.getChildren().add(finished);
  }
}
