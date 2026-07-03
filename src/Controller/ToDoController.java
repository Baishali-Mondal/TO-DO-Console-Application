package Controller;

import DTO.Task;
import DTO.TaskStatus;
import Service.ITaskService;
import Service.TaskService;

import java.util.*;
//import java.util.List;
//import java.util.Scanner;

public class ToDoController {

    private Scanner sc = new Scanner(System.in);
    ITaskService taskService = new TaskService();

    public void runToDoApp() {
        while (true) {
            showMenu();
            String userAction = getUserInput("Enter Input of your Choice : ");
            try {
                performAction(Integer.parseInt(userAction));
            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed!!");
            }
        }
    }


    private String getUserInput(String inputMessage) { //code reusuability
        System.out.print(inputMessage + " ");
        return sc.nextLine();
    }

    private void performAction(int action) {
        switch (action) {
            case 1:
                addTask();
                break;
            case 2:
                updateTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                getTasks();
                break;
            case 5:
                System.out.println("\nThank you for using TO DO application!!!!!");
                System.exit(0);
            default:
                System.out.println("\nIt's an Invalid Action. Please choose from 1-5 ");
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("           Welcome to the To-Do App");
        System.out.println("===============================================");
        System.out.println("Action Menu: ");
        System.out.println("1. Add a new Task");
        System.out.println("2. Update an existing Task");
        System.out.println("3. Delete an existing Task");
        System.out.println("4. List the Tasks available");
        System.out.println("5. Exit \n");
    }

    private boolean addTask() {
        String taskName = getUserInput("Enter the Task Name: ");
        String taskDeadline = getUserInput("Enter the Deadline (DD/MM/YYYY): ");

        Task task = new Task(
                Task.getTaskAutoId(),
                taskName,
                TaskStatus.PENDING,
                taskDeadline);

        boolean isAdded = taskService.addTask(task);

        if (isAdded) {
            System.out.println("Task Added Successfully!!");
        } else {
            System.out.println("No Task Added");
        }
        return isAdded;
    }

    private boolean deleteTask() {
        int id = getValidTaskId("Enter TaskId to be Deleted: ");
        taskService.deleteTask(id);

        System.out.println("\nTask Deleted Successfully!!");
        return true;
    }

    private boolean updateTask() {
        int id = getValidTaskId("Enter Task Id : ");

        String taskName = getUserInput("Enter New Task Name : ");

        System.out.println("1. PENDING");
        System.out.println("2. IN-PROGRESS");
        System.out.println("3. COMPLETED");

        int choice = Integer.parseInt(getUserInput("Enter the Updated Status : "));

        TaskStatus status;

            switch (choice) {
                case 1:
                    status = TaskStatus.PENDING;
                    break;
                case 2:
                    status = TaskStatus.IN_PROGRESS;
                    break;
                case 3:
                    status = TaskStatus.COMPLETED;
                    break;
                default:
                    System.out.println("Invalid Status");
                    return false;
            }


        String deadLine = getUserInput("Enter DeadLine");

        Task updatedTask = new Task(id, taskName, status, deadLine);

        taskService.updateTask(updatedTask);

        System.out.println("Task Updated Successfully!!");
        return true;
    }

    private void getTasks() {
        List<Task> tasks = taskService.getTasks();
        System.out.println("--------------------------------------------------------------");
        System.out.println("ID  " + "   |  " + "TASK" + "   |   " + "TASK STATUS" + "   |  " + "DEADLINE");
        System.out.println("--------------------------------------------------------------");
        for (Task task : tasks) {
            System.out.println(task.getTaskId() + " | "
                    + task.getTaskName() + " -- "
                    + task.getTaskStatus() + " -- "
                    + task.getTaskDeadline());
        }
    }

    private int getValidTaskId(String message) {
        while (true) {
            try {
                int id = Integer.parseInt(getUserInput(message));
                List<Task> tasks = taskService.getTasks();
                for (Task task : tasks) {
                    if (task.getTaskId() == id) {
                        return id;
                    }
                }
                System.out.println("Task ID does not exist.");
            } catch (NumberFormatException e) {
                System.out.println("Only numbers are allowed!!.. Please choose a valid Task Id");
            }
        }
    }
}
