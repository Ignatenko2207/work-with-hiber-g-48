package ua.mainacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.internal.QueryImpl;
import ua.mainacademy.factory.impl.PostgresSessionFactory;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.OrderItem;
import ua.mainacademy.model.User;

import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class OrderItemDAO extends BaseDAO<OrderItem>{

    public List<OrderItem> findAllByUserAndCartStatus(User user, Order.Status status) {
        List<OrderItem> result;

        if (isNull(user.getId()) || isNull(status)) {
            throw new RuntimeException("Search is failed!");
        }
        SessionFactory sessionFactory = new PostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createNativeQuery("" +
                "SELECT oi.* " +
                "FROM order_items oi " +
                "JOIN orders o ON o.id=oi.order_id " +
                "WHERE o.user_id=?1 " +
                "AND o.status=?2", OrderItem.class);
        query.setParameter(1, user.getId());
        query.setParameter(2, status.ordinal());

        result = query.getResultList();
        session.close();
        return result;
    }



}
