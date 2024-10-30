/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
/**
 *
 * @author RC_Student_lab
 */
public class RegistrationAndLogin {
    static String name;
    static String surname;
    static String userName;
    static String Password;
    static String Password2;
    static String user2;

    public static void main(String[] args) {
        EnterUserDetails();
        CheckUserName();
        registerUser();
        loginUser();
        returnLoginStatus(true);
    }

    public static boolean EnterUserDetails() {
        name = JOptionPane.showInputDialog("Name");
        surname = JOptionPane.showInputDialog("Surname");
        return true;
    }

    public static boolean CheckUserName() {
        userName = JOptionPane.showInputDialog("UserName");
        
        if (userName.contains("_") ) {
            JOptionPane.showMessageDialog(null, "Username successfully created");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correct.");
            return false;
        }
    }

    public static boolean CheckPasswordComplexity() {
        Password = JOptionPane.showInputDialog("Password");
        
        return Password.length() >= 8 &&
               Password.matches(".*[A-Z].*") &&
               Password.matches(".*[0-9].*") &&
               Password.matches(".*[@#$%&*].*");
    }

    public static String registerUser() {
        if (!CheckPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "Password is not correct. Ensure it meets complexity requirements.");
            return null;
        } else {
            JOptionPane.showMessageDialog(null, "Password is correct");
            return Password;
        }
    }

    public static boolean loginUser() {
        user2 = JOptionPane.showInputDialog("Enter your Username");
        
        if (!user2.equals(userName)) {
            JOptionPane.showMessageDialog(null, "Username does not match");
            return false;
        }

        Password2 = JOptionPane.showInputDialog("Enter your Password");
        
        if (!Password.equals(Password2)) {
            JOptionPane.showMessageDialog(null, "Password does not match");
            return false;
        }

        JOptionPane.showMessageDialog(null, "You have successfully logged in to your profile");
        return true;
    }

    public static boolean returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome, " + name + " " + surname + "! It is good to see you again.");
            showOptionsMenu();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect login details. Try again.");
            return false;
        }
    }

    public static void showOptionsMenu() {
        int choice;
        
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog("1. Add tasks\n2. Show report\n3. Quit"));
            
            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks"));
        TaskFeaturs[] tasks = new TaskFeaturs[numTasks];
        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (less than 50 characters)");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration"));
            int taskStatus = Integer.parseInt(JOptionPane.showInputDialog("Enter task status (1 for To Do, 2 for Done, 3 for Doing)"));

            TaskFeaturs task = new TaskFeaturs(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            
            if (task.checkTaskDescription()) {
                tasks[i] = task;
                totalHours += task.getDuration();
                JOptionPane.showMessageDialog(null, "Task successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                i--;  // Retry this task entry
            }
        }

        displayTaskDetails(tasks, totalHours);
    }

    public static void displayTaskDetails(TaskFeaturs[] tasks, int totalHours) {
        StringBuilder taskDetails = new StringBuilder();

        for (TaskFeaturs task : tasks) {
            if (task != null) {
                taskDetails.append(task.printTaskDetails()).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, taskDetails.toString());
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
    }
}