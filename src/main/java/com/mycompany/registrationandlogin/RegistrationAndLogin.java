/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.*;

import javax.swing.*;
import java.util.ArrayList;

public class RegistrationAndLogin {

    private static User currentUser;
    private static TaskFeatures taskManager = new TaskFeatures();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome! Choose an option:",
                    "Registration and Login",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {
                registerUser();
            } else if (choice == 1) {
                if (loginUser()) {
                    userMenu();
                }
            } else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }
        }
    }

    private static void registerUser() {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter a username with an underscore and no more than 5 characters:");
            if (username == null) return; // User canceled

            if (!username.contains("_") || username.length() > 5) {
                JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
                continue;
            }

            String password = JOptionPane.showInputDialog("Enter a password with at least 8 characters, a capital letter, a number, and a special character:");
            if (password == null) return; // User canceled

            if (!isValidPassword(password)) {
                JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
                continue;
            }

            String firstName = JOptionPane.showInputDialog("Enter your first name:");
            if (firstName == null) return;

            String lastName = JOptionPane.showInputDialog("Enter your last name:");
            if (lastName == null) return;

            currentUser = new User(username, password, firstName, lastName);
            JOptionPane.showMessageDialog(null, "Account successfully created!");
            break;
        }
    }

    private static boolean loginUser() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "No account found. Please register first.");
            return false;
        }

        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username == null) return false;

        String password = JOptionPane.showInputDialog("Enter your password:");
        if (password == null) return false;

        if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
            JOptionPane.showMessageDialog(null, "Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            return false;
        }
    }

    private static void userMenu() {
        while (true) {
            String[] options = {"Add Tasks", "Show Task Report", "View Longest Task", "Log Out", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "What would you like to do?",
                    "User Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0 -> addTasks();
                case 1 -> JOptionPane.showMessageDialog(null, taskManager.generateReport());
                case 2 -> JOptionPane.showMessageDialog(null, taskManager.getLongestTask());
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "Logging out...");
                    return;
                }
                case 4, JOptionPane.CLOSED_OPTION -> {
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                }
            }
        }
    }

    private static void addTasks() {
        String input = JOptionPane.showInputDialog("How many tasks would you like to add?");
        if (input == null) return;

        int numTasks;
        try {
            numTasks = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number. Please try again.");
            return;
        }

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            if (taskName == null) return;

            String developer = JOptionPane.showInputDialog("Enter developer details:");
            if (developer == null) return;

            String taskID = JOptionPane.showInputDialog("Enter task ID:");
            if (taskID == null) return;

            String durationInput = JOptionPane.showInputDialog("Enter task duration (in hours):");
            if (durationInput == null) return;

            int duration;
            try {
                duration = Integer.parseInt(durationInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration. Task skipped.");
                continue;
            }

            String[] statuses = {"To Do", "Done", "Doing"};
            int statusIndex = JOptionPane.showOptionDialog(
                    null,
                    "Select task status:",
                    "Task Status",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    statuses,
                    statuses[0]
            );

            if (statusIndex == JOptionPane.CLOSED_OPTION) return;

            taskManager.addTask(developer, taskName, taskID, duration, statusIndex + 1);
            JOptionPane.showMessageDialog(null, "Task added successfully!");
        }
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}

class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class TaskFeatures {
    private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    private String getStatusString(int status) {
        return switch (status) {
            case 1 -> "To Do";
            case 2 -> "Done";
            case 3 -> "Doing";
            default -> "Unknown";
        };
    }

    public void addTask(String developer, String taskName, String taskID, int duration, int status) {
        developers.add(developer);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(duration);
        taskStatuses.add(getStatusString(status));
    }

    public String getLongestTask() {
        if (taskDurations.isEmpty()) return "No tasks available.";
        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return "Developer: " + developers.get(maxIndex) + ", Duration: " + taskDurations.get(maxIndex) + " hours.";
    }

    public String generateReport() {
        if (taskNames.isEmpty()) return "No tasks available.";
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task Name: ").append(taskNames.get(i))
                    .append("\nDeveloper: ").append(developers.get(i))
                    .append("\nTask ID: ").append(taskIDs.get(i))
                    .append("\nDuration: ").append(taskDurations.get(i))
                    .append("\nStatus: ").append(taskStatuses.get(i))
                    .append("\n\n");
        }
        return report.toString();
    }
}




    

  
