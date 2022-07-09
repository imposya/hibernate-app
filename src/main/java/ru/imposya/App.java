package ru.imposya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.imposya.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person1 = new Person("Sasha", 25);
            Person person2 = new Person("Masha", 21);
            Person person3 = new Person("Antosha", 26);

            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
