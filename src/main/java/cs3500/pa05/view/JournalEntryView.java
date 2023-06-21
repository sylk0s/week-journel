package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The view for a generic journal entry
 */
public abstract class JournalEntryView extends VBox {
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

  protected final SideBarController side;
  protected TextField name;

  /**
   * Constructs a JournalEntryView object
   *
   * @param name - label of the name
   * @param desc - description
   */
  public JournalEntryView(String name, String desc, SideBarController side) {
    this.remove = new Button("Delete");
    this.side = side;

    this.topBox = new HBox();
    this.createNameLabel(topBox, name);
    this.topBox.getChildren().add(this.remove);

    this.desc = new TextArea();
    this.desc.setText(desc);
    this.desc.setWrapText(true);
    // todo tweak
    this.setMaxWidth(200);
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

  protected void createNameLabel(HBox box, String name) {
    box.getChildren().add(new TextField(name));
  }
}