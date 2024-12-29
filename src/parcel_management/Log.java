package parcel_management;

import java.io.*;


public class Log {
    private static Log instance;
    private StringBuilder log;
    private Log() {
        log = new StringBuilder();
    }
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }
    public void addEvent(String event) {
        log.append(event).append("\n");
    }
    public String getLog() {
        return log.toString();
    }
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
