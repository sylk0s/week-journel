package cs3500.pa05.model;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a week
 */
public class Week {
  List<Day> days;
  int eventMax;
  int taskMax;
  String name;

  Week(List<Day> days, int eventMax, int taskMax, String name) {
    this.days = days;
    this.eventMax = eventMax;
    this.taskMax = taskMax;
    this.name = name;
  }

  public List<Day> getDays() {
    return this.days;
  }

  public int getEventMax() {
    return this.eventMax;
  }

  public int getTaskMax() {
    return this.taskMax;
  }

  public String getName() {
    return this.name;
  }

  public void setTaskMax(int max) {
    this.taskMax = max;
  }

  public void setEventMax(int max) {
    this.eventMax = max;
  }

  public int totalFinishedTasks() {
    return this.days.stream().reduce(0, (num, day) -> day.numFinishedTasks(), Integer::sum);
  }

  public int totalTasks() {
    return this.days.stream().reduce(0, (num, day) -> day.numTasks(), Integer::sum);
  }

  public List<Task> getTasks() {
    return this.days.stream().flatMap((day) -> day.getTasks().stream())
        .collect(Collectors.toList());
  }

  public List<Event> getEvent() {
    return this.days.stream().flatMap((day) -> day.getEvents().stream())
        .collect(Collectors.toList());
  }
}
