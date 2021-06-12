package edu.umn.cs.csci3081w.project.webserver;

public final class SaveSimulationSingleton {

  private static SaveSimulationSingleton instance;
  public SaveSimulationData simData;

  /**
   * Singleton private constructor.
   */
  private SaveSimulationSingleton() {
    this.instance = null;
    this.simData = new SaveSimulationData();
  }

  /**
   * Returns a single instance of SaveSimulation, only one to be used throughout.
   */
  public static SaveSimulationSingleton getInstance() {
    if (instance == null) {
      instance = new SaveSimulationSingleton();
    }
    return instance;
  }
}
