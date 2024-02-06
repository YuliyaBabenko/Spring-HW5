package ru.geekbrains.task_notes_app.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.task_notes_app.exception.TaskNotFoundException;
import ru.geekbrains.task_notes_app.models.Status;
import ru.geekbrains.task_notes_app.models.Task;
import ru.geekbrains.task_notes_app.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сервис осуществляющий работу с задачами.
 */
@Service
@AllArgsConstructor
public class TaskServiceImpl implements iTaskService {

    private final TaskRepository taskRepository;

    /**
     * Создание новой задачи.
     *
     * @param task объект задачи.
     * @return созданную задачу.
     */
    public Task addTask(Task task) {
        task.setStatus(Status.NOT_STARTED);
        task.setDateCreation(LocalDateTime.now());
        taskRepository.save(task);
        return task;
    }

    /**
     * Обновление задачи.
     *
     * @param task объект задачи.
     */
    public Task updateTask(Long id, Task task) {
        Task taskForUpdate = getTask(id);
        if(task.getDescription() != null) {
            taskForUpdate.setDescription(task.getDescription());
        }
        if(task.getStatus() != null) {
            taskForUpdate.setStatus(task.getStatus());
        }
        return taskRepository.save(taskForUpdate);
    }

    /**
     * Удаление задачи.
     *
     * @param id уникальный идентификатор задачи.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Получение задачи.
     *
     * @param id уникальный идентификатор задачи.
     * @return объект задачи.
     */
    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task: " + id + " not found!"));
    }

    /**
     * Получение всех задач.
     *
     * @return список задач.
     */
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    /**
     * Получение задач по заданному статусу.
     *
     * @param status статус задачи.
     * @return список задач с заданным статусом.
     */
    public List<Task> getTaskFormStatus(Status status) {
        return taskRepository.findByStatus(status);
    }
}
