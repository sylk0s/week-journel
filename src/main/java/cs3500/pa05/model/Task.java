package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task
 */
public class Task extends JournalEntry {

  /**
   * if this task has been completed
   */
  private boolean completed;

  /**
   * constructor
   *
   * @param name the name of this task
   * @param desc the desc of this task
   * @param completed if this task has been completed
   */
  @JsonCreator
  public Task(@JsonProperty("name") String name,
              @JsonProperty("desc") String desc,
              @JsonProperty("isFinished") boolean completed) {
    super(name, desc);
    this.completed = completed;
  }

  /**
   * If this task is finished
   *
   * @return if this task is finished
   */
  @JsonGetter("isFinished")
  @Override
  public boolean isFinished() {
    return this.completed;
  }

  /**
   * Sets the state of this task to finished
   *
   * @param finished if the task is finished
   */
  public void setFinished(boolean finished) {
    this.completed = finished;
  }
}