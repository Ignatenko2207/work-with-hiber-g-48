package ua.mainacademy.factory.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.model.Item;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.OrderItem;
import ua.mainacademy.model.User;

import static java.util.Objects.isNull;

public class PostgresSessionFactory implements HibernateSessionFactory {

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getHibernateSessionFactory() {
        if (isNull(sessionFactory)) {
            Configuration configuration = new Configuration().configure();

            configuration.addAnnotatedClass(Item.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(OrderItem.class);

            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }
        return sessionFactory;
    }
}
