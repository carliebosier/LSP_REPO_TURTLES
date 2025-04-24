package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages tasks by allowing adding, retrieving, updating, and printing grouped by status.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task if the name is unique.
     *
     * @param name     the name of the task
     * @param priority the priority of the task
     * @param status   the status of the task 
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by name.
     *
     * @param name the name of the task
     * @return the Task object
     * @throws TaskNotFoundException if the task does not exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name   the name of the task
     * @param status the new status 
     * @throws TaskNotFoundException if the task does not exist
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their current status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        Map<String, List<Task>> grouped = new HashMap<>();
        grouped.put("TODO", new ArrayList<>());
        grouped.put("IN_PROGRESS", new ArrayList<>());
        grouped.put("DONE", new ArrayList<>());

        for (Task task : tasks.values()) {
            grouped.get(task.getStatus()).add(task);
        }

        for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            for (Task task : grouped.get(status)) {
                System.out.println("  " + task);
            }
        }
    }
}

