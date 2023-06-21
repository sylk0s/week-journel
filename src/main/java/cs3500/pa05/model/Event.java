package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.LocalTime;

public class Event extends JournalEntry {
  private LocalTime time;
  private Duration duration;

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

  public void setTime(int hour, int min) {
    this.time = LocalTime.MIDNIGHT.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(min));
  }

  public void setDur(int hour, int min) {
    this.duration = Duration.ofHours(hour).plus(Duration.ofMinutes(min));
  }

  @JsonIgnore
  @Override
  public boolean isFinished() {
    return this.time.plus(this.duration).isAfter(LocalTime.now());
  }
}
