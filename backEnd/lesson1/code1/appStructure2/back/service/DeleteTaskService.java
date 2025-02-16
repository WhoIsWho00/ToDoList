package lesson1.code1.appStructure2.back.service;

import lesson1.code1.appStructure2.back.dto.ResponseDto;
import lesson1.code1.appStructure2.back.entity.Task;
import lesson1.code1.appStructure2.back.repository.TaskInMemory;

public class DeleteTaskService {
    private TaskInMemory repository;
    private FindTaskService findTaskService;

    public DeleteTaskService(TaskInMemory repository, FindTaskService findTaskService) {
        this.repository = repository;
        this.findTaskService = findTaskService;
    }

    public ResponseDto<Task> deleteTaskById(Integer id) {
        System.out.println("Received delete request by id: " + id);

        ResponseDto<Task> response = findTaskService.findById(id);
        // провести проверку корректности данных
        if (response.getResponseCode() == 200 && response.getResponseInfo() != null) {
            repository.deleteById(id);
            return new ResponseDto<>(200, null, "Task successfully deleted");
        } else {
            return new ResponseDto<>(404, null, "Task with id = " + id + " not found");
        }
    }
}
