package com.example;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

/**
 *
 */
@ApplicationScoped
public class UserService {

    @Inject
    @Channel(Events.USER_REGISTRATION_CONFIRMED)
    Emitter<User> emitter;

    @WithTransaction
    public Uni<PanacheEntityBase> createUser() {
        return new User().persist()
                .onItem().invoke(user -> emitter.send((User) user));
    }

}
