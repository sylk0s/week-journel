package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class TaskView extends JournalEntryView {
  /**
   * A checkbox indicating if a task is finished
   */
  CheckBox finished;
  public TaskView(String name, String desc) {
    super(name, desc);
    this.finished = new CheckBox("isFinished");
    this.getChildren().add(this.finished);

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
}
