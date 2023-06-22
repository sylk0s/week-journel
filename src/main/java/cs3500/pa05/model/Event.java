package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Represents an event model
 */
public class Event extends JournalEntry {

  /**
   * The time of the event
   */
  private LocalTime time;

  /**
   * The length of the event
   */
  private Duration duration;

  /**
   * constructor
   *
   * @param name the name of the event
   * @param desc the description for the event
   * @param time the time of the event
   * @param duration the length of the event
   */
  @JsonCreator
  public Event(@JsonProperty("name") String name,
               @JsonProperty("desc") String desc,
               @JsonProperty("time") LocalTime time,
               @JsonProperty("duration") Duration duration) {
    super(name, desc);
    this.time = time;
    this.duration = duration;
  }

  /**
   * gets the time of the event
   *
   * @return the time of the event
   */
  @JsonGetter("time")
  public LocalTime getTime() {
    return this.time;
  }

  /**
   * gets the length of the event
   *
   * @return the length of the event
   */
  @JsonGetter("duration")
  public Duration getDuration() {
    return this.duration;
  }

  /**
   * sets the time of the event
   *
   * @param hour the hour part of the time
   * @param min the minute part of the time
   */
  public void setTime(int hour, int min) {
    this.time = LocalTime.MIDNIGHT.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(min));
  }

  /**
   * sets the length of the event
   *
   * @param hour the hour part of the length
   * @param min the min part of the length
   */
  public void setDur(int hour, int min) {
    this.duration = Duration.ofHours(hour).plus(Duration.ofMinutes(min));
  }

  /**
   * If this event over?
   *
   * @return if the event if over
   */
  @JsonIgnore
  @Override
  public boolean isFinished() {
    return this.time.plus(this.duration).isAfter(LocalTime.now());
  }
}