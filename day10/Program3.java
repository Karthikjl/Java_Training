package com.celcom.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
	String taskName;
	boolean taskStatus;

	Task(String taskName, boolean taskStatus) {
		this.taskName = taskName;
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		String taskVal = taskStatus ? "Completed" : "Pending";
		return taskName + "\t" + taskVal;
	}

}

class TaskManager {

	List<Task> tasks = new ArrayList<Task>();

	// add task
	void addTask(Task task) {
		this.tasks.add(task);
		System.out.println("Task Added Sucessfully\n");
	}

	// view all task
	void viewAll() {
		if (tasks.isEmpty()) {
			System.out.println("Add some task to view.\n");
		} else {
			System.out.println("Task Name\tStatus");
			for (Task task : tasks) {
				System.out.println(task);
			}
			System.out.println();
		}
	}

	// delete task
	void deleteTask(String taskName) {
		Task taskToDelete = null;
		for (Task task : tasks) {
			if (task.taskName.equals(taskName)) {
				taskToDelete = task;
				break;
			}
		}
		if (taskToDelete != null) {
			tasks.remove(taskToDelete);
			System.out.println("Task Deleted Successfully\n");
		} else {
			System.out.println("Task not found.\n");
		}

	}

// mark task
	void markTaskCompleted(String taskName) {
		for (Task task : tasks) {
			if (task.taskName.equalsIgnoreCase(taskName)) {
				task.taskStatus = true;
				System.out.println("Task Marked as completed\n");
				return;
			}
		}
		System.out.println("Task not found.\n");
	}

	void searchTask(String taskName) {
		System.out.println("Task Name\tStatus");
		for (Task task : tasks) {
			if (task.taskName.equalsIgnoreCase(taskName)) {
				System.out.println(task);
				return;
			}
		}
		System.out.println("Task not found.\n");
	}
}

public class Program3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice;
		System.out.println("Task Manager\n");
		boolean isRunning = true;

		TaskManager taskManager = new TaskManager();
		Task task;

		while (isRunning) {

			System.out
					.println("1. Add Task\n2. View All\n3. Mark as Completed\n4. Delete Task\n5. Search Task\n6. Exit");
			System.out.print("Enter the choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {

			// Add task
			case 1:
				System.out.print("Enter task: ");
				task = new Task(scanner.nextLine(), false);
				taskManager.addTask(task);
				break;
			case 2:
				taskManager.viewAll();
				break;

			case 3:
				System.out.print("Enter task name: ");
				String completedTask = scanner.nextLine();
				taskManager.markTaskCompleted(completedTask);
				break;

			case 4:
				System.out.print("Enter task to delete: ");
				String deleteTask = scanner.nextLine();
				taskManager.deleteTask(deleteTask);
				break;
			case 5:
				System.out.print("Enter a task to search: ");
				taskManager.searchTask(scanner.nextLine());
				break;

			case 6:
				System.out.println("Exiting");
				isRunning = false;
				break;

			default:
				System.out.println("Enter a valid choice.");
			}

		}
		scanner.close();
	}

}
