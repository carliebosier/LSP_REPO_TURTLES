package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a task is not found by name.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
