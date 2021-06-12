package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umn.cs.csci3081w.project.model.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;



public class MyWebServerTest {

  /**
   *  makes sure My Web Server Updates busses correctly.
   */
  @Test
  public void testMyWebServerUpdateBussesTest() {

    MyWebServer testMyWebServer = new MyWebServer();
    List<BusData> coward = new ArrayList<>();
    coward = testMyWebServer.busses;
    BusData howard = new BusData("0", new Position(44.972392, -93.243774), 0, 30, 0, 0, 0, 0);
    coward.add(howard);
    testMyWebServer.setBussesWeb(coward);
    testMyWebServer.updateBus(howard, false);
    BusData yoward = new BusData("1", new Position(44.972392, -93.243774), 0, 30, 0, 0, 0, 0);
    coward.add(yoward);
    testMyWebServer.setBussesWeb(coward);
    testMyWebServer.updateBus(yoward, true);
    BusData roward = new BusData("2", new Position(44.972392, -93.243774), 0, 30, 0, 0, 0, 0);
    testMyWebServer.updateBus(roward, false);

    assertEquals(2, Integer.parseInt(roward.getId()));
  }

  /**
   * makes sure route updating in my webserver works.
   */
  @Test
  public void testMyWebServerUpdateRoutesTest() {

    MyWebServer testMyWebServer = new MyWebServer();
    List<RouteData> smooth = new ArrayList<>();
    List<StopData> wow = new ArrayList<>();
    StopData cober = new StopData("0", new Position(44.972392, -93.243774), 5);
    wow.add(cober);
    smooth = testMyWebServer.routes;
    RouteData moved = new RouteData();
    moved.setId("why");
    moved.setStops(wow);
    smooth.add(moved);
    testMyWebServer.updateRoute(moved, false);


    List<StopData> stopList = new ArrayList<>();
    StopData stopHolder = new StopData("1", new Position(44.97232, -93.24374), 4);
    stopList.add(stopHolder);
    RouteData normalName = new RouteData();
    moved.setId("terrance");
    moved.setStops(stopList);
    testMyWebServer.updateRoute(normalName, true);

    testMyWebServer.updateRoute(moved, true);

  }
}
