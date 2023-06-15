package cs3500.pa05.controller;

import cs3500.pa05.model.Bujo;

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
    throw new UnsupportedOperationException();
  }

  /**
   * Turns a JSON string into a BUJO file
   *
   * @param string the string to deserialize
   * @return the Bujo file
   */
  private Bujo deserialize(String string) {
    throw new UnsupportedOperationException();
  }

  /**
   * Writes the bujo string to a file
   *
   * @param path the path of the file to write to
   * @param bujo the object to write to the file
   */
  public void write(String path, Bujo bujo) {
    throw new UnsupportedOperationException();
  }

  /**
   * Reads and deserialized a .bujo into an object
   *
   * @param path the path to read from
   * @return a bujo file
   */
  public Bujo read(String path) {
    throw new UnsupportedOperationException();
  }
}
