package com.example;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 */
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_")
public class User extends PanacheEntity {

    @OneToMany
    private Set<EntityA> entityA;

    public User(Long userId) {
        this.id = userId;
    }
}
