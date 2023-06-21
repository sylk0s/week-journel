package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Event.class, name = "Event"),

    @JsonSubTypes.Type(value = Task.class, name = "Task") }
)
public abstract class JournalEntry {
  protected String name;
  protected String description;

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

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public abstract boolean isFinished();
}
