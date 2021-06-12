package edu.umn.cs.csci3081w.project.model;

public class BusData {
  private String id;
  private Position position;
  private int numPassengers;
  private int capacity;
  private int red;
  private int green;
  private int blue;
  private int alpha;

  /**
   * Stores details of a bus.
   *
   * @param id   bus id
   * @param pos  position of the bus
   * @param pass number of passengers
   * @param cap  capacity of bus to be created
   */
  public BusData(String id, Position pos, int pass,
                 int cap, int red, int green, int blue, int alpha) {
    this.id = id;
    this.position = pos;
    this.numPassengers = pass;
    this.capacity = cap;
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }

  public BusData() {
    this.position = new Position();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public int getNumPassengers() {
    return numPassengers;
  }

  public void setNumPassengers(int numPassengers) {
    this.numPassengers = numPassengers;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /*
  public void setColor(Color color) {
    this.color = color;
  }
*/
  public int getRed() {
    return red;
  }

  public void setRed(int red) {
    this.red = red;
  }

  public int getGreen() {
    return green;
  }

  public void setGreen(int green) {
    this.green = green;
  }

  public int getBlue() {
    return blue;
  }

  public void setBlue(int blue) {
    this.blue = blue;
  }

  public int getAlpha() {
    return alpha;
  }

  public void setAlpha(int alpha) {
    this.alpha = alpha;
  }
}
