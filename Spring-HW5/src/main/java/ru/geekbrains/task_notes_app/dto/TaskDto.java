package ru.geekbrains.task_notes_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import ru.geekbrains.task_notes_app.models.Status;

import java.time.LocalDateTime;

/**
 * Объект dto для задач.
 */
@Data
public class TaskDto {
    /**
     * Уникальный идентификатор задачи.
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    /**
     * Описание задачи.
     */
    @NotEmpty(message = "Описание не может быть пустым!")
    private String description;
    /**
     * Время создания задачи.
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreation;
    /**
     * Статус задачи.
     */
    private Status status;
}
