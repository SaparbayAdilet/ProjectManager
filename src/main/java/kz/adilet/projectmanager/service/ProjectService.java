package kz.adilet.projectmanager.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import kz.adilet.projectmanager.dto.ProjectDto;
import kz.adilet.projectmanager.entity.Project;
import kz.adilet.projectmanager.entity.QProject;
import kz.adilet.projectmanager.repository.ProjectRepository;
import kz.adilet.projectmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private EntityManager entityManager;

    public List<Project> view() {
        return projectRepo.findAll();
    }
    public Project get(Long id) {
        return  projectRepo.getById(id);
    }
    public void create(Project project){
        projectRepo.save(project);
    }
    public void edit(Project newProject, Long id) {
        Project oldProject = projectRepo.findById(id).orElseThrow(()->new RuntimeException("Not found by id"));
        oldProject.setName(newProject.getName());
        oldProject.setDateStart(newProject.getDateStart());
        oldProject.setDateEnd(newProject.getDateEnd());
        oldProject.setStatus(newProject.getStatus());
        oldProject.setPriority(newProject.getPriority());
        projectRepo.save(oldProject);
    }
    public void delete(Long id){
        taskRepository.deleteByProjectId(id);
        projectRepo.deleteById(id);

    }
    public List<Project> filter(ProjectDto dto){
        JPAQuery<Project> jpaQuery = new JPAQuery<>(entityManager);
        BooleanBuilder where = new BooleanBuilder();
        QProject qProject = QProject.project;
        if(dto.getName() != null) {
            where.and(qProject.name.eq(dto.getName()));
        }

        jpaQuery.select(Projections.fields(Project.class, qProject.name)).from(qProject).where(where);
     return jpaQuery.fetch();
    }



}
