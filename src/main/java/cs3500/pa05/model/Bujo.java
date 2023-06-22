package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents a state of a "week" in the journal
 */
public class Bujo {
  /**
   * the week in this bujo
   */
  private final Week week;

  /**
   * Constructor
   *
   * @param week the week model
   */
  @JsonCreator
  public Bujo(@JsonProperty("week") Week week) {
    this.week = week;
  }

  /**
   *
   * @return The current state of the week
   */
  @JsonGetter("week")
  public Week getWeek() {
    return this.week;
  }
}