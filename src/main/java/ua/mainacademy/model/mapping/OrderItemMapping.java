package ua.mainacademy.model.mapping;

import ua.mainacademy.dao.OrderItemDAO;
import ua.mainacademy.model.Item;
import ua.mainacademy.model.OrderItem;
import ua.mainacademy.model.dto.OrderItemDTO;

public class OrderItemMapping {

    public static OrderItem toModel(OrderItemDTO orderItemDTO) {
        return OrderItem.builder()
                .item(Item.builder()
                        .name(orderItemDTO.getItemName())
                        .build()
                )
                .amount(orderItemDTO.getAmount())
                .build();

    }

    public static OrderItemDTO toDTO (OrderItem orderItem) {
        return OrderItemDTO.builder()
                .amount(orderItem.getAmount())
                .itemName(orderItem.getItem().getName())
                .build();
    }
}
