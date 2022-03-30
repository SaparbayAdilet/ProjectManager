package kz.adilet.projectmanager.repository;

import kz.adilet.projectmanager.entity.Project;
import kz.adilet.projectmanager.entity.Task;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ProjectRepository extends JpaRepositoryImplementation<Project, Long> {
}
