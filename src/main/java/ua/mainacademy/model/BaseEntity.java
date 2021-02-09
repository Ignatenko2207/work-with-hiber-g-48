package ua.mainacademy.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
