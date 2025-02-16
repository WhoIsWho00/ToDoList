package lesson1.code1.appStructure2.back.service;
//
//import lesson_02.code.appStructireVar2.back.dto.ResponseDto;
//import lesson_02.code.appStructireVar2.back.entity.Task;
//import lesson_02.code.appStructireVar2.back.repository.TaskInMemory;

import lesson1.code1.appStructure2.back.dto.ResponseDto;
import lesson1.code1.appStructure2.back.entity.Task;
import lesson1.code1.appStructure2.back.repository.TaskInMemory;

public class DeleteTaskService {
    private TaskInMemory repository;

    public DeleteTaskService(TaskInMemory repository) {
        this.repository = repository;
    }

    public ResponseDto<Task> deleteTaskById(Integer id){
        return null; // переписать это метод
    }
}
