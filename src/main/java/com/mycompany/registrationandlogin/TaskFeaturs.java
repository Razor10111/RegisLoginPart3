/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */

public class TaskFeaturs {
    public final class Task {
    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskID;
    private final String taskStatus;

    // Constructor
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus;
    }

    // Method to check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create task ID
    public String createTaskID() {
        String TaskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskID;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\nDeveloper Details: " + developerDetails + "\nTask Number: " + taskNumber + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription + "\nTask ID: " + taskID + "\nDuration: " + taskDuration + " hours";
    }

    // Method to return total hours
    public int returnTotalHours() {
        return taskDuration;
    }
}
    class Tasks{
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Tasks(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUsername() {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity() {
        if (password.length() >= 8 &&
                password.matches(".[A-Z].") &&
                password.matches(".[0-9].") &&
                password.matches(".[!@#$%^&(),.?\":{}|<>].*")) {
            return true;
        } else {
            return false;
        }
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



    private static ArrayList<Task> tasks = new ArrayList<>();

    public static class Task {
        private String name;
        private String description;
        private String developer;
        private int duration;
        private String status;

        public Task(String name, String description, String developer, int duration, String status) {
            this.name = name;
            this.description = description;
            this.developer = developer;
            this.duration = duration;
            this.status = status;
        }

        public boolean isDescriptionValid() {
            return description.length() < 50;
        }

        public String getDetails() {
            return "Task Name: " + name +
                    "\nDescription: " + description +
                    "\nDeveloper: " + developer +
                    "\nDuration: " + duration + " hours" +
                    "\nStatus: " + status;
        }

        public int getDuration() {
            return duration;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        showOptionsMenu();
    }

    public static void showOptionsMenu() {
        int choice;

        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Add tasks\n2. Show all tasks\n3. Search for task\n4. Delete task\n5. Longest task\n6. Quit"));

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    displayAllTasks();
                    break;
                case 3:
                    searchTaskByName();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    displayLongestTask();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void addTask() {
        try {
            String name = JOptionPane.showInputDialog("Enter task name");
            String description = JOptionPane.showInputDialog("Enter task description (less than 50 characters)");
            String developer = JOptionPane.showInputDialog("Enter developer details");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration"));
            String status = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing)");

            Task newTask = new Task(name, description, developer, duration, status);

            if (newTask.isDescriptionValid()) {
                tasks.add(newTask);
                JOptionPane.showMessageDialog(null, "Task successfully captured!");
            } else {
                JOptionPane.showMessageDialog(null, "Task description must be less than 50 characters.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values where required.");
        }
    }

    public static void displayAllTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder allTasks = new StringBuilder();
        for (Task task : tasks) {
            allTasks.append(task.getDetails()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, allTasks.toString());
    }

    public static void searchTaskByName() {
        String searchName = JOptionPane.showInputDialog("Enter the task name to search for");
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(searchName)) {
                JOptionPane.showMessageDialog(null, task.getDetails());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    public static void deleteTask() {
        String deleteName = JOptionPane.showInputDialog("Enter the task name to delete");
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equalsIgnoreCase(deleteName)) {
                tasks.remove(i);
                JOptionPane.showMessageDialog(null, "Task successfully deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    public static void displayLongestTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.getDuration() > longestTask.getDuration()) {
                longestTask = task;
            }
        }

        JOptionPane.showMessageDialog(null, "Longest Task:\n" + longestTask.getDetails());
    }
    class TaskManager {
    private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    public void addTask(String developer, String taskName, String taskID, int duration, int status) {
        developers.add(developer);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(duration);
        taskStatuses.add(getStatusString(status));
    }

    private String getStatusString(int status) {
        return switch (status) {
            case 1 -> "To Do";
            case 2 -> "Done";
            case 3 -> "Doing";
            default -> "Unknown";
        };
    }

    public String getLongestTask() {
        if (taskDurations.isEmpty()) return "No tasks available.";
        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return "Longest Task - Developer: " + developers.get(maxIndex) + ", Duration: " + taskDurations.get(maxIndex) + " hours.";
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
}
