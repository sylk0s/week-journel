package cs3500.pa05.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.ThemeModel;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ThemeView {
  private ThemeModel model;
  private ComboBox<Theme> themeComboBox;

  public ThemeView(ThemeModel model, Stage primaryStage) {
    this.model = model;

    VBox root = new VBox();
    root.setSpacing(10);
    root.setPadding(new Insets(10));

    themeComboBox = new ComboBox<>(FXCollections.observableArrayList(model.getThemes()));
    themeComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldTheme, newTheme)
        -> {
      model.setSelectedTheme(newTheme);
      applyTheme(newTheme);
    });

    Button applyButton = new Button("Apply");
    applyButton.setOnAction(event -> {
      Theme selectedTheme = themeComboBox.getValue();
      model.setSelectedTheme(selectedTheme);
      applyTheme(selectedTheme);
    });

    root.getChildren().addAll(themeComboBox, applyButton);

    primaryStage.setScene(new Scene(root, 200, 150));
    primaryStage.setTitle("Theme Selector");
    primaryStage.show();
  }

  private void applyTheme(Theme theme) {
    String backgroundColor = theme.getBackgroundColor();
    String fontColor = theme.getFontColor();
    String fontFamily = theme.getFontFamily();
    Font font = new Font(fontFamily, 12);

    // update background color of a pane
    Pane pane = null; // change this
    Color background = Color.web(backgroundColor);
    pane.setBackground(new Background(new BackgroundFill(background, null, null)));

    // update font color and style of a label
    Label label = null; //change this
    Color fontColorValue = Color.web(fontColor);
    label.setTextFill(fontColorValue);
    label.setFont(font);

    // refresh the UI
    Control control = null; //change this
    control.applyCss();
    control.layout();
  }
}