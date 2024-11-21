/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */

public class TaskFeatursTest {

    private final TaskFeaturs taskFeatures = new TaskFeaturs();  // Instance of TaskFeaturs class

    // Test for checking task description validity
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        String description = "Create Login to authenticate users";
        boolean result = taskFeatures.checkTaskDescription(description);
        assertTrue(result, "Description should be valid");
    }

    // Test to get the task duration
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        // Add a task with a duration
        taskFeatures.addTask("Create Login", "Robyn Harrison", 1, "Create Login to authenticate users", 8);
        
        int result = taskFeatures.getDuration();
        assertEquals(8, result, "Task duration should be 8 hours");
    }

    // Test to create a task ID
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        String taskName = "Add Task Feature";
        String developerDetails = "Mike Smith";
        int taskNumber = 1;
        String result = taskFeatures.createTaskID(taskName, developerDetails, taskNumber);
        String expected = "AD:1:ITH";  // Expected Task ID
        assertEquals(expected, result, "Task ID format is incorrect");
    }

    // Test for printing task details
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        String taskStatus = "To Do";
        String developerDetails = "Robyn Harrison";
        int taskNumber = 1;
        String taskName = "Create Login";
        String taskDescription = "Create Login to authenticate users";
        String taskID = "CL:1:SON";
        int taskDuration = 8;

        String result = taskFeatures.printTaskDetails(
            taskStatus,
            developerDetails,
            taskNumber,
            taskName,
            taskDescription,
            taskID,
            taskDuration
        );

        String expected = "Task Status: To Do\n" +
                          "Developer Details: Robyn Harrison\n" +
                          "Task Number: 1\n" +
                          "Task Name: Create Login\n" +
                          "Task ID: CL:1:SON\n" +
                          "Task Duration: 8 hours\n" +
                          "Task Description: Create Login to authenticate users";

        assertEquals(expected, result, "Task details format is incorrect");
    }
    
    // Test for adding tasks
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        taskFeatures.addTask("Add New Feature", "John Doe", 1, "Adding new feature to the system", 5);
        
        String taskID = taskFeatures.getTaskID(1); // Assuming task number 1
        assertEquals("Task1", taskID, "Task ID should be 'Task1'");
    }
}

    


