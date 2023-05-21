package main.java.ru.netology.stream;

import java.util.*;
import java.util.stream.Collectors;

// https://github.com/netology-code/jd-homeworks/blob/master/streams/task2/README.md
public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = PersonProvider.getPersons();
        System.out.println("Количество несовершеннолетних: " + getTeenagersCount(persons));
        System.out.println("Фамилий призывников: " + getConscriptsSurnames(persons));
        System.out.println("Список потенциально работоспособных людей: " + getAbleBodiedPeople(persons));
    }

    private static List<String> getAbleBodiedPeople(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .filter(person -> (person.getSex().equals(Sex.MAN) && person.getAge() >= 18 && person.getAge() <= 65) ||
                        (person.getSex().equals(Sex.WOMAN) && person.getAge() >= 18 && person.getAge() <= 60))
                .map(person -> String.format("%s %s, %s, %s", person.getFamily(), person.getName(), person.getSex(),
                        person.getAge()))
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> getConscriptsSurnames(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    private static long getTeenagersCount(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
    }
}