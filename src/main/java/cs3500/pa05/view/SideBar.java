package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    taskList.setPadding(new Insets(15, 15, 15, 15));
    taskList.setSpacing(10);

    stats.setPadding(new Insets(15, 15, 15, 15));
    stats.setSpacing(10);

    // Setting font to bold for the stats VBox
    stats.setStyle("-fx-font-weight: bold;");

    taskList.setAlignment(Pos.TOP_LEFT);
    stats.setAlignment(Pos.TOP_LEFT);

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(taskList, stats);

    // Updated color to a shade of blue
    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#fffaf0"), // updated color to baby blue
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);


    this.setBackground(background);
    this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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
