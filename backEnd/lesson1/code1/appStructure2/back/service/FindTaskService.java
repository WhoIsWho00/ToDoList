package lesson1.code1.appStructure2.back.service;

import lesson1.code1.appStructure2.back.dto.ResponseDto;
import lesson1.code1.appStructure2.back.entity.Task;
import lesson1.code1.appStructure2.back.repository.TaskInMemory;

import java.util.List;
import java.util.Optional;

public class FindTaskService {
    private TaskInMemory repository;

    public FindTaskService(TaskInMemory repository) {
        this.repository = repository;
    }

    public ResponseDto<List<Task>> findAll(){

        List<Task> allTasks =  repository.findAll();
        String message = "";

        if (allTasks.isEmpty()) {
            message = "Список задач пуст";
            return new ResponseDto<>(205,allTasks,message);
        } else {
            return new ResponseDto<>(200,allTasks,message);
        }
    }


    public ResponseDto<Task> findById(Integer id){
        Optional<Task> foundedTask = repository.findById(id);
        String message = "";

        if (foundedTask.isPresent()) {
            return new ResponseDto<>(200,foundedTask.get(),message);
        } else {
            message = "Task with id = " + id + " not found";
            return new ResponseDto<>(404, null, message);
        }
    }

    public ResponseDto<List<Task>> findByName(String name){
        List<Task> foundedTasks = repository.findByName(name);
        String message = "";

        if (foundedTasks.isEmpty()) {
            message = "Tasks with name: " + name + " not found";
            return new ResponseDto<>(404,foundedTasks,message);
        } else {
            return new ResponseDto<>(200, foundedTasks, message);
        }
    }
}
