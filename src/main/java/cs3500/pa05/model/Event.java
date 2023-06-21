package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.time.Duration;
import java.time.LocalTime;

public class Event extends JournalEntry {
  LocalTime time;
  Duration duration;

  @JsonCreator
  public Event(@JsonProperty("name") String name,
               @JsonProperty("desc") String desc,
               @JsonProperty("time") LocalTime time,
               @JsonProperty("duration") Duration duration) {
    super(name, desc);
    this.time = time;
    this.duration = duration;
  }

  @JsonGetter("time")
  public LocalTime getTime() {
    return this.time;
  }

  @JsonGetter("duration")
  public Duration getDuration() {
    return this.duration;
  }

  @Override
  public boolean isFinished() {
    return this.time.plus(this.duration).isAfter(LocalTime.now());
  }
}
