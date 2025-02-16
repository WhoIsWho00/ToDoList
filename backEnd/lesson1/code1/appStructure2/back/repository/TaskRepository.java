package lesson1.code1.appStructure2.back.repository;

import lesson1.code1.appStructure2.back.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskInMemory {

    private List<Task> database;
    private Integer taskIdCounter = 0;

    public TaskRepository() {
        this.database = new ArrayList<>();
    }

    @Override
    public Task add(Task task) {
        // вариант 1
//        task.setTaskId(++taskIdCounter);
//        database.add(task);
//        return task;

        Task taskForSave = new Task(++taskIdCounter, task.getName(), task.getDescription());
        database.add(taskForSave);
        return taskForSave;

    }

    @Override
    public Optional<Task> findById(Integer id) {
        return database.stream()
                .filter(task -> task.getTaskId().equals(id))
                .findFirst();
    }

    @Override
    public List<Task> findByName(String name) {

        // вариант 1 с циклами
//        List<Task> foundedTask = new ArrayList<>();
//
//        for (Task currentTask : database){
//            if (currentTask.getName().equals(name)){
//                foundedTask.add(currentTask);
//            }
//        }

        return database.stream()
                .filter(task -> task.getName().equals(name))
                .toList();

    }

    @Override
    public Optional<Task> deleteById(Integer id) {
        Optional<Task> optTaskById = findById(id);

        if (optTaskById.isPresent()){
            Task taskForDelete = optTaskById.get();
            database.remove(taskForDelete);
        }
        return optTaskById;


    }

    @Override
    public List<Task> findAll() {
        return database;
    }
}
