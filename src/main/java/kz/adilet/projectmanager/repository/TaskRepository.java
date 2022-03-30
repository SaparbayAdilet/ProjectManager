package kz.adilet.projectmanager.repository;

import kz.adilet.projectmanager.entity.Task;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.transaction.Transactional;

public interface TaskRepository extends JpaRepositoryImplementation<Task, Long > {
    @Transactional
    void deleteByProjectId(Long id);

}
