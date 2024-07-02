package org.example;

import java.util.Scanner;

public class Menu {
    private TaskList taskList;
    private Scanner scanner;

    public Menu(TaskList taskList) {
        this.taskList = taskList;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n===TaskList Main Menu===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. View Task Statistics");
            System.out.println("6. Sort Tasks by Completion Status");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    taskList.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt();
                    taskList.removeTask(removeIndex - 1);
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    taskList.markTaskAsCompleted(completeIndex - 1);
                    break;
                case 4:
                    taskList.viewTasks();
                    break;
                case 5:
                    taskList.viewStatistics();
                    break;
                case 6:
                    taskList.sortTasksByCompletionStatus();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    public void closeScanner() {
        scanner.close();
    }
}
