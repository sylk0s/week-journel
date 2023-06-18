package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Theme
 */
public class ThemeModel {
  private List<Theme> themes;
  private Theme selectedTheme;

  /**
   * Constructs a new ThemeModel object
   */
  public ThemeModel() {
    themes = new ArrayList<>();
    selectedTheme = null;
  }

  /**
   * Adds a theme to the list of themes
   *
   * @param theme - a theme
   */
  public void addTheme(Theme theme) {
    themes.add(theme);
  }

  /**
   * Gets the list of themes
   *
   * @return a list of themes
   */
  public List<Theme> getThemes() {
    return themes;
  }

  /**
   * Gets a specific theme
   *
   * @return - a theme
   */
  public Theme getSelectedTheme() {
    return selectedTheme;
  }

  /**
   * Sets the selected theme to a specifc theme
   *
   * @param theme - a theme
   */
  public void setSelectedTheme(Theme theme) {
    selectedTheme = theme;
  }
}
