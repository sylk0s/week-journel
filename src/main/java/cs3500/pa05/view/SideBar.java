package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Expandable sidebar on the left of the screen
 */
public class SideBar extends VBox {
  private final VBox taskList;
  private final HBox stats;

  /**
   * Constructs a SideBar object
   */
  public SideBar() {
    taskList = new VBox();
    stats = new HBox();

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(taskList, stats);
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
  public HBox getStats() {
    return stats;
  }
}