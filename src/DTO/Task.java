package DTO;

public class Task {
    private int taskId;
    private String taskName;
    private TaskStatus taskStatus;
    private String deadLine;

    private static int taskAutoId = 0;

    public Task(int taskId, String taskName, TaskStatus taskStatus, String deadLine) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.deadLine = deadLine;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

//    public String gettaskStatus(){
//        return String.valueOf(taskStatus);
//    }

    public String getTaskDeadline() {
        return deadLine;
    }

    public static int getTaskAutoId() {
        taskAutoId++;
        return taskAutoId;
    }

    public void completeTask(){
        this.taskStatus = TaskStatus.COMPLETED;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
