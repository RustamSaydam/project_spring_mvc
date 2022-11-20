package ru.saydam.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.saydam.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Rustam"));
        people.add(new Person(++PEOPLE_COUNT,"Anya"));
        people.add(new Person(++PEOPLE_COUNT, "Olga"));
        people.add(new Person(++PEOPLE_COUNT, "Sergey"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
