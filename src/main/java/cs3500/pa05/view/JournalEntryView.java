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
  /**
   * The name of the jounral entry
   */
  private final Label name;
  /**
   * the button to remove this journal entry from it's parent
   */
  private final Button remove;
  /**
   * the hbox that contains the name and buttons
   */
  private final HBox topBox;
  /**
   * The description for this note
   */
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
    // todo tweak
    this.desc.setMaxWidth(100);
    this.desc.setWrapText(true);

    setSpacing(10);
    setPadding(new Insets(10));
    getChildren().addAll(topBox, this.desc);
  }

  /**
   *
   * @param onDeleteListener the thing to run when the delete key is pressed
   */
  public void setOnDeleteListener(Runnable onDeleteListener) {
    remove.setOnAction(event -> onDeleteListener.run());
  }
}