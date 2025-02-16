package lesson1.code1.appStructure2;

import User.UserInput;
import lesson1.code1.appStructure2.back.repository.TaskInMemory;
import lesson1.code1.appStructure2.back.repository.TaskRepository;
import lesson1.code1.appStructure2.back.service.AddTaskService;
import lesson1.code1.appStructure2.back.service.FindTaskService;
import lesson1.code1.appStructure2.back.service.ValidationTaskService;
import lesson1.code1.appStructure2.front.UserMenu;

public class TaskApp {
    public static void main(String[] args) {

        TaskInMemory repository = new TaskRepository();
        ValidationTaskService validationTaskService = new ValidationTaskService();

        AddTaskService addTaskService = new AddTaskService(repository, validationTaskService);
        FindTaskService findTaskService = new FindTaskService(repository);

        UserInput userInput = new UserInput();

        UserMenu userMenu = new UserMenu(addTaskService, findTaskService, userInput);

        userMenu.menu();


    }
}
