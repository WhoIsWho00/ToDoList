package lesson1.code1.appStructure.front;


import User.UserInput;
import lesson1.code1.appStructure.back.entity.Task;
import lesson1.code1.appStructure.back.service.AddTaskService;
import lesson1.code1.appStructure.back.service.FindTaskService;

import java.util.List;

public class UserMenu {

    private AddTaskService addTaskService;
    private FindTaskService findTaskService;
    private UserInput userInput;

    public UserMenu(AddTaskService addTaskService, FindTaskService findTaskService, UserInput userInput) {
        this.addTaskService = addTaskService;
        this.findTaskService = findTaskService;
        this.userInput = userInput;
    }

    public void menu(){

        while (true) {
            // печать текста меню
            printMenu();

            int choice = userInput.userInt("Выберите пункт меню: ");

            switch (choice) {
                case 1 -> addNewTask();
                case 2 -> findAllTasks();
                case 3 -> findTaskById();
                case 4 -> findTasksByName();
                case 5 -> deleteTaskById();
                case 6 -> updateTasksById();
                case 7 -> {
                    return;
                }
                default -> System.out.println("Incorrect ...");
            }

        }

    }

    // ------- закончился метод menu ------

    private void updateTasksById() {
        System.out.println("Пока не работает !!!");
    }

    private void deleteTaskById() {
        System.out.println("Пока не работает !!!");
    }

    private void findTasksByName() {
        System.out.println("Поиск задачи по имени");
        String taskNameForSearch = userInput.userText("Введите название задачи :");

        List<Task> foundedTasks = findTaskService.findByName(taskNameForSearch);

        System.out.println(foundedTasks);
    }

    private void findTaskById() {
        System.out.println("Поиск задачи по ID");
        Integer taskIdForSearch = userInput.userInt("Введите ID задачи :");

        Task foundedTask = findTaskService.findById(taskIdForSearch);

        System.out.println(foundedTask);
    }

    private void findAllTasks() {
        System.out.println("Список всех задач:");
        List<Task> allTasks = findTaskService.findAll();
        for (Task currentTask : allTasks){
            System.out.println(currentTask);
        }
    }

    private void addNewTask() {

        System.out.println("Ввод новой задачи: ");
        String taskName = userInput.userText("Введите название задачи: ");
        String taskDescription = userInput.userText("Введите описание задачи: ");

        Task saveTask = addTaskService.addNewTask(taskName,taskDescription);

        if (saveTask != null) {
            System.out.println("Задача добавилась успешно. " + saveTask);
        } else {
            System.out.println("Задачу добавить не получилось");
        }
    }

    // ---------------------------------------

    private void printMenu(){
        System.out.println("------------");
        System.out.println("User menu:");
        System.out.println("1. Add new task");
        System.out.println("2. Find all tasks");
        System.out.println("3. Find task by ID");
        System.out.println("4. Find tasks by name");
        System.out.println("5. Delete task by ID");
        System.out.println("6. Update task by ID");
        System.out.println("7. Exit");
    }
}
