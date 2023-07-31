package com.example;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

/**
 */
@Slf4j
@ApplicationScoped
public class EntityAService {

    @WithSession
    @Incoming(Events.USER_REGISTRATION_CONFIRMED)
    public Uni<EntityA> onUserRegistrationConfirmed(User user) {
        return createEntityAAndLinkToUser(user.id)
                .onItem().invoke(link -> log.info("EntityA created and linked"));
    }

    @WithTransaction
    public Uni<EntityA> createEntityAAndLinkToUser(Long userId) {
        var entityA = new EntityA();
        entityA.setUser(new User(userId));
        return entityA.persist();
    }
}
