package edu.umn.cs.csci3081w.project.webserver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.websocket.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;





public class VisualizationSimulatorTest {
  /**
   * setup.
   */
  @BeforeEach
  public void setUp() {
    PassengerFactory.DETERMINISTIC = true;
    PassengerFactory.DETERMINISTIC_NAMES_COUNT = 0;
    PassengerFactory.DETERMINISTIC_DESTINATION_COUNT = 0;
    RandomPassengerGenerator.DETERMINISTIC = true;
  }

  /**
   * Testing if an update happens.
   */
  @Test
  public void testVisualizationUpdate() throws IOException {
    MyWebServerSession myWebServerSessionSpy = spy(MyWebServerSession.class);
    doNothing().when(myWebServerSessionSpy).sendJson(Mockito.isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    myWebServerSessionSpy.onOpen(sessionDummy);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "update");
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
    VisualizationSimulator holder = myWebServerSessionSpy.getMySim();
    List<Integer> ints = Arrays.asList(1);
    holder.setTimeSinceLastBus(ints);
    holder.update();
  }

  /**
   * Testing another aspect of the update, empty list this time.
   */
  @Test
  public void testVisualizationUpdate1() throws IOException {
    MyWebServerSession myWebServerSessionSpy = spy(MyWebServerSession.class);
    doNothing().when(myWebServerSessionSpy).sendJson(Mockito.isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    myWebServerSessionSpy.onOpen(sessionDummy);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "update");
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
    VisualizationSimulator holder = myWebServerSessionSpy.getMySim();
    List<Integer> ints = Arrays.asList();
    holder.setTimeSinceLastBus(ints);
    holder.update();
  }

  /**
   * A test to toggle the pausing and unpausing feature.
   */
  @Test
  public void testVisualizationUpdate2() throws IOException {
    MyWebServerSession myWebServerSessionSpy = spy(MyWebServerSession.class);
    doNothing().when(myWebServerSessionSpy).sendJson(Mockito.isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    myWebServerSessionSpy.onOpen(sessionDummy);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "pause");
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
    commandFromClient.addProperty("command", "update");
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
  }


  /**
   * A more indepth attempt to use most of update.
   */
  @Test
  public void testVisualizationUpdate3() throws IOException {
    MyWebServer myWMock = mock(MyWebServer.class);
    ConfigManager cuMock = mock(ConfigManager.class);
    MyWebServerSession mySMock = mock(MyWebServerSession.class);
    VisualizationSimulator mysim = new VisualizationSimulator(myWMock, cuMock, mySMock);
    List<Integer> time = new ArrayList<>();
    time.add(3);
    time.add(1);
    time.add(10);
    time.add(16);
    mysim.setTimeSinceLastBus(time);


    Stop stop1 = new Stop(0, 44.972392, -93.243774);
    Stop stop2 = new Stop(1, 44.973580, -93.235071);
    Stop stop3 = new Stop(2, 44.975392, -93.226632);
    List<Stop> stopsIn = new ArrayList<Stop>();
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    stopsIn.add(stop3);
    List<Double> distancesIn = new ArrayList<Double>();
    distancesIn.add(0.008784);
    distancesIn.add(0.008631);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.15);
    probabilitiesIn.add(0.3);
    probabilitiesIn.add(.025);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(probabilitiesIn, stopsIn);
    Route testRouteIn = new Route("testRouteIn", stopsIn, distancesIn, 3, generatorIn);
    List<Stop> stopsOut = new ArrayList<>();
    stopsOut.add(stop3);
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.008631);
    distancesOut.add(0.008784);
    List<Double> probabilitiesOut = new ArrayList<>();
    probabilitiesOut.add(.025);
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.15);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(probabilitiesOut, stopsOut);
    Route testRouteOut = new Route("testRouteIn", stopsOut, distancesOut, 3, generatorOut);
    Bus bus = new Bus("TestBus", testRouteOut, testRouteIn, 5, 1);
    Bus bus1 = new Bus("Testy", testRouteOut, testRouteIn, 5, 1);

    List<Bus> newlist = new ArrayList<>();
    newlist.add(bus);
    newlist.add(bus1);
    mysim.setBusses(newlist);

    List<Route> getDone = new ArrayList<>();
    Route holder = TestUtils.createRoute();
    getDone.add(holder);
    mysim.setPrototypeRoutes(getDone);

    mysim.update();


  }

  /**
   * testing the pause feature toggle.
   */
  @Test
  public void testVisualizationPause() throws IOException {
    MyWebServerSession myWebServerSessionSpy = spy(MyWebServerSession.class);
    doNothing().when(myWebServerSessionSpy).sendJson(Mockito.isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    myWebServerSessionSpy.onOpen(sessionDummy);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "pause");
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
    commandFromClient.addProperty("command", "pause");
    myWebServerSessionSpy.onMessage(commandFromClient.toString());
  }

  /**
   *  Testing the start of the visualization.
   */
  @Test
  public void startVisualizationTest() {
    MyWebServer myWock = mock(MyWebServer.class);
    ConfigManager ceMy = new ConfigManager();
    MyWebServerSession myMock = mock(MyWebServerSession.class);
    VisualizationSimulator mysim = new VisualizationSimulator(myWock, ceMy, myMock);
    List<Integer> listy = new ArrayList<>();
    listy.add(1);
    listy.add(2);
    mysim.start(listy, 10);
    List<Route> list = new ArrayList<>();
    List<StopData> configure = new ArrayList<>();
    StopData bob = new StopData("0", new Position(44.972392, -93.243774), 5);
    configure.add(bob);
    RouteData holder = new RouteData();
    holder.setId("hippo");
    holder.setStops(configure);
    Route hagrid = TestUtils.createRoute();
    list.add(hagrid);
    ceMy.setRoutes(list);
    mysim.start(listy, 10);
    assertEquals(2, listy.size());


  }

  /**
   * Testing the correct command.
   */
  @Test
  public void testVisualizationStart() {
    MyWebServerSession myWebServerSessionSpy = spy(MyWebServerSession.class);
    doNothing().when(myWebServerSessionSpy).sendJson(Mockito.isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    myWebServerSessionSpy.onOpen(sessionDummy);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "start");
  }

  /**
   *  testing adding bus observers.
   */
  @Test
  public void addBusObserverTest() {

    Stop stop1 = new Stop(0, 44.972392, -93.243774);
    Stop stop2 = new Stop(1, 44.973580, -93.235071);
    Stop stop3 = new Stop(2, 44.975392, -93.226632);
    List<Stop> stopsIn = new ArrayList<Stop>();
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    stopsIn.add(stop3);
    List<Double> distancesIn = new ArrayList<Double>();
    distancesIn.add(0.008784);
    distancesIn.add(0.008631);
    List<Double> probabilitiesIn = new ArrayList<Double>();
    probabilitiesIn.add(.15);
    probabilitiesIn.add(0.3);
    probabilitiesIn.add(.025);
    PassengerGenerator generatorIn = new RandomPassengerGenerator(probabilitiesIn, stopsIn);
    Route testRouteIn = new Route("testRouteIn", stopsIn, distancesIn, 3, generatorIn);
    List<Stop> stopsOut = new ArrayList<>();
    stopsOut.add(stop3);
    stopsOut.add(stop2);
    stopsOut.add(stop1);
    List<Double> distancesOut = new ArrayList<>();
    distancesOut.add(0.008631);
    distancesOut.add(0.008784);
    List<Double> probabilitiesOut = new ArrayList<>();
    probabilitiesOut.add(.025);
    probabilitiesOut.add(0.3);
    probabilitiesOut.add(.15);
    PassengerGenerator generatorOut = new RandomPassengerGenerator(probabilitiesOut, stopsOut);
    Route testRouteOut = new Route("testRouteIn", stopsOut, distancesOut, 3, generatorOut);
    Bus bus = new Bus("TestBus", testRouteOut, testRouteIn, 5, 1);

    MyWebServer myS = mock(MyWebServer.class);
    ConfigManager ceM = mock(ConfigManager.class);
    MyWebServerSession myW = mock(MyWebServerSession.class);
    VisualizationSimulator mysim = new VisualizationSimulator(myS, ceM, myW);
    Bus testBus = TestUtils.createBus();
    Bus testBus1 = TestUtils.createSmallBus();
    List<Bus> ok = new ArrayList<>();
    ok.add(bus);
    ok.add(testBus);
    ok.add(testBus1);
    mysim.setBusses(ok);
    mysim.addBusObserver("1000");
    mysim.addBusObserver("TestBus");
    assertEquals(5, bus.getCapacity());
  }

  /**
   * testing stop Observer.
   */
  @Test
  public void testStopObserver() {
    MyWebServer myW = mock(MyWebServer.class);
    ConfigManager ceMy = mock(ConfigManager.class);
    MyWebServerSession myS = mock(MyWebServerSession.class);
    VisualizationSimulator mysim = new VisualizationSimulator(myW, ceMy, myS);
    List<StopData> configure = new ArrayList<>();
    StopData bob = new StopData("0", new Position(44.972392, -93.243774), 5);
    configure.add(bob);
    List<Stop> stopsIn = new ArrayList<Stop>();
    Stop stop1 = new Stop(0, 44.972392, -93.243774);
    Stop stop2 = new Stop(1, 44.973580, -93.235071);
    Stop stop3 = new Stop(2, 44.975392, -93.226632);
    stopsIn.add(stop1);
    stopsIn.add(stop2);
    stopsIn.add(stop3);

    List<Route> list = new ArrayList<>();
    List<Double> no = new ArrayList<>();
    no.add(2.0);
    no.add(3.0);
    Route holder = TestUtils.createRoute();
    String x = holder.getName();
    list.add(holder);
    mysim.setPrototypeRoutes(list);
    mysim.addStopObserver("1000");
    mysim.addStopObserver("2");

  }

}
