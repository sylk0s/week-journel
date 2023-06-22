package cs3500.pa05.view;

import cs3500.pa05.controller.SideBarController;
import cs3500.pa05.model.JournalEntry;
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
   * The description for this note
   */
  private final TextArea desc;

  /**
   * The sidebar controller
   */
  protected final SideBarController side;

  /**
   * Text field for name
   */
  protected TextField name;

  /**
   * This entry
   */
  protected final JournalEntry self;

  /**
   * Constructs a JournalEntryView object
   *
   * @param name - label of the name
   * @param desc - description
   * @param side - the sidebar controller
   * @param self - this entry model
   */
  public JournalEntryView(String name, String desc, SideBarController side, JournalEntry self) {
    this.remove = new Button("X");
    this.self = self;
    this.side = side;

    HBox topBox = new HBox();
    this.createNameLabel(topBox, name);
    topBox.getChildren().add(this.remove);
    this.name.setOnKeyTyped(k -> {
      this.self.setName(this.name.getText());
      this.side.updateView();
    });

    this.desc = new TextArea();
    this.desc.setText(desc);
    this.desc.setWrapText(true);
    this.desc.setOnKeyTyped(k -> {
      this.self.setDescription(this.desc.getText());
      this.side.updateView();
    });

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

  /**
   * Creates the name label
   *
   * @param box box to add label to
   * @param name the name of the entry
   */
  protected void createNameLabel(HBox box, String name) {
    this.name = new TextField(name);
    box.getChildren().add(this.name);
  }
}