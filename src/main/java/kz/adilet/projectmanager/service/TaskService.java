package kz.adilet.projectmanager.service;
import kz.adilet.projectmanager.entity.Project;
import kz.adilet.projectmanager.entity.Task;
import kz.adilet.projectmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepo;

    public List<Task> view() {
        return taskRepo.findAll();
    }
    public Task get(Long id) {
        return  taskRepo.getById(id);
    }
    public void create(Task task){
        taskRepo.save(task);
    }
    public void edit(Task newTask, Long id) {
        Task oldTask = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found by id"));
        oldTask.setName(newTask.getName());
        oldTask.setDescription(newTask.getDescription());
        oldTask.setPriority(newTask.getPriority());
        oldTask.setStatus(newTask.getStatus());
        taskRepo.save(oldTask);
    }
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }



}
