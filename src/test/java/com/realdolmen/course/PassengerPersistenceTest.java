package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by cerseilannister on 30/06/16.
 */
public class PassengerPersistenceTest {

    @Test
    public void bookCanBePersisted() throws Exception {
        Book book = new Book("Animal Farm", "George Orwell", Book.Genre.thriller);
        entityManager().persist(book);
        assertNotNull(book.getId());
    }

    @Test(expected = PersistenceException.class)
    public void bookCanNotBePersistedWithoutTitle() throws Exception {
        Book book = new Book(null, "John Doe", Book.Genre.thriller);
        entityManager().persist(book);
    }

    @Test
    public void bookCanBeRetrievedById() throws Exception {
        assertEquals("Nineteen Eighty Four", entityManager().find(Book.class, 1000).getTitle());
    }
}

/*
package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void bookCanBePersisted() throws Exception {
        Book book = new Book("Animal Farm", "George Orwell", Book.Genre.thriller);
        entityManager().persist(book);
        assertNotNull(book.getId());
    }

    @Test(expected = PersistenceException.class)
    public void bookCanNotBePersistedWithoutTitle() throws Exception {
        Book book = new Book(null, "John Doe", Book.Genre.thriller);
        entityManager().persist(book);
    }

    @Test
    public void bookCanBeRetrievedById() throws Exception {
        assertEquals("Nineteen Eighty Four", entityManager().find(Book.class, 1000).getTitle());
    }
}

 */
