package kz.adilet.projectmanager.controller;

import kz.adilet.projectmanager.dto.ProjectDto;
import kz.adilet.projectmanager.entity.Project;
import kz.adilet.projectmanager.service.ProjectService;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService pService;

    @GetMapping("/project")
    public List<Project> getAll() {
        return pService.view();
    }

    @GetMapping("/project/{id}")
    public Project getById(@PathVariable Long id){
        return pService.get(id);
    }

    @PostMapping("/project")
    public void create(@RequestBody Project project) {
        pService.create(project);
    }

    @PutMapping("/project/{id}")
    public void update(@RequestBody Project project, @PathVariable Long id) {
        pService.edit(project, id);
    }

    @DeleteMapping("project/{id}")
    public void delete(@PathVariable Long id) {
        pService.delete(id);

    }
    @PostMapping("/project/filter")
    public List<Project> filter(@RequestBody ProjectDto dto) {
        return pService.filter(dto);
    }
}
