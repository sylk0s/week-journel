package cs3500.pa05.view;

import javafx.scene.control.CheckBox;

public class TaskView extends JournalEntryView {
  CheckBox finished;
  TaskView(String name, String desc) {
    super(name, desc);
    this.finished = new CheckBox();
    this.getChildren().add(this.finished);
  }
}
