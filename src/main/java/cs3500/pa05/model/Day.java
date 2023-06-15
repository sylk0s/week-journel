package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Represents a day of the week
 */
public class Day {
  String name;
  List<AbstractEventTask> items;

  public Day(List<AbstractEventTask> items, String name) {
    this.items = items;
    this.name = name;
  }

  public Day(String name) {
    this(new ArrayList<>(), name);
  }

  public void add(Event e) {
    this.items.add(e);
  }

  public void add(Task t) {
    this.items.add(t);
  }

  public void remove(Event e) {
    this.items.remove(e);
  }

  public void remove(Task t) {
    this.items.remove(t);
  }

  public String getName() {
    return this.name;
  }

  // todo this whole thing is kinda jank, maybe fix that?

  public List<Task> getTasks() {
    return this.items.stream()
        .filter((x) -> x instanceof Task)
        .map((x) -> (Task) x)
        .collect(Collectors.toList());
  }

  public List<Event> getEvents() {
    return this.items.stream()
        .filter((x) -> x instanceof Event)
        .map((x) -> (Event) x)
        .collect(Collectors.toList());
  }

  public int numItems() {
    return this.items.size();
  }

  public int numTasks() {
    return numMatch(this.items, (x) -> x instanceof Task);
  }

  public int numEvents() {
    return numMatch(this.items, (x) -> x instanceof Event);
  }

  private <T> int numMatch(Collection<T> list, Predicate<T> p) {
    return list.stream().reduce(0, (acc, x) -> acc + (p.test(x) ? 1 : 0), Integer::sum);
  }
  public int numFinishedTasks() {
    return numMatch(this.items, (x) -> x instanceof Task && x.isFinished());
  }

  public boolean isOverTaskMax(int max) {
    return max < this.getTasks().size();
  }

  public boolean isOverEventMax(int max) {
    return max < this.getTasks().size();
  }
}
