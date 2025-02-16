package lesson1.code1.optional;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {
    private Map<Integer, Person> persons = new HashMap<>();

    public void addPerson(Integer id, Person person){
        persons.put(id,person);
    }

    public Person findById(Integer id){
        return persons.get(id);
    }
}
