package lesson1.code1.appStructure2.back.service;

import lesson1.code1.appStructure2.back.dto.RequestDto;

public class ValidationTaskService {

    public String validate(RequestDto request){
        String message = "";

        if (request.getName().isBlank()) {
            message = message + "Название задачи не может быть пустым";
        }

        if (request.getName().length() < 5) {
            message = message + "Длина названия задачи не может быть меньше 5 символов";
        }

        if (request.getName().length() > 15) {
            message = message + "Длина названия задачи не может быть более 15 символов";
        }

        if (request.getDescription().isBlank()) {
            message = message + "Описание задачи не может быть пустым";
        }

        return message;
    }
}
