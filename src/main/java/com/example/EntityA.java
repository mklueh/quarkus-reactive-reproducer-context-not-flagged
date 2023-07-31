package com.example;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 *
 */
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entity_a")
public class EntityA extends PanacheEntity {

    @Column
    private String name;

    @ManyToOne
    private User user;

}
