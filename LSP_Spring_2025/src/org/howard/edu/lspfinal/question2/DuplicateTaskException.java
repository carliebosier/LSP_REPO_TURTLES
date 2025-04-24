package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to add a task with a duplicate name.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}

