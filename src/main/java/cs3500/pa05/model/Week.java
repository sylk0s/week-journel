package cs3500.pa05.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Represents a week
 */
public class Week {
  /**
   * The days of this week
   */
  List<Day> days;

  /**
   * The maximum number of events that can exist in each day
   */
  int eventMax;

  /**
   * The maximum number of tasks that can exist in each day
   */
  int taskMax;

  /**
   * The name of this week
   */
  String name;
  private DayType startDay;

  @JsonCreator
  Week(@JsonProperty("days") List<Day> days,
       @JsonProperty("eventMax") int eventMax,
       @JsonProperty("taskMax") int taskMax,
       @JsonProperty("name") String name,
       @JsonProperty("startDay") DayType startDay
  ) {
    this.days = days;
    this.eventMax = eventMax;
    this.taskMax = taskMax;
    this.name = name;
    this.startDay = startDay;
  }

  /**
   * Constructor that automatically creates a new week with all the proper days
   *
   * @param eventMax the maximum number of events
   * @param taskMax the maximum number of tasks
   * @param name the name of this week
   */
  public Week(int eventMax, int taskMax, String name) {
    this.eventMax = eventMax;
    this.taskMax = taskMax;
    this.name = name;
    this.startDay = DayType.SUNDAY;

    this.days = new ArrayList<>();
    for (DayType type: DayType.values()) {
      this.days.add(new Day(type));
    }
  }

  /**
   *
   * @return The days in this week
   */
  @JsonGetter("days")
  public List<Day> getDays() {
    return this.days;
  }

  /**
   *
   * @return The max number of events that can happen in a day
   */
  @JsonGetter("eventMax")
  public int getEventMax() {
    return this.eventMax;
  }

  /**
   *
   * @return The max number of tasks that can happen in a day
   */
  @JsonGetter("taskMax")
  public int getTaskMax() {
    return this.taskMax;
  }

  /**
   *
   * @return The name of this week
   */
  @JsonGetter("name")
  public String getName() {
    return this.name;
  }

  /**
   * Sets the max number of tasks in each day of this week
   *
   * @param max the new value
   */
  public void setTaskMax(int max) {
    this.taskMax = max;
  }

  /**
   * Sets the max number of events in each day of this week
   *
   * @param max the new value
   */
  public void setEventMax(int max) {
    this.eventMax = max;
  }

  /**
   *
   * @return The total number of tasks that have been finished
   */
  public int totalFinishedTasks() {
    return this.days.stream().reduce(0, (num, day) -> num + day.numFinishedTasks(), Integer::sum);
  }

  /**
   *
   * @return The total number of tasks
   */
  public int totalTasks() {
    return this.days.stream().reduce(0, (num, day) -> num + day.numTasks(), Integer::sum);
  }

  /**
   *
   * @return A list of all the tasks in this week
   */
  @JsonIgnore
  public List<Task> getTasks() {
    return this.days.stream().flatMap((day) -> day.getTasks().stream())
        .collect(Collectors.toList());
  }

  /**
   *
   * @return A list of all the events in this week
   */
  @JsonIgnore
  public List<Event> getEvent() {
    return this.days.stream().flatMap((day) -> day.getEvents().stream())
        .collect(Collectors.toList());
  }

    public void addEntry(JournalEntry entry, DayType dayType) {
      Optional<Day> dayOptional = this.days.stream()
          .filter(day -> day.getName().equals(dayType))
          .findFirst();

      if (dayOptional.isPresent()) {
        Day day = dayOptional.get();
        day.add(entry);
      } else {
        throw new IllegalArgumentException("DayType not found in the week.");
      }
    }

  @JsonIgnore
  public List<JournalEntry> getEntries() {

    List<Event> events = this.getEvent();
    List<Task> tasks = this.getTasks();

    List<JournalEntry> entries = new ArrayList<>();

    entries.addAll(events);
    entries.addAll(tasks);

    return entries;

  }

  public Day getDay(DayType type) {
    Optional<Day> result = this.days.stream().filter(d -> d.name.equals(type)).findFirst();
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new IllegalStateException("Could not find day");
    }
  }

  @JsonGetter("startDay")
  public DayType getStartDay() {
    return this.startDay;
  }

  public void setStartDay(DayType day) {
    this.startDay = day;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("");
    for (Day day : days) {
      sb.append(day.getName()).append("\n");
    }
    return sb.toString();
  }
}