package main.java.ru.netology.stream;

import java.util.*;

public class PersonProvider {
    private static Random random = new Random();

    public static Collection<Person> getPersons() {
        List<String> names = getNames();
        List<String> families = getFamilies();
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(random.nextInt(names.size())),
                    families.get(random.nextInt(families.size())),
                    random.nextInt(100),
                    Sex.values()[random.nextInt(Sex.values().length)],
                    Education.values()[random.nextInt(Education.values().length)])
            );
        }
        return persons;
    }

    private static List<String> getNames() {
        return Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
    }

    private static List<String> getFamilies() {
        return Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
    }
}
