package com.gp.solutions.service;

import com.gp.solutions.entity.dbo.Person;
import com.gp.solutions.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DrinkingBuddyServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private DrinkingBuddyService service;

    @Test
    public void findBuddyTest() {
        final List<Person> people = new ArrayList<Person>();

        final Person p1 = new Person();
        p1.setId(1l);
        p1.setName("John");
        p1.setAge(25);
        people.add(p1);

        final Person p2 = new Person();
        p2.setId(2l);
        p2.setName("Marry");
        p2.setAge(22);
        people.add(p2);

        final Person p3 = new Person();
        p3.setId(3l);
        p3.setName("Peter");
        p3.setAge(35);
        people.add(p3);

        when(repository.findAll()).thenReturn(people);

        assertEquals(service.findBuddy(p1), p2);
    }

}
