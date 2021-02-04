package ua.mainacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.mainacademy.factory.impl.PostgresSessionFactory;
import ua.mainacademy.model.User;

import static java.util.Objects.nonNull;

public class UserDAO {

    public static User save(User user) {
        if (nonNull(user.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        PostgresSessionFactory postgresSessionFactory = new PostgresSessionFactory();
        SessionFactory sessionFactory = postgresSessionFactory.getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(user);
        transaction.commit();
        user.setId(id);
        session.close();
        return user;
    }
}
