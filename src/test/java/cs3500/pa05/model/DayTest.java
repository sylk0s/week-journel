package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayTest {
/**
  private Day day;

  @BeforeEach
  public void setUp() {
    // Assuming DayType.MONDAY exists
    day = new Day(DayType.MONDAY);
  }

  @Test
  public void testAddAndRemoveTask() {
    // Assuming Task class has a no-arg constructor
    Task task = new Task();
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
    Event event = new Event();
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
    Task task1 = new Task();
    Task task2 = new Task();

    day.add(task1);
    day.add(task2);

    assertTrue(day.isOverTaskMax(1), "Day should be over task max after adding two tasks and comparing with a max of 1");
  }

  @Test
  public void testIsOverEventMax() {
    // Assuming Event class has a no-arg constructor
    Event event1 = new Event();
    Event event2 = new Event();

    day.add(event1);
    day.add(event2);

    assertTrue(day.isOverEventMax(1), "Day should be over event max after adding two events and comparing with a max of 1");
  }
}

//class DayTest {
//  @Test
//  void testSerialization() {
//
//    try {
//      String result = new ObjectMapper().writeValueAsString(new Day("name"));
//
//      String expected = """
//          {
//            "name":"name",
//            "items": [],
//          }""";
//
//      assertEquals(result, expected);
//    } catch (JsonProcessingException e) {
//      fail();
//    }
//
//  }
//
//  @Test
//  void testDeserialization() {
//
//  }
//
  */
}