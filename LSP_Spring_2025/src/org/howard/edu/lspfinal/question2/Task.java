package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a name, priority, and status
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a Task object with the given name, priority, and status.
     *
     * @param name     the name of the task
     * @param priority the priority of the task
     * @param status   the status of the task 
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the name of the task.
     *
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the priority of the task.
     *
     * @return the task priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the current status of the task.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets a new status for the task.
     *
     * @param status the new status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task including its name, priority, and status.
     *
     * @return string representation of the task
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
