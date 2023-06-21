package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayTest {
  private Day day;

  @BeforeEach
  public void setUp() {
    day = new Day(DayType.MONDAY);
  }

  @Test
  public void testAddAndRemoveTask() {
    Task task = new Task("aaa", "bbb", false);
    day.add(task);

    assertEquals(1, day.numItems(), "Day should have one item after adding a task");
    assertEquals(1, day.numTasks(), "Day should have one task after adding a task");

    day.remove(task);

    assertEquals(0, day.numItems(), "Day should have no items after removing the task");
    assertEquals(0, day.numTasks(), "Day should have no tasks after removing the task");
  }

  @Test
  public void testAddAndRemoveEvent() {
    // Assuming Event class has a no-arg constructor
    Event event = new Event("aaa", "bbb", LocalTime.now(), Duration.ofHours(1));
    day.add(event);

    assertEquals(1, day.numItems(), "Day should have one item after adding an event");
    assertEquals(1, day.numEvents(), "Day should have one event after adding an event");

    day.remove(event);

    assertEquals(0, day.numItems(), "Day should have no items after removing the event");
    assertEquals(0, day.numEvents(), "Day should have no events after removing the event");
  }

  @Test
  public void testIsOverTaskMax() {
    // Assuming Task class has a no-arg constructor
    Task task1 = new Task("aaa", "bbb", false);
    Task task2 = new Task("ccc", "ddd", false);

    day.add(task1);
    day.add(task2);

    assertTrue(day.isOverTaskMax(1),
        "Day should be over task max after adding two tasks and comparing with a max of 1");
  }

  @Test
  public void testGetEntries() {
    // Create a Day instance
    DayType dayType = DayType.MONDAY;
    Day day = new Day(dayType);

    // Create some tasks and events
    Task task1 = new Task("Task 1", "test1", true);
    Task task2 = new Task("Task 2", "test2", true);
    Event event1 = new Event("Event 1", "Event Description 1", null, null);
    Event event2 = new Event("Event 2", "Event Description 2", null, null);

    // Add the tasks and events to the Day
    day.add(task1);
    day.add(task2);
    day.add(event1);
    day.add(event2);

    // Get the entries from the Day
    List<JournalEntry> entries = day.getEntries();

    // Assert that the entries contain all the tasks and events
    assertTrue(entries.contains(task1));
    assertTrue(entries.contains(task2));
    assertTrue(entries.contains(event1));
    assertTrue(entries.contains(event2));
  }
}