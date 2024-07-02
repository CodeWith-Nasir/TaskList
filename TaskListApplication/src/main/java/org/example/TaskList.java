package org.example;

public class TaskList {
    private String[] tasks = new String[100];
    private boolean[] isCompleted = new boolean[100];
    private int taskCount = 0;

    public void addTask(String task) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = task;
            isCompleted[taskCount] = false;
            taskCount++;
            System.out.println("Task added.");
        } else {
            System.out.println("Task list is full.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < taskCount) {
            for (int i = index; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
                isCompleted[i] = isCompleted[i + 1];
            }
            taskCount--;
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < taskCount) {
            isCompleted[index] = true;
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks[i] + " [" + (isCompleted[i] ? "Completed" : "Not Completed") + "]");
            }
        }
    }

    public void viewStatistics() {
        int completedCount = 0;
        for (int i = 0; i < taskCount; i++) {
            if (isCompleted[i]) {
                completedCount++;
            }
        }
        System.out.println("Total tasks: " + taskCount);
        System.out.println("Completed tasks: " + completedCount);
        System.out.println("Percentage completed: " + (taskCount == 0 ? 0 : (completedCount * 100 / taskCount)) + "%");
    }

    public void sortTasksByCompletionStatus() {
        for (int i = 0; i < taskCount - 1; i++) {
            for (int j = 0; j < taskCount - i - 1; j++) {
                if (isCompleted[j] && !isCompleted[j + 1]) {

                    String tempTask = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = tempTask;

                    boolean tempStatus = isCompleted[j];
                    isCompleted[j] = isCompleted[j + 1];
                    isCompleted[j + 1] = tempStatus;
                }
            }
        }
        System.out.println("Tasks sorted by completion status.");
    }
}
