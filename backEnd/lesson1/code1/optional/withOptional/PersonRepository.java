package lesson1.code1.optional.withOptional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {
    private Map<Integer, Person> persons = new HashMap<>();

    public void addPerson(Integer id, Person person){
        persons.put(id,person);
    }

    public Optional<Person> findById(Integer id){

        if (persons.containsKey(id)){
            return Optional.of(persons.get(id));
        } else {
            return Optional.empty();
        }

    }

    public Optional<Person> findByIdVer2(Integer id){

        return Optional.ofNullable(persons.get(id));
    }
}
