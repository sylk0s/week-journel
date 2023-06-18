package cs3500.pa05.controller;

import cs3500.pa05.model.JournalEntry;
import cs3500.pa05.model.Week;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.WeekView;

// calls all controllers and runs application
public class JournalApp {
  initialController init = new initialController();
  JournalViewController view = new JournalViewController();
  //SideBarController side = new SideBarController();
  //TopBarController top = new TopBarController();
  //WeekViewController week = new WeekViewController();

  public void run(){
    Week week = new Week(10, 10, "");

  };
}
