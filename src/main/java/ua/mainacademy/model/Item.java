package ua.mainacademy.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
@Entity
public class Item extends BaseEntity{

    @Column(name = "iem_code", nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private String name;

    private Integer price;

    @Column(name = "init_price")
    private Integer initPrice;

}
