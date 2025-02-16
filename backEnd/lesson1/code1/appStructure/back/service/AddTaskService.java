package lesson1.code1.appStructure.back.service;

import lesson1.code1.appStructure.back.entity.Task;
import lesson1.code1.appStructure.back.repository.TaskInMemory;

public class AddTaskService {

    private TaskInMemory repository;

    public AddTaskService(TaskInMemory repository){
        this.repository = repository;
    }

    public Task addNewTask(String name, String description){
        Task newTask = new Task(name, description);
        Task savedTask = repository.add(newTask);
        return savedTask;
    }
}
