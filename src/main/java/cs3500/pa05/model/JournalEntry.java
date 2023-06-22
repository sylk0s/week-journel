package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Represents some journal entry
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Event.class, name = "Event"),

    @JsonSubTypes.Type(value = Task.class, name = "Task") }
)
public abstract class JournalEntry {

  /**
   * The name of this entry
   */
  protected String name;

  /**
   * The description of this entry
   */
  protected String description;

  /**
   * Constructor
   *
   * @param name the name of this entry
   * @param description the desc of this entry
   */
  @JsonCreator
  public JournalEntry(@JsonProperty("name") String name,
                      @JsonProperty("desc") String description) {
    this.name = name;
    this.description = description;
  }

  /**
   * Gets the name
   *
   * @return the name
   */
  @JsonSetter("name")
  public String getName() {
    return this.name;
  }

  /**
   * gets the desc
   *
   * @return the desc
   */
  @JsonGetter("desc")
  public String getDescription() {
    return this.description;
  }

  /**
   * sets the name
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * sets the desc
   *
   * @param description the desc
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * check if this entry is finished
   *
   * @return if this entry is finished
   */
  public abstract boolean isFinished();
}