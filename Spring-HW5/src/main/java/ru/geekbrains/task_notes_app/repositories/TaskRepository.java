package ru.geekbrains.task_notes_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.task_notes_app.models.Status;
import ru.geekbrains.task_notes_app.models.Task;

import java.util.List;

/**
 * Репозиторий для сущности task.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получение списка задач по статусу задачи.
     * @param status статус задачи.
     * @return список задач.
     */
    List<Task> findByStatus(Status status);
}
