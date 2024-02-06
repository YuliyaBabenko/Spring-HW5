package ru.geekbrains.task_notes_app.exception;

/**
 * Исключение при отсутствии пользователя.
 */
public class TaskNotFoundException extends RuntimeException{
    /**
     * Конструктор родительского класса.
     * @param message сообщение об ошибке
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
