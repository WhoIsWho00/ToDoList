package lesson1.code1.optional.withOptional;

import java.util.Optional;

public class PersonDemo {
    public static void main(String[] args) {

        PersonRepository repository = new PersonRepository();

        repository.addPerson(1,new Person("Ruslan"));
        repository.addPerson(3,new Person("Olga"));
        repository.addPerson(5,new Person("Roman"));
        repository.addPerson(7,new Person("Oleg"));
        repository.addPerson(10,new Person("Petr"));
        repository.addPerson(12,new Person("Victor"));

        // ------ получаем данные из репозитория по id ----

        Integer searchIndex = 15;

        Optional<Person> optionalPersonFromCollection = repository.findById(searchIndex);

        if (optionalPersonFromCollection.isPresent()) {
            Person personFromCollection = optionalPersonFromCollection.get();
            System.out.println("Имя сотрудника: " + personFromCollection.getName());
        } else {
            System.out.println("Пользователя с id = " + searchIndex + " не найдено");
        }
    }
}
