package cs3500.pa05.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The view for a generic journal entry
 */
public abstract class JournalEntryView extends VBox {
  Label name;
  Button remove;
  HBox topBox;
  TextArea desc;

  JournalEntryView(String name, String desc) {
    this.name = new Label(name);
    this.remove = new Button("delete");

    // box for the top which contains the name of the entry and some buttons to interact
    this.topBox = new HBox();
    this.topBox.getChildren().add(this.name);
    this.topBox.getChildren().add(this.remove);

    // description, which goes under the top box
    this.desc.textProperty().set(desc);

    this.getChildren().add(this.topBox);
    this.getChildren().add(this.desc);
  }
}
