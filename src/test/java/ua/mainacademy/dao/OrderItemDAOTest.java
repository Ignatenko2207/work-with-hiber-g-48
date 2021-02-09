package ua.mainacademy.dao;

import org.junit.jupiter.api.Test;
import ua.mainacademy.model.Item;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.OrderItem;
import ua.mainacademy.model.User;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDAOTest {

    @Test
    void findAllByUserAndCartStatus() {
        Item item = new ItemDAO().save(
                Item.builder()
                        .name("testName")
                        .itemCode("123456")
                        .price(123456)
                        .initPrice(123456)
                        .build()
        );

        User user = new UserDAO().save(
                User.builder()
                        .login("ignatenko2207")
                        .password("123456")
                        .firstName("Alex")
                        .lastName("Ignatenko")
                        .build()
        );

        Order order = new OrderDAO().save(
                Order.builder()
                        .user(user)
                        .creationTime(new Date().getTime())
                        .status(Order.Status.CLOSED)
                        .build()
        );

        OrderItemDAO orderItemDAO = new OrderItemDAO();

        OrderItem orderItem = orderItemDAO.save(
                OrderItem.builder()
                        .amount(2)
                        .item(item)
                        .order(order)
                        .build()
        );

        assertNotNull(orderItem);
        assertNotNull(orderItem.getId());

        List<OrderItem> result = orderItemDAO.findAllByUserAndCartStatus(user, order.getStatus());

        assertNotNull(result);
        assertFalse(result.isEmpty());

    }
}