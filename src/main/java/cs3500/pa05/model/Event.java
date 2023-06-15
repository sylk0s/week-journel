package cs3500.pa05.model;

import java.time.Duration;
import java.time.LocalTime;

public class Event extends AbstractEventTask {
  LocalTime time;
  Duration duration;

  public Event(String name, String desc, LocalTime time, Duration duration) {
    super(name, desc);
    this.time = time;
    this.duration = duration;
  }

  public LocalTime getTime() {
    return this.time;
  }

  public Duration getDuration() {
    return this.duration;
  }

  @Override
  public boolean isFinished() {
    return this.time.plus(this.duration).isAfter(LocalTime.now());
  }
}
