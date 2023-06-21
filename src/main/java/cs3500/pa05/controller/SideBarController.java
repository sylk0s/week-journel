package cs3500.pa05.controller;

import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.SideBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.stream.Collectors;

/**
 * Controls the sidebar
 */
public class SideBarController {
  private final Week week;
  private final SideBar view;

  private boolean visable;

  /**
   * Constructor for SideBarController
   *
   * @param week the week to be controlled
   * @param view the SideBar view to be managed
   */
  public SideBarController(Week week, SideBar view) {
    this.week = week;
    this.view = view;
    updateView();
  }

  /**
   * Updates the SideBar view to reflect the current state of the week.
   */
  public void updateView() {
    // Update taskList
    view.getTaskList().getChildren().clear();
    for (Task task : week.getTasks()) {
      // Just display the task's toString() result, replace this with however you want to display tasks
      CheckBox taskText = new CheckBox(task.getName());
      view.getTaskList().getChildren().add(taskText);
    }

    // Update stats
    view.getStats().getChildren().clear();
    Label statsLabel = new Label("Total Tasks: " + week.totalTasks());
    view.getStats().getChildren().add(statsLabel);
  }

  public void toggleVis() {
    System.out.println("toggled sidebar");
    this.view.setVisible(this.visable);
    if (this.visable) {
      // todo this doesnt actually work now
      this.view.setMaxWidth(0);
    } else {
      this.view.setMaxWidth(100);
    }
    this.visable = !this.visable;
  }
}
