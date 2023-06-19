package cs3500.pa05.view;

import cs3500.pa05.view.DayView;
import cs3500.pa05.view.SideBar;
import cs3500.pa05.view.TaskView;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Creating a sudo GUI class to run GUI independent of controller
 * just for Alpha release since the GUI with controller keeps throwing errors.
 */
public class JournalGUI extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Journal Application");

    // Create a GridPane to hold the weeks and days
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(10));

    // Add the weeks and days to the GridPane
    addWeeksAndDays(gridPane);

    // Create a Sidebar and add it to the VBox
    SideBar sideBar = new SideBar();

// Create a TaskView for finished tasks and add it to the Sidebar
    TaskView finishedTasks = new TaskView("Finished Tasks", "");
    finishedTasks.setMinHeight(50); // Set the desired height for the TaskView
    finishedTasks.setMaxHeight(50);
    sideBar.getTaskList().getChildren().add(finishedTasks);

// Create a TaskView for remaining tasks and add it to the Sidebar
    TaskView remainingTasks = new TaskView("Remaining Tasks", "");
    remainingTasks.setMinHeight(50); // Set the desired height for the TaskView
    remainingTasks.setMaxHeight(50);
    sideBar.getTaskList().getChildren().add(remainingTasks);

// Create a StackPane to hold the GridPane and Sidebar
    StackPane stackPane = new StackPane(gridPane, sideBar);
    stackPane.setAlignment(Pos.BOTTOM_LEFT);

// Create a VBox to hold the StackPane
    VBox vbox = new VBox(gridPane);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(10);
    vbox.setBackground(new Background(new BackgroundFill(Color.WHITE,
        CornerRadii.EMPTY, Insets.EMPTY)));
    // Create a Scene with the VBox
    Scene scene = new Scene(vbox, 800, 600);

    // Set the background color of the week and day boxes
    scene.setFill(Color.LIGHTBLUE);

    // Set the Scene to the primary stage
    primaryStage.setScene(scene);

    // Show the primary stage
    primaryStage.show();
  }

  private void addWeeksAndDays(GridPane gridPane) {
    // Create labels for the weeks and days
    for (int i = 1; i <= 1; i++) {

      Label weekLabel = new Label("Week " + i);
      Rectangle weekBox = new Rectangle(800, 60);
      weekBox.setFill(Color.LIGHTGREEN);


      VBox weekContainer = new VBox(weekLabel, weekBox);
      weekContainer.setAlignment(Pos.CENTER);

      gridPane.add(weekContainer, i - 1, 0);

      GridPane daysGridPane = new GridPane();
      daysGridPane.setAlignment(Pos.TOP_CENTER);
      daysGridPane.setHgap(10);

      for (int j = 1; j <= 7; j++) {
        Rectangle dayBox = new Rectangle(100, 400);
        Label dayLabel = new Label("Day " + j);
        dayBox.setFill(Color.LIGHTBLUE);


        VBox dayContainer = new VBox(dayLabel, dayBox);
        dayContainer.setAlignment(Pos.CENTER);

        daysGridPane.add(dayContainer, j, 0);
      }

      gridPane.add(daysGridPane, i - 1, 1);
    }
  }

}
