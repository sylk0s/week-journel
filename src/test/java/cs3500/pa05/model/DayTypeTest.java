package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for day enum
 */
public class DayTypeTest {

  @Test
  public void testEnumValues() {
    // Check the number of enum values
    assertEquals(7, DayType.values().length);

    // Check specific enum values
    assertEquals(DayType.SUNDAY, DayType.valueOf("SUNDAY"));
    assertEquals(DayType.MONDAY, DayType.valueOf("MONDAY"));
    assertEquals(DayType.TUESDAY, DayType.valueOf("TUESDAY"));
    assertEquals(DayType.WEDNESDAY, DayType.valueOf("WEDNESDAY"));
    assertEquals(DayType.THURSDAY, DayType.valueOf("THURSDAY"));
    assertEquals(DayType.FRIDAY, DayType.valueOf("FRIDAY"));
    assertEquals(DayType.SATURDAY, DayType.valueOf("SATURDAY"));
  }
}
