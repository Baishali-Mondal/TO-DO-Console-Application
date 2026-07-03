package Service;

import DAO.TaskRepository;
import DTO.Task;

import java.util.List;

//Implementation - how can be done
public class TaskService implements ITaskService {

//    private final TaskRepository taskRepository; //private-hide from other classes & final-It should never point to another Repository for this case

    TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    @Override
    public boolean addTask(Task task) {

        if(task.getTaskName().isBlank()){
            System.out.println("Task name can't be blank!");
            return false;
        }
        return taskRepository.addTask(task);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    @Override
    public List<Task> updateTask(Task task) {
        return taskRepository.updateTask(task);
    }

    @Override
    public List<Task> deleteTask(int taskId) {
    return taskRepository.deleteTask(taskId);
    }
}
