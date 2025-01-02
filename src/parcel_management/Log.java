package parcel_management;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<String> events; // For displaying in GUI
    private List<String> pendingEvents; // For file-writing
    private static Log instance;

    // Private constructor for Singleton
    private Log() {
        events = new ArrayList<>();
        pendingEvents = new ArrayList<>();
    }

    // Singleton pattern: Get instance
    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    // Add an event to the log
    public synchronized void addEvent(String event) {
        events.add(event);
        pendingEvents.add(event); // Keep it pending for file-writing
    }

    // Save log events to a file
    public synchronized void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (String event : pendingEvents) {
                writer.write(event + "\n");
            }
            pendingEvents.clear(); // Only clear the events already written to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Return log as a string (for display in GUI)
    @Override
    public synchronized String toString() {
        StringBuilder logText = new StringBuilder();
        for (String event : events) {
            logText.append(event).append("\n");
        }
        return logText.toString();
    }
}