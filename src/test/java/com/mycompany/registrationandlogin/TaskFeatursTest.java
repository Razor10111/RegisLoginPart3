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

    
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        String Description = "Create Login to authencate users";
        int num = 0;
        TaskFeatursTest instance = new TaskFeatursTest ();
        boolean expResult = true;
        boolean result = instance.testCheckTaskDescription(description);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        int taskDuration = 0;
        TaskFeatursTest instance = new TaskFeatursTest();
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
       
    }
     public void testCreateTaskID() {
        System.out.println("Create TaskID"); 
        String taskname = "add task feature";
        String developerDetails = "Mike Smith";
        int taskNumber = 0;
        TaskFeatursTest  instance = new TaskFeatursTest();
        String result = instance.testCreateTaskID (int taskNumber,String developerDetails);
        String expResult = "AD:1:ITH";
        assertEquals(expResult, result);
     }
    /**
     * Test of printTaskDetails method, of class TaskFeaturs.
     */
    @Test
    public void testPrintTaskDetails() {
        String taskStatus = "To Do";
        String developerDetails = "Robyn Harrison";
        int taskNumber = 0;
        String taskDescription  = "Create Login to authencitate users";
        String tasksID = "";
        int taskDuration = 8;
        String expResult = taskStatus + developerDetails + "0" + taskName + taskDescription
        TaskFeatursTest instance = new Tasks (taskNumber);
        
}
    @Test 
    public void testCreateTaskID2() {
        System.out.println("Create TaskID"); 
        String taskname = "add task feature";
        String developerDetails = "Mike Smith";
        int taskNumber = 0;
        TaskFeatursTest  instance = new TaskFeatursTest();
        String result = instance.printTaskDetails();
        String expResult = instance.testCreateTaskID2();
        assertEquals(expResult, result);
        
    }
    @Test
       public void testCheckTaskDescription2() {
        System.out.println("checkTaskDescription");
        String taskDescription = "Create Login to authencate users";
        TaskFeatursTest instance = new TaskFeatursTest();
        boolean expResult = false;
        boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
     }
    @Test
    public void testGetDuration2() {
        System.out.println("getDuration");
        int taskDuration = 0;
        TaskFeatursTest instance = new TaskFeatursTest();
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
     }

   
    @Test
    public void testPrintTaskDetails2() {
        System.out.println("printTaskDetails");
        int details = 0;
        TaskFeatursTest instance = new TaskFeatursTest();
        TaskFeatursTest instance = ;
        String expResult = "Task Status: Doing\n"+
                           "Developer Details: Mike Snitch\n"+
                           "Task Number:\n"+
                           "Task Name: Add Task Feature\n"+
                           "Task ID: AD:1:TTH\n"+ 
                           "Task Duration: 10hours";
        String result = instance.printTaskDetails(int details);
        assertEquals(expResult, result);
    }   
}

