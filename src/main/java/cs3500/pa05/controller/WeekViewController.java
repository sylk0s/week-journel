package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.WeekView;
import java.util.stream.Collectors;

/**
 * Controls the week view
 */
public class WeekViewController {
  Week week;
  WeekView view;

  WeekViewController(Week week) {
    this.week = week;
    this.view = new WeekView(week.getDays().stream()
        .map(WeekView::getDayFrom)
        .collect(Collectors.toList()));
  }

  public void run() {
    // does something to display the week
    // needs to be called by the driver class or a higher controller (driver for testing, controller
    // for the finished project)
  }
}