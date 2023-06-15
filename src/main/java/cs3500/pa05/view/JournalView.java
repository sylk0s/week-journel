package cs3500.pa05.view;

import cs3500.pa05.controller.KeyPressHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * The view for the main screen with the sidebar, top bar, week view
 */
public class JournalView extends BorderPane {
  Pane sideBar;
  Pane topBar;
  Pane weekView;
  KeyPressHandler keyPressHandler;
}
