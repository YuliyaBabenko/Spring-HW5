package ru.geekbrains.task_notes_app.dto;

import org.springframework.stereotype.Component;
import ru.geekbrains.task_notes_app.models.Task;

/**
 * Маппер преобразования объектов dto в сущности и наоборот.
 */
@Component
public class DtoMapper {
    /**
     * Преобразование в dto.
     *
     * @param task объект задачи.
     * @return объект dto.
     */
    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setDateCreation(task.getDateCreation());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }

    /**
     * Преобразование в объект сущности.
     *
     * @param taskDto объект dto.
     * @return объект сущности.
     */
    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setDescription(taskDto.getDescription());
        task.setDateCreation(taskDto.getDateCreation());
        task.setStatus(taskDto.getStatus());
        return task;
    }
}
