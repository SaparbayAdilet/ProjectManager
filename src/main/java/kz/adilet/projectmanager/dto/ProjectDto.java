package kz.adilet.projectmanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectDto {
    private String name;
    private LocalDateTime dateStartFrom;
    private LocalDateTime dateStartTo;

}
