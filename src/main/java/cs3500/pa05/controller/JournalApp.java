package cs3500.pa05.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.InitialView;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.WeekView;
import cs3500.pa05.view.SideBar;
import cs3500.pa05.view.TopBar;

import java.util.stream.Collectors;

// Calls all controllers and runs the application
public class JournalApp extends Application {

  private InitialController init;
  private JournalViewController journalView;
  private SideBarController side;
  private TopBarController top;
  private WeekViewController week;


  @Override
  public void start(Stage primaryStage) {
    // Initialize the models
    Week weekModel = new Week(10, 10, "");
    System.out.println(weekModel.toString());
    Bujo bujo = new Bujo(weekModel);

    // Initialize the views
    InitialView initialView = new InitialView(primaryStage);
    JournalView journalView = new JournalView(weekModel);
    SideBar sideBar = journalView.getSideBar();
    TopBar topBar = journalView.getTopBar();

    // Initialize the serializers
    BujoSerializer serializer = new BujoSerializer();

    // Initialize the controllers with the models and views
    this.init = new InitialController(initialView, serializer);
    this.journalView = new JournalViewController(journalView, weekModel);
    this.side = new SideBarController(weekModel, sideBar);
    this.top = new TopBarController(weekModel, bujo, serializer, topBar);

    // Run the application
    this.run();
    Scene scene = new Scene(journalView, 800, 800);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void run() {
    // Run each of the controllers.

    this.journalView.run();
    this.side.updateView();
  }
}
