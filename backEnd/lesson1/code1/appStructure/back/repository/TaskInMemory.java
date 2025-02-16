package lesson1.code1.appStructure.back.repository;

import lesson1.code1.appStructure.back.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskInMemory {

    Task add(Task task);

    Optional<Task> findById(Integer id);

    List<Task> findByName(String name);

    Optional<Task> deleteById(Integer id);

    List<Task> findAll();



}
