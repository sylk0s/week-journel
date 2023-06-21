package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WeekTest {

  @Test
  public void testGetDays() {
    List<Day> days = new ArrayList<>();
    days.add(new Day(DayType.MONDAY));
    days.add(new Day(DayType.TUESDAY));
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    String note = "Test Note";
    Week week = new Week(days, eventMax, taskMax, name, note);

    List<Day> actualDays = week.getDays();

    assertEquals(days, actualDays);
  }

  @Test
  public void testTotalFinishedTasks() {
    List<Day> days = new ArrayList<>();
    Day day1 = new Day(DayType.MONDAY);
    day1.add(new Task("Task 1", "test1", true));
    Day day2 = new Day(DayType.TUESDAY);
    day2.add(new Task("Task 2", "test2", true));
    day2.add(new Task("Task 3", "test3", false));
    days.add(day1);
    days.add(day2);
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    String note = "Test Note";
    Week week = new Week(days, eventMax, taskMax, name, note);

    int totalFinishedTasks = week.totalFinishedTasks();

    assertEquals(2, totalFinishedTasks);
  }

  @Test
  public void testGetEntries() {
    List<Day> days = new ArrayList<>();
    Day day1 = new Day(DayType.MONDAY);
    day1.add(new Task("Task 1", "test1", true));
    Day day2 = new Day(DayType.TUESDAY);
    day2.add(new Task("Task 2", "test2", true));
    day2.add(new Task("Task 3", "test3", false));
    days.add(day1);
    days.add(day2);
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    String note = "Test Note";
    Week week = new Week(days, eventMax, taskMax, name, note);

    List<JournalEntry> entries = week.getEntries();

    assertEquals(3, entries.size());
    assertTrue(entries.contains(day1.getItems().get(0)));
    assertTrue(entries.contains(day2.getItems().get(0)));
    assertTrue(entries.contains(day2.getItems().get(1)));
  }

  @Test
  public void testToString() {
    List<Day> days = new ArrayList<>();
    Day day1 = new Day(DayType.MONDAY);
    Day day2 = new Day(DayType.TUESDAY);
    days.add(day1);
    days.add(day2);
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    String note = "Test Note";
    Week week = new Week(days, eventMax, taskMax, name, note);

    String weekString = week.toString();

    String expectedString = "MONDAY\nTUESDAY\n";
    assertEquals(expectedString, weekString);
  }

  @Test
  public void testGetDay() {
    List<Day> days = new ArrayList<>();
    Day day1 = new Day(DayType.MONDAY);
    Day day2 = new Day(DayType.TUESDAY);
    days.add(day1);
    days.add(day2);
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    String note = "Test Note";
    Week week = new Week(days, eventMax, taskMax, name, note);

    Day resultDay = week.getDay(DayType.TUESDAY);

    assertEquals(day2, resultDay);
  }
}
