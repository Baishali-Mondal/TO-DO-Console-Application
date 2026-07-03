package DAO; //Data Access Object

import DTO.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskRepository {
    private static List<Task> taskDB = new ArrayList<>();    // static bcoz every repository object shares the same list i.e one Data Source

    public boolean addTask(Task task){
        return taskDB.add(task);
    }

    public List<Task> getTasks(){
        return taskDB;
    }

    public List<Task> updateTask(Task updatedTask){
        for(Task task : taskDB){
            if(task.getTaskId() == updatedTask.getTaskId()){
               task.setTaskName(updatedTask.getTaskName());
               task.setTaskStatus(updatedTask.getTaskStatus());
               task.setTaskDeadLine(updatedTask.getTaskDeadline());
               return taskDB;
            }
        }
        return taskDB;
    }

    public List<Task> deleteTask(int taskId){

        for(int i = 0; i<taskDB.size(); i++){
            if(taskDB.get(i).getTaskId() == taskId){
                taskDB.remove(i);
                break;
            }
        }
        return taskDB;
    }
}
