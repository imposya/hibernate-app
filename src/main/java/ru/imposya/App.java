package ru.imposya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.imposya.model.Item;
import ru.imposya.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person = new Person("Roman", 44);
            Item item = new Item("Hibernate2", person);
            person.setItems(new ArrayList<Item>(Collections.singletonList(item)));

            session.save(person);
            session.save(item);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
