package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.Stop;
import javax.websocket.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class StartCommandTest {
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
   * attempted to use the start test.
   */
  @Test
  public void testStart() {
    MyWebServerSession myWebServerSessionMock = spy(MyWebServerSession.class);
    MyWebServerSessionState myWebServerSessionState = spy(MyWebServerSessionState.class);
    JsonObject barry = new JsonObject();
    barry.addProperty("hi", "start");
    StartCommand startCommandMock = mock(StartCommand.class);
    startCommandMock.getMySimBusses();
    startCommandMock.getCurrentSimulationTime();
    assertEquals(0, startCommandMock.getNumTimeSteps());
    startCommandMock.execute(myWebServerSessionMock, barry, myWebServerSessionState);
    assertEquals(0, startCommandMock.getNumTimeSteps());

  }

}
