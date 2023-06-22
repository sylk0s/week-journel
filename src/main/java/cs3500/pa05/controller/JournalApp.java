package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.InitialView;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.SideBar;
import cs3500.pa05.view.Splash;
import cs3500.pa05.view.TopBar;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The main application class
 */
public class JournalApp extends Application {

  /**
   * The controller for the sidebar
   */
  private SideBarController side;
  /**
   * Handler object for keypresses
   */
  private KeyPressHandler keyPressHandler;

  /**
   * Starts the application
   *
   * @param primaryStage the primary stage for this application, onto which
   *                     the application scene can be set.
   *                     Applications may create other stages, if needed, but they will not be
   *                     primary stages.
   */
  @Override
  public void start(Stage primaryStage) {
    // Create the splash screen
    Splash splashScreen = new Splash("My Journal App");

    // Transition to the initial view after 2 seconds
    FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1.5), splashScreen);
    fadeOutTransition.setFromValue(1);
    fadeOutTransition.setToValue(0);
    fadeOutTransition.setOnFinished(event -> {
      primaryStage.setScene(createInitialScene(primaryStage));
      primaryStage.show();
    });
    fadeOutTransition.play();

    Scene splashScene = new Scene(splashScreen, 800, 600);

    // Set the splash scene initially
    primaryStage.setScene(splashScene);
    primaryStage.show();
  }

  /**
   * Creates the initial scene
   *
   * @param primaryStage the scene for the app
   * @return the initial scene
   */
  private Scene createInitialScene(Stage primaryStage) {
    InitialView initialView = new InitialView();
    // Initialize the serializers
    BujoSerializer serializer = new BujoSerializer();
    new InitialController(initialView, serializer, primaryStage, this);
    Scene initialScene = new Scene(initialView, 800, 600);
    primaryStage.setScene(initialScene);
    primaryStage.show();
    return initialScene;
  }

  /**
   * Creates the journal view
   *
   * @param primaryStage the stage for the app
   * @param weekModel the model for the week
   * @return the journal view
   */
  public JournalView getJournalView(Stage primaryStage, Week weekModel) {
    // Initialize the models

    // Initialize the views
    SideBar sideBar = new SideBar();
    this.side = new SideBarController(weekModel, sideBar);
    WeekViewController weekController = new WeekViewController(weekModel, primaryStage, this.side);
    TopBar topBar = new TopBar(weekController);


    // Initialize the controllers with the models and views
    TopBarController top = new TopBarController(weekController, topBar,
        primaryStage, side, this);
    this.keyPressHandler = new KeyPressHandler(top);
    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> keyPressHandler.handle(event));
    this.run();
    JournalView journalView = new JournalView(sideBar, topBar, weekController.getWeekView());
    JournalViewController journalView1 = new JournalViewController(journalView);
    return journalView1.getView();
  }

  /**
   * Runs the various components of the app
   */
  public void run() {
    // Run each of the controllers
    this.side.updateView();
  }
}