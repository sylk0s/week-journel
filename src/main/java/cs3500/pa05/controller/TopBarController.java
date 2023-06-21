package cs3500.pa05.controller;

import java.io.File;
import java.io.IOException;

import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.TopBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controls the top bar
 */
public class TopBarController {
  private Week week;
  private Bujo bujo;
  private TopBar view;
  private SideBarController side;

  public TopBarController(Week week, Bujo bujo, TopBar view, Stage stage, SideBarController side) {
    System.out.println("constructing controller...");
    this.week = week;
    this.bujo = bujo;
    this.view = view;
    this.side = side;
    this.initHandlers(stage);
  }

  public void initHandlers(Stage primaryStage) {
    System.out.println("initializing handlers...");

    this.view.registerOnSave(e -> {
      System.out.println("save click");
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Save");
      fileChooser.setInitialFileName("savefile.bujo");
      fileChooser.getExtensionFilters().addAll(
          new FileChooser.ExtensionFilter("Bujo Files", "*.bujo"),
          new FileChooser.ExtensionFilter("All Files", "*.*")
      );

      File selectedFile = fileChooser.showSaveDialog(primaryStage);
      if (selectedFile != null) {
        try {
          // Perform save operation by writing bujo data to the selected file
          BujoSerializer serializer = new BujoSerializer();
          Bujo bujo = new Bujo(this.week); // Replace with your bujo creation logic
          serializer.write(selectedFile.getAbsolutePath(), bujo);
          System.out.println("Bujo file saved: " + selectedFile.getAbsolutePath());
        } catch (IOException aaa) {
          System.out.println("Error saving bujo file: " + aaa.getMessage());
        }
      }
    });

    this.view.registerOnAdd(e -> {
      System.out.println("add button");
      this.view.showAddDropdown();
    });

    this.view.registerOnToggleBar(e -> {
      System.out.println("toggled bar");
      this.side.toggleVis();
    });

    System.out.println("all registered...");
  }
}

//    // max events and tasks handlers
//    view.getMaxEventsTextField().setOnAction(new EventHandler<ActionEvent>() {
//      @Override
//      public void handle(ActionEvent actionEvent) {
//        String maxEvents = view.getMaxEventsTextField().getText();
//        week.setEventMax(Integer.parseInt(maxEvents));
//      }
//    });
//
//    view.getMaxTasksTextField().setOnAction(new EventHandler<ActionEvent>() {
//      @Override
//      public void handle(ActionEvent actionEvent) {
//        String maxTasks = view.getMaxTasksTextField().getText();
//        week.setTaskMax(Integer.parseInt(maxTasks));
//      }
//    });