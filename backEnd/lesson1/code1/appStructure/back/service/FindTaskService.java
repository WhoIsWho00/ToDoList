package lesson1.code1.appStructure.back.service;

import lesson1.code1.appStructure.back.entity.Task;
import lesson1.code1.appStructure.back.repository.TaskInMemory;

import java.util.List;
import java.util.Optional;

public class FindTaskService {
    private TaskInMemory repository;

    public FindTaskService(TaskInMemory repository){
        this.repository = repository;
    }

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task findById(Integer id){
        Optional<Task> foundedTask = repository.findById(id);

        if(foundedTask.isPresent()){
            return foundedTask.get();
        } else {
            return null;
        }
    }

    public List<Task> findByName(String name){
        return repository.findByName(name);
    }
}
