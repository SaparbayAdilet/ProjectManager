package kz.adilet.projectmanager.controller;

import kz.adilet.projectmanager.entity.Task;
import kz.adilet.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService tService;

    @GetMapping("/task")
    public List<Task> getAll() {
        return tService.view();
    }

    @GetMapping("/task/{id}")
    public Task getById(@PathVariable Long id){
        return tService.get(id);
    }

    @PostMapping("/task")
    public void create(@RequestBody Task task) {
        tService.create(task);
    }

    @PutMapping("/task/{id}")
    public void update(@RequestBody Task task, @PathVariable Long id) {
        tService.edit(task, id);
    }

    @DeleteMapping("task/{id}")
    public void delete(@PathVariable Long id) {
        tService.delete(id);
    }
}
