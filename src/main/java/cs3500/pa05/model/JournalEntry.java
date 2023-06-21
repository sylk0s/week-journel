package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class JournalEntry {
  String name;
  String description;

  @JsonCreator
  public JournalEntry(@JsonProperty("name") String name,
                      @JsonProperty("desc") String description) {
    this.name = name;
    this.description = description;
  }

  @JsonSetter("name")
  public String getName() {
    return this.name;
  }

  @JsonGetter("desc")
  public String getDescription() {
    return this.description;
  }

  public abstract boolean isFinished();
}
