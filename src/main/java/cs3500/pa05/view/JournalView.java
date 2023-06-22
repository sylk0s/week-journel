package cs3500.pa05.view;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * The view for the main screen with the sidebar, top bar, week view
 */
public class JournalView extends BorderPane {

  /**
   * Constructs a JournalView object
   *
   * @param sideBar the sidebar view
   * @param topBar the topbar view
   * @param weekView the view for the week
   */
  public JournalView(SideBar sideBar, TopBar topBar, WeekView weekView) {
    setLeft(sideBar);
    setTop(topBar);
    setCenter(weekView);

    BackgroundFill backgroundFill =
        new BackgroundFill(
            Color.valueOf("#fffaf0"),
            new CornerRadii(0),
            new Insets(0)
        );

    Background background =
        new Background(backgroundFill);

    this.setBackground(background);
  }
}