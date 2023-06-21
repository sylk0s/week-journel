package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

public class EventTest {

  @Test
  public void testEventConstructor() {
    String name = "Test Event";
    String desc = "Event Description";
    LocalTime time = LocalTime.of(10, 30);
    Duration duration = Duration.ofHours(1);
    Event event = new Event(name, desc, time, duration);
    assertEquals(name, event.getName());
    assertEquals(time, event.getTime());
    assertEquals(duration, event.getDuration());
  }

  @Test
  public void testSetTime() {
    Event event = new Event("Test Event", "Event Description", null, null);
    int hour = 9;
    int minute = 45;
    event.setTime(hour, minute);
    LocalTime expectedTime = LocalTime.MIDNIGHT.plus(Duration.ofHours(hour)).plus(
        Duration.ofMinutes(minute));
    assertEquals(expectedTime, event.getTime());
  }

  @Test
  public void testSetDuration() {
    Event event = new Event("Test Event", "Event Description", null, null);
    int hour = 2;
    int minute = 30;
    event.setDur(hour, minute);
    Duration expectedDuration = Duration.ofHours(hour).plus(Duration.ofMinutes(minute));
    assertEquals(expectedDuration, event.getDuration());
  }
}
