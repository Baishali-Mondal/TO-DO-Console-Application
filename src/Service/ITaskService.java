package Service;

import DTO.Task;

import java.util.List;

//It's a contract - What can be done
public interface ITaskService {

    public List<Task> getTasks();

    public boolean addTask(Task task);

    public List<Task> updateTask(Task task);

    public List<Task> deleteTask(int taskId);
}
