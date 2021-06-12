package edu.umn.cs.csci3081w.project.webserver;

import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.Route;
import edu.umn.cs.csci3081w.project.model.Stop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveSimulationData {

  public File csvFile;
  public FileWriter csvWriter;

  /**
   * Constructor for an object that saves data to csv file.
   */
  public SaveSimulationData() {
    csvFile = new File("SimulationUpdates.csv");
  }

  /**
   * Function that writes data to csv file, this csv file exists in the root folder of directory.
   *
   * @param timeElapsed integer based on time that is passed during simulation
   * @param busses      list of busses in simulation
   * @param routes      list of routes being used in simulation
   * @throws IOException if any errors occur on input or output streams
   */
  public void writeSimulationData(int timeElapsed, List<Bus> busses,
                                  List<Route> routes) throws IOException {

    FileWriter csvWriter = new FileWriter(csvFile.getName(), true);

    //Write Bus information first
    for (Bus i : busses) {
      csvWriter.append("BUS");
      csvWriter.append(",");
      csvWriter.append(String.valueOf(timeElapsed));
      csvWriter.append(",");
      csvWriter.append(i.getBusData().getId());
      csvWriter.append(",");
      csvWriter.append(Double.toString(i.getBusData().getPosition().getXcoordLoc()));
      csvWriter.append(",");
      csvWriter.append(Double.toString(i.getBusData().getPosition().getYcoordLoc()));
      csvWriter.append(",");
      csvWriter.append(String.valueOf(i.getNumPassengers()));
      csvWriter.append(",");
      csvWriter.append(String.valueOf(i.getCapacity()));
      csvWriter.append("\n");
    }

    // Write route information second
    for (Route j : routes) {
      for (Stop k : j.getStops()) {
        csvWriter.append("STOP");
        csvWriter.append(",");
        csvWriter.append(String.valueOf(timeElapsed));
        csvWriter.append(",");
        csvWriter.append(String.valueOf(k.getId()));
        csvWriter.append(",");
        csvWriter.append(Double.toString(k.getLongitude()));
        csvWriter.append(",");
        csvWriter.append(Double.toString(k.getLatitude()));
        csvWriter.append(",");
        csvWriter.append(String.valueOf(k.getNumPassengersPresent()));
        csvWriter.append("\n");
      }
    }
    //Flush and Close the csvWriter
    csvWriter.flush();
    csvWriter.close();
  }
}
