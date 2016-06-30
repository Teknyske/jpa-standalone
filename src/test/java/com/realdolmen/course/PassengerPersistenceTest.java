package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Passenger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by cerseilannister on 30/06/16.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passagier = new Passenger(1L, "socialnumber1", "Peter","Derous",500);
        entityManager().persist(passagier);
        assertNotNull(passagier.getId());


    }


    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutTitle() throws Exception {
        Passenger passagier2 = new Passenger(null,"Socialnumber2","John", "Doe", 10);
        entityManager().persist(passagier2);
    }


    @Test
    public void passengerCanBeRetrievedById() throws Exception {
       assertEquals("Peter", entityManager().find(Passenger.class, 1L).getFirstName() );
    }

}


