package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.Task;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
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

public class TaskView extends JournalEntryView {
  Task entry;
  /**
   * A checkbox indicating if a task is finished
   */
  CheckBox finished;
  DayView dayView;
  public TaskView(Task entry, SideBarController side, DayView dayView) {
    super(entry.getName(), entry.getDescription(), side, entry);
    this.entry = entry;
    this.dayView = dayView;

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

  @Override
  protected void createNameLabel(HBox box, String name) {
    HBox tmp = new HBox();
    this.finished = new CheckBox();
    this.name = new TextField(name);

    this.finished.setOnAction(e -> {
      System.out.println("push finished");
      this.entry.setFinished(!this.entry.isFinished());
      this.side.updateView();
      this.dayView.updateProgress();
    });
    this.finished.setSelected(this.self.isFinished());
    tmp.getChildren().addAll(finished, this.name);
    box.getChildren().add(tmp);
  }
}
