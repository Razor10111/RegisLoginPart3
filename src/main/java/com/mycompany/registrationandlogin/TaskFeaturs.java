/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class TaskFeaturs{
    private String name;
    private String description;
    private String developer;
    private int duration;
    private int status;

    public TaskFeaturs(String name, String description, String developer, int duration, int status) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
    }

    public boolean checkTaskDescription() {
        return description.length() < 50;
    }

    public int getDuration() {
        return duration;
    }

    public String printTaskDetails() {
        return "Task Name: " + name + "\nDescription: " + description + "\nDeveloper: " + developer + "\nDuration: " + duration + " hours\nStatus: " + status;
    }
}