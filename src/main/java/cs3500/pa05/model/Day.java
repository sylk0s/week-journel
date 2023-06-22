package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Represents a day of the week
 */
public class Day {

  /**
   * The name of the day
   */
  private final DayType name;

  /**
   * The events and tasks in this day
   */
  private final List<JournalEntry> items;

  /**
   * JSON constructor for Days
   *
   * @param items the items in this day
   * @param name the name of the day
   */
  @JsonCreator
  public Day(@JsonProperty("items") List<JournalEntry> items, @JsonProperty("name") DayType name) {
    this.items = items;
    this.name = name;
  }

  /**
   * Constructs a Day with no tasks or events
   *
   * @param name The name of the day
   */
  public Day(DayType name) {
    this(new ArrayList<>(), name);
  }

  /**
   * Adds an event or task to this day's items
   *
   * @param e the event to add
   */
  public void add(JournalEntry e) {
    this.items.add(e);
  }

  /**
   * Removes an event or task from this day's items
   *
   * @param e the event to remove
   */
  public void remove(JournalEntry e) {
    this.items.remove(e);
  }


  /**
   *
   * @return The name of this day
   */
  @JsonGetter("name")
  public DayType getName() {
    return this.name;
  }

  // todo this whole thing is kinda jank, maybe fix that?

  /**
   *
   * @return The list of all tasks for this day
   */
  @JsonIgnore
  public List<Task> getTasks() {
    return this.items.stream()
        .filter((x) -> x instanceof Task)
        .map((x) -> (Task) x)
        .collect(Collectors.toList());
  }

  /**
   *
   * @return The list of all events for this day
   */
  @JsonIgnore
  public List<Event> getEvents() {
    return this.items.stream()
        .filter((x) -> x instanceof Event)
        .map((x) -> (Event) x)
        .collect(Collectors.toList());
  }

  /**
   *
   * @return The list of all items for this day
   */
  @JsonGetter("items")
  public List<JournalEntry> getItems() {
    return this.items;
  }

  /**
   *
   * @return The number of items in this day
   */
  public int numItems() {
    return this.items.size();
  }

  /**
   *
   * @return The number of tasks in this day
   */
  public int numTasks() {
    return numMatch(this.items, (x) -> x instanceof Task);
  }

  /**
   *
   * @return The number of events in this day
   */
  public int numEvents() {
    return numMatch(this.items, (x) -> x instanceof Event);
  }

  /**
   * Determines how many items match a predicate
   *
   * @param list The list to check
   * @param p The predicate to test for each item for
   * @param <T> The type of the list
   * @return The number of items in the list that satisfy the predicate
   */
  private <T> int numMatch(Collection<T> list, Predicate<T> p) {
    return list.stream().reduce(0, (acc, x) -> acc + (p.test(x) ? 1 : 0), Integer::sum);
  }

  /**
   *
   * @return The number of tasks that are finished
   */
  public int numFinishedTasks() {
    return numMatch(this.items, (x) -> x instanceof Task && x.isFinished());
  }

  /**
   * Check if this day is over the maximum amount of tasks for the week
   *
   * @param max the maximum amount of tasks
   * @return if the tasks are over the max
   */
  public boolean isOverTaskMax(int max) {
    return max < this.getTasks().size();
  }

  /**
   * Check if this day is over the maximum amount of events for the week
   *
   * @param max the maximun amount of events
   * @return if the events are over the max
   */
  public boolean isOverEventMax(int max) {
    return max < this.getTasks().size();
  }
}