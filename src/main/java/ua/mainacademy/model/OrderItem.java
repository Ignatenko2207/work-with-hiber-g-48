package ua.mainacademy.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Item.class)
    private Item item;

    @ManyToOne(targetEntity = Order.class)
    private Order order;

    @Column(nullable = false)
    private Integer amount;

}
