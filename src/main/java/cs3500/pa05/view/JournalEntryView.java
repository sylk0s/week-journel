package cs3500.pa05.view;

import cs3500.pa05.model.JournalEntry;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The view for a generic journal entry
 */
public abstract class JournalEntryView extends VBox {
  private final Label name;
  private final Button remove;
  private final HBox topBox;
  private final TextArea desc;

  /**
   * Constructs a JournalEntryView object
   *
   * @param name - label of the name
   * @param desc - description
   */
  public JournalEntryView(String name, String desc) {
    this.name = new Label(name);
    this.remove = new Button("Delete");

    this.topBox = new HBox();
    this.topBox.getChildren().addAll(this.name, this.remove);

    this.desc = new TextArea();
    this.desc.setText(desc);
    this.desc.setWrapText(true);

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(topBox, this.desc);
  }

  public void setOnDeleteListener(Runnable onDeleteListener) {
    remove.setOnAction(event -> onDeleteListener.run());
  }

  public void displayEntries(JournalView jv) {
    // Clear the previous entries
    desc.clear();

    List<JournalEntry> entries = jv.displayEntries();
    // Display the new entries
    for (JournalEntry entry : entries) {
      String entryText = entry.getName() + ": " + entry.getDescription() + "\n";
      desc.appendText(entryText);
    }
  }

}
