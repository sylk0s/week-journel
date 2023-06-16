package cs3500.pa05.model;

public abstract class JournalEntry {
  String name;
  String description;

  public JournalEntry(String name, String description) {
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
