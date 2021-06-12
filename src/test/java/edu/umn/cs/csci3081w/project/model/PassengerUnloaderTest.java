package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassengerUnloaderTest {

  /**
   * Setup deterministic operations before each test runs.
   */
  @BeforeEach
  public void setUp() {
    PassengerFactory.DETERMINISTIC = true;
    PassengerFactory.DETERMINISTIC_NAMES_COUNT = 0;
    PassengerFactory.DETERMINISTIC_DESTINATION_COUNT = 0;
    RandomPassengerGenerator.DETERMINISTIC = true;
  }

  /**
   * Test unloading of passengers.
   */
  @Test
  public void testUnloadPassengerNoPassengers() {
    List<Passenger> passengers = new ArrayList<>();
    Stop stop = new Stop(0, 44.972392, -93.243774);
    PassengerUnloader testPassUnloader = new PassengerUnloader();
    int passUnloaded = testPassUnloader.unloadPassengers(passengers, stop);
    assertEquals(0, passUnloaded);
  }

  /**
   * Test unloading of passengers.
   */
  @Test
  public void testUnloadPassenger() {
    List<Passenger> passengers = new ArrayList<>();
    Stop stop = new Stop(1, 45, -93.243774);
    Stop stopTwo = new Stop(2, 47, -93.243774);
    Stop stopThree = new Stop(3, 48, -93.243774);
    PassengerUnloader testPassUnloader = new PassengerUnloader();
    Passenger noah = new Passenger(2, "noah");
    Passenger noahTwo = new Passenger(1, "noah");
    Passenger noahThree = new Passenger(3, "noah");
    passengers.add(noah);
    passengers.add(noahTwo);
    passengers.add(noahThree);
    int passUnloaded = testPassUnloader.unloadPassengers(passengers, stop);
    passUnloaded += testPassUnloader.unloadPassengers(passengers, stopTwo);
    passUnloaded += testPassUnloader.unloadPassengers(passengers, stopThree);
    assertEquals(3, passUnloaded);
  }

}
