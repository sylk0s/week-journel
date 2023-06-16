package cs3500.pa05.model;

/**
 * Represents a task
 */
public class Task extends JournalEntry {
  boolean completed;

  public Task(String name, String desc, boolean completed) {
    super(name, desc);
    this.completed = completed;
  }

  @Override
  public boolean isFinished() {
    return this.completed;
  }

  public void setFinished() {
    this.completed = true;
  }
}
