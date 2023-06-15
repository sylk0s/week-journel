package cs3500.pa05.model;

import java.time.Duration;
import java.time.LocalTime;

public class Event extends AbstractEventTask {
  LocalTime time;
  Duration duration;

  public LocalTime getTime() {
    return this.time;
  }

  public Duration getDuration() {
    return this.duration;
  }

  @Override
  public boolean isFinished() {
    throw new UnsupportedOperationException();
  }
}
