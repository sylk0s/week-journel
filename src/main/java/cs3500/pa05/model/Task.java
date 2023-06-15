package cs3500.pa05.model;

public class Task extends AbstractEventTask {
  boolean completed;

  @Override
  public boolean isFinished() {
    return this.completed;
  }

  public void setFinished() {
    this.completed = true;
  }
}
