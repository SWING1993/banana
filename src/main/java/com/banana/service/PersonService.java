package com.banana.service;

import com.banana.dao.PersonDAO;
import com.banana.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired private PersonDAO personDAO;

    public List<Person> getPersons() {
        return personDAO.getPersons();
    }

//    public Person getPersonById(String id) {
//        return personDAO.get
//    }

    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    public void  updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    public void deletePersonById(String id) {
        personDAO.deletePersonById(id);
    }
}
