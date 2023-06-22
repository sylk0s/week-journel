package cs3500.pa05.view;

import cs3500.pa05.controller.WeekViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



/**
 * The bar on the top of the page
 */
public class TopBar extends HBox {

  /**
   * Button to toggle sidebar
   */
  private final Button sideBarToggle;

  /**
   * Button to save
   */
  private final Button save;

  /**
   * Button to add a new entry
   */
  private final Button add;

  /**
   * Button for a new week
   */
  private final Button newWeek;

  /**
   * Button to change the start day
   */
  private final Button startDay;

  /**
   * Button to open a file
   */
  private final Button open;

  /**
   * the max number of events
   */
  private final TextField maxEvents;

  /**
   * the max number of tasks
   */
  private final TextField maxTasks;

  /**
   * Constructing a new TopBar object
   *
   * @param week the week controller
   */
  public TopBar(WeekViewController week) {
    this.sideBarToggle = new Button("Sidebar Y/N");
    this.save = new Button("Save");
    this.add = new Button("Add");
    this.open = new Button("Open");
    this.newWeek = new Button("New Week");
    this.startDay = new Button("Start Day");
    this.maxEvents = new TextField(week.getWeek().getEventMax() + "");
    this.maxTasks = new TextField(week.getWeek().getTaskMax() + "");

    // Set uniform button styles
    for(Button button: new Button[]{sideBarToggle, save, add, newWeek, startDay, open}){
      button.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
      button.setTextFill(Color.BLACK);
      button.setBackground(new Background(new BackgroundFill(Color.valueOf("#fffaf0"),
          new CornerRadii(5), new Insets(-5))));
      button.setPrefWidth(100); // increase button width for better UX
    }

    // Set uniform TextField styles
    for(TextField textField: new TextField[]{maxEvents, maxTasks}){
      textField.setPrefWidth(60); // Set preferred width for the text field
      textField.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
    }

    // Set label styles
    Label maxEventsLabel = new Label("Max Events:");
    Label maxTasksLabel = new Label("Max Tasks:");
    for(Label label: new Label[]{maxEventsLabel, maxTasksLabel}){
      label.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
    }

    this.setSpacing(20);
    this.setPadding(new Insets(20));
    this.getChildren().addAll(this.sideBarToggle, this.save, this.add, this.newWeek, this.open,
        this.startDay, maxEventsLabel, this.maxEvents, maxTasksLabel, this.maxTasks);

    BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#bde0ff"),
        new CornerRadii(0), new Insets(0));
    Background background = new Background(backgroundFill);
    this.setBackground(background);



  }

  /**
   * registers this handler for the save button
   *
   * @param handler the handler to register
   */
  public void registerOnSave(EventHandler<ActionEvent> handler) {
    this.save.setOnAction(handler);
  }

  /**
   * registers this handler for the add button
   *
   * @param handler the handler to register
   */
  public void registerOnAdd(EventHandler<ActionEvent> handler) {
    this.add.setOnAction(handler);
  }

  /**
   * registers this handler for the save button
   *
   * @param handler the handler to register
   */
  public void registerOnNewWeek(EventHandler<ActionEvent> handler) {
    this.newWeek.setOnAction(handler);
  }

  /**
   * registers this handler for the start day button
   *
   * @param handler the handler to register
   */
  public void registerOnStartDay(EventHandler<ActionEvent> handler) {
    this.startDay.setOnAction(handler);
  }

  /**
   * registers this handler for the toggle bar button
   *
   * @param handler the handler to register
   */
  public void registerOnToggleBar(EventHandler<ActionEvent> handler) {
    this.sideBarToggle.setOnAction(handler);
  }

  /**
   * registers this handler for the max events
   *
   * @param handler the handler to register
   */
  public void registerMaxEvents(EventHandler<KeyEvent> handler) {
    this.maxEvents.setOnKeyTyped(handler);
  }

  /**
   * registers this handler for the max tasks
   *
   * @param handler the handler to register
   */
  public void registerMaxTasks(EventHandler<KeyEvent> handler) {
    this.maxTasks.setOnKeyTyped(handler);
  }

  /**
   * Getter method for max events
   *
   * @return maxEvents
   */
  public TextField getMaxEventsTextField() {
    return maxEvents;
  }

  /**
   * registers for open button
   *
   * @param handler the handler to register
   */
  public void registerOpen(EventHandler<ActionEvent> handler) {
    this.open.setOnAction(handler);
  }

  /**
   * Getter method for max tasks
   *
   * @return maxTasks
   */
  public TextField getMaxTasksTextField() {
    return maxTasks;
  }


}