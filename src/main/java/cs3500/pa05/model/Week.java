package cs3500.pa05.model;

import java.util.List;

public class Week {
  List<Day> days;
  int eventMax;
  int taskMax;
  String name;

  Week(List<Day> days) {
    this.days = days;
  }

  public List<Day> getDays() {
    throw new UnsupportedOperationException();
  }

  public int getEventMax() {
    throw new UnsupportedOperationException();
  }

  public int getTaskMax() {
    throw new UnsupportedOperationException();
  }

  public String getName() {
    throw new UnsupportedOperationException();
  }

  public int totalFinishedTasks() {
    throw new UnsupportedOperationException();
  }

  public int totalTasks() {
    throw new UnsupportedOperationException();
  }

  public List<Task> getTasks() {
    throw new UnsupportedOperationException();
  }

  public List<Event> getEvent() {
    throw new UnsupportedOperationException();
  }
}
