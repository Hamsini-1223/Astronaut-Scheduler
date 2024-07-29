/**
 * Manages notifications for users in the application.
 * Allows adding new notifications and notifying all users of the current notifications.
 */
package com.scheduler.service;

import java.util.ArrayList;
import java.util.List;

public class UserNotifier {
    private List<String> notifications;

    public UserNotifier() {
        notifications = new ArrayList<>();
    }

    public void addNotification(String notification) {
        notifications.add(notification);
    }

    public void notifyUsers() {
        notifications.forEach(System.out::println);
        notifications.clear();
    }
}
