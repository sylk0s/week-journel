package cs3500.pa05.controller;

import cs3500.pa05.view.Splash;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cs3500.pa05.model.Bujo;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.InitialView;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.SideBar;
import cs3500.pa05.view.TopBar;

import javafx.util.Duration;

// Calls all controllers and runs the application
public class JournalApp extends Application {

  private InitialController init;
  private JournalViewController journalView;
  private SideBarController side;
  private TopBarController top;
  private WeekViewController week;

  @Override
  public void start(Stage primaryStage) {
    // Create the splash screen
    Splash splashScreen = new Splash("My Journal App");
    Scene splashScene = new Scene(splashScreen, 800, 600);

    // Transition to the initial view after 2 seconds
    FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1.5), splashScreen);
    fadeOutTransition.setFromValue(1);
    fadeOutTransition.setToValue(0);
    fadeOutTransition.setOnFinished(event -> {
      primaryStage.setScene(createInitialScene(primaryStage));
      primaryStage.show();
      run();
    });
    fadeOutTransition.play();

    // Set the splash scene initially
    primaryStage.setScene(splashScene);
    primaryStage.show();
  }

  private Scene createInitialScene(Stage primaryStage) {
    // Initialize the models
    Week weekModel = new Week(10, 10, "");
    Bujo bujo = new Bujo(weekModel);

    // Initialize the views
    InitialView initialView = new InitialView(primaryStage);
    SideBar sideBar = new SideBar();
    this.side = new SideBarController(weekModel, sideBar);
    TopBar topBar = new TopBar();
    WeekViewController weekController = new WeekViewController(weekModel, primaryStage, this.side);
    JournalView journalView = new JournalView(sideBar, topBar, weekController.getWeekView());

    // Initialize the serializers
    BujoSerializer serializer = new BujoSerializer();

    // Initialize the controllers with the models and views
    this.init = new InitialController(initialView, serializer, primaryStage, journalView);
    this.journalView = new JournalViewController(journalView, weekModel);
    this.top = new TopBarController(weekController, bujo, topBar, primaryStage, side);

    Scene initialScene = new Scene(initialView, 800, 600);
    primaryStage.setScene(initialScene);
    primaryStage.show();
    this.run();
    return initialScene;
  }

  public void run() {
    // Run each of the controllers
    this.journalView.run();
    this.side.updateView();
  }
}
