package ru.geekbrains.task_notes_app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.geekbrains.task_notes_app.exception.TaskNotFoundException;


/**
 * Класс перехватывающий исключения и возвращающий их на фронт.
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * Обработка исключения при отсутствии задачи.
     * @param e объект исключения.
     * @return ответ с ошибкой.
     */
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerTaskNotFound(TaskNotFoundException e){
        return e.getMessage();
    }
}
