package kz.adilet.projectmanager.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.adilet.projectmanager.entity.enumuration.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "task")
public class Task {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    TaskStatus status;
    Integer priority;
    @ManyToOne
    @JoinColumn(name = "project_id",updatable = false,insertable = false)
    @JsonIgnore
    Project project;

    @Column(name = "project_id")
    Long projectId;

}
