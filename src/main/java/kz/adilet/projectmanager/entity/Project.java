package kz.adilet.projectmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.adilet.projectmanager.entity.enumuration.ProjectStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "project")
public class Project {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDateTime dateStart;
    LocalDateTime dateEnd;
    Integer priority;
    ProjectStatus status;

}
