package edu.umn.cs.csci3081w.project.model;

public class MaroonColorDecorator extends BusData {
  public MaroonColorDecorator(String id, Position pos, int pass, int cap) {
    super(id, pos, pass, cap, 128, 0, 0, 255);
  }

}
