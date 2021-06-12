package edu.umn.cs.csci3081w.project.model;

public class GoldColorDecorator extends BusData {
  public GoldColorDecorator(String id, Position pos, int pass, int cap) {
    super(id, pos, pass, cap, 255, 215, 0, 255);
  }

}
