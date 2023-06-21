package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task
 */
public class Task extends JournalEntry {
  boolean completed;

  @JsonCreator
  public Task(@JsonProperty("name") String name,
              @JsonProperty("desc") String desc,
              @JsonProperty("isFinished") boolean completed) {
    super(name, desc);
    this.completed = completed;
  }

  @JsonGetter("isFinished")
  @Override
  public boolean isFinished() {
    return this.completed;
  }

  public void setFinished(boolean finished) {
    this.completed = finished;
  }
}
