/**
 * Provides logging functionality for the scheduler application.
 * 
 * The Logger class is responsible for writing log messages to a file named "scheduler.log".
 * It supports logging messages at the "INFO" and "ERROR" levels.
 */

package com.scheduler.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "scheduler.log";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logInfo(String message) {
        log("INFO", message);
    }

    public static void logError(String message) {
        log("ERROR", message);
    }

    private static void log(String level, String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.printf("%s [%s]: %s%n", LocalDateTime.now().format(dtf), level, message);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}
