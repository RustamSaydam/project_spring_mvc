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
        people.add(new Person(++PEOPLE_COUNT, "Rustam", 24, "testspring@222.com"));
        people.add(new Person(++PEOPLE_COUNT, "Anya", 52, "testspri43@2ng.com"));
        people.add(new Person(++PEOPLE_COUNT, "Olga", 18, "testspr323@4ing2.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sergey", 34, "test1sp3r@ing4.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);

    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setEmail(updatePerson.getEmail());
        personToBeUpdated.setAge(updatePerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
