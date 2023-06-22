package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Expandable sidebar on the left of the screen
 */
public class SideBar extends VBox {

  /**
   * The list of tasks on the sidebar
   */
  private final VBox taskList;
  /**
   * The statistics for the week
   */
  private final VBox stats;

  /**
   * Constructs a SideBar object
   */
  public SideBar() {
    taskList = new VBox();
    stats = new VBox();
    // why doesnt this work pls help
    stats.setAlignment(Pos.BOTTOM_LEFT);

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(taskList, stats);

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#FAA4BD"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
  }

  /**
   * Gets the list of tasks
   *
   * @return VBox taskList
   */
  public VBox getTaskList() {
    return taskList;
  }

  /**
   * Get the statistics of the journal
   *
   * @return HBox stats
   */
  public VBox getStats() {
    return stats;
  }
}