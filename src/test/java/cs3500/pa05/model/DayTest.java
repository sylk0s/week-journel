package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class DayTest {
  @Test
  void testSerialization() {
    /*
    try {
      String result = new ObjectMapper().writeValueAsString(new Day("name"));

      String expected = """
          {
            "name":"name",
            "items": [],
          }""";

      assertEquals(result, expected);
    } catch (JsonProcessingException e) {
      fail();
    }
    */
  }

  @Test
  void testDeserialization() {

  }
}