package cs3500.pa05.view;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.animation.SequentialTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;


/**
 * Opening splash screen
 */
public class Splash extends StackPane {

  /**
   * The label for the screen
   */
  private final Label splash;

  /**
   * constructor
   *
   * @param text the text to display
   */
  public Splash(String text) {
    this.splash = new Label(text);
    initializeSplash();
  }

  /**
   * initializes the splash
   */
  private void initializeSplash() {
    // Set splash screen styling
    splash.setFont(Font.font("Verdana", 50));
    splash.setTextFill(Color.WHITE);

    // Add a shadow effect
    splash.setEffect(new DropShadow(30, Color.BLACK));

    // Set gradient background
    BackgroundFill backgroundFill = new BackgroundFill(
        Color.BLUE,
        new CornerRadii(1),
        null
    );
    Background background = new Background(backgroundFill);
    this.setBackground(background);

    // Create a fade-in transition for the splash screen
    FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(2), splash);
    fadeInTransition.setFromValue(0);
    fadeInTransition.setToValue(1);

    // Create a fade-out transition for the splash screen
    FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(2), splash);
    fadeOutTransition.setFromValue(1);
    fadeOutTransition.setToValue(0);
    fadeOutTransition.setDelay(Duration.seconds(2));

    // Combine the fade-in and fade-out transitions
    SequentialTransition sequentialTransition = new SequentialTransition(fadeInTransition, fadeOutTransition);

    // Add the splash label to the center of the StackPane
    this.getChildren().add(splash);
    StackPane.setAlignment(splash, Pos.CENTER);

    // Play the fade-in transition to show the splash screen
    sequentialTransition.play();
  }
}
