package cs3500.pa05.model;

public abstract class AbstractEventTask {
  String name;
  String description;

  public AbstractEventTask(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public abstract boolean isFinished();
}
