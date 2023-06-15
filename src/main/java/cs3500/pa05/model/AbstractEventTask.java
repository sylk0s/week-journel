package cs3500.pa05.model;

public abstract class AbstractEventTask {
  String name;
  String description;

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    throw new UnsupportedOperationException();
  }

  public abstract boolean isFinished();
}
