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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Handles the tasks
 */
public class TaskView extends JournalEntryView {

  private final Task entry;
  private final DayView dayView;

  /**
   * @param entry name of tasks
   * @param side side bar stats
   * @param dayView which day does it show up in?
   */
  public TaskView(Task entry, SideBarController side, DayView dayView) {
    super(entry.getName(), entry.getDescription(), side, entry);
    this.entry = entry;
    this.dayView = dayView;

    BorderStroke borderStroke = new BorderStroke(
        Color.BLACK,
        BorderStrokeStyle.SOLID,
        new CornerRadii(5),
        new BorderWidths(2)
    );

    this.setBorder(new Border(borderStroke));

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#c7d3fc"),
            new CornerRadii(3),
            new Insets(0)
        );

    Background background = new Background(backgroundFill);
    this.setBackground(background);
    this.setSpacing(25); // added spacing between the elements
    this.setPadding(new Insets(10)); // padding for the VBox


  }

  @Override
  protected void createNameLabel(HBox box, String name) {
    CheckBox finished = new CheckBox();
    this.name = new TextField(name);

    this.name.setFont(Font.font("Arial", FontWeight.BOLD, 14));


    finished.setOnAction(e -> {
      this.entry.setFinished(!this.entry.isFinished());
      this.side.updateView();
      this.dayView.updateProgress();
    });
    finished.setSelected(this.self.isFinished());

    HBox tmp = new HBox();
    tmp.setSpacing(20); // added spacing between elements
    tmp.getChildren().addAll(finished, this.name);
    box.getChildren().add(tmp);
  }
}
