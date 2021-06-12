package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BusDeploymentStrategyDayTest {

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
   * Test get next bus.
   */
  @Test
  public void testGetNextBus() {
    Stop stop1 = new Stop(0, 44.972392, -93.243774);
    Stop stop2 = new Stop(1, 44.973580, -93.235071);
    Stop stop3 = new Stop(2, 44.975392, -93.226632);
    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop1);
    stopsOut.add(stop2);
    stopsOut.add(stop3);
    List<Double> distancesOut = new ArrayList<Double>();
    distancesOut.add(0.9712663713083954);
    distancesOut.add(0.961379387775189);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(.15);
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.0);
    Route testOutRoute = TestUtils.createRouteGivenData(stopsOut, distancesOut, probabilitiesOut);
    List<Stop> stopsIn = new ArrayList<>();
    stopsIn.add(stop3);
    stopsIn.add(stop2);
    stopsIn.add(stop1);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.961379387775189);
    distancesIn.add(0.9712663713083954);
    List<Double> probabilitiesIn = new ArrayList<>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    probabilitiesIn.add(.0);
    Route testInRoute = TestUtils.createRouteGivenData(stopsIn, distancesIn, probabilitiesIn);
    BusDeploymentStrategyDay busDeploymentStrategyDay = new BusDeploymentStrategyDay();
    Bus testBus = busDeploymentStrategyDay.getNextBus("0", testOutRoute, testInRoute, 1);
    assertTrue(testBus instanceof RegularBus);
  }

  /**
   * Test get next bus, instance should be large bus.
   */
  @Test
  public void testGetNextBusLarge() {
    Stop stop1 = new Stop(0, 44.972392, -93.243774);
    Stop stop2 = new Stop(1, 44.973580, -93.235071);
    Stop stop3 = new Stop(2, 44.975392, -93.226632);
    List<Stop> stopsOut = new ArrayList<Stop>();
    stopsOut.add(stop1);
    stopsOut.add(stop2);
    stopsOut.add(stop3);
    List<Double> distancesOut = new ArrayList<Double>();
    distancesOut.add(0.9712663713083954);
    distancesOut.add(0.961379387775189);
    List<Double> probabilitiesOut = new ArrayList<Double>();
    probabilitiesOut.add(.15);
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.0);
    Route testOutRoute = TestUtils.createRouteGivenData(stopsOut, distancesOut, probabilitiesOut);
    List<Stop> stopsIn = new ArrayList<>();
    stopsIn.add(stop3);
    stopsIn.add(stop2);
    stopsIn.add(stop1);
    List<Double> distancesIn = new ArrayList<>();
    distancesIn.add(0.961379387775189);
    distancesIn.add(0.9712663713083954);
    List<Double> probabilitiesIn = new ArrayList<>();
    probabilitiesIn.add(.025);
    probabilitiesIn.add(0.3);
    probabilitiesIn.add(.0);
    Route testInRoute = TestUtils.createRouteGivenData(stopsIn, distancesIn, probabilitiesIn);
    BusDeploymentStrategyDay busDeploymentStrategyDay = new BusDeploymentStrategyDay();
    Bus testBus = busDeploymentStrategyDay.getNextBus("0", testOutRoute, testInRoute, 1);

    List<Stop> stopsOutN = new ArrayList<Stop>();
    stopsOutN.add(stop1);
    stopsOutN.add(stop2);
    stopsOutN.add(stop3);
    List<Double> distancesOutN = new ArrayList<Double>();
    distancesOutN.add(0.9712663713083954);
    distancesOutN.add(0.961379387775189);
    List<Double> probabilitiesOutN = new ArrayList<Double>();
    probabilitiesOutN.add(.15);
    probabilitiesOutN.add(0.3);
    probabilitiesOutN.add(.0);
    Route testOutRouteN = TestUtils.createRouteGivenData(stopsOut, distancesOut, probabilitiesOut);
    List<Stop> stopsInN = new ArrayList<>();
    stopsInN.add(stop3);
    stopsInN.add(stop2);
    stopsInN.add(stop1);
    List<Double> distancesInN = new ArrayList<>();
    distancesInN.add(0.961379387775189);
    distancesInN.add(0.9712663713083954);
    List<Double> probabilitiesInN = new ArrayList<>();
    probabilitiesInN.add(.025);
    probabilitiesInN.add(0.3);
    probabilitiesInN.add(.0);
    Route testInRouteN = TestUtils.createRouteGivenData(stopsIn, distancesIn, probabilitiesIn);
    Bus testBusN = busDeploymentStrategyDay.getNextBus("1", testOutRouteN, testInRouteN, 1);

    assertTrue(testBusN instanceof LargeBus);
  }
}
