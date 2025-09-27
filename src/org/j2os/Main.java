package org.j2os;

import org.j2os.entity.Person;
import org.j2os.service.PersonService;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
//        PersonService.getInstance().save(new Person().setName("Mona").setFamily("Jamshidi"));

        List<Person> list = PersonService.getInstance().findAll();
        list.forEach(person -> System.out.println(person.getId() + " -- " + person.getName() + "--" + person.getFamily()));
//
//        for (Person person : list){
//            System.out.println(person.getId() + " -- " + person.getName() + "--" + person.getFamily());
//        }

//        PersonService.getInstance().update(new Person().setId(2101).setName("Mona").setFamily("Jamshidi"));
    }
}
