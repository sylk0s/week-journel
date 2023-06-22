package cs3500.pa05.controller;

import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.SideBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * Controls the sidebar
 */
public class SideBarController {

  /**
   * The week model
   */
  private final Week week;

  /**
   * The view for the sidebar
   */
  private final SideBar view;

  /**
   * If the sidebar is visible
   */
  private boolean visible;

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
      // Just display the task's toString() result,
      // replace this with however you want to display tasks
      CheckBox taskText = new CheckBox(task.getName());
      taskText.setSelected(task.isFinished());
      view.getTaskList().getChildren().add(taskText);
    }

    // Update stats
    double prog = (week.totalTasks() > 0
        ? ((double) week.totalFinishedTasks()) / week.totalTasks() : 0);
    view.getStats().getChildren().clear();
    Label statsLabel1 = new Label("Total Tasks: " + week.totalTasks());
    Label statsLabel2 = new Label("Total Events: " + week.getEvent().size());
    ProgressBar progress = new ProgressBar();
    progress.setProgress(prog);
    view.getStats().getChildren().add(statsLabel1);
    view.getStats().getChildren().add(statsLabel2);
    Label statsLabel3 = new Label("Percent finished: "
        + prog * 100 + "%");
    view.getStats().getChildren().add(statsLabel3);
    view.getStats().getChildren().add(progress);
  }

  /**
   * Toggle visibility of the sidebar
   */
  public void toggleVis() {
    this.view.setVisible(this.visible);
    if (this.visible) {
      this.view.setMaxWidth(150);
    } else {
      this.view.setMaxWidth(0);
    }
    this.visible = !this.visible;
  }
}