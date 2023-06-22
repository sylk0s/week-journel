package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.controller.BujoSerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests for bujo files
 */
public class BujoTest {

  @Test
  public void testGetWeek() {
    // Create expected Week object
    List<Day> days = new ArrayList<>();
    Day day1 = new Day(DayType.MONDAY);
    Day day2 = new Day(DayType.TUESDAY);
    Day day3 = new Day(DayType.WEDNESDAY);
    Day day4 = new Day(DayType.THURSDAY);
    Day day5 = new Day(DayType.FRIDAY);
    Day day6 = new Day(DayType.SATURDAY);
    Day day7 = new Day(DayType.SUNDAY);

    days.add(day1);
    days.add(day2);
    days.add(day3);
    days.add(day4);
    days.add(day5);
    days.add(day6);
    days.add(day7);
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    Week expectedWeek = new Week(days, eventMax, taskMax, name, DayType.MONDAY);

    // Create Bujo instance
    Bujo bujo = new Bujo(expectedWeek);

    // Serialize the Bujo object to JSON string
    BujoSerializer serializer = new BujoSerializer();
    String jsonString = serializer.serialize(bujo);

    // Write the JSON string to a file
    String filePath = "sample.bujo";
    try {
      serializer.write(filePath, bujo);
      System.out.println("Sample Bujo file created: " + filePath);
    } catch (IOException e) {
      System.out.println("Error writing Bujo file: " + e.getMessage());
    }


    // Call getWeek method
    Week actualWeek = bujo.getWeek();

    // Compare expected and actual Week objects
    assertEquals(expectedWeek, actualWeek);
  }

  @Test
  public void testBujoCreation() {
    // Create expected Week object
    List<Day> days = new ArrayList<>();
    Day day1 = new Day(DayType.MONDAY);
    Day day2 = new Day(DayType.TUESDAY);
    days.add(day1);
    days.add(day2);
    int eventMax = 5;
    int taskMax = 10;
    String name = "Test Week";
    Week expectedWeek = new Week(days, eventMax, taskMax, name, DayType.MONDAY);

    // Create Bujo instance
    Bujo bujo = new Bujo(expectedWeek);

    // Get the Week object from the Bujo instance
    Week week = bujo.getWeek();

    // Compare the class type of the Week object
    assertTrue(week instanceof Week);

    // Compare the properties of the Week object
    assertEquals(expectedWeek.getDays(), week.getDays());
    assertEquals(expectedWeek.getEventMax(), week.getEventMax());
    assertEquals(expectedWeek.getTaskMax(), week.getTaskMax());
    assertEquals(expectedWeek.getName(), week.getName());
  }
}