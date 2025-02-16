package lesson1.code1.appStructure2.back.service;

import lesson1.code1.appStructure2.back.dto.RequestDto;
import lesson1.code1.appStructure2.back.dto.ResponseDto;
import lesson1.code1.appStructure2.back.entity.Task;
import lesson1.code1.appStructure2.back.repository.TaskInMemory;

public class AddTaskService {

    private TaskInMemory repository;
    private ValidationTaskService validationTaskService;

    public AddTaskService(TaskInMemory repository, ValidationTaskService validationTaskService) {
        this.repository = repository;
        this.validationTaskService = validationTaskService;
    }

    public ResponseDto<Task> addNewTask(RequestDto request){
        // выведем на экран информацию о полученном запросе

        System.out.println("Received request: " + request);

        // провести проверку корректности данных

        String message = validationTaskService.validate(request);

        if (message.isBlank()) {
            Task newTask = new Task(request.getName(), request.getDescription());
            Task savedTask = repository.add(newTask);
            return new ResponseDto<>(200, savedTask,message);
        } else {
            return new ResponseDto<>(400,null, message);
        }
    }
}
