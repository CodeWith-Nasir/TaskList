package org.example;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Menu menu = new Menu(taskList);
        menu.displayMenu();
        menu.closeScanner();
    }
}