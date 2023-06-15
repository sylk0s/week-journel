package cs3500.pa05.model;

import java.util.List;

public class Day {
  List<AbstractEventTask> items;

  public void add(Event e) {

  }

  public void add(Task t) {

  }

  public void remove(Event e) {

  }

  public void remove(Task t) {

  }

  public List<Task> getTasks() {
    throw new UnsupportedOperationException();
  }

  public List<Event> getEvents() {
    throw new UnsupportedOperationException();
  }

  public int numItems() {
    return this.items.size();
  }

  public int numTasks() {
    throw new UnsupportedOperationException();
  }

  public int numEvents() {
    throw new UnsupportedOperationException();
  }
}
