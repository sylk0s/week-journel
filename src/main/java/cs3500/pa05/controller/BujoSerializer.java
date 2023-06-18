package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.Bujo;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Handles serializing/deserializing and writing + reading the bujo file
 */
public class BujoSerializer {
  /**
   * Turns the BUJO object into a JSON string
   *
   * @param bujo the object to turn into a string
   * @return the JSON string
   */
  private String serialize(Bujo bujo) {
    return new ObjectMapper().convertValue(bujo, JsonNode.class).asText();
  }

  /**
   * Turns a JSON string into a BUJO file
   *
   * @param string the string to deserialize
   * @return the Bujo file
   */
  private Bujo deserialize(String string) throws JsonProcessingException {
    return new ObjectMapper().readValue(string, Bujo.class);
  }

  /**
   * Writes the bujo string to a file
   *
   * @param path the path of the file to write to
   * @param bujo the object to write to the file
   */
  public void write(String path, Bujo bujo) throws IOException {
    Files.write(FileSystems.getDefault().getPath(path), this.serialize(bujo).getBytes());
  }

  /**
   * Reads and deserialized a .bujo into an object
   *
   * @param path the path to read from
   * @return a bujo file
   */
  public Bujo read(String path) throws IOException {
    return this.deserialize(Files.readString(FileSystems.getDefault().getPath(path)));
  }
}
